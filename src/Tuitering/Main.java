package Tuitering;

import javax.xml.crypto.Data;
import java.util.Scanner;

public class Main {
    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }

    public static void printStatistics() {
        System.out.println("Выберете какую именно статистику за месяц вы бы хотели узнать?");
        System.out.println("1 - Количество пройденных шагов по дням недели");
        System.out.println("2 - Общее количество шагов");
        System.out.println("3 - Максильмальное пройденное количество шагов");
        System.out.println("4 - Среднее количество шагов");
        System.out.println("5 - Пройденная дистанция ");
        System.out.println("6 - Количество соженных каллорий");
        System.out.println("7 - Лучшая серия шагов");
        System.out.println("8 - Общий отчет по всем пунктам");

    }

    public static void main(String[] args) {
        printMenu();
        Scanner sc = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        try {
            int chose = sc.nextInt();
            while (chose != 0) {
                if (chose == 1) {
                    int month;
                    do {
                        System.out.print("Введите текущий месяц - ");
                        month = sc.nextInt();
                        if ((!((month - 1) >= 0 && month <= 12))) {
                            System.out.println("Введен некорректный месяц");
                        }
                    } while (!((month - 1) >= 0 && month <= 12));

                    int day;
                    do {
                        System.out.print("Введите текущий день месяца - ");
                        day = sc.nextInt();
                        if (!isDayCorrect(day)) {
                            System.out.println("Введен некорректный день");
                        }
                    } while (!isDayCorrect(day));

                    int stepsToday;
                    do {
                        System.out.print("Введите сколько шагов вы прошли - ");
                        stepsToday = sc.nextInt();
                        if (!(stepsToday >= 0)) {
                            System.out.println("Введено некорректное число шагов");
                        }
                    } while (!(stepsToday >= 0));
                    stepTracker.addData(month, day, stepsToday);
                } else if (chose == 2) {
                    int monthData;
                    int choseStatic;
                    do {
                        System.out.println("Введите за какой месяц требуется отобразить статистику: ");
                        monthData = sc.nextInt();
                        if (!(monthData - 1 >= 0)) {
                            System.out.println("Выбран некорректный месяц");
                        }
                    }while (!(monthData - 1 >= 0));
                    do {
                        printStatistics();
                        choseStatic = sc.nextInt();
                        if (!(choseStatic >= 1 && choseStatic <= 8)) {
                            System.out.println("Нет такого пункта");
                        }
                    } while (!(choseStatic >= 1 && choseStatic <= 8));

                    stepTracker.printGeneralStatistics(monthData, choseStatic);
                }
                 else if (chose == 3) {
                    System.out.println("Текущая цель по шагам - " + stepTracker.getGoal());
                    System.out.print("Введите новую цель: ");
                    int newGoal = sc.nextInt();
                    stepTracker.setGoal(newGoal);
                    System.out.println("Новая цель успешно установлена!");
                } else {
                    System.out.println("Введена некорректная команда! Пожалуйста, выберете команду из списка: ");
                }
                System.out.println();
                printMenu();
                chose = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Введена некорректная команда, пожалуйста, запустите программу ещё раз!");
            throw e;
        }

    }

    private static boolean isDayCorrect(int day) {
        return day - 1 >= 0 && day <= 30;
    }
}
