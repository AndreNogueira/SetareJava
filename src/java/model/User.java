package model;

import java.util.HashSet;
import java.util.Objects;
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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user", catalog = "Setare", uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class User implements java.io.Serializable {

    private Integer id;
    private UserProfile userProfile;
    private String name;
    private String email;
    private String password;
    private String bi;
    private String driverLicense;
    private String nif;
    private String address;
    private String phoneNumber;
    private Set<CarService> carServices = new HashSet<>(0);
    private Set<TaxiService> taxiServices = new HashSet<>(0);

    public User() {
    }

    public User(UserProfile userProfile, String name, String email, String password, String bi, String driverLicense, String nif, String address, String phoneNumber) {
        this.userProfile = userProfile;
        this.name = name;
        this.email = email;
        this.password = password;
        this.bi = bi;
        this.driverLicense = driverLicense;
        this.nif = nif;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public User(UserProfile userProfile, String name, String email, String password, String bi, String driverLicense, String nif, String address, String phoneNumber, Set<CarService> carServices, Set<TaxiService> taxiServices) {
        this.userProfile = userProfile;
        this.name = name;
        this.email = email;
        this.password = password;
        this.bi = bi;
        this.driverLicense = driverLicense;
        this.nif = nif;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.carServices = carServices;
        this.taxiServices = taxiServices;
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
    @JoinColumn(name = "user_profile_id", nullable = false)
    public UserProfile getUserProfile() {
        return this.userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email", unique = true, nullable = false)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "bi", nullable = false, length = 15)
    public String getBi() {
        return this.bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    @Column(name = "driver_license", nullable = false, length = 12)
    public String getDriverLicense() {
        return this.driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    @Column(name = "nif", nullable = false, length = 15)
    public String getNif() {
        return this.nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Column(name = "address", nullable = false, length = 200)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "phone_number", nullable = false, length = 15)
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<CarService> getCarServices() {
        return this.carServices;
    }

    public void setCarServices(Set<CarService> carServices) {
        this.carServices = carServices;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<TaxiService> getTaxiServices() {
        return this.taxiServices;
    }

    public void setTaxiServices(Set<TaxiService> taxiServices) {
        this.taxiServices = taxiServices;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (this.getClass() != obj.getClass())) {
            return false;
        }
        User other = (User) obj;
        return (this.name.equals(other.getName()))
                && (this.address.equals(other.getAddress()))
                && (this.bi.equals(other.getBi()))
                && (this.email.equals(other.getEmail()))
                && (this.driverLicense.equals(other.getDriverLicense()))
                && (this.phoneNumber.equals(other.getPhoneNumber()))
                && (this.nif.equals(other.getNif()));
    }

}
