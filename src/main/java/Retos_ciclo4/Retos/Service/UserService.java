package Retos_ciclo4.Retos.Service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Retos_ciclo4.Retos.Model.User;
import Retos_ciclo4.Retos.Repository.UserRepository;

@Service
public class UserService {
    

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }

    public User save(User user){
        if(user.getId() == null) {
            return user;
        }else{
            Optional<User> e = userRepository.getUser(user.getId());
            if(e.isEmpty()){
                if(emailExists(user.getEmail())==false){
                    return userRepository.save(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }
        }
    }

    public User update(User user) {
        if(user.getId() != null) {
            Optional<User> user1Db = userRepository.getUser(user.getId());
            if (!user1Db.isEmpty()) {
                if (user.getIdentification() == null) {
                    user1Db.get().setIdentification(user.getIdentification());
                }
                if (user.getName() == null) {
                    user1Db.get().setName(user.getName());
                }
                if (user.getAddress() == null) {
                    user1Db.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() == null) {
                    user1Db.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() == null) {
                    user1Db.get().setEmail(user.getEmail());
                }
                if (user.getPassword() == null) {
                    user1Db.get().setPassword(user.getPassword());
                }
                if (user.getZone() == null) {
                    user1Db.get().setZone(user.getZone());
                }
                if (user.getType() == null) {
                    user1Db.get().setType(user.getType());
                }
                userRepository.save(user1Db.get());
                return user1Db.get();
            } else {
                return user;
            }
        }else{
            return user;
        }
    }

    public boolean delete(int userId) {
        Boolean userBoolean = getUser(userId).map(user ->{
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return userBoolean;
    }

    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    public User authenticateUser (String email, String password) {
        Optional<User> user = userRepository.authenticateUser(email, password);
        if(user.isEmpty()){
            return new User();
        } else{
            return user.get();
        }
    }
}
