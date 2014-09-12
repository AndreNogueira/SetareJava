<div class="row">
    <div class="large-12 columns">
        <div class="row">
            <div class="large-8 large-centered columns end">
                <h2>Login</h2>
            </div>
        </div>
        <s:form action="login" namespace="/users" method="post" validate="true" data-abide="abide" >
            <fieldset class="fieldset-border">
                <div class="row">
                    <div class="email-field">
                        <div class="large-2 columns">
                            <s:label value="E-mail" cssClass="right inline"/>
                        </div>
                        <div class="large-10 columns">
                            <s:textfield type="email" name="email" autofocus="true" placeholder="E-mail" required="true" />
                            <small class="error">An email address is required.</small>
                            <s:if test="hasFieldErrors()">
                                <small class="error">
                                    <s:iterator value="fieldErrors.email">
                                        <s:property /> 
                                    </s:iterator>
                                </small>
                            </s:if>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="password-field">
                        <div class="large-2 columns">
                            <s:label value="Password" cssClass="right inline" />
                        </div>
                        <div class="large-10 columns">
                            <s:password name="password" placeholder="Password" required="true" />
                            <small class="error">A password is required.</small>
                            <s:if test="hasFieldErrors()">
                                <small class="error">
                                    <s:iterator value="fieldErrors.password">
                                        <s:property /> 
                                    </s:iterator>
                                </small> 
                            </s:if>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="large-6 large-offset-2 columns">
                        <s:submit type="button" cssClass="button small radius" >
                            <i class="fi-check large"></i> Login
                        </s:submit>
                    </div>
                </div>
            </s:form>
            <div class="row">
                <div class="large-6 large-offset-2 columns">
                    <s:url action="register-page" namespace="users" var="registerURL" />
                    <s:a href="/%{registerURL}" namespace="users">Register</s:a>
                </div>
            </div>
        </fieldset>
    </div>
</div>

