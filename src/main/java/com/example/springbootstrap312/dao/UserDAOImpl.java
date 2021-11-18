package com.example.springbootstrap312.dao;

import com.example.springbootstrap312.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUser(long id) {
        return (User) entityManager.createQuery("from User u JOIN fetch u.roles where u.id=:id")
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void updateUser(long id, User updatedUser) {
        User user = getUser(id);
        user.setFirstName(updatedUser.getFirstName());
        user.setAge(updatedUser.getAge());
        user.setEmail(updatedUser.getEmail());
    }

    @Override
    public User getUserByName(String username) {
        return (User) entityManager.createQuery("from User u where u.username=:username")
                .setParameter("username", username).getSingleResult();
    }
}
