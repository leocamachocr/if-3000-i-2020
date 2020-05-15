package edu.ucr.rp.exam1;

import edu.ucr.rp.exam1.domain.Client;
import edu.ucr.rp.exam1.domain.Messenger;
import edu.ucr.rp.exam1.domain.contact.Address;
import edu.ucr.rp.exam1.domain.contact.Telephone;

public class MessageDemo {

    public static void main(String args[]) {
        Client client = new Client();
        client.setName("Leo");

        Address phone = new Telephone();

        client.addContactMedium(phone);


        String message = "Su producto está listo para retirar";
        for (Address medium : client.getAddresses()) {
            Messenger messenger = new Messenger(message, medium);
            messenger.send();
        }
    }
}
