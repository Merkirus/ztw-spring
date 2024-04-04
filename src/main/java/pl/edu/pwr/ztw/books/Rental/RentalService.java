package pl.edu.pwr.ztw.books.Rental;

import org.springframework.stereotype.Service;
import pl.edu.pwr.ztw.books.Database.IDatabaseService;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class RentalService implements IRentalService{

    private final IDatabaseService dbService;

    public RentalService(IDatabaseService dbService) {
        this.dbService = dbService;
    }

    @Override
    public void addRental(Rental rental) {
        dbService.addRental(rental);
    }

    @Override
    public Collection<Rental> getRentals() {
        return dbService.getRentals();
    }

    @Override
    public Rental getRental(int id) {
        return dbService.getRentals().stream()
                .filter(a -> a.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Rental with id = " + id + " not found"));
    }

    @Override
    public void updateRental(int id, Rental rental) {
        dbService.updateRental(id, rental);
    }

    @Override
    public void deleteRental(int id) {
        dbService.deleteRental(id);
    }
}
