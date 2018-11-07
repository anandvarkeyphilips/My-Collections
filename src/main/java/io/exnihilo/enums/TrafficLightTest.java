package io.exnihilo.enums;

public class TrafficLightTest {
    public static void main(String[] args) {

        TrafficLight newLight = TrafficLight.RED;

        switch (newLight) {
            case GREEN:
                System.out.println(TrafficLight.GREEN);
                break;
            case RED:
                System.out.println(TrafficLight.RED);
                break;
            case YELLOW:
                System.out.println(TrafficLight.YELLOW);
                break;
        }


        System.out.println(TrafficLight.GREEN);
        System.out.println(TrafficLight.GREEN.getDuration());
        System.out.println(TrafficLight.GREEN.name());
        System.out.println(TrafficLight.valueOf("GREEN"));

        for (TrafficLight trafficLight : TrafficLight.values())
            System.out.printf("%s - %d\n", trafficLight, trafficLight.getDuration());
    }
}
