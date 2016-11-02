/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight.reservation.system;

import java.util.ArrayList;

/**
 *
 * @author kmhasan
 */
public class Customer {
    private String firstName;
    private String lastName;
    private MailingAddress mailingAddress;
    private ArrayList<PhoneNumber> phoneList;
    private ArrayList<PhoneNumber> faxList;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setMailingAddress(MailingAddress mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public MailingAddress getMailingAddress() {
        return mailingAddress;
    }

    public ArrayList<PhoneNumber> getPhoneList() {
        return phoneList;
    }

    public ArrayList<PhoneNumber> getFaxList() {
        return faxList;
    }
    
    
}
