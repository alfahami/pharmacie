package com.pharma.pharmacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.pharmacy.Constants;
import com.pharma.pharmacy.pojo.Drug;
import com.pharma.pharmacy.repository.PharmaRepository;

@Service
public class PharmaService {
    
    @Autowired
    PharmaRepository pharmaRepository;

    public void addDrug(Drug drug){
        this.pharmaRepository.addDrug(drug);
    }

    public void updateDrug(int index, Drug drug) {
        this.pharmaRepository.updateDrug(index, drug);
    }

    public Drug getDrug(int index) {
        return this.pharmaRepository.getDrug(index);
    }

    public void deleteDrug(int index) {
        this.pharmaRepository.removeDrug(index);
    }

    public List<Drug> getDrugs() {
        return this.pharmaRepository.getDrugs();
    }

    public void submitForm(Drug drug) {
        int index = getDrugIndex(drug.getId());
         if(index != Constants.NOT_FOUND) 
            updateDrug(index, drug);
         else addDrug(drug);
    }

    public Drug getDrugById(String id) {
        int index = getDrugIndex(id);
        return index == Constants.NOT_FOUND ? new Drug() : getDrug(index);
    }

    public int getDrugIndex(String id) {
        for (int i = 0; i < getDrugs().size(); i++) {
            if(getDrugs().get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }
}
