package rocket;

public class U2 extends Rocket {

    public U2(){ super("U2", 120, 16329.3, 26308.4); }

    @Override
    public boolean launch() {

        //Chance of launch explosion = 4% * (cargo carried / cargo limit)
        double luck=(4*(getCurrentWeight()/getMaxWeight()))/100;
        double luckyNumber=(Math.random());

        return luckyNumber>luck;

    }

    @Override
    public boolean land() {

        //Chance of landing crash = 8% * (cargo carried / cargo limit)
        double luck=(8*(getCurrentWeight()/getMaxWeight()))/100;
        double luckyNumber=(Math.random());

        return luckyNumber>luck;

    }

}
