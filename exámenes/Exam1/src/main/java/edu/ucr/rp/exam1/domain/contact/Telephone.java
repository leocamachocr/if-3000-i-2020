package edu.ucr.rp.exam1.domain.contact;

public class Telephone implements Address {
    private String number;

    public String getDestiny() {
        return number;
    }

    public String getType() {
        return "Telephone";
    }
}
