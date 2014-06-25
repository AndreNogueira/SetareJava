<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<table style="border-collapse: collapse !important;">
    <thead>
        <tr>
            <th>Service ID</th>
            <th>Pick-Date</th>
            <th>Return-Date</th>
            <th>Car</th>
            <th>Pick-Location</th>
            <th>Drop-Location</th>
            <th>Agency</th>
            <th>Extras</th>
            <th>Price</th>
        </tr>
    </thead>
    <tbody>
        <s:iterator value="carServices">
            <tr>
                <td><s:property value="id"/></td>
                <td><s:property value="getText('{0,date,dd/MM/yy}',{serviceBegin})"/></td>
                <td><s:property value="getText('{0,date,dd/MM/yy}',{serviceEnd})"/></td>
                <td><s:property value="car.brand"/></td>
                <td><s:property value="subsidiaryByDropOffSubsidiaryId.name"/>, <s:property value="subsidiaryByDropOffSubsidiaryId.city.country.name"/> </td>
                <td><s:property value="subsidiaryByPickUpSubsidiaryId.name"/>, <s:property value="subsidiaryByPickUpSubsidiaryId.city.country.name"/></td>
                <td><s:property value="subsidiaryByPickUpSubsidiaryId.agency.name"/></td>
                <td>
                    <s:if test="%{gps.equals(true)}">
                        GPS;
                    </s:if>
                    <s:if test="%{babySeat.equals(true)}">
                        Child-Seat;
                    </s:if>
                    <s:if test="%{additionalDriver.equals(true)}">
                        Additional-Driver;
                    </s:if>
                </td>
                <td><s:property value="finalPrice"/>&euro;</td>
            </tr>
        </s:iterator>
    </tbody>
</table>

