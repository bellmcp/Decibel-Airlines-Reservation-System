/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seat;

/**
 *
 * @author Dell
 */
public class Flight extends Seat {

    private static Seat[] seat = new Seat[42];

    public Flight() { //create an array eg. seat[0] = "A1" ... seat[41] = "F6" to store passenger's data
        String[] label = new String[]{"A", "B", "C", "D", "E", "F"}; //label[0] = "A" ... label[5] = "F"
        for (int i = 1; i <= 6; i++) { //loop for label A-F
            for (int j = 1; j <= 7; j++) { //loop for number 1-7
                int x = (7 * (i - 1)) + (j - 1); //eg. seat[41] = (7 * (6 - 1)) + (7 - 1) means i = 6, j = 7 
                this.seat[x] = new Seat(label[i - 1] + "" + j); // Seat("F6") << String seatNo = "F6"
            }
        }
    }

    public boolean[] getAvailableStatus() { //return avaiable status of ALL seats (true = available, false = booked)
        boolean[] availableStatus = new boolean[42];
        for (int i = 0; i < 42; i++) {
            availableStatus[i] = seat[i].isAvailable();
        }
        return availableStatus;
    }

    public int countAvailable() { //return amount of available seats
        int availableCount = 0;
        for (int i = 0; i < 42; i++) {
            if (seat[i].isAvailable()) {
                availableCount++;
            }
        }
        return availableCount;
    }

    public boolean bookSeat(String seatNo, String firstName, String lastName, String passportNo) { //store passenger's data to passenger's seat arrays
        for (int i = 0; i < 42; i++) {
            if (seat[i].getSeatNo().equals(seatNo)) {
                return seat[i].book(firstName, lastName, passportNo);
            }
        }
        return false;
    }
    
    public void cancelSeat(String seatNo) { //reset THAT seat data to default
        for (int i = 0; i < 42; i++) {
            if (seat[i].getSeatNo().equals(seatNo)) {
                seat[i].reset();
            }
        }
    }    

    public boolean getSeatStatus(String seatNo) {  //return avaiable status of THAT seat (true = available, false = booked)
        for (int i = 0; i < 42; i++) {
            if (seat[i].getSeatNo().equals(seatNo)) {
                return seat[i].isAvailable();
            }
        }
        return false;
    }

    public String getSeatInfo(String seatNo) { //return all data of THAT seat
        for (int i = 0; i < 42; i++) {
            if (seat[i].getSeatNo().equals(seatNo)) {
                return ("#### PASSENGER INFO #### " + " \n Seat: " + seat[i].getSeatNo() + " \n Full Name: "
                        + seat[i].getFullName() + " \n Passport No: " + seat[i].getPassportNo()
                        + "\n#### successfully booked #### ");
            }
        }
        return "#### PASSENGER INFO : error returning passenger info";
    }

    public String getSeatSeatNo(String seatNo) {
        for (int i = 0; i < 42; i++) {
            if (seat[i].getSeatNo().equals(seatNo)) {
                return (seat[i].getSeatNo());
            }
        }
        return "Error returning getSeatSeatNo";
    }

    public String getSeatFirstName(String seatNo) {
        for (int i = 0; i < 42; i++) {
            if (seat[i].getSeatNo().equals(seatNo)) {
                return (seat[i].getFirstName());
            }
        }
        return "Error returning getSeatFirstName";
    }

    public String getSeatLastName(String seatNo) {
        for (int i = 0; i < 42; i++) {
            if (seat[i].getSeatNo().equals(seatNo)) {
                return (seat[i].getLastName());
            }
        }
        return "Error returning getSeatLastName";
    }

    public String getSeatPassportNo(String seatNo) {
        for (int i = 0; i < 42; i++) {
            if (seat[i].getSeatNo().equals(seatNo)) {
                return (seat[i].getPassportNo());
            }
        }
        return "Error returning getSeatPassportNo";
    }
}
