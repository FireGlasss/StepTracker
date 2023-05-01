package Report;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MonthlyReport {
    private ArrayList<Transaction> transactions;

    private String month;


    public MonthlyReport(ArrayList<Transaction> transactions, String month) {
        this.month = month;
        this.transactions = transactions;

    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public String getMonth() {
        return month;
    }

    public int getSummaIncome() {
        int sum = 0;
        for(Transaction t : transactions) {
            if (!t.isExpense()) {
                sum += t.getSumma();
            }
        }
        return sum;
    }

    public int getSummaExpenses() {
        int sum = 0;
        for(Transaction t : transactions) {
            if (t.isExpense()) {
                sum += t.getSumma();
            }
        }
        return sum;
    }

    public Transaction getMostProfitableTransaction() {
        int maxIncome = 0;
        Transaction returnable = null;
        for (Transaction t : transactions) {
            if (!t.isExpense()) {
                if (maxIncome < t.getSumma()) {
                    maxIncome = t.getSumma();
                    returnable = t;
                }
            }
        }
        return returnable;
    }

    public String getMostProfitableTransactionName() {
        return getMostProfitableTransaction().getItemName();
    }

    public Transaction getMostExpenseTransaction () {
        int maxExpense = 0;
        Transaction returnable = null;
        for (Transaction t : transactions) {
            if (t.isExpense()) {
                if (maxExpense < t.getSumma()) {
                    maxExpense = t.getSumma();
                    returnable = t;
                }
            }
        }
        return returnable;
    }
    public String getMostExpenseTransactionName() {
        return getMostExpenseTransaction().getItemName();
    }

    public int getMostIncome() {
        return getMostProfitableTransaction().getSumma();
    }

    public int getMostExpense() {
        return getMostExpenseTransaction().getSumma();
    }



}
