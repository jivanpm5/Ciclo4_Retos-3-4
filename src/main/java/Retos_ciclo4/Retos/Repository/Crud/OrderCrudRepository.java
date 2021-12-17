package Retos_ciclo4.Retos.Repository.Crud;

import java.util.Date;
import java.util.List;
//import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;

import Retos_ciclo4.Retos.Model.Order;


public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    List<Order> findBySalesManZone(String zone);
    List<Order> findBySalesManId(Integer salesManId);
    List<Order> findByStatusAndSalesManId(String status, Integer salesManId);
    List<Order> findByRegisterDayAndSalesManId(Date registerDay, Integer salesManId);
    
    
}

