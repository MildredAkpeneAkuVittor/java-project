package interfaces;

public interface Ebranch {
    public boolean addCustomerTransaction(String customerName, double transaction);

    public boolean newCustomer(String customerName, Double initialTransaction);
}

