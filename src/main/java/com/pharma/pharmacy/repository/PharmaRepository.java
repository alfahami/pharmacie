package com.pharma.pharmacy.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pharma.pharmacy.pojo.Drug;

@Repository
public class PharmaRepository {
    
    List<Drug> drugs = new ArrayList<>();

    public void addDrug(Drug drug) {
        this.drugs.add(drug);
    }

    public void updateDrug(int index, Drug drug) {
        this.drugs.set(index, drug);
    }

    public void removeDrug(int index) {
        this.drugs.remove(index);
    }

    public Drug getDrug(int index) {
        return this.drugs.get(index);
    }

    public List<Drug> getDrugs() {
        return this.drugs;
    }

}
