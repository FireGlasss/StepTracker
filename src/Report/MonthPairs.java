package Report;

public class MonthPairs {
    private MonthIncome monthIncome;
    private MonthExpense monthExpense;
    private int month;

    public MonthPairs(MonthIncome monthIncome, MonthExpense monthExpense, int month) {
        this.monthIncome = monthIncome;
        this.monthExpense = monthExpense;
        this.month = month;
    }
    public int getMonthIncomeAmount() {
        return monthIncome.getAmount();
    }

    public int getMonthExpenseAmount() {
        return monthExpense.getAmount();
    }

    public String getMonthName() {
        String monthName = "";
        switch (month) {
            case 1:
                monthName = "Январь";
                break;
            case 2:
                monthName = "Февраль";
                break;
            case 3:
                monthName = "Март";
                break;
            case 4:
                monthName = "Аперль";
                break;
            case 5:
                monthName = "Май";
                break;
            case 6:
                monthName = "Июнь";
                break;
            case 7:
                monthName = "Июль";
                break;
            case 8:
                monthName = "Август";
                break;
            case 9:
                monthName = "Сентябрь";
                break;
            case 10:
                monthName = "Октябрь";
                break;
            case 11:
                monthName = "Ноябрь";
                break;
            case 12:
                monthName = "Декабрь";
                break;
            default:
                return null;
        }
        return monthName;
    }
}
