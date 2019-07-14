package com.thoughtworks.tdd.parklot;

public class CarTicket {
    private String id;
    private boolean isUsed;
    private String parkCarMessage;
    public CarTicket(){
        isUsed = false;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public String getParkCarMessage() {
        return parkCarMessage;
    }

    public void setParkCarMessage(String parkCarMessage) {
        this.parkCarMessage = parkCarMessage;
    }
}
