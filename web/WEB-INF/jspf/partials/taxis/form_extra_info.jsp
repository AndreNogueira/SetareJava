<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:url action="reserve-taxis" namespace="taxis" var="taxiReserveURL" />
<s:form action="/%{taxiReserveURL}" data-abide="abide" validate="true">
    <s:hidden name="idTaxi" value="%{idTaxi}" />
    <s:hidden name="cost" value="%{cost}" /> 
    
    <s:include value="/WEB-INF/jspf/partials/taxis/transfer_details.jsp" />
    <s:include value="/WEB-INF/jspf/partials/taxis/user_info.jsp" />

    <fieldset class="fieldset-border">
        <legend><i class="fi-info"></i> Payment Information</legend>

        <!-- Row CardHolder Name -->
        <div class="row">
            <div class="large-6 columns">
                <s:label value="First Name" />
                <s:textfield name="creditCard.firstName" placeholder="Insert your first name..." required="true" pattern="alpha" />
                <small class="error">You need to insert your first name.</small>
            </div>
            <div class="large-6 columns">
                <s:label value="Last Name" />
                <s:textfield name="creditCard.lastName" placeholder="Insert your last name..." required="true" pattern="alpha" />
                <small class="error">You need to insert your last name.</small>
            </div>
        </div>

        <!-- Row Card Type e Card Number -->
        <div class="row">
            <div class="large-6 columns">
                <s:label value="Card Type" />
                <s:select name="creditCard.cardType" list="creditCards" headerKey="-1" headerValue="Choose your card type" required="true" />
                <small class="error">You need to choose your credit card type.</small>
            </div>
            <div class="large-6 columns">
                <s:label value="Credit Card Number" />
                <s:textfield name="creditCard.cardNumber" placeholder="Insert your credit card number..." required="true" pattern="number" />
                <small class="error">You need to insert your credit card number.</small>
            </div>
        </div>

        <!-- Row CVV and Expire Date -->
        <div class="row">
            <div class="large-6 columns">
                <s:label value="CVV/Security Number" />
                <s:textfield name="creditCard.cvv" placeholder="Insert your credit card security number..." required="true" maxLength="3" />
                <small class="error">You need to insert your credit card security number.</small>
            </div>
            <div class="large-6 columns">
                <s:label value="Expiry Date" />
                <s:select name="creditCard.year" headerKey="-1" headerValue="Choose year" list="years" 
                          cssClass="taxi-expiry-year" required="true" />
                <s:select name="creditCard.month" headerKey="-1" headerValue="Choose month" list="months" 
                          cssClass="taxi-expiry-month" required="true"/>
                <small class="error" style="margin-top: 0 !important;width: 281px;">
                    You need to choose an year and a month.
                </small>
            </div>
        </div>
                
        <!-- Row for Book Button -->
        <div class="row" style="margin: 3% 0 0 0 !important;">
            <div class="large-12 columns">
                <s:submit type="button" cssClass="button small radius expand" >
                    <i class="fi-bookmark"></i> Book Now!!
                </s:submit>
            </div>
        </div>
    </fieldset>
</s:form>