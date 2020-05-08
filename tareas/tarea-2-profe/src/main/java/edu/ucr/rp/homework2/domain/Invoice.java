package edu.ucr.rp.homework2.domain;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private Boolean serviceTax;
    private Double subTotal;
    private Double total;
    private final static Double SERVICE_PERCENTAGE = 10D;
    private List<Product> products;
    private Client client;
    private Company company;

    public Invoice(Client client, Company company) {
        this.client = client;
        this.company = company;
        products = new ArrayList<>();//ListFactory.createInstance(); ->  {return new ArrayList();}
    }

    public void calculatePrice() {
        total = 0D;//subtotal+impuesto
        subTotal = 0D;//suma de los precios sin impuesto
        for (Product product : products) {
            subTotal += product.getPrice();
            total += product.calculateFinalPrice();
        }
        total = total * (1 + (SERVICE_PERCENTAGE / 100));
    }

    public List<Product> addProduct(Product product) {
        products.add(product);
        return products;
    }

    public Boolean getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(Boolean serviceTax) {
        this.serviceTax = serviceTax;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
