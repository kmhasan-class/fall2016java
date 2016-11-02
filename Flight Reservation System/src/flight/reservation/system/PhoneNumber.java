/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight.reservation.system;

/**
 *
 * @author kmhasan
 */
class PhoneNumber {
    private int countryCode;
    private int areaCode;
    private int localNumber;

    public PhoneNumber() {
    }

    public PhoneNumber(int countryCode, int areaCode, int localNumber) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.localNumber = localNumber;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public int getLocalNumber() {
        return localNumber;
    }
    
    
}
