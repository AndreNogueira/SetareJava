/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pjmaia
 */
public class CarForm {
    
    private int pick_country;
    private int pick_city;
    private int pick_subsidiary;
    private int drop_country;
    private int drop_city;
    private int drop_subsidiary;
    private String pick_date;
    private String pick_time;
    private String drop_date;
    private String drop_time;
    private boolean return_at_same_location;
    
    
    //convert String to Date
    public Date convertToDate(String date){        
        Date dat = null;
        try {
            dat = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException ex) {
        }
        return dat;
    }
    
    public Date getPick_date() {
        return convertToDate(pick_date);
    }
    
    public void setPick_date(String pick_date) {
        this.pick_date = pick_date;
    }
    
    public Date getDrop_date() {
        return convertToDate(drop_date);
    }
    
    public void setDrop_date(String drop_date) {
        this.drop_date = drop_date;
    }
    
    public boolean getReturn_at_same_location() {
        return return_at_same_location;
    }
    
    public void setReturn_at_same_location(boolean return_at_same_location) {
        this.return_at_same_location = return_at_same_location;
    }
    
    public int getPick_country() {
        return pick_country;
    }
    
    public void setPick_country(int pick_country) {
        this.pick_country = pick_country;
    }
    
    public int getPick_city() {
        return pick_city;
    }
    
    public void setPick_city(int pick_city) {
        this.pick_city = pick_city;
    }
    
    public int getPick_subsidiary() {
        return pick_subsidiary;
    }
    
    public void setPick_subsidiary(int pick_subsidiary) {
        this.pick_subsidiary = pick_subsidiary;
    }
    
    public int getDrop_country() {
        return drop_country;
    }
    
    public void setDrop_country(int drop_country) {
        this.drop_country = drop_country;
    }
    
    public int getDrop_city() {
        return drop_city;
    }
    
    public void setDrop_city(int drop_city) {
        this.drop_city = drop_city;
    }
    
    public int getDrop_subsidiary() {
        return drop_subsidiary;
    }
    
    public void setDrop_subsidiary(int drop_subsidiary) {
        this.drop_subsidiary = drop_subsidiary;
    }
    
    public String getPick_time() {
        return pick_time;
    }
    
    public void setPick_time(String pick_time) {
        this.pick_time = pick_time;
    }
    
    public String getDrop_time() {
        return drop_time;
    }
    
    public void setDrop_time(String drop_time) {
        this.drop_time = drop_time;
    }
}
