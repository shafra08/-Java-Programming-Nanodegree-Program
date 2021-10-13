package spaceChallenge;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        double costMeOne, costMeTwo;
        ArrayList<Rocket> rockAway;
        ArrayList<Rocket> testTwo;
        ArrayList<Item> testOne;

        Simulation cookie = new Simulation();

        testOne =cookie.loadItems();

        System.out.println("Starting simulation for U-1");

        rockAway = cookie.loadU1(testOne);

        costMeOne = cookie.runSimulation(rockAway);

        System.out.println("Rocket U-1 needs a total of $"+costMeOne +" to launch\n");

        System.out.println("Starting simulation for U-2");

        testTwo = cookie.loadU2(testOne);

        costMeTwo= cookie.runSimulation(testTwo);

        System.out.println("Rocket U-2 needs a total of $"+costMeTwo +" to launch\n");



    }
}
