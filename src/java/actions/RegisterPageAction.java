/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Namespace;

/**
 *
 * @author pjmaia
 */
@Namespace("/users")
public class RegisterPageAction extends ActionSupport{
     
    @Override
    public String execute() throws Exception {  
        return SUCCESS;
    }     
}
