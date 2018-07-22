package main;

import rocket.*;
import struct.Item;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        int U1Costs=0; //in million
        int U2Costs=0; //in million
        String[] itemDirectories=new String[2];
        ArrayList<ArrayList<Item>> phasesItems;

        ArrayList<ArrayList<Rocket>> U1Rockets=new ArrayList<>();
        ArrayList<ArrayList<Rocket>> U2Rockets=new ArrayList<>();

        itemDirectories[0]="resources\\Phase-1.txt";
        itemDirectories[1]="resources\\Phase-2.txt";

        Simulation simulate=new Simulation();

        phasesItems=simulate.loadItems(itemDirectories);

        for (ArrayList<Item> phaseItems:phasesItems){
            U1Rockets.add(simulate.loadRocket(new U1(), phaseItems));
            U2Rockets.add(simulate.loadRocket(new U2(), phaseItems));
        }

        for (ArrayList<Rocket> U1s:U1Rockets){
            U1Costs+=simulate.runSimulation(U1s);
        }
        System.out.println(U1Rockets.get(0).get(0).getName()+" costs: "+U1Costs+" million dollars");

        for (ArrayList<Rocket> U2s:U2Rockets){
            U2Costs+=simulate.runSimulation(U2s);
        }
        System.out.println(U2Rockets.get(0).get(0).getName()+" costs: "+U2Costs+" million dollars");

    }
}
