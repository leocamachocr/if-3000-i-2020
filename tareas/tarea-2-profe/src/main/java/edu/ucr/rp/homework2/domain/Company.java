package edu.ucr.rp.homework2.domain;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Client> clients;
    private List<Product> products;
    private List<Invoice> invoices;

    public Company() {
        invoices = new ArrayList<>();
        products = new ArrayList<>();
    }

    public void registerProduct(Product product) {
        products.add(product);
    }
    public void registerInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
