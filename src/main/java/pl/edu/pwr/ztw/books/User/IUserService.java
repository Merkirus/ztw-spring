package pl.edu.pwr.ztw.books.User;


import java.util.Collection;

public interface IUserService {
    abstract public void addUser(User user);
    abstract public Collection<User> getUsers();
    abstract public User getUser(int id);
    abstract public void updateUser(int id, User user);
    abstract public void deleteUser(int id);
}
