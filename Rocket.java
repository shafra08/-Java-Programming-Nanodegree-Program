package spaceChallenge;

public class Rocket implements SpaceShip{
    double cost ;
    double weight ;
    double maxWeight;
    boolean exploded;
    boolean crashLanding;


    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }



    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public final boolean canCarry(Item item) {
        double tonneWeight;

        tonneWeight = this.weight + (item.getWeight() * 0.001);

        if(this.maxWeight >= tonneWeight){
            return true;
        }
        return false;
    }

    @Override
    public final void carry(Item item) {
        this.setWeight(this.weight + (item.getWeight() * 0.001));
    }
}
