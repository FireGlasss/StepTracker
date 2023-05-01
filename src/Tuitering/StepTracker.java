package Tuitering;

public class StepTracker {
    private int goal = 10000;
    private MonthData[] monthData;
    public StepTracker() {
        monthData = new MonthData[12];
        for (int i = 0; i < monthData.length; i++) {
            monthData[i] = new MonthData();
        }
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }


    public void addData(int month, int day, int stepsToday) {
            monthData[month - 1].setDays(day - 1, stepsToday);
            System.out.println("Данные внесены!");

    }

    public void printGeneralStatistics(int month, int choseStatic) {
            if (choseStatic == 1) {
                for (int i = 0; i < 30; i++) {
                    System.out.println("За " + (i + 1) + " день: " + monthData[month-1].getSteps(i));
                }
            } else if (choseStatic == 2) {
                System.out.println("Сумма шагов за месяц составляет: " + getSummaStepsPerMonth(month - 1));
            } else if (choseStatic == 3) {
                System.out.println("Максимально количество шагов за этот месяц: " + getStepsMaxPerMonth(month - 1));
            } else if (choseStatic == 4) {
                System.out.println("Среднее количество пройденных шагов: " + getAverageSteps(month - 1));
            } else if (choseStatic == 5) {
                System.out.println("Вы прошли за данный месяц: " + getStepsInKM(month - 1) + " км");
            } else if (choseStatic == 6) {
                System.out.println("Вы сожгли - " + getStepsInCalories(month - 1) + " килокалорий");
            } else if (choseStatic == 7) {
                System.out.println("Максимальная серия в днях составляет: " + getStepsCombo(month - 1));
            } else if (choseStatic == 8) {
                getAllStatisticPerMonth(month);
            }
    }
    private int getSummaStepsPerMonth(int month) {
        return getSumSteps(month);
    }

    private int getStepsMaxPerMonth(int month) {
        int max = 0;
        for (int day = 0; day < 29; day++) {
            if (monthData[month].getSteps(day) > monthData[month].getSteps(day + 1) && max < monthData[month].getSteps(day)) {
                max = monthData[month].getSteps(day);
            } else if (monthData[month].getSteps(day) < monthData[month].getSteps(day + 1) && max < monthData[month].getSteps(day + 1)) {
                max = monthData[month].getSteps(day + 1);
            }
        }
        return max;
    }

    private int getAverageSteps(int month) {
        return getSumSteps(month) / 30;
    }

    private double getStepsInKM(int month) {
        return Converter.stepToKM(getSumSteps(month));
    }
    private int getStepsInCalories(int month) {
        int summa = getSumSteps(month);
        return Converter.stepToCalories(summa);
    }
    private int getStepsCombo(int month) {
        int combo = 0;
        int timerCombo = 0;
        for (int i = 0; i < 30; i++) {
            if (monthData[month].getSteps(i) >= goal) {
                combo++;
            } else {
                if (timerCombo <= combo) {
                    timerCombo = combo;
                }
                combo = 0;
            }
        }
        if (timerCombo <= combo) { // повторение одного и того же кода
            timerCombo = combo;
        }
        return  timerCombo;
    }

    private void getAllStatisticPerMonth(int month) {
        for (int i = 1; i < 8; i++)
        printGeneralStatistics(month, i);
    }

    public int getSumSteps(int month) {
        int summa = 0;
        for (int i = 0; i < 30; i++) {
            summa += monthData[month].getSteps(i);
        }

        return summa;
    }

}