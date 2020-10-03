package com.MakeUC.MakeUC;

public class Capsule {
    public String id;
    public String serial;
    public String status;
    public String o_launch;
    public String[] missionNames;
    public int landings;
    public String type;
    public String dets;
    public int reuses;

    Capsule(String a, String b, String c, int f, String g, int i) {
        id = a;
        serial = b;
        status = c;
        landings = f;
        type = g;
        reuses = i;
        dets = "";
        o_launch = "";
    }

    public void setMissionNames(String[] data) {
        missionNames = data;
    }
    public void setDetails(String details) {
        dets = (details == null ? "" : details);
    }
    public void setLaunch(String launch) {
        o_launch = (launch == null ? "" : launch);
    }
}