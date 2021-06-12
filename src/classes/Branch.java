package classes;
import interfaces.Ebranch;

import java.util.ArrayList;

public class Branch implements Ebranch {

    private String name;
    private ArrayList<customer> customers;


    public Branch(String name){
        this.name = name;
        this.customers = new ArrayList<customer>();
    }

    public String getName() {
        return name;
    }

    public static ArrayList<customer> getcustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, Double initialTransaction){
        if(findcustomer(customerName) == null) {
            customer customer = new customer(customerName, initialTransaction);
            this.customers.add(customer);
            return true;
        }
        System.out.println("customer already exists");
        return false;
    }

    private customer findcustomer(String customerName){
        for(customer customer : customers){
            if(customerName.equals(customer.getName())) {
                return customer;
            }
        }
        return null;
    }

    public boolean addCustomerTransaction(String customerName, double transaction){
        customer customer = findcustomer(customerName);
        if(customer == null){
            return false;
        }
        customer.getTransactions().add(transaction);
        return true;
    }
}

