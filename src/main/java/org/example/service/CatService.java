package org.example.service;

import org.example.model.Cat;
import org.example.model.CatBehaviour;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CatService {

    private final Map<String, Cat> cats = new HashMap<>();

    public CatService() {
        cats.put("Tom", new Cat("Tom", CatBehaviour.CALM));
        cats.put("Oscar", new Cat("Oscar", CatBehaviour.NORMAL));
    }

    public Cat getCat(String catName) {
        return cats.get(catName);
    }

    public Collection<Cat> getAllCats() {
        return cats.values();
    }

    public Collection<Cat> getCatsByBehaviour(CatBehaviour catBehaviour) {
        List<Cat> filteredCats = new ArrayList<>();

        if (catBehaviour == null) {
            return filteredCats;
        }

        for (Cat cat : cats.values()) {
            if (catBehaviour.equals(cat.getBehaviour())) {
                filteredCats.add(cat);
            }
        }
        return filteredCats;
    }

    public boolean addCat(Cat cat) {
        if (cats.containsKey(cat.getName())) {
            return false;
        }

        cats.put(cat.getName(), cat);
        return true;
    }

    public Cat updateCat(String catNumber, Cat cat) {
        cats.put(catNumber, cat);
        return cats.get(catNumber);
    }

    public Cat deleteCat(String catName) {
        return cats.remove(catName);
    }
}
