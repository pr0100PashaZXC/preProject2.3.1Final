package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import javax.validation.Valid;
import java.util.List;


@Service
@Transactional
public class UserServiseImpl implements UserService{

    private final UserDAO userDAO;

    @Autowired
    public UserServiseImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> index() {
        return userDAO.index();
    }

    @Override
    public User show(long id) {
        return userDAO.show(id);
    }

    @Override
    public void update(@Valid User user) {
        userDAO.update(user);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void delete(long id) {
        userDAO.delete(id);
    }
}
