package Retos_ciclo4.Retos.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;


import Retos_ciclo4.Retos.Model.Order;
import Retos_ciclo4.Retos.Repository.Crud.OrderCrudRepository;

/**
 *
 * @author desarrolloextremo
 */
@Repository
public class OrderRepository {

    @Autowired
    private OrderCrudRepository orderCrudRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }

    public void update(Order order) {
        orderCrudRepository.save(order);
    }

    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }

    public List<Order> getOrderByZone(String zone){
        return orderCrudRepository.findBySalesManZone(zone);
    }

    public List<Order> getOrderBySalesManId(Integer salesManId){
        return orderCrudRepository.findBySalesManId(salesManId);
    }

    public List<Order> getOrderByStatusAndSalesManId(String status, Integer salesManId){
        return orderCrudRepository.findByStatusAndSalesManId(status, salesManId);
    }

    public List<Order> getOrderByRegisterDayAndSalesManId(String registerDay, Integer salesManId){
        try {
            return orderCrudRepository.findByRegisterDayAndSalesManId(new SimpleDateFormat("yyyy-MM-dd").parse(registerDay), salesManId);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

    