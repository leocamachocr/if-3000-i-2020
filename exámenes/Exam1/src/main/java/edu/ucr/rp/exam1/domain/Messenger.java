package edu.ucr.rp.exam1.domain;

import edu.ucr.rp.exam1.domain.contact.Address;

public class Messenger {
    private String message;
    private Address medium;


    public Messenger(String message, Address medium) {
        this.medium=medium;
        this.message=message;
    }

    public void send() {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Enviando el mensaje '"+message+"'");
        System.out.println("Al "+medium.getType()+ ": '"+medium.getDestiny()+"'");
        System.out.println("------------------------------------------------------------------------------------------");
    }
}
