package spaceChallenge;

import java.lang.Math;

public class U2 extends Rocket{
    private double launchExplosion;
    private double landingCrash ;
    double randomGen ;

    public U2(){
        setCost(120.0);
        setWeight(18.0);
        setMaxWeight(29.0);
        exploded = false;
        crashLanding = false;
        launchExplosion = 0.0;
        landingCrash = 0.0;
    }

    @Override
    public boolean launch() {
        randomGen = Math.random();
        launchExplosion = 0.04 * (getWeight()/getMaxWeight());

        if(randomGen < launchExplosion)
        {
            exploded = true;
            System.out.println("Crash Landing on you");
        }
        else{
            exploded = false;
        }

        return exploded;
    }

    @Override
    public boolean land() {
        randomGen = Math.random();
        landingCrash = 0.08 * (getWeight()/getMaxWeight());

        if(randomGen < landingCrash)
        {
            crashLanding = true;
            System.out.println("Boom boom pow");
        }
        else{
            crashLanding = false;
        }

        return crashLanding;
    }
}
