package pl.edu.pwr.ztw.books.Rental;

import java.util.Collection;

public interface IRentalService {
    abstract public void addRental(Rental rental);
    abstract public Collection<Rental> getRentals();
    abstract public void updateRental(int id, Rental rental);
    abstract public void deleteRental(int id);
}
