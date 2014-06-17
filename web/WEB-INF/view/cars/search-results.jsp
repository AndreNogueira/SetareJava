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
    <s:include value="/WEB-INF/jspf/partials/cars/search_box_results.jsp"></s:include>    
        <!-- end left bar search -->
        
        <!-- right results search -->
    <s:include value="/WEB-INF/jspf/partials/cars/results_list.jsp"></s:include>    
    <!-- end right results search    -->
</div>



