package main.java.web.projectBoot.dao;


import org.springframework.stereotype.Repository;
import main.java.web.projectBoot.model.User;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override

    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }
    public User show(int id){
        return entityManager.find(User.class, id);
    }


    public void update(User updatedUser){
        entityManager.merge(updatedUser);
        entityManager.flush();
    }

    @Override
    public void delete(int id) {
        User user = show(id);
        entityManager.remove(user);
        entityManager.flush();
    }

}
