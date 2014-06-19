<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>


<table style="border-collapse: collapse !important;">
    <thead>
        <tr>
            <th>Service ID</th>
            <th>Date</th>
            <th>Return Date</th>
            <th>Taxi</th>
            <th>Type of Trip</th>
            <th>Luggage</th>
            <th>Pick-Up</th>
            <th>Drop-Off</th>
            <th>Price</th>
            <th>Special Requests</th>
        </tr>
    </thead>
    <tbody>        
        <s:iterator value="taxiServices">  
        <tr>
            <td><s:property value="id"/></td>
            <td><s:date name="serviceBegin" format="dd/MM/yyyy HH:MM" /> </td>
            <td>
                <s:if test="%{serviceEnd == null}">
                    <s:date name="serviceEnd" format="dd/MM/yyyy HH:MM" />
                </s:if>
                <s:else>------</s:else>
            </td>
            <td><s:property value="taxi.name"/></td>
            <td>
                <s:if test="%{roundTrip.equals(false)}">One-Way</s:if>
                <s:else>Round-Trip</s:else>                    
            </td>
            <td>
                <s:if test="%{luggage.equals(true)}">Yes</s:if>
                <s:else>No</s:else>  
            </td>
            <td><s:property value="pickUpLocation"/></td>
            <td><s:property value="dropOffLocation"/></td>
            <td><s:property value="finalPrice"/>&euro;</td>
            <td>
                <s:if test="%{specialRequest.isEmpty()}">------</s:if>
                <s:else><s:property value="specialRequest"/></s:else>
            </td>
        </tr>
        </s:iterator>
    </tbody>
</table>