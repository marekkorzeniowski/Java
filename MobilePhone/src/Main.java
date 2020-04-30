import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("534 888 199");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();

        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");

            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("\n Shutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;

            }


        }
     }

     private static void startPhone() {
         System.out.println("Starting phone");
     }

    public static void printActions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To shutdown.");
        System.out.println("\t 1 - To print contacts.");
        System.out.println("\t 2 - To add new contact.");
        System.out.println("\t 3 - To update existing contact.");
        System.out.println("\t 4 - To remove a contact.");
        System.out.println("\t 5 - To query for existing contact.");
        System.out.println("\t 6 - To print a list of available actions.");
        System.out.println("Choose your action: ");
    }

    private static void addNewContact() {
        System.out.println("Entera name: ");
        String name = scanner.nextLine();

        System.out.println("enter a number: ");
        String phone = scanner.nextLine();

        Contact newContact = Contact.createContact(name, phone);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println(name + " successfully added");
        }
        else {
            System.out.println("Already exist");
        }

    }

    private static void updateContact() {
        System.out.println("Entera name: ");
        String name = scanner.nextLine();

        Contact existingRecord = mobilePhone.queryContact(name);
        if (existingRecord == null) {
            System.out.println("Record not founded");
        return;
        }
        System.out.println("enter a name: ");
        String newName = scanner.nextLine();
        System.out.println("enter a number");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(newName,phone);
        if (mobilePhone.updateContact(existingRecord, newContact)){
            System.out.println("Successfully updated record");
        }
        else {
            System.out.println("Error updating record");
        }


    }
    private static void removeContact() {
        System.out.println("Entera name: ");
        String name = scanner.nextLine();

        Contact existingRecord = mobilePhone.queryContact(name);
        if (existingRecord == null) {
            System.out.println("Record not founded");
            return;
        }

        if(mobilePhone.removeContact(existingRecord)) {
            System.out.println("Successfully deleted");
        }
        else {
            System.out.println("Error deleting");
        }
    }

    private static void queryContact() {
        System.out.println("Entera name: ");
        String name = scanner.nextLine();

        Contact existingRecord = mobilePhone.queryContact(name);
        if (existingRecord == null) {
            System.out.println("Record not founded");
            return;
        }

        System.out.println("Name " + existingRecord.getName() + " number " + existingRecord.getPhoneNumber());
    }



}
