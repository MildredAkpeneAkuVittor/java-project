package classes;
import interfaces.Ecustomer;

import java.util.ArrayList;

public class customer implements Ecustomer {
    private String name;
    private ArrayList<Double> transactions;

    public customer(String name, double initialTransaction){
        this.name = name;
        this.transactions = new ArrayList<>();
        this.transactions.add(initialTransaction);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double transaction){
        this.transactions.add(transaction);
    }

}
