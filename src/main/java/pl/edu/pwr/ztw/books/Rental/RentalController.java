package pl.edu.pwr.ztw.books.Rental;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@RequestMapping("/rentals")
@RestController
public class RentalController {

    private final IRentalService rentalService;

    public RentalController(IRentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public ResponseEntity<Collection<Rental>> getRentals() {
        return new ResponseEntity<>(rentalService.getRentals(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rental> getRental(@PathVariable("id") int id) {
        return new ResponseEntity<>(rentalService.getRental(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addRental(@RequestBody Rental rental) {
        rentalService.addRental(rental);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRental(@PathVariable("id") int id, @RequestBody Rental rental) {
        rentalService.updateRental(id, rental);
        return new ResponseEntity<>(HttpStatus.OK);
        //return ResponseEntity.ok(booksService.updateBook(id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable("id") int id) {
        rentalService.deleteRental(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
