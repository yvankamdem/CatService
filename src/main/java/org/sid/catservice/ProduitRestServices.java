package org.sid.catservice;

import org.sid.catservice.dao.ProduitRepository;
import org.sid.catservice.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitRestServices {
    @Autowired
    private ProduitRepository produitRepository;
    @GetMapping(value = "/listProducts")
    public List<Produit> listProduits(){
        return produitRepository.findAll();
    }
    @GetMapping(value = "/listProducts/{id}")
    public Produit listProduits(@PathVariable(name = "id") Long id){
        return produitRepository.findById(id).get();
    }

    @PutMapping(value = "/listProducts/{id}")
    public Produit update(@PathVariable(name = "id") Long id,@RequestBody Produit p){
        p.setId(id);
        return produitRepository.save(p);
    }
    @PostMapping(value = "/listproducts")
    public Produit save(@RequestBody Produit p){
        return produitRepository.save(p);
    }
    @DeleteMapping(value = "/listproducts/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        produitRepository.deleteById(id);
    }
}
