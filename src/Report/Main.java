package Report;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void printMenu() {
        System.out.println("1 - Считать все месячные отчеты");
        System.out.println("2 - Считать годовой отчет");
        System.out.println("3 - Сверить отчеты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выйти из программы");
        System.out.print("Какой пункт меню вас интересует - ");
    }

    public static void main(String[] args) {
        printMenu();
        Scanner sc = new Scanner(System.in);
        ArrayList<MonthlyReport> monthlyReports = new ArrayList<>();
        ArrayList<YearlyReport> yearlyReports = new ArrayList<>();
        try {
            int chose = sc.nextInt();
            while (chose != 0) {
                if (chose == 1) {
                    int counter = 1;
                    while (ReaderFile.readFileContentsOrNull("C:\\Users\\Asus\\Desktop\\Project\\m.20210" + counter + ".csv") != null) {
                        String dataFromFile = ReaderFile.readFileContentsOrNull("C:\\Users\\Asus\\Desktop\\Project\\m.20210" + counter + ".csv");
                        String[] lines = dataFromFile.split("\n"); // разделение на строки и добаление в массив
                        ArrayList<Transaction> allTransactionsForMonth = new ArrayList<>(); // коллекция, которая состоит из всех транзакций в течении месяца
                        String[] lineContents; // Массив, для разделенных позиций в строках
                        try {
                            for (int i = 1; i < lines.length; i++) {
                                lineContents = lines[i].split(","); // разделение по позициям
                                Transaction transaction = new Transaction(lineContents[0], Boolean.parseBoolean(lineContents[1]),
                                        Integer.parseInt(lineContents[2]), Integer.parseInt(lineContents[3])); // Создание транзакции, исходя из заполнения полей.
                                allTransactionsForMonth.add(transaction); // добавление строки транзакций за месяц
                            }
                        } catch (Exception e) {
                            System.out.println("Файл некорректен");
                        }
                        switch (counter) {
                            case 1:
                                monthlyReports.add(new MonthlyReport(allTransactionsForMonth, "Январь"));
                                System.out.println("Данные за Январь внесены!");
                                break;
                            case 2:
                                monthlyReports.add(new MonthlyReport(allTransactionsForMonth, "Февраль"));
                                System.out.println("Данные за Февраль внесены!");
                                break;
                            case 3:
                                monthlyReports.add(new MonthlyReport(allTransactionsForMonth, "Март"));
                                System.out.println("Данные за Март внесены!");
                                break;
                            case 4:
                                monthlyReports.add(new MonthlyReport(allTransactionsForMonth, "Апрель"));
                                System.out.println("Данные за Апрель внесены!");
                                break;
                            case 5:
                                monthlyReports.add(new MonthlyReport(allTransactionsForMonth, "Май"));
                                System.out.println("Данные за Май внесены!");
                                break;
                            case 6:
                                monthlyReports.add(new MonthlyReport(allTransactionsForMonth, "Июнь"));
                                System.out.println("Данные за Июнь внесены!");
                                break;
                            case 7:
                                monthlyReports.add(new MonthlyReport(allTransactionsForMonth, "Июль"));
                                System.out.println("Данные за Июль внесены!");
                                break;
                            case 8:
                                monthlyReports.add(new MonthlyReport(allTransactionsForMonth, "Август"));
                                System.out.println("Данные за Август внесены!");
                                break;
                            case 9:
                                monthlyReports.add(new MonthlyReport(allTransactionsForMonth, "Сентябрь"));
                                System.out.println("Данные за Сентябрь внесены!");
                                break;
                            case 10:
                                monthlyReports.add(new MonthlyReport(allTransactionsForMonth, "Октябрь"));
                                System.out.println("Данные за Октябрь внесены!");
                                break;
                            case 11:
                                monthlyReports.add(new MonthlyReport(allTransactionsForMonth, "Ноябрь"));
                                System.out.println("Данные за Ноябрь внесены!");
                                break;
                            case 12:
                                monthlyReports.add(new MonthlyReport(allTransactionsForMonth, "Декабрь"));
                                System.out.println("Данные за декабрь внесены!");
                                break;
                        }
                        counter++;
                    }
                }
                if (chose == 2) {
                    String dataFromFileForYear = ReaderFile.readFileContentsOrNull("C:\\Users\\Asus\\Desktop\\Project\\y.2021.csv");
                    String[] lines = dataFromFileForYear.split("\n");
//                   ArrayList<YearValues> allYearsValues = new ArrayList<>();
                    ArrayList<MonthIncome> allMonthIncome = new ArrayList<>();
                    ArrayList<MonthExpense> allMonthExpense = new ArrayList<>();
                    ArrayList<MonthPairs> allPair = new ArrayList<>();
                    String[] lineContents;
                    try {
                        for (int i = 1; i < lines.length; i++) {
                            lineContents = lines[i].split(",");
                            if (Boolean.parseBoolean(lineContents[2])) {
                                MonthExpense monthExpense = new MonthExpense(Integer.parseInt(lineContents[1]));
                                allMonthExpense.add(monthExpense);
                            } else {
                                MonthIncome monthIncome = new MonthIncome(Integer.parseInt(lineContents[1]));
                                allMonthIncome.add(monthIncome);
                            }
                        }
//                            YearValues yearValues = new YearValues(Integer.parseInt(lineContents[0]),
//                                        Integer.parseInt(lineContents[1]), Boolean.parseBoolean(lineContents[2]));
//                                allYearsValues.add(yearValues);
                        for (int j = 0; j < lines.length/2; j++) {
                            MonthPairs monthPair = new MonthPairs(allMonthIncome.get(j), allMonthExpense.get(j), j+1);
                            allPair.add(monthPair);
                        }
                    } catch (Exception e) {
                        System.out.println("Файл некорректен");
                    }
                    yearlyReports.add(new YearlyReport(allPair));
//                    yearlyReports.add(new YearlyReport(allYearsValues));
                    System.out.println("Данные за год внесены!");

                }
                if (chose == 3) {
                    System.out.println();
                    for (MonthlyReport monthlyReport : monthlyReports) {
                        System.out.println("\n" + "Доходы за " + monthlyReport.getMonth() + " " + monthlyReport.getSummaIncome());
                        System.out.println("Расходы за " + monthlyReport.getMonth() + " " + monthlyReport.getSummaExpenses());
                        yearlyReports.get(0).checkingTheOperation(monthlyReport);
                    }
                }
                if (chose == 4) {
                    System.out.println();
                    for (MonthlyReport monthlyReport : monthlyReports) {
                        System.out.println("\n" + "Месяц - " + monthlyReport.getMonth());
                        System.out.println("Самый доходный товар - " + monthlyReport.getMostProfitableTransactionName() + "\n" +
                                "Доход с товара составила - " + monthlyReport.getMostIncome());
                        System.out.println("Самый убыточный товар - " + monthlyReport.getMostExpenseTransactionName() + "\n" + // как в профите
                                "Убыток с товара составил - " + monthlyReport.getMostExpense());
                    }
                }
                if (chose == 5) {
                    System.out.println();
                    System.out.println("ОТЧЕТ ЗА 2021 ГОД");
                    yearlyReports.get(0).profitСalculation();
                    System.out.println("Средний расход за год - " + yearlyReports.get(0).averageExpense() + " рублей.");
                    System.out.println("Средний доход за год - " + yearlyReports.get(0).AverageIncome() + " рублей.");
                }
                System.out.println();
                printMenu();
                chose = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Введено не корректное значение, перезапустите программу!");
        }
    }
}


