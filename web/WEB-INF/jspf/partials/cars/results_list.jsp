<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<div class="large-9 columns">
    
    <s:if test="%{list_selected_subsidiary.isEmpty()}">
        <div class="large-12 columns" style="text-align: center">
            <h4>The vehicles are all ocupied.. Sorry.</h4>
        </div>
    </s:if>
    <s:else>        
        <s:iterator value="list_selected_subsidiary">            
            <s:include value="/WEB-INF/jspf/partials/cars/result_list_grid.jsp"></s:include>
        </s:iterator> 
    </s:else>
    
    <!-- List of cars from other agencies if avaiable BEGIN -->
    <s:if test="%{other_agencies_list.isEmpty()}">    
        <div class="large-12 columns" style="text-align: center">
            <h4>No vehicles available from other agencies.</h4>
        </div>
    </s:if>
    <s:else>
         <div class="large-12 columns" style="text-align: center">
            <h4>Avaiable Cars from other Agencies</h4>
        </div>            
        <s:iterator value="other_agencies_list">            
            <s:iterator value="value">
                <s:include value="/WEB-INF/jspf/partials/cars/result_list_grid.jsp"></s:include>
            </s:iterator>
        </s:iterator>    
    </s:else>
    <!-- List of cars from other agencies if avaiable END-->
</div>