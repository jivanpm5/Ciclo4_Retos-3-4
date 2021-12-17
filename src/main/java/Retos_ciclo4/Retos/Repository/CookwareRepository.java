package Retos_ciclo4.Retos.Repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Retos_ciclo4.Retos.Model.Cookware;
import Retos_ciclo4.Retos.Repository.Crud.CookwareCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class CookwareRepository {
    @Autowired
    private CookwareCrudRepository productCrudRepository;

    public List<Cookware> getAll(){
        return productCrudRepository.findAll();
    }

    public Optional<Cookware> getProduct(String id){
        return productCrudRepository.findById(id);
    }

    public Cookware create(Cookware product){
        return productCrudRepository.save(product);
    }

    public void update(Cookware product){
        productCrudRepository.save(product);
    }

    public void delete(Cookware product){
        productCrudRepository.delete(product);
    }
}
