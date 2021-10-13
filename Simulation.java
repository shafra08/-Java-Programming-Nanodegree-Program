package spaceChallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    ArrayList<Item> spacers= new ArrayList<>();
    File phaseOne = new File("src/spaceChallenge/phase-1.txt");
    File phaseTwo = new File("src/spaceChallenge/phase-2.txt");
    Item fillUp = new Item();
    Scanner fileOne;
    private String baggage;
    private int iloop;
    ArrayList<U1> mission1 = new ArrayList<>();
    ArrayList<U2> mission2 = new ArrayList<>();

    {
        try {
            fileOne = new Scanner(phaseOne);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Scanner fileTwo;

    {
        try {
            fileTwo = new Scanner(phaseTwo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList loadItems(){
        while(fileOne.hasNextLine()){
            baggage = fileOne.nextLine();
            iloop =0;

            for(String list:baggage.split("=")){
                if(iloop ==0){
                    fillUp.setName(list);
                }else {
                    fillUp.setWeight(Integer.parseInt(list));
                }
                iloop ++;
            }
            spacers.add(fillUp);
            fillUp = new Item();
        }

        baggage = null;
        fillUp = new Item();

        while(fileTwo.hasNextLine()){
            baggage = fileTwo.nextLine();
            iloop =0;

            for(String list:baggage.split("=")){
                if(iloop ==0){
                    fillUp.setName(list);
                }else {
                    fillUp.setWeight(Integer.parseInt(list));
                }
                iloop ++;
            }
            spacers.add(fillUp);
            fillUp = new Item();
        }


        return spacers;
    }

    public ArrayList loadU1(ArrayList spacers){

        U1 spaceOutOne = new U1();

        for(int i=0; i< spacers.size();i++){
            if(spaceOutOne.canCarry((Item) spacers.get(i))){
                spaceOutOne.carry((Item) spacers.get(i));
            }
            else
            {
                mission1.add(spaceOutOne);
                spaceOutOne = new U1();
                spaceOutOne.carry((Item) spacers.get(i));
            }
        }
        mission1.add(spaceOutOne);

        return mission1;
    }

    public ArrayList loadU2(ArrayList spacers) {

        U2 spaceOutTwo = new U2();

        for (int i = 0; i < spacers.size(); i++) {
            if (spaceOutTwo.canCarry((Item) spacers.get(i))) {
                spaceOutTwo.carry((Item) spacers.get(i));
            } else {
                mission2.add(spaceOutTwo);
                spaceOutTwo = new U2();
                spaceOutTwo.carry((Item) spacers.get(i));
            }
        }
        mission2.add(spaceOutTwo);

        return mission2;
    }

    public double runSimulation(ArrayList<Rocket> leSigh){
        double totalCost = 0.0;

        for(int i = 0; i<leSigh.size();i++){
            leSigh.get(i).launch();
            leSigh.get(i).land();

           if(leSigh.get(i).exploded == true || leSigh.get(i).crashLanding == true) {
               totalCost += leSigh.get(i).getCost();
           }
        }

        return totalCost;

    }


}