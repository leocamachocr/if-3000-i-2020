package edu.ucr.rp.homework2;

import edu.ucr.rp.homework2.domain.Client;
import edu.ucr.rp.homework2.domain.Company;
import edu.ucr.rp.homework2.domain.Invoice;
import edu.ucr.rp.homework2.domain.Product;

public class InvoiceDemo {
    public static void main(String args[]) {
        Company minSuper2048 = new Company();
        minSuper2048.setName("Mini 2048");

        Product rice = new Product();
        rice.setName("Arroz 2k");
        rice.setPrice(2_000D);
        rice.setTax(0D);
        rice.setApplyTax(false);

        Product chocolate = new Product();
        chocolate.setName("Chocolate Milka");
        chocolate.setPrice(1_500D);
        chocolate.setTax(13D);
        chocolate.setApplyTax(true);

        minSuper2048.registerProduct(rice);//nuevo
        minSuper2048.registerProduct(chocolate);

        Client bart = new Client();
        bart.setName("Bartholomeo J Simpson");

        Invoice invoice = new Invoice(bart, minSuper2048);
        invoice.setServiceTax(false);
        minSuper2048.registerInvoice(invoice);
        invoice.addProduct(chocolate);
        invoice.addProduct(rice);
        invoice.calculatePrice();

        System.out.println("Precio sub-total = " + invoice.getSubTotal());
        System.out.println("Precio total = " + invoice.getTotal());
    }
}
