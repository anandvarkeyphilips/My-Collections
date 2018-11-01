package io.exnihilo.enums;
public class TrafficLightTest{
    public static void main(String[] args){
        for(TrafficLight trafficLight : TrafficLight.values())
            System.out.printf("%s - %d\n", trafficLight, trafficLight.getDuration());
    }
}
