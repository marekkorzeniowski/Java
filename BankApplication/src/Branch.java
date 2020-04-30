import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer (String customerName, double initialAmount) {

        if (findCustomer(customerName)== null) {
            this.customers.add(new Customer(customerName,initialAmount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction (String customerName, double amount) {
        Customer existingCustomer =findCustomer(customerName);

        if(existingCustomer!=null) {
            existingCustomer.addTransacation(amount);
            return true;
        }
        return false;
    }
    public Customer findCustomer(String name) {

        for (int i=0; i<this.customers.size();i++) {
            if(this.customers.get(i).getName().equals(name)) {
                return this.customers.get(i);
            }
        }
        return null;
    }

}
