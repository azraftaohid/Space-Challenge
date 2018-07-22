package struct;

public class Item implements Cloneable {
    private String name;
    private double weight;
    private boolean hasLoaded;

    public Item(String name, double weight){
        this.name=name;
        this.weight=weight;
        this.hasLoaded=false;
    }

    public String getName(){
        return this.name;
    }

    public double getWeight() {
        return weight;
    }

    public void setHasLoaded(boolean hasLoaded) {
        this.hasLoaded = hasLoaded;
    }

    public boolean isHasLoaded() {
        return hasLoaded;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
