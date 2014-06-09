<div class="row">
    <div class="large-9 large-offset-1 columns end">
        
        <div class="row">
            <div class="large-9 large-offset-2 columns">
                <h2>Change your password</h2>
            </div>
        </div>
        
        <s:form action="update-password" method="post" namespace="/users" data-abide="abide">
            
            <fieldset class="fieldset-border">
                <!-- Row Current Password -->
                <div class="row">
                    <div class="name-field">
                        <div class="large-3 columns">
                            <s:label name="current_password" value="Current Password" cssClass="right inline"/>  
                        </div>
                        <div class="large-9 columns">
                            <s:password name="current_password" required="true" autofocus="true" pattern=".{8,20}" />
                            <small class="error">Current Password is required and needs to have at least 8 digits.</small> 
                            <s:if test="hasFieldErrors()">
                                <small class="error">
                                    <s:iterator  value="fieldErrors.current_password" >                                       
                                        <s:property /> 
                                    </s:iterator>                                    
                                </small> 
                            </s:if>                                
                        </div>
                    </div>
                </div>        
                
                <!-- Row New Password -->
                <div class="row">
                    <div class="name-field">
                        <div class="large-3 columns">
                            <s:label name="new_password" value="New Password" cssClass="right inline"/>
                        </div>
                        <div class="large-9 columns">
                            <s:password name="new_password" id="new_password" required="true" pattern=".{8,20}"/>
                            <small class="error">New password is required and needs to have at least 8 digits.</small> 
                            <s:if test="hasFieldErrors()">
                                <small class="error">
                                    <s:iterator  value="fieldErrors.new_password" >                                       
                                        <s:property /> 
                                    </s:iterator>                                    
                                </small> 
                            </s:if>                                
                        </div>
                    </div>
                </div>     
                
                <!-- Row Confirm Password -->
                <div class="row">
                    <div class="name-field">
                        <div class="large-3 columns">
                            <s:label name="confirm_password" value="Password Confirmation" cssClass="right inline"/>
                        </div>
                        <div class="large-9 columns">
                            <s:password name="confirm_password" required="true" pattern=".{8,20}" data-equalto="new_password" />
                            <small class="error">Confirm password is required and needs to be equal to New Password.</small> 
                            <s:if test="hasFieldErrors()">
                                <small class="error">
                                    <s:iterator  value="fieldErrors.confirm_password" >                                       
                                        <s:property /> 
                                    </s:iterator>                                    
                                </small> 
                            </s:if>                                
                        </div>
                    </div>
                </div>  
                
                <div class="row">
                    <div class="name-field">             
                        <div class="large-3 large-offset-5 columns end">
                            <s:submit type="button" cssClass="button small radius" value="Update"/>
                        </div>
                    </div>
                </div>    
                
            </s:form>            
    </div>
</div>
