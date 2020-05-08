package edu.ucr.rp.homework2.domain;

public class Product {
    private String name;
    private Double price;
    private Boolean applyTax;
    private Double tax;//ejemplo 13 -> 13%

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getApplyTax() {
        return applyTax;
    }

    public void setApplyTax(Boolean applyTax) {
        this.applyTax = applyTax;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double calculateFinalPrice() {
        if (applyTax) {
            return price * (1 + (tax / 100));
        }
        return price;
    }
}
