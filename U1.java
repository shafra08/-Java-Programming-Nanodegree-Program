package spaceChallenge;

import java.lang.Math;

public class U1 extends Rocket {
    private double launchExplosion;
    private double landingCrash ;
    double randomGen ;

    public U1(){
        setCost(100.0);
        setWeight(10.0);
        setMaxWeight(18.0);
        exploded = false;
        crashLanding = false;
        launchExplosion = 0.0;
        landingCrash = 0.0;
    }

    @Override
    public boolean land() {
        randomGen = Math.random();
        landingCrash = 0.01 * (getWeight()/getMaxWeight());

        if(randomGen < landingCrash)
        {
            crashLanding = true;
            System.out.println("Crash Landing on you");
        }
        else{
            crashLanding = false;
        }

        return crashLanding;
    }

    @Override
    public boolean launch() {
        randomGen = Math.random();
        launchExplosion = 0.05 * (getWeight()/getMaxWeight());

        if(randomGen < launchExplosion)
        {
            exploded = true;
            System.out.println("Boom boom pow");
        }
        else{
            exploded = false;
        }

        return exploded;
    }
}
