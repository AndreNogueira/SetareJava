<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:if test="%{taxiResults.isEmpty()}">
    <div data-alert class="alert-box warning radius" style="margin-top: 3%;">
        <span>No results with the desired parameters were found.</span>
        <span>Please perform once again with other search parameters.</span>
    </div>
</s:if>
<s:else>
    <s:iterator value="taxiResults">
        <div class="row taxi">
            <!-- Taxi Image -->
            <s:set var="imageURL">/SetareJava/${initParam.taxisImagePath}<s:property value="taxi.image" />.png</s:set>
                <div class="large-4 columns" style="padding-top: 1%;text-align: center;">
                    <img src="<s:property value="#imageURL"/>" class="th radius taxi-image" />
                <div class="span-align">
                    <span style="color: midnightblue;"><s:property value="taxi.name" /></span>
                </div>
            </div>


            <!-- Taxi Info -->
            <div class="large-5 columns taxi-info-div">
                <div class="row">
                    <!-- Taxi Capacity -->
                    <div class="large-4 columns">
                        <img src="/SetareJava/assets/images/passengers.png" />
                        <div class="taxi-info">
                            <span class="taxi-text-color">
                                <s:property value="taxi.passengersNumber" />
                            </span>
                        </div>
                    </div>

                    <!-- Taxi Luggage -->
                    <div class="large-4 columns">
                        <img src="/SetareJava/assets/images/lagguage.png" />
                        <div class="taxi-info">
                            <span class="taxi-text-color">
                                <s:property value="taxi.luggage" />
                            </span>
                        </div>
                    </div>
                    <!-- Taxi Price -->
                    <div class="large-4 columns" style="padding-top: 4%;">
                        <span class="taxi-text-color">
                            <s:property value="getText('{0,number, #,##0}',{cost})" /> &euro;
                        </span>
                    </div>

                </div>
            </div>
            <!-- Taxi Button -->
            <div class="large-3 columns" style="padding-top: 5%;">
                <s:form action="select-taxi" namespace="/taxis" method="post">
                    <s:hidden name="idTaxi" value="%{taxi.id}" />
                    <s:hidden name="cost" value="%{cost}" />                    
                    <s:submit type="button" cssClass="button small radius">
                        <i class="fi-check"></i> Select Taxi
                    </s:submit>
                </s:form>
            </div>
        </div>
    </s:iterator>
</s:else>