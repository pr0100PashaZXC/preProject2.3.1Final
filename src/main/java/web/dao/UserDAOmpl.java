package web.dao;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import web.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

@Component
@Transactional
public class UserDAOmpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDAOmpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> index() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User show(long id) {
        return entityManager.find(User.class, id);

    }

    @Override
    public void update(@Valid User user) {
        System.out.println(user.toString());
        entityManager.merge(user);
        System.out.println(user.toString());
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(show(id));

    }
}