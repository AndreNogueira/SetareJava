package model;
// Generated 4/jun/2014 17:47:26 by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PickUpLocationTaxiId generated by hbm2java
 */
@Embeddable
public class PickUpLocationTaxiId  implements java.io.Serializable {


     private int pickUpLocationId;
     private int taxiId;

    public PickUpLocationTaxiId() {
    }

    public PickUpLocationTaxiId(int pickUpLocationId, int taxiId) {
       this.pickUpLocationId = pickUpLocationId;
       this.taxiId = taxiId;
    }
   


    @Column(name="pick_up_location_id", nullable=false)
    public int getPickUpLocationId() {
        return this.pickUpLocationId;
    }
    
    public void setPickUpLocationId(int pickUpLocationId) {
        this.pickUpLocationId = pickUpLocationId;
    }


    @Column(name="taxi_id", nullable=false)
    public int getTaxiId() {
        return this.taxiId;
    }
    
    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PickUpLocationTaxiId) ) return false;
		 PickUpLocationTaxiId castOther = ( PickUpLocationTaxiId ) other; 
         
		 return (this.getPickUpLocationId()==castOther.getPickUpLocationId())
 && (this.getTaxiId()==castOther.getTaxiId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getPickUpLocationId();
         result = 37 * result + this.getTaxiId();
         return result;
   }   


}


