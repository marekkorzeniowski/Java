import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches =new ArrayList<Branch>();
    }
    public boolean addBranch (String branchName) {
        if(findBranch(branchName)==null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer (String branch, String customer, double initialAmount) {
        Branch searchedBranch = findBranch(branch);
        if(searchedBranch!=null) {
            return searchedBranch.newCustomer(customer,initialAmount);
        }
        return false;
    }
    public boolean addCustomerTransaction (String branch, String customer, double amount) {
        Branch searchedBranch = findBranch(branch);
        if(searchedBranch!=null) {
            return searchedBranch.addCustomerTransaction(customer,amount);
        }
        return false;
    }

    private Branch findBranch (String name) {
        for (int i=0; i<this.branches.size(); i++) {
            if(this.branches.get(i).getName().equals(name)) {
                return this.branches.get(i);
            }

        }
        return null;
    }

    public boolean listCustomers (String branchName, boolean showTransaction) {

        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer detail for branch: " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i=0; i<branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println((i+1) + " Customer: " + branchCustomer.getName());
                if (showTransaction){
                    System.out.println("Transactions ");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j=0;j<transactions.size(); j++) {
                        System.out.println((j+1) + " Transaction " + transactions.get(j));
                    }
                }
            }
            return true;
        }
        return false;
    }

}
