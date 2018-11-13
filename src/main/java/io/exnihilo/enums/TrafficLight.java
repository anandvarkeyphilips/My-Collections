package io.exnihilo.enums;

enum Restaurants {
    dominos, kfc, pizzahut, paninos, burgerking
}

public enum TrafficLight {
    RED(90),
    GREEN(70),
    YELLOW(60);

    // instance field
    private final int duration;

    TrafficLight(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return this.duration;
    }

    public static void main(String[] args) {
        Restaurants r;
        System.out.println("All constants of enum type Restaurants are:");
        Restaurants  rArray[] = Restaurants.values(); //returns an array of constants of type Restaurants
        for(Restaurants  a : rArray) //using foreach loop
            System.out.println(a);

        System.out.println("-------------------------------------------------------");
        r = Restaurants.valueOf("dominos");
        System.out.println("I AM " + r);

        System.out.println("-------------------------------------------------------");
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

        System.out.println("-------------------------------------------------------");
        System.out.println(TrafficLight.GREEN);
        System.out.println(TrafficLight.GREEN.getDuration());
        System.out.println(TrafficLight.GREEN.name());
        System.out.println(TrafficLight.valueOf("GREEN"));

        System.out.println("-------------------------------------------------------");
        for (TrafficLight trafficLight : TrafficLight.values())
            System.out.printf("%s - %d\n", trafficLight, trafficLight.getDuration());
    }
}
