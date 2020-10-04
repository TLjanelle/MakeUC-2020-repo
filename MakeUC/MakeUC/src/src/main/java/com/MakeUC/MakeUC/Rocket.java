package com.MakeUC.MakeUC;

public class Rocket {
    public Boolean active;
    public int stages;
    public int boosters;
    public int cost;
    public int successRate;
    public String o_launch;
    public String country;
    public String company;
    public Height height;
    public Diameter diameter;
    public Mass mass;
    public String description;
    public String id;
    public String name;
    public String type;
    public String[] images;
    public String wiki;
    public Payload[] payloads;
    public FirstStage fs;
    public SecondStage ss;
    public Engines engines;
    public LandLegs landLegs;

    public Rocket() {
    }

    public static class LandLegs {
        public Integer num;
        public String material;

        public LandLegs() {
        }
    }

    public static class Engines {
        public int num;
        public String type;
        public String version;
        public String layout;
        public Isp isp;
        public Integer engineMaxLoss;
        public String prop1;
        public String prop2;
        public Thrust seaLevel;
        public Thrust vacuum;
        public int thrustToWeight;

        public Engines() {
        }
    }

    public static class Isp {
        public int seaLevel;
        public int vacuum;

        public Isp() {
        }
    }

    public static class Thrust {
        public int kn;
        public int lbf;

        public Thrust() {
        }
    }

    public static class SecondStage {
        public boolean reusable;
        public int engines;
        public double fuelTons;
        public Integer burnSecs;
        public Thrust thrust;
        public String[] payloads;
        public Height height;
        public Diameter diameter;

        public SecondStage() {
        }
    }

    public static class FirstStage {
        public boolean reusable;
        public int engines;
        public double fuelTons;
        public Integer burnSecs;
        public Thrust thrustSea;
        public Thrust thrustVac;

        public FirstStage() {
        }
    }


    public static class Payload {
        public String id;
        public String name;
        public Mass mass;

        public Payload() {
        }
    }

    public static class Diameter {
        public double meters;
        public double feet;

        public Diameter() {
        }
    }

    public static class Mass {
        public int kilo;
        public int pounds;

        public Mass() {
        }
    }

    public static class Height {
        public double meters;
        public double feet;

        public Height() {
        }
    }
}
