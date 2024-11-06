package com.aziz.voyages.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aziz.voyages.entities.Categorie;
import com.aziz.voyages.repos.CategorieRepository;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin("*")
public class CategorieRESTController {

    @Autowired
    CategorieRepository categorieRepository;

    // GET all categories
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Categorie>> getAllCategories() {
        List<Categorie> categories = categorieRepository.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // GET category by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categorie> getCategorieById(@PathVariable("id") Long id) {
        Optional<Categorie> categorie = categorieRepository.findById(id);
        return categorie.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST create new category
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie) {
        Categorie createdCategorie = categorieRepository.save(categorie);
        return new ResponseEntity<>(createdCategorie, HttpStatus.CREATED);
    }

    // DELETE category by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCategorie(@PathVariable("id") Long id) {
        if (categorieRepository.existsById(id)) {
            categorieRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // PUT update category by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Categorie> updateCategorie(@PathVariable("id") Long id, @RequestBody Categorie categorie) {
        if (categorieRepository.existsById(id)) {
            categorie.setIdCat(id);  // Ensure the ID is set correctly
            Categorie updatedCategorie = categorieRepository.save(categorie);
            return new ResponseEntity<>(updatedCategorie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
