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
@Table(name="category"
    ,catalog="Setare"
)
public class Category  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Set<Car> cars = new HashSet<Car>(0);

    public Category() {
    }

	
    public Category(String name) {
        this.name = name;
    }
    public Category(String name, Set<Car> cars) {
       this.name = name;
       this.cars = cars;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="category")
    public Set<Car> getCars() {
        return this.cars;
    }
    
    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }




}


