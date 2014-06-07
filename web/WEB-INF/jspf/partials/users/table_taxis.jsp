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
        <s:iterator value="#taxiServices">  
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        </s:iterator>
    </tbody>
</table>