/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.ExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import dao.UserDAO;
import java.util.Map;
import model.User;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author pjmaia
 */
@Namespace("/users")
@Results({  @Result(name="success",location="profile-page.jsp"),
    @Result(name="input", location = "password-page.jsp"),
    @Result(name="error", location = "password-page.jsp")})
public class UpdatePasswordAction extends ActionSupport implements SessionAware{
    
    private Map<String, Object> session;
    private String current_password;
    private String new_password;
    private String confirm_password;
    private User user;
    
    //Annotations validation
    @Validations(stringLengthFields = {
        @StringLengthFieldValidator( type = ValidatorType.FIELD, fieldName = "new_password", maxLength = "20", minLength = "8", message = "New Password needs to have at least 8 digits.")},
            expressions = {
                @ExpressionValidator(expression = "confirm_password == new_password",message = "Password Confirmation differs from New Password.")},
            requiredStrings = {
                @RequiredStringValidator(type= ValidatorType.FIELD, fieldName = "confirm_password", message="Password Confirmation is required."),
                @RequiredStringValidator(type= ValidatorType.FIELD, fieldName = "current_password", message="Current Password is required."),
                @RequiredStringValidator(type= ValidatorType.FIELD, fieldName = "new_password", message="New Password is required.")})
    
    
    @Override
    public String execute() throws Exception{
        update_password(current_password, new_password, confirm_password);
        return SUCCESS;
    }
    
    public void update_password(String c_pass, String n_pass, String conf_pass){
        UserDAO u = new UserDAO();
        User current_user = (User)this.session.get("user");
        if(current_user.getPassword().equals(c_pass)){
            current_user.setPassword(n_pass);
            if(u.update(current_user)){
                addActionMessage("Your Password has been updated succefully.");
            }
        }else{
            addActionError("The Current password you entered is incorrect.");
        }
    }
    
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getCurrent_password() {
        return current_password;
    }
    
    public void setCurrent_password(String current_password) {
        this.current_password = current_password;
    }
    
    public String getNew_password() {
        return new_password;
    }
    
    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }
    
    public String getConfirm_password() {
        return confirm_password;
    }
    
    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }
}
