package com.MakeUC.MakeUC;

public class Core {
    public String serial;
    public Integer block;
    public String status;
    public String o_launch;
    public int reuse;
    public int rtls_att;
    public int rtls_landing;
    public int asds_att;
    public int asds_landing;
    public boolean water_landing;
    public String[] missions;
    public String dets;

    public Core(String a, int d, int e, int f, int g, int h, boolean i) {
        serial = a;
        reuse = d;
        rtls_att = e;
        rtls_landing = f;
        asds_att = g;
        asds_landing = h;
        water_landing = i;
        status = "";
        o_launch = "";
        dets = "";
        block = null;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setBlock(int block) {
        this.block = block;
    }
    public void setLaunch(String launch) {
        o_launch = (launch == null ? "" : launch);
    }
    public void setDetails(String details) {
        dets = (details == null ? "" : details);
    }
    public void setMissions(String[] missions) {
        this.missions = missions;
    }
}
