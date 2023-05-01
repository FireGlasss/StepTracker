package Report;

import java.util.ArrayList;

public class YearlyReport {

    //    private ArrayList<YearValues> yearValues;
//
//    public YearlyReport(ArrayList<YearValues> yearValues) {
//        this.yearValues = yearValues;
//    }
    private ArrayList<MonthPairs> monthPairs;

    public YearlyReport(ArrayList<MonthPairs> monthPairs) {
        this.monthPairs = monthPairs;
    }

    public void checkingTheOperation(MonthlyReport monthlyReport) {
        for (MonthPairs monthPair : monthPairs) {
            if (monthlyReport.getMonth().equals(monthPair.getMonthName())) {
                if (monthlyReport.getSummaIncome() == monthPair.getMonthIncomeAmount()) {
                    System.out.println("Операция сравнения доходов с годовым отчетом прошла успешно");
                } else {
                    System.out.println("Обнаружено не совпадение доходов с годовым отчетом");
                }
                if (monthlyReport.getSummaExpenses() == monthPair.getMonthExpenseAmount()) {
                    System.out.println("Операция сравнения расходов с годовым отчетом прошла успешно");
                } else {
                    System.out.println("Обнаружено не совпадение расходов с годовым отчетом");

                }
            }
        }
    }

    public void profitСalculation() {
        for (MonthPairs monthPair : monthPairs) {
            String monthNow = monthPair.getMonthName();
            int profit;
            profit = monthPair.getMonthIncomeAmount() - monthPair.getMonthExpenseAmount();

//        for (int i = 0; i < yearValues.size(); i += 2) {
//            int monthNow = yearValues.get(i).getMonth();
//            int profit = 0;
//            if (!yearValues.get(i).isExpense()) {
//                profit = getYearValuesAmount(i) - getYearValuesAmount(i + 1);
//            } else {
//                profit = getYearValuesAmount(i + 1) - getYearValuesAmount(i);
//            }
            System.out.println("Прибыль за " + monthNow + " месяц, составляет - " + profit + " рублей.");
        }
    }

    public int averageExpense() {
        int allExpense = 0;
        for (MonthPairs monthPair : monthPairs) {
            allExpense += monthPair.getMonthExpenseAmount();
        }
        return allExpense / monthPairs.size(); // Так как позиций расходов, столько же по счету как и пар в целом

//        int expenseCounter = 0;
//        for (YearValues yearValue : yearValues){
//            if (yearValue.isExpense()) {
//                allExpense += yearValue.getAmount();
//                expenseCounter++;
//            }
//        }
//        return allExpense/expenseCounter;
    }

    public double AverageIncome() {
        int allIncome = 0;
        for (MonthPairs monthPair : monthPairs) {
            allIncome += monthPair.getMonthIncomeAmount();
        }
        return allIncome / monthPairs.size(); // monthPairs.size() - Так как позиций доходов, столько же по счету как и пар в целом
    }
//        int incomeCounter = 0;
//        for (YearValues yearValues : yearValues){
//            if (yearValues.isExpense() == false) {
//                allIncome += yearValues.getAmount();
//                incomeCounter++;
//            }
//        }
//        return allIncome/incomeCounter;

//    public int getYearValuesAmount (int line) {
//        return yearValues.get(line).getAmount();
//    }
//}
}