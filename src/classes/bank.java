package classes;

import interfaces.Ebanking;
import interfaces.Ebranch;

import java.util.ArrayList;

public class bank  implements Ebanking {
    private String name;
    private ArrayList<Branch> branches;

    public bank(String name){
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction){
        Branch branch = findBranch(branchName);
        if(branch != null){
            branch.newCustomer(customerName,initialTransaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction){
        Branch branch = findBranch(branchName);
        if(branch != null){
            branch.addCustomerTransaction(customerName, transaction);
            return true;
        }
        return false;
    }

    public boolean listCustomers(String branchName, boolean printTransactions){
        Branch branch = this.findBranch(branchName);
        if(branch != null) {
            ArrayList<customer> customers = Branch.getcustomers();
            System.out.println("Customer details for branch " + branchName);
            if (!printTransactions) {
                for (int i = 0; i < customers.size(); i++) {
                    System.out.println("Customer: " + customers.get(i).getName() + "[" + (i + 1) + "]");
                }
                return true;
            }
            for (int i = 0; i < customers.size(); i++) {
                System.out.println("Customer: " + customers.get(i).getName() + "[" + (i + 1) + "]");
                System.out.println("Transactions");
                ArrayList<Double> transactions = customers.get(i).getTransactions();
                for(int j = 0; j < transactions.size(); j++){
                    System.out.println("["+(j+1)+"]" +"Amount " + transactions.get(j));
                }
            }
            return true;
        }

        return false;
    }

    public boolean addBranch(String branchName){
        if(findBranch(branchName) == null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }


    private Branch findBranch(String branchName){
        for(Branch branch:branches){
            if(branch.getName().equals(branchName)){
                return branch;
            }
        }
        return null;
    }

}
