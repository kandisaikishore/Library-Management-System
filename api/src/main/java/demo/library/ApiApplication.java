package demo.library;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class ApiApplication {
 public static void main(String[] args){SpringApplication.run(ApiApplication.class,args);}
 @RestController @RequestMapping("/api/books") @CrossOrigin(origins="*")
 static class BooksApi {
  private final Map<Integer,Map<String,Object>> books=new LinkedHashMap<>();
  private final AtomicInteger ids=new AtomicInteger(6);
  BooksApi(){addSeed(1,"Java Basics","James Gosling","available");addSeed(2,"OOP Concepts","Grady Booch","out");addSeed(3,"Clean Code","Robert C. Martin","available");addSeed(4,"Atomic Habits","James Clear","available");addSeed(5,"The Hobbit","J. R. R. Tolkien","out");addSeed(6,"Deep Work","Cal Newport","available");}
  void addSeed(int id,String title,String author,String status){Map<String,Object>b=new LinkedHashMap<>();b.put("id",id);b.put("title",title);b.put("author",author);b.put("status",status);books.put(id,b);}
  @GetMapping List<Map<String,Object>> all(){return new ArrayList<>(books.values());}
  @PostMapping ResponseEntity<?> create(@RequestBody Map<String,Object> body){String title=String.valueOf(body.getOrDefault("title","")).trim(),author=String.valueOf(body.getOrDefault("author","")).trim();if(title.isEmpty()||author.isEmpty())return ResponseEntity.badRequest().body(Map.of("error","title and author are required"));int id=ids.incrementAndGet();Map<String,Object>b=new LinkedHashMap<>();b.put("id",id);b.put("title",title);b.put("author",author);b.put("status","available");books.put(id,b);return ResponseEntity.status(201).body(b);}
  @PatchMapping("/{id}") ResponseEntity<?> update(@PathVariable int id,@RequestBody Map<String,Object> body){Map<String,Object>b=books.get(id);if(b==null)return ResponseEntity.notFound().build();Object status=body.get("status");if(status!=null){String s=status.toString();if(!s.equals("available")&&!s.equals("out"))return ResponseEntity.badRequest().body(Map.of("error","status must be available or out"));b.put("status",s);}return ResponseEntity.ok(b);}
  @DeleteMapping("/{id}") ResponseEntity<?> delete(@PathVariable int id){return books.remove(id)==null?ResponseEntity.notFound().build():ResponseEntity.noContent().build();}
 }
}