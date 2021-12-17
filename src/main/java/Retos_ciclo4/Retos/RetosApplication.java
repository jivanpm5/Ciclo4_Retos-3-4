package Retos_ciclo4.Retos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import Retos_ciclo4.Retos.Repository.Crud.CookwareCrudRepository;
import Retos_ciclo4.Retos.Repository.Crud.OrderCrudRepository;
import Retos_ciclo4.Retos.Repository.Crud.UserCrudRepository;

@Component
@SpringBootApplication
public class RetosApplication implements CommandLineRunner {
	@Autowired
    private OrderCrudRepository orderCrudRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private CookwareCrudRepository cookwareCrudRepository;

	public static void main(String[] args) {
		SpringApplication.run(RetosApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
        orderCrudRepository.deleteAll();
        userCrudRepository.deleteAll();
		cookwareCrudRepository.deleteAll();
	}
}