package actions;

import com.opensymphony.xwork2.ActionSupport;
import dao.CarServiceDAO;
import dao.TaxiServiceDAO;
import java.util.List;
import java.util.Map;
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
    private List<CarService> carServices;
    private List<TaxiService> taxiServices;
    
    public ReservationsAction() {
    }
    
    @Override
    public String execute() throws Exception {
        TaxiServiceDAO taxiServicesDAO = new TaxiServiceDAO();
        CarServiceDAO carServicesDAO = new CarServiceDAO();
        User u = (User) this.session.get("user");
        setCarServices(carServicesDAO.getCarServicesFromUser(u.getId()));
        setTaxiServices(taxiServicesDAO.getTaxiServicesFromUser(u.getId()) );
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {        
        this.session = map;
    }

    public List<CarService> getCarServices() {
        return carServices;
    }    
    public List<TaxiService> getTaxiServices() {
        return taxiServices;
    }

    public void setCarServices(List<CarService> carServices) {
        this.carServices = carServices;
    }
    public void setTaxiServices(List<TaxiService> taxiServices) {
        this.taxiServices = taxiServices;
    }
}
