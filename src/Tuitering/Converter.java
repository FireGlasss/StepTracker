package Tuitering;

public class Converter {


    private static int smStep = 75;
    private static int calories = 50;


    public static double stepToKM(double summaStepsForMonth) {
        double km = (summaStepsForMonth * 75)/100000;
        return km;
    }

    public static int stepToCalories(int summaStepsForMonth) {
        int Kcalories = (summaStepsForMonth * 50) / 1000;
        return Kcalories;

    }

    public static int getSmStep() {
        return smStep;
    }

    public static void setSmStep(int smStep) {
        Converter.smStep = smStep;
    }

    public static int getCalories() {
        return calories;
    }

    public static void setCalories(int calories) {
        Converter.calories = calories;
    }

}