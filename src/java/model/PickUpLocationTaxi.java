package model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pick_up_location_taxi"
    ,catalog="Setare"
)
public class PickUpLocationTaxi  implements java.io.Serializable {


     private PickUpLocationTaxiId id;
     private Taxi taxi;
     private PickUpLocation pickUpLocation;

    public PickUpLocationTaxi() {
    }

    public PickUpLocationTaxi(PickUpLocationTaxiId id, Taxi taxi, PickUpLocation pickUpLocation) {
       this.id = id;
       this.taxi = taxi;
       this.pickUpLocation = pickUpLocation;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="pickUpLocationId", column=@Column(name="pick_up_location_id", nullable=false) ), 
        @AttributeOverride(name="taxiId", column=@Column(name="taxi_id", nullable=false) ) } )
    public PickUpLocationTaxiId getId() {
        return this.id;
    }
    
    public void setId(PickUpLocationTaxiId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="taxi_id", nullable=false, insertable=false, updatable=false)
    public Taxi getTaxi() {
        return this.taxi;
    }
    
    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pick_up_location_id", nullable=false, insertable=false, updatable=false)
    public PickUpLocation getPickUpLocation() {
        return this.pickUpLocation;
    }
    
    public void setPickUpLocation(PickUpLocation pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }




}


