package Retos_ciclo4.Retos.Service;

//import com.cuatroa.retotres.model.Order;
//import com.cuatroa.retotres.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Retos_ciclo4.Retos.Model.Order;
import Retos_ciclo4.Retos.Repository.OrderRepository;

/**
 *
 * @author desarrolloextremo
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    public Order create(Order order) {
        if(order.getId()!= null){
            return orderRepository.create(order);
        }else{
            return order;
        }
        
    }

    public Order update(Order order) {

        if (order.getId() != null) {
            Optional<Order> orden = orderRepository.getOrder(order.getId());
            if(!orden.isEmpty()) {

                if (order.getId() != null) {
                    orden.get().setId(order.getId());
                }
                if (order.getRegisterDay() != null) {
                    orden.get().setRegisterDay(order.getRegisterDay());
                }
                if (order.getStatus() != null) {
                    orden.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    orden.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    orden.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null) {
                    orden.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null) {
                    orden.get().setQuantities(order.getQuantities());
                }
                orderRepository.update(orden.get());
                return orden.get();
            }else{
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Order> getZone(String zone) {
        return orderRepository.getZone(zone);
    }
    
    public List<Order> getBySalesManId(Integer id) {
        return orderRepository.getBySalesManId(id);
    }

    public List<Order> getByIdSalesManIdAndState(Integer id, String state) {
        return orderRepository.getBySalesManIdAndStatus(id, state);
    }

    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id) {
        return orderRepository.getByRegisterDayAndSalesManId(registerDay, id);
    }

    public List<Order> ordersSalesManById(Integer id){
        return orderRepository.ordersSalesManById(id);
    }

    public List<Order> findByZone(String zona) {
        return orderRepository.findByZone(zona);
    }
    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        return orderRepository.ordersSalesManByDate(dateStr, id);
    }
    public List<Order> ordersSalesManByStatus(String status, Integer id) {
        return orderRepository.ordersSalesManByStatus(status, id);
    }
}
