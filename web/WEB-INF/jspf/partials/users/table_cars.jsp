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
        <s:iterator value="#carServices">
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
            </tr>
        </s:iterator>
    </tbody>
</table>