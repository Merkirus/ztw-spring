package pl.edu.pwr.ztw.books.User;

import pl.edu.pwr.ztw.books.Rental.Rental;

import java.util.Collection;

public interface IUserService {
    abstract public void addUser(User user);
    abstract public Collection<User> getUser();
    abstract public void updateUser(int id, User user);
    abstract public void deleteUser(int id);
}
