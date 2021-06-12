package interfaces;

public interface Ebanking {
    public boolean addBranch(String branchName);

    public boolean listCustomers(String branchName, boolean printTransactions);

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction);

    public boolean addCustomer(String branchName, String customerName, double initialTransaction);
}
