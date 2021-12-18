package Retos_ciclo4.Retos.Repository.Crud;

import Retos_ciclo4.Retos.Model.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserCrudRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByNameOrEmail(String name, String email);
    List<User> findByMonthBirthtDay(String month);
}
