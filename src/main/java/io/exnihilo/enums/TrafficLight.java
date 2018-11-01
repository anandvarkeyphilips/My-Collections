package io.exnihilo.enums;
public enum TrafficLight{
    RED(90),
    GREEN(70),
    YELLOW(60);

    // instance field
    private final int duration;

    // constructor
    TrafficLight(int duration){
        this.duration = duration;
    }
    // accessor for duration
    public int getDuration(){
        return this.duration;
    }
}
