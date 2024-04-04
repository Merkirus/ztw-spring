package pl.edu.pwr.ztw.books.Books;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@RequestMapping("/books")
@RestController
public class BooksController {
    //@Autowired
    private final IBooksService booksService;

    public BooksController(IBooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public ResponseEntity<Collection<Book>> getBooks() {
        return new ResponseEntity<>(booksService.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        return new ResponseEntity<>(booksService.getBook(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addBook(@RequestBody Book book) {
        booksService.addBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        booksService.updateBook(id, book);
        return new ResponseEntity<>(HttpStatus.OK);
        //return ResponseEntity.ok(booksService.updateBook(id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
        booksService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
