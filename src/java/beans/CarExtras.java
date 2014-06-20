/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package beans;

/**
 *
 * @author pjmaia
 */
public class CarExtras {
    
    private int additional_driver_quantity;
    private boolean gps;
    private boolean baby_seat;
    private int gps_quantity;
    private int baby_seat_quantity;
    private boolean additional_driver;
          
    public void setAdditional_driver_quantity(int additional_driver_quantity) {
        this.additional_driver_quantity = additional_driver_quantity;
    }
    
    public void setGps_quantity(int gps_quantity) {
        this.gps_quantity = gps_quantity;
    }
    
    public void setBaby_seat_quantity(int baby_seat_quantity) {
        this.baby_seat_quantity = baby_seat_quantity;
    }
    public void setAdditional_driver(boolean additional_driver) {
        this.additional_driver = additional_driver;
    }
    public void setGps(boolean gps) {
        this.gps = gps;
    }
    public void setBaby_seat(boolean baby_seat) {
        this.baby_seat = baby_seat;
    }
    
    public int getAdditional_driver_quantity() {
        return additional_driver_quantity;
    }
    
    public int getGps_quantity() {
        return gps_quantity;
    }
    
    public int getBaby_seat_quantity() {
        return baby_seat_quantity;
    }

}