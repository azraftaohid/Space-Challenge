package rocket;

import struct.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public ArrayList<ArrayList<Item>> loadItems(String[] paths) throws IOException {
        ArrayList<ArrayList<Item>> items=new ArrayList<>();
        for (String path:paths){
            BufferedReader phase=new BufferedReader(new FileReader(path));
            Scanner lineReader=new Scanner(phase);
            String line;
            ArrayList<Item> phaseItems=new ArrayList<>();
            while (lineReader.hasNextLine()){
                line=lineReader.nextLine();
                boolean isName=true;
                String itemName="";
                for (String x:line.split("=")){
                    if (isName){
                        itemName=x;
                        isName=false;
                    } else {
                        phaseItems.add(new Item(itemName, Double.parseDouble(x)));
                        isName=true;
                    }
                }
            }
            items.add(phaseItems);
        }
        return items;
    }

    public ArrayList<Rocket> loadRocket(Rocket rocket, ArrayList<Item> items){
        ArrayList<Rocket> rockets=new ArrayList<>();
        int remainingItems=items.size();

        ArrayList<Item> tempItems=new ArrayList<>();

        for (Item item:items){
            Item x;
            try {
                x=(Item) item.clone();
            } catch (CloneNotSupportedException e){
                x=new Item(item.getName(), item.getWeight());
            }
            tempItems.add(x);
        }

        for (; remainingItems!=0; ) {
            Rocket tempRocket;

            try {
                tempRocket=(Rocket) rocket.clone();
            } catch (CloneNotSupportedException e){
                System.err.println(e.getMessage());
                return rockets;
            }

            int i=0;
            for (Item item:tempItems) {
                if (!item.isHasLoaded()){
                    if (item.getWeight()>(rocket.getMaxWeight()-rocket.getWeight())){
                        tempItems.get(i).setHasLoaded(true);
                        remainingItems--;
                    }
                    if (tempRocket.canCarry(item)) {
                        tempRocket.carry(item);
                        tempItems.get(i).setHasLoaded(true);
                        remainingItems--;
                    }
                }
                i++;
            }
            rockets.add(tempRocket);
        }

        return rockets;
    }


    public int runSimulation(ArrayList<Rocket> rockets){
        int budget=0;

        for (int i=0; i<rockets.size(); i++){
            budget+=rockets.get(i).getRocketCost();
            if (!rockets.get(i).launch()) {
                i--;
            } else {
                if (!rockets.get(i).land()) {
                    i--;
                }
            }
        }

        return budget;
    }

}