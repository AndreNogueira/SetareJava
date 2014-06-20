<!-- status bar -->    
<s:include value="/WEB-INF/jspf/partials/cars/progress_status.jsp">
    <s:param name="search_results">passed</s:param>
    <s:param name="optional_extras">active</s:param>
    <s:param name="payment">last next</s:param>
</s:include>    
<!-- end of status bar -->

<div class="row" id="results_main_container">
  <!-- left bar search -->  
   <s:include value="/WEB-INF/jspf/partials/cars/search_box_results.jsp"></s:include> 
  <!-- end left bar search -->

  <div class="large-9 columns" >
       <s:include value="/WEB-INF/jspf/partials/cars/service_extras.jsp"></s:include>     
  </div>

</div>