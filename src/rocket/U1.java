package rocket;

public class U1 extends Rocket {

    public U1(){
        super("U1", 100,9071.85, 16329.3);
    }

    @Override
    public boolean launch() {

        //Chance of launch explosion = 5% * (cargo carried / cargo limit)
        double luck=(5*(getCurrentWeight()/getMaxWeight()))/100;
        double luckyNumber=(Math.random());

        return luckyNumber>luck;
    }

    @Override
    public boolean land() {

        //Chance of landing crash = 1% * (cargo carried / cargo limit)
        double luck=(1*(getCurrentWeight()/getMaxWeight()))/100;
        double luckyNumber=(Math.random());

        return luckyNumber>luck;
    }

}