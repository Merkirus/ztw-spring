package pl.edu.pwr.ztw.books.User;

import org.springframework.stereotype.Service;
import pl.edu.pwr.ztw.books.Database.IDatabaseService;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class UserService implements IUserService {

    private final IDatabaseService dbService;

    public UserService(IDatabaseService dbService) {
        this.dbService = dbService;
    }

    @Override
    public void addUser(User user) {
        dbService.addUser(user);
    }

    @Override
    public Collection<User> getUsers() {
        return dbService.getUsers();
    }

    @Override
    public User getUser(int id) {
        return dbService.getUsers().stream()
                .filter(a -> a.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("User with id = " + id + " not found"));
    }

    @Override
    public void updateUser(int id, User user) {
        dbService.updateUser(id, user);
    }

    @Override
    public void deleteUser(int id) {
        dbService.deleteUser(id);
    }
}
