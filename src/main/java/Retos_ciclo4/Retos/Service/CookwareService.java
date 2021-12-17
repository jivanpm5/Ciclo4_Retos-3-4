package Retos_ciclo4.Retos.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Retos_ciclo4.Retos.Model.Cookware;
import Retos_ciclo4.Retos.Repository.CookwareRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CookwareService {

    @Autowired
    private CookwareRepository productRepository;

    public List<Cookware> getAll(){
        return productRepository.getAll();
    }

    public Optional<Cookware> getCleaningProducts(String reference){
        return productRepository.getProduct(reference);
    }

    public Cookware save(Cookware cleaningProduct){
        if(cleaningProduct.getReference() == null) {
            return cleaningProduct;
        }else{
            return productRepository.create(cleaningProduct);
        }
    }

    public Cookware update(Cookware product) {

        if (product.getReference() != null) {
            Optional<Cookware> dbProduct = productRepository.getProduct(product.getReference());
            if (!dbProduct.isEmpty()) {
                if (product.getBrand() != null) {
                    dbProduct.get().setBrand(product.getBrand());
                }
                if (product.getCategory() != null) {
                    dbProduct.get().setCategory(product.getCategory());
                }
                if (product.getDescription() != null) {
                    dbProduct.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0.0) {
                    dbProduct.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    dbProduct.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    dbProduct.get().setPhotography(product.getPhotography());
                }
                dbProduct.get().setAvailability(product.isAvailability());
                productRepository.update(dbProduct.get());
                return dbProduct.get();
            } else {
                return product;
            }
        }else{
            return product;
        }
    }

    public boolean delete(String reference){
        Boolean aboolean= getCleaningProducts(reference).map(cleaningProduct -> {
            productRepository.delete(cleaningProduct);
            return true;
        }).orElse(false);
        return aboolean;
    }
}
