<script>
    $('select#pick_city').attr("disabled",false);
</script>
    
<!-- status bar -->    

<s:include value="/WEB-INF/jspf/partials/cars/progress_status.jsp">
    <s:param name="search_results">active</s:param>
    <s:param name="optional_extras">next</s:param>
    <s:param name="payment">last next</s:param>
</s:include>    
<!-- end of status bar -->
    
<div class="row" id="results_main_container">
    
    <!-- left bar search -->
    <#%= render 'car/partials/search_box_results', locations: @locations, ids:session[:service_params] %>
    <#s:push value="%{locations,ids}">
        <#s:include value="/WEB-INF/jspf/partials/cars/search_box_results.jsp"/>
    <#/s:push>
        
        
    <!-- end left bar search -->
        
    <!-- right results search -->
    <!--<#%= render 'car/partials/results_list', car_list: @list_selected_subsidiary ,other_agencies_list:@other_agencies_list %>-->
    <!-- end right results search    -->
        
</div>
    
    
    
    