package com.MakeUC.MakeUC;

public class Dragons {
    public String name;
    public String type;
    public boolean active;
    public int capacity;
    public int orbit;
    public int dryMassKg;
    public int dryMassLb;
    public String o_launch;
    public HeatShield shield;
    public Thruster[] thrusters;
    public Mass launch;
    public Vol launchVol;
    public Mass ret;
    public Vol retVol;
    public Vol pressVol;
    public Trunk trunk;
    public Vol heightWTruck;
    public Vol diameter;
    public String[] images;
    public String wiki;
    public String description;

    public Dragons() {
    }

    public static class HeatShield {
        public String material;
        public double size;
        public int temp;
        public String dev;

        public HeatShield() {
        }
    }

    public static class Thruster {
        public String type;
        public int amount;
        public int pods;
        public String f1;
        public String f2;
        public int isp;
        public double thrustKn;
        public int thrustLbf;

        public Thruster() {
        }
    }

    public static class Mass {
        public int kg;
        public int lb;

        public Mass() {
        }
    }

    public static class Vol {
        public double meters;
        public double feet;

        public Vol() {
        }
    }

    public static class Trunk {
        public Vol vol;
        public int solArray;
        public boolean cargo;

        public Trunk() {
        }
    }
}
