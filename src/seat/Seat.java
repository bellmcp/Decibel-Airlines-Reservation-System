/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seat;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Dell
 */
public class Seat { //This class managed EACH passenger's seat and controlled by mother "Flight" Class

    private String seatNo;
    private boolean isAvailable;
    private String firstName;
    private String lastName;
    private String passportNo;

    public Seat() {
    }

    public Seat(String seatNo) {
        this.seatNo = seatNo;
        this.isAvailable = true;
        this.firstName = "";
        this.lastName = "";
        this.passportNo = "";
    }

    public String getSeatNo() {
        return this.seatNo;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }
    
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getPassportNo() {
        return this.passportNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public boolean book(String firstName, String lastName, String passportNo) {
        if (this.isAvailable) {
            this.isAvailable = false;
            this.firstName = firstName;
            this.lastName = lastName;
            this.passportNo = passportNo;
            return true;
        }
        return false;
    }

    public void reset() {
        this.isAvailable = true;
        this.firstName = "";
        this.lastName = "";
        this.passportNo = "";
    }
}
