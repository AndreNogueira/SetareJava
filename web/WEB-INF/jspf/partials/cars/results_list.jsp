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
            <s:include value="/WEB-INF/jspf/partials/cars/results_list_grid.jsp"></s:include>
        </s:iterator> 
    </s:else>
    
    
    <!-- List of cars from other agencies if avaiable BEGIN -->
    <#% if other_agencies_list.size > 0 %>
    
    <div class="large-12 columns" style="text-align: center">
        <h4>Avaiable Cars from other Agencies</h4>
    </div>
        
        
    <#% if other_agencies_list.first[0].nil?%>
    
    <#%other_agencies_list.each do |car| %>
    
    <#%= render 'car/partials/result_list_grid',car: car %>
    
    <#%end%>
    
    <#%else%>
    
    <#% other_agencies_list.each do |cl| %>
    
    <#% cl.each do |car| %>
    
    <#%= render 'car/partials/result_list_grid',car: car %>
    
    <#%end%>
    
    <#%end%>
    
    <#%end%>
    
    <#%end%>
    <!-- List of cars from other agencies if avaiable END-->
    <s:debug/>
</div>