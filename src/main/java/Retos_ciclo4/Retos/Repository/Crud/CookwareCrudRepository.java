package Retos_ciclo4.Retos.Repository.Crud;

import org.springframework.data.mongodb.repository.MongoRepository;

import Retos_ciclo4.Retos.Model.Cookware;

import java.util.List;

public interface CookwareCrudRepository extends MongoRepository<Cookware,String> {
    public List<Cookware> findByPrice(double price);
    public List<Cookware> findByDescriptionContainingIgnoreCase(String description);
}
