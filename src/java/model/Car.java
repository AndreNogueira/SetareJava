package model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "car", catalog = "Setare"
)
public class Car implements java.io.Serializable {

    private Integer id;
    private Agency agency;
    private Category category;
    private String image;
    private String brand;
    private String model;
    private int year;
    private boolean ac;
    private boolean abs;
    private boolean transmission;
    private int doorsNumber;
    private int capacity;
    private BigDecimal price;
    private boolean isAvailable;
    private int currentSubsidiary;
    private String fuelType;
    private long fuelConsumption;
    private Set<CarService> carServices = new HashSet<CarService>(0);

    public Car() {
    }

    public Car(Agency agency, Category category, String image, String brand, String model, int year, boolean ac, boolean abs, boolean transmission, int doorsNumber, int capacity, BigDecimal price, boolean isAvailable, int currentSubsidiary, String fuelType, long fuelConsumption) {
        this.agency = agency;
        this.category = category;
        this.image = image;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.ac = ac;
        this.abs = abs;
        this.transmission = transmission;
        this.doorsNumber = doorsNumber;
        this.capacity = capacity;
        this.price = price;
        this.isAvailable = isAvailable;
        this.currentSubsidiary = currentSubsidiary;
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
    }

    public Car(Agency agency, Category category, String image, String brand, String model, int year, boolean ac, boolean abs, boolean transmission, int doorsNumber, int capacity, BigDecimal price, boolean isAvailable, int currentSubsidiary, String fuelType, long fuelConsumption, Set<CarService> carServices) {
        this.agency = agency;
        this.category = category;
        this.image = image;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.ac = ac;
        this.abs = abs;
        this.transmission = transmission;
        this.doorsNumber = doorsNumber;
        this.capacity = capacity;
        this.price = price;
        this.isAvailable = isAvailable;
        this.currentSubsidiary = currentSubsidiary;
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
        this.carServices = carServices;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agency_id", nullable = false)
    public Agency getAgency() {
        return this.agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "image", nullable = false)
    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "brand", nullable = false)
    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "model", nullable = false)
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "year", nullable = false)
    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Column(name = "ac", nullable = false)
    public boolean isAc() {
        return this.ac;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }

    @Column(name = "abs", nullable = false)
    public boolean isAbs() {
        return this.abs;
    }

    public void setAbs(boolean abs) {
        this.abs = abs;
    }

    @Column(name = "transmission", nullable = false)
    public boolean isTransmission() {
        return this.transmission;
    }

    public void setTransmission(boolean transmission) {
        this.transmission = transmission;
    }

    @Column(name = "doors_number", nullable = false)
    public int getDoorsNumber() {
        return this.doorsNumber;
    }

    public void setDoorsNumber(int doorsNumber) {
        this.doorsNumber = doorsNumber;
    }

    @Column(name = "capacity", nullable = false)
    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Column(name = "price", nullable = false, precision = 10)
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "is_available", nullable = false)
    public boolean isIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Column(name = "current_subsidiary", nullable = false)
    public int getCurrentSubsidiary() {
        return this.currentSubsidiary;
    }

    public void setCurrentSubsidiary(int currentSubsidiary) {
        this.currentSubsidiary = currentSubsidiary;
    }

    @Column(name = "fuel_type", nullable = false)
    public String getFuelType() {
        return this.fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Column(name = "fuel_consumption", nullable = false, precision = 10, scale = 0)
    public long getFuelConsumption() {
        return this.fuelConsumption;
    }

    public void setFuelConsumption(long fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    public Set<CarService> getCarServices() {
        return this.carServices;
    }

    public void setCarServices(Set<CarService> carServices) {
        this.carServices = carServices;
    }

}
