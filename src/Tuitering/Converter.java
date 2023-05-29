package Tuitering;

public class Converter {


    private final static int smStep = 75;
    private final static int calories = 50;


    public static double stepToKM(double summaStepsForMonth) {
        return (summaStepsForMonth * smStep)/100000;

    }

    public static int stepToCalories(int summaStepsForMonth) {
        return ( summaStepsForMonth * calories) / 1000;
    }
}