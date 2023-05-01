package Tuitering;

public class MonthData {
    private int[] days;

    public int getSteps(int day) {
        return days[day];
    }

    public void setDays (int day, int steps) {
        days[day] = steps;
    }

    public MonthData() {
         days = new int[30];
        for (int i = 0; i < 30; i++) {
                days[i] = 0;
            }

    }
}
