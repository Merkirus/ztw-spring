package pl.edu.pwr.ztw.books.Books;

import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BooksController {
    @Autowired
    IBooksService booksService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<Object> getBooks() {
        return new ResponseEntity<>(booksService.getBooks(), HttpStatus.OK);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getBook(@PathVariable("id") int id) {
        return new ResponseEntity<>(booksService.getBook(id), HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Object> addBook(@RequestBody Book book) {
        booksService.addBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id") int id) {
        booksService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
