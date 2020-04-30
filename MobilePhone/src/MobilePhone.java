import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList <Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList <Contact>();
    }

    public boolean addNewContact (Contact contact) {

        if(findContact(contact.getName())>=0) {
            System.out.println("Contact already exists");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact (Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position<0) {
            System.out.println("Contact doesn't exist");
            return false;
        }
        else if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact with " + newContact.getName() + " failed, contact already exists");
            return  false;
        }
        this.myContacts.set(position, newContact);
        System.out.println(oldContact.getName()+ "was replaced" + newContact.getName());
        return true;
    }

    private int findContact (Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact (String contactName) {

        for (int i=0; i<this.myContacts.size();i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact (Contact contact) {
        if (findContact(contact)>=0){
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact (String name) {
        int position = findContact(name);
        if (position>=0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public boolean removeContact (Contact contact) {
        int foundPosition = findContact(contact);

        if (foundPosition<0) {
            System.out.println("Contact doesnt exist");
            return false;
        }
        System.out.println(contact.getName()+ " was successfully removed!");
        this.myContacts.remove(foundPosition);
        return true;
    }

    public void printContacts () {

        for (int i=0; i<this.myContacts.size(); i++) {
            System.out.println((i+1)+ ". "+ this.myContacts.get(i).getName()
                                + " --> "+ this.myContacts.get(i).getPhoneNumber());
        }
    }




}
