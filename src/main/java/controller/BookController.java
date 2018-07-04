package controller;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<?> save(@RequestBody Book book){
        long id = bookService.save(book);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/book/{id}")
    public ResponseEntity<?> get(@PathVariable("id") long id){
       Book book = bookService.get(id);
       return ResponseEntity.ok().body(book);
    }

}
