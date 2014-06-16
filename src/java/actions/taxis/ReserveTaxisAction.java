package actions.taxis;

import beans.TaxiForm;
import beans.TaxiReservationForm;
import businesslogic.TaxiReservation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import model.User;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

@Namespace("/taxis")
@Results({
    @Result(name = "success", location = "/index.jsp"), //@Result(name = "error", location = "login-page.jsp"),
//@Result(name = "input", location = "login-page.jsp")
})
public class ReserveTaxisAction extends ActionSupport implements ModelDriven<TaxiReservationForm>, SessionAware {

    private TaxiReservationForm taxiReservationForm;
    private Map<String, Object> session;

    public ReserveTaxisAction() {
        this.taxiReservationForm = new TaxiReservationForm();
    }

    @Override
    public String execute() throws Exception {
        TaxiForm taxiFormSearch = (TaxiForm) session.get("taxiForm");
        User u = (User) session.get("user");
        TaxiReservation tr = new TaxiReservation(taxiReservationForm, taxiFormSearch, u);
        boolean res = tr.reservation();
        if (res) {
            addActionMessage("Your taxi reservation was successful created. Check your e-mail for more details.");

        } else {
            addActionError("Your credit card is invalid. Please check your credentials.");
        }
        return SUCCESS;
    }

    @Override
    public TaxiReservationForm getModel() {
        return this.taxiReservationForm;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

}
