<div class="row">
  <div class="tabs">
    <ul class="tab-links">
      <li class="active"><a href="#tab-taxis">Taxis Services</a></li>
      <li><a href="#tab-cars">Cars Services</a></li>
    </ul>
    <div class="tab-content">
      <div id="tab-taxis" class="tab active" style="display: block;">
          <s:include value="/WEB-INF/jspf/partials/users/table_taxis.jsp"/>          
      </div>
      <div id="tab-cars" class="tab" style="display: none;">
          <s:include value="/WEB-INF/jspf/partials/users/table_cars.jsp" />
      </div>
    </div>
  </div>
</div>
