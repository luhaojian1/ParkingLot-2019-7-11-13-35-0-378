package com.thoughtworks.tdd.parklot;

import com.thoughtworks.tdd.person.Customer;

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
