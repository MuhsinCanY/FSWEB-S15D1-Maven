package org.example.mobile;

import java.util.*;


public class MobilePhone {

    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
    }

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact)>=0) {
            return false;
        } else {
            myContacts.add(contact);
            return true;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        if (findContact(oldContact)>=0) {
            myContacts.set(myContacts.indexOf(oldContact), newContact);
            return true;
        } else {
            return false;
        }
    }



    public boolean removeContact(Contact contact) {
        int index = findContact(contact);
        if (index != -1) {
            myContacts.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public int findContact(Contact contact) {
        for (int i = 0; i < myContacts.size(); i++) {
            String name = myContacts.get(i).getName();
            String phoneNumber = myContacts.get(i).getPhoneNumber();
//            if (contact.getName().equals(name) && contact.getPhoneNumber().equals(phoneNumber)) {
            if (contact.equals(myContacts.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public int findContact(String contact) {
        for (int i = 0; i < myContacts.size(); i++) {
            String name = myContacts.get(i).getName();
            if (name.equals(contact)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contact) {

        for(Contact myContact: myContacts){
            if(myContact.getName().equals(contact)){
                System.out.println("queryContact :" + myContact.getName()+ " " + myContact.getPhoneNumber());
                return myContact;
            }
        }

        return null;
    }

    public void printContact() {
        for (int i = 0; i < myContacts.size(); i++) {
            String name = myContacts.get(i).getName();
            String phoneNumber = myContacts.get(i).getPhoneNumber();
            System.out.println(i + 1 + ". " + name + " -> " + phoneNumber + " - " + myContacts.get(i));
        }
    }

}
