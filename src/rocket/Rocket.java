package rocket;

import struct.Item;

public class Rocket implements SpaceShip, Cloneable{
    private final String name;
    private final int rocketCost;
    private final double weight;
    private final double maxWeight;
    private double currentWeight;

    Rocket(String name, int rocketCost, double rocketWeight, double maxWeight){
        this.name=name;
        this.rocketCost=rocketCost;
        this.weight=rocketWeight;
        this.maxWeight=maxWeight;
        this.currentWeight=rocketWeight;
    }

    public boolean launch(){

        return true;
    }

    public boolean land(){

        return true;
    }

    public boolean canCarry(Item item){
        return item.getWeight()<(this.maxWeight-this.currentWeight);
    }

    public void carry(Item item){
        this.currentWeight+=item.getWeight();
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public String getName() {
        return name;
    }

    double getCurrentWeight() {
        return this.currentWeight;
    }

    double getMaxWeight() {
        return this.maxWeight;
    }

    int getRocketCost() { return this.rocketCost; }

    double getWeight() {
        return weight;
    }
}
