package com.pharma.pharmacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.pharmacy.pojo.Drug;
import com.pharma.pharmacy.repository.PharmaRepository;

@Service
public class PharmaService {
    
    @Autowired
    PharmaRepository pharmaRepository;

    public void add(Drug drug){
        this.pharmaRepository.addDrug(drug);
    }

    public void update(int index, Drug drug) {
        this.pharmaRepository.updateDrug(index, drug);
    }

    public Drug get(int index) {
        return this.pharmaRepository.getDrug(index);
    }

    public void delete(int index) {
        this.pharmaRepository.removeDrug(index);
    }

    public List<Drug> getDrugs() {
        return this.pharmaRepository.getDrugs();
    }
}
