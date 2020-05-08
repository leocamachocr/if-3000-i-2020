package edu.ucr.rp.homework2.domain;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private List<Invoice> invoices;

    public Client() {
        invoices= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }


}
