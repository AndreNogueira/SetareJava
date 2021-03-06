package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="agency"
    ,catalog="Setare"
)
public class Agency  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String image;
     private Set<Car> cars = new HashSet<>(0);
     private Set<Subsidiary> subsidiaries = new HashSet<>(0);

    public Agency() {
    }

	
    public Agency(String name, String image) {
        this.name = name;
        this.image = image;
    }
    public Agency(String name, String image, Set<Car> cars, Set<Subsidiary> subsidiaries) {
       this.name = name;
       this.image = image;
       this.cars = cars;
       this.subsidiaries = subsidiaries;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="image", nullable=false)
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="agency")
    public Set<Car> getCars() {
        return this.cars;
    }
    
    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="agency")
    public Set<Subsidiary> getSubsidiaries() {
        return this.subsidiaries;
    }
    
    public void setSubsidiaries(Set<Subsidiary> subsidiaries) {
        this.subsidiaries = subsidiaries;
    }




}


