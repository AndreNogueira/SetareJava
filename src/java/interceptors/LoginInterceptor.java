package interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import model.User;


public class LoginInterceptor extends AbstractInterceptor {
    
    private static final List<String> classesToUserNull = Arrays.asList("LoginAction", "LoginPageAction",
                                                         "RegisterAction","RegisterPageAction");
    
    public LoginInterceptor() {
    }
    
    @Override
    public void destroy() {
    }
    
    @Override
    public void init() {
        
    }
    
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String className = actionInvocation.getAction().getClass().getSimpleName();
        Map<String,Object> session = actionInvocation.getInvocationContext().getSession();
        User user =(User) session.get("user");
        if(user == null){
            if(classesToUserNull.contains(className)) return actionInvocation.invoke();
            else return "loginError";                        
        }else{
            if(classesToUserNull.contains(className)) return "indexPage";
            else return actionInvocation.invoke();
        }
        
    }
    
}
