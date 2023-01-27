package com.company;


public class Cabin {
    private Passenger passengerslot1;
    private Passenger passengerslot2;
    private Passenger Passengerslot3;

    public Cabin(Passenger passengerslot1, Passenger passengerslot2, Passenger passengerslot3) {
        this.passengerslot1 = passengerslot1;
        this.passengerslot2 = passengerslot2;
        Passengerslot3 = passengerslot3;
    }

    public Passenger getPassengerslot1() {
        return passengerslot1;
    }

    public void setPassengerslot1(Passenger passengerslot1) {
        this.passengerslot1 = passengerslot1;
    }

    public Passenger getPassengerslot2() {
        return passengerslot2;
    }

    public void setPassengerslot2(Passenger passengerslot2) {
        this.passengerslot2 = passengerslot2;
    }

    public Passenger getPassengerslot3() {
        return Passengerslot3;
    }

    public void setPassengerslot3(Passenger passengerslot3) {
        Passengerslot3 = passengerslot3;
    }
}
