package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> index();

    public User show(long id);

    public void update(User updatedUser);
    public  void save(User user);

    void delete(long id);
}
