package com.thoughtworks.tdd.parklot;

public class CarTicket {
    private String id;
    private boolean isUsed;

    public CarTicket(){
        isUsed = false;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
