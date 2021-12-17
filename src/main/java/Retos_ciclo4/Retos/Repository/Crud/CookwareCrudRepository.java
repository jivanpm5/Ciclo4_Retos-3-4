package Retos_ciclo4.Retos.Repository.Crud;

import org.springframework.data.mongodb.repository.MongoRepository;

import Retos_ciclo4.Retos.Model.Cookware;

public interface CookwareCrudRepository extends MongoRepository<Cookware,String> {

}
