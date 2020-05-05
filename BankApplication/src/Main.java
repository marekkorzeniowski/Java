public class Main {

    public static void main(String[] args) {

        // Your job is to create a simple banking application.
        // There should be a Bank class
        // It should have an arraylist of Branches
        // Each Branch should have an arraylist of Customers
        // The Customer class should have an arraylist of Doubles (transactions)
        // Customer:
        // Name, and the ArrayList of doubles.
        // Branch:
        // Need to be able to add a new customer and initial transaction amount.
        // Also needs to add additional transactions for that customer/branch
        // Bank:
        // Add a new branch
        // Add a customer to that branch with initial transaction
        // Add a transaction for an existing customer for that branch
        // Show a list of customers for a particular branch and optionally a list
        // of their transactions
        // Demonstration autoboxing and unboxing in your code
        // Hint: Transactions// Add data validation.
        // e.g. check if exists, or does not exist, etc.
        // Think about where you are adding the code to perform certain actions

        Bank bank = new Bank("PKO");
        if(bank.addBranch("Warsaw")) {
            System.out.println("Warsaw branch created");
        }
        bank.addCustomer("Warsaw", "Marek", 50.05);
        bank.addCustomer("Warsaw", "Jarek", 175.34);
        bank.addCustomer("Warsaw", "Kasia", 220.12);
        bank.addBranch("Gdansk");
        bank.addCustomer("Gdansk", "Tomek", 150.54);
        bank.addCustomerTransaction("Warsaw", "Tim", 44.22);
        bank.addCustomerTransaction("Warsaw", "Tim", 12.44);
        bank.addCustomerTransaction("Warsaw", "Mike", 1.65);
        bank.listCustomers("Warsaw", true);
        bank.listCustomers("Gdansk", true);
        bank.addBranch("Lodz");
        if(!bank.addCustomer("Lodz", "Janka", 5.53)) {
            System.out.println("Error Lodz branch does not exist");
        }
        if(!bank.addBranch("Warsaw")) {
            System.out.println("Warsaw branch already exists");
        }
        if(!bank.addCustomerTransaction("Warsaw", "Fergus", 52.33)) {
            System.out.println("Customer does not exist at branch");
        }
        if(!bank.addCustomer("Warsaw", "Tim", 12.21)) {
            System.out.println("Customer Tim already exists"); }

    }
}
