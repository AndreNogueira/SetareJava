package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DropOffLocationPickUpLocationId implements java.io.Serializable {

    private int dropOffLocationId;
    private int pickUpLocationId;

    public DropOffLocationPickUpLocationId() {
    }

    public DropOffLocationPickUpLocationId(int dropOffLocationId, int pickUpLocationId) {
        this.dropOffLocationId = dropOffLocationId;
        this.pickUpLocationId = pickUpLocationId;
    }

    @Column(name = "drop_off_location_id", nullable = false)
    public int getDropOffLocationId() {
        return this.dropOffLocationId;
    }

    public void setDropOffLocationId(int dropOffLocationId) {
        this.dropOffLocationId = dropOffLocationId;
    }

    @Column(name = "pick_up_location_id", nullable = false)
    public int getPickUpLocationId() {
        return this.pickUpLocationId;
    }

    public void setPickUpLocationId(int pickUpLocationId) {
        this.pickUpLocationId = pickUpLocationId;
    }

    @Override
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof DropOffLocationPickUpLocationId)) {
            return false;
        }
        DropOffLocationPickUpLocationId castOther = (DropOffLocationPickUpLocationId) other;

        return (this.getDropOffLocationId() == castOther.getDropOffLocationId())
                && (this.getPickUpLocationId() == castOther.getPickUpLocationId());
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getDropOffLocationId();
        result = 37 * result + this.getPickUpLocationId();
        return result;
    }

}
