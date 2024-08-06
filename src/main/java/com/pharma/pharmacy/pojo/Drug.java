package com.pharma.pharmacy.pojo;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Drug {

    private String id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 0, message = "Price cannot be null")
    private Double price;
    private int quantity;
    
    @Size(max=43)
    private String barcode;


    public Drug() {
        this.id = UUID.randomUUID().toString();
    }
    

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }


    
}
