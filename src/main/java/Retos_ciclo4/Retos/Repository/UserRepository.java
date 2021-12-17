package Retos_ciclo4.Retos.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Retos_ciclo4.Retos.Model.User;
import Retos_ciclo4.Retos.Repository.Crud.UserCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }

    public User create(User user){
        return userCrudRepository.save(user);
    }

    public void update(User user){
        userCrudRepository.save(user);
    }

    public void delete(User user){
        userCrudRepository.delete(user);
    }

    public boolean emailExists(String email){
        Optional<User> user = userCrudRepository.findByEmail(email);
        return !user.isEmpty();
    }

    public Optional<User> authenticateUser (String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    public Optional<User> getUserByNameOrEmail(String name, String email){
        return userCrudRepository.findByNameOrEmail(name, email);
    }
}


