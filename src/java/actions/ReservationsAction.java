package actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import java.util.Set;
import model.CarService;
import model.TaxiService;
import model.User;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.SessionAware;

@ParentPackage("interceptors")
@InterceptorRef(value = "loginStack")
@Namespace("/users")
public class ReservationsAction extends ActionSupport implements SessionAware{
    
    private Map<String, Object> session;
    private Set<CarService> carServices;
    private Set<TaxiService> taxiServices;
    
    public ReservationsAction() {
    }
    
    @Override
    public String execute() throws Exception {
        User u = (User) this.session.get("user");
        setCarServices(u.getCarServices());
        setTaxiServices(u.getTaxiServices());
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {        
        this.session = map;
    }

    public Set<CarService> getCarServices() {
        return carServices;
    }    
    public Set<TaxiService> getTaxiServices() {
        return taxiServices;
    }

    public void setCarServices(Set<CarService> carServices) {
        this.carServices = carServices;
    }
    public void setTaxiServices(Set<TaxiService> taxiServices) {
        this.taxiServices = taxiServices;
    }
}
