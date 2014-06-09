<div class="row">
    <div class="large-12 columns">
        <div class="row">
            <div class="large-8 large-centered columns end">
                <h2>Sign up</h2>
            </div>
        </div>
        <!--  form action="user-registration" data-abide="" namespace="/users" method="post"  -->
        <s:form action="register" namespace="/users" method="post" data-abide="abide" novalidate="novalidate" validate="true" >
            <fieldset class="fieldset-border">                
                <!-- Row Name -->
                <div class="row">
                    <div class="name-field">
                        <div class="large-3 columns">
                            <s:label name="user.name" value="Name" cssClass="right inline"></s:label>              
                            </div>
                            <div class="large-9 columns">
                            <s:textfield name="user.name" required="true" placeholder="Insert your name" ></s:textfield>
                                <small class="error">Name is required.</small> 
                            <s:if test="hasFieldErrors()">
                                <small class="error">
                                    <s:iterator  value="fieldErrors['user.name']" >                                       
                                        <s:property /> 
                                    </s:iterator>                                    
                                </small> 
                            </s:if>                                
                        </div>
                    </div>
                </div>                    
                
                <!-- Row Email -->
                <div class="row">
                    <div class="email-field">
                        <div class="large-3 columns">
                            <s:label name="user.email" value="Email" cssClass="right inline"></s:label> 
                            </div>
                            <div class="large-9 columns">
                            <s:textfield name="user.email" type="email" required="true" placeholder="Insert your email" ></s:textfield>
                                <small class="error">The email entered is not valid.</small>                                    
                            <s:fielderror fieldName="user.email" />
                            <s:if test="hasFieldErrors()">
                                <small class="error">
                                    <s:iterator  value="fieldErrors['user.email']" >                                       
                                        <s:property /> 
                                    </s:iterator>                                    
                                </small> 
                            </s:if>         
                        </div>  
                    </div>
                </div>                
                    
                <!-- Row Password -->
                <div class="row">
                    <div class="password-field">
                        <div class="large-3 columns">
                            <s:label name="user.password" value="password" cssClass="right inline"></s:label>
                            </div>
                            <div class="large-9 columns">
                            <s:password name="user.password" required="true" placeholder="Insert your password" ></s:password>
                                <small class="error">Password must be at least 8 characters.</small>
                            <s:if test="hasFieldErrors()">
                                <small class="error">
                                    <s:iterator  value="fieldErrors['user.password']" >                                       
                                        <s:property /> 
                                    </s:iterator>                                    
                                </small> 
                            </s:if>        
                        </div>
                    </div>
                </div>
                <!-- Row Password Confirmation -->
                <div class="row">
                    <div class="password-confirmation-field">
                        <div class="large-3 columns">
                            <s:label name="password_confirmation" value="Password Confirmation" cssClass="right inline"></s:label>
                            </div>
                            <div class="large-9 columns">
                            <s:password name="password_confirmation" required="true" placeholder="Repeat your password"  ></s:password>
                                <small class="error">Password confirmation must be equal to Password.</small>
                            <s:if test="hasFieldErrors()">
                                <small class="error">
                                    <s:iterator value="fieldErrors.password_confirmation">
                                        <s:property /> 
                                    </s:iterator>
                                </small> 
                            </s:if>     
                        </div>
                    </div>
                </div>                    
                
                <div class="row">
                    <div class="number-field">
                        <div class="large-3 columns">
                            <s:label name="user.bi" value="Citizen Card nº" cssClass="right inline"></s:label>
                            </div>
                            <div class="large-9 columns">
                            <s:textfield name="user.bi" required="true" placeholder="Repeat your password" pattern="[1-9][0-9]{8}" ></s:textfield>
                                <small class="error">BI must be a number with 9 digits.</small>
                            <s:if test="hasFieldErrors()">
                                <small class="error">
                                    <s:iterator  value="fieldErrors['user.bi']" >                                       
                                        <s:property /> 
                                    </s:iterator>                                    
                                </small> 
                            </s:if>        
                        </div>
                    </div>
                </div>
                    
                <!-- Row Driver License -->
                <div class="row">
                    <div class="number-field">
                        <div class="large-3 columns">
                            <s:label name="user.driverLicense" value="Driver License" cssClass="right inline"></s:label>
                            </div>
                            <div class="large-9 columns">
                            <s:textfield name="user.driverLicense" required="true" placeholder="Insert your driver license" pattern="[A-Z]-[1-9][0-9]{6}" ></s:textfield> 
                                <small class="error">Driver License must be a uppercase letter and number with 7 digits. Example: P-1234567</small>
                            <s:if test="hasFieldErrors()">
                                <small class="error">
                                    <s:iterator  value="fieldErrors['user.driverLicense']" >                                       
                                        <s:property /> 
                                    </s:iterator>                                    
                                </small> 
                            </s:if>        
                        </div>
                    </div>
                </div>
                
                <!-- Row NIF -->
                <div class="row">
                    <div class="number-field">
                        <div class="large-3 columns">
                            <s:label name="user.nif" value="NIF" cssClass="right inline"></s:label>
                            </div>
                            <div class="large-9 columns">
                            <s:textfield name="user.nif" required="true" placeholder="Insert your NIF number" pattern="[1-9][0-9]{8}" ></s:textfield> 
                                <small class="error">NIF must be a number with 9 digits.</small>
                            <s:if test="hasFieldErrors()">
                                <small class="error">
                                    <s:iterator  value="fieldErrors['user.nif']" >                                       
                                        <s:property /> 
                                    </s:iterator>                                    
                                </small> 
                            </s:if>        
                        </div>
                    </div>
                </div>
                <!-- Row Phone Number -->
                <div class="row">
                    <div class="number-field">
                        <div class="large-3 columns">
                            <s:label name="user.phoneNumber" value="Phone number" cssClass="right inline"></s:label>
                            </div>
                            <div class="large-9 columns">
                                
                            <s:textfield name="user.phoneNumber" required="true" placeholder="Insert your phone number" />
                            <small class="error">Phone must be a number with 9 digits.</small>
                            <s:if test="hasFieldErrors()">
                                <small class="error">
                                    <s:iterator  value="fieldErrors['user.phoneNumber']" >                                       
                                        <s:property /> 
                                    </s:iterator>                                    
                                </small> 
                            </s:if>        
                        </div>
                    </div>
                </div>
                <!-- Row Address -->
                <div class="row">
                    <div class="name-field">
                        <div class="large-3 columns">
                            <s:label name="user.address" value="Address" cssClass="right inline"></s:label>
                            </div>
                            <div class="large-9 columns">
                            <s:textfield name="user.address" required="true" placeholder="Insert your address" ></s:textfield>
                                <small class="error">Address is required</small>
                            <s:if test="hasFieldErrors()">
                                <small class="error">
                                    <s:iterator  value="fieldErrors['user.address']" >                                       
                                        <s:property /> 
                                    </s:iterator>                                    
                                </small> 
                            </s:if>        
                        </div>
                    </div>
                </div>
                <!-- Row Address -->
                <div class="row">
                    <div class="large-6 large-offset-3 columns">
                        <s:submit type="button" cssClass="button small radious">
                            <i class="fi-plus large"> Register</i>
                        </s:submit> 
                    </div>
                </div>
            </fieldset>
        </s:form>   
        
    </div>
</div>