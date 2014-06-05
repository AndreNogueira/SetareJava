<div class="row">
    <div class="large-12 columns">
        <div class="row">
            <div class="large-8 large-centered columns end">
                <h2>Sign up</h2>
            </div>
        </div>
        <!--  form action="user-registration" data-abide="" namespace="/users" method="post"  -->
        <s:form action="register-page" namespace="/users" method="post" novalidate="novalidate"  >
            <fieldset class="fieldset-border">
                
                <!-- FALTA ADICIONAR AQUI QQ MERDA PARA DAR OS ERROS -->
                    
                <!-- Row Name -->
                <div class="row">
                    <div class="name-field">
                        <div class="large-2 columns">
                            <s:label name="user.name" value="Name" cssClass="right inline"></s:label>              
                            </div>
                            <div class="large-10 columns">
                            <s:textfield name="user.name" required="true" placeholder="Insert your name" ></s:textfield>
                                <small class="error">Name is required.</small>
                            </div>
                        </div>
                    </div>
                        
                        
                    <!-- Row Email -->
                    <div class="row">
                        <div class="email-field">
                            <div class="large-2 columns">
                            <s:label name="user.email" value="Email" cssClass="right inline"></s:label> 
                            </div>
                            <div class="large-10 columns">
                            <s:textfield name="user.email" required="true" placeholder="Insert your email" ></s:textfield>
                                <small class="error">An email address is required.</small>
                            </div>
                        </div>
                    </div>
                        
                        
                    <!-- Row Password -->
                    <div class="row">
                        <div class="password-field">
                            <div class="large-2 columns">
                            <s:label name="user.password" value="password" cssClass="right inline"></s:label>
                            </div>
                            <div class="large-10 columns">
                            <s:textfield name="user.password" required="true" placeholder="Insert your password" ></s:textfield>
                                <small class="error">Password must be at least 8 characters.</small>
                            </div>
                        </div>
                    </div>
                    <!-- Row Password Confirmation -->
                    <div class="row">
                        <div class="password-confirmation-field">
                            <div class="large-2 columns">
                            <s:label name="user.password_confirmation" value="Password Confirmation" cssClass="right inline"></s:label>
                            </div>
                            <div class="large-10 columns">
                            <s:password name="user.password_confirmation" required="true" placeholder="Repeat your password" ></s:password>
                                <small class="error">Passwords must be equals.</small>
                            </div>
                        </div>
                    </div>
                        
                        
                    <div class="row">
                        <div class="number-field">
                            <div class="large-2 columns">
                            <s:label name="user.bi" value="Citizen Card nº" cssClass="right inline"></s:label>
                            </div>
                            <div class="large-10 columns">
                            <s:textfield name="user.bi" required="true" placeholder="Repeat your password" pattern="[1-9][0-9]{8}" ></s:textfield>
                                <small class="error">BI must be a number with 9 digits.</small>
                            </div>
                        </div>
                    </div>
                        
                    <!-- Row Driver License -->
                    <div class="row">
                        <div class="number-field">
                            <div class="large-2 columns">
                            <s:label name="user.driverLicense" value="Driver License" cssClass="right inline"></s:label>
                            </div>
                            <div class="large-10 columns">
                            <s:textfield name="user.driverLicense" required="true" placeholder="Insert your driver license" pattern="[A-Z]-[1-9][0-9]{6}" ></s:textfield> 
                                <small class="error">Driver License must be a uppercase letter and number with 7 digits. Example: P-1234567</small>
                            </div>
                        </div>
                    </div>
                        
                    <!-- Row NIF -->
                    <div class="row">
                        <div class="number-field">
                            <div class="large-2 columns">
                            <s:label name="user.nif" value="NIF" cssClass="right inline"></s:label>
                            </div>
                            <div class="large-10 columns">
                            <s:textfield name="user.nif" required="true" placeholder="Insert your NIF number" pattern="[1-9][0-9]{8}" ></s:textfield> 
                                <small class="error">NIF must be a number with 9 digits.</small>
                            </div>
                        </div>
                    </div>
                    <!-- Row Phone Number -->
                    <div class="row">
                        <div class="number-field">
                            <div class="large-2 columns">
                            <s:label name="user.phoneNumber" value="Phone number" cssClass="right inline"></s:label>
                            </div>
                            <div class="large-10 columns">

                            <s:textfield name="user.phoneNumber" required="true" />
                            <small class="error">Phone must be a number with 9 digits.</small>
                        </div>
                    </div>
                </div>
                <!-- Row Address -->
                <div class="row">
                    <div class="name-field">
                        <div class="large-2 columns">
                            <s:label name="user.address" value="Address" cssClass="right inline"></s:label>
                            </div>
                            <div class="large-10 columns">
                            <s:textfield name="user.address" required="true" placeholder="Address" ></s:textfield>
                                <small class="error">Address is required.s</small>
                            </div>
                        </div>
                    </div>
                    <!-- Row Address -->
                    <div class="row">
                        <div class="large-6 large-offset-2 columns">
                        <s:submit type="button" cssClass="button small radious">
                            <i class="fi-plus large"> Register</i>
                        </s:submit> 
                    </div>
                </div>
                <div class="row">
                    <div class="large-6 large-offset-2 columns">
                        < if controller_name != 'sessions' %>
                        <= link_to "Sign in", new_session_path(resource_name) %>
                        < end %>
                    </div>
                </div>
            </fieldset>
        </s:form>   
            
    </div>
</div>