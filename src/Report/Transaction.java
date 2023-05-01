package Report;

public class Transaction {


    private String itemName;

    private boolean isExpense;

    private int quantity;

    private int sumOfOne;

    public Transaction(String itemName, boolean isExpense, int quantity, int sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
    public String getItemName() {
        return itemName;
    }
    public boolean isExpense() {
        return isExpense;
    }
    public int getSumma () {
        return quantity * sumOfOne;
    }
}
