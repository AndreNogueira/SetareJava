package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.ExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import dao.UserDAO;
import dao.UserProfileDAO;
import model.User;
import model.UserProfile;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("/users")
@Results({  @Result(name="success",location="login-page.jsp"),
    @Result(name="input", location = "register-page.jsp"),
    @Result(name="error", location = "register-page.jsp")})
public class RegisterAction extends ActionSupport {
    private User user;
    private String password_confirmation;
    
    @Override
    public String execute() throws Exception {
        create_user(user);
        return SUCCESS;
    }
    
    public User getUser() {
        
        return user;
        
    }
    
    public void setUser(User user) {
        
        this.user = user;
        
    }
    
    public String getPassword_confirmation() {
        return password_confirmation;
    }
    
    public void setPassword_confirmation(String password_confirmation) {
        this.password_confirmation = password_confirmation;
    }
    
    // Validations using Struts2 Annotations
    @EmailValidator(fieldName = "user.email", message = "The email you wrote is not valid!")
    @Validations(
            requiredStrings = {
                @RequiredStringValidator(type= ValidatorType.FIELD, fieldName = "password_confirmation", message="Password Confirmation is required."),
                @RequiredStringValidator(type= ValidatorType.FIELD, fieldName = "user.name", message="This field is required."),
                @RequiredStringValidator(type= ValidatorType.FIELD, fieldName = "user.email", message="This field is required."),
                @RequiredStringValidator(type= ValidatorType.FIELD, fieldName = "user.address", message="This field is required."),
                @RequiredStringValidator(type= ValidatorType.FIELD, fieldName = "user.phoneNumber", message="This field is required."),
                @RequiredStringValidator(type= ValidatorType.FIELD, fieldName = "user.driverLicense", message="This field is required."),
                @RequiredStringValidator(type= ValidatorType.FIELD, fieldName = "user.bi", message="This field is required."),
                @RequiredStringValidator(type= ValidatorType.FIELD, fieldName = "user.password", message="This field is required."),
                @RequiredStringValidator(type= ValidatorType.FIELD, fieldName = "user.nif", message="This field is required.")},
            stringLengthFields = {
                @StringLengthFieldValidator( type = ValidatorType.FIELD, fieldName = "user.phoneNumber", maxLength = "9", minLength = "9", message = "The phone number can only have 9 digits."),
                @StringLengthFieldValidator(type = ValidatorType.FIELD, fieldName = "user.password", minLength = "8", maxLength = "20", message = "Password needs to have at least 8 digits.")},
            regexFields = {
                @RegexFieldValidator(fieldName = "user.driverLicense",regex = "[A-Z]-[1-9][0-9]{6}")},
            expressions = {@ExpressionValidator(expression = "password_confirmation == user.password",message = "Password Confirmation differs from Password.")})
    
    public void create_user(User u){
        UserProfile up;
        UserProfileDAO upDAO = new UserProfileDAO();
        up = upDAO.find(1);
        
        UserDAO uDAO = new UserDAO();
        u.setUserProfile(up);
        if(uDAO.create(u)){
            addActionMessage("New User account created with success!");
        }else{
            addActionError("An unexpected error ocurred. Please try again.");
        }
    }
    
}
