<div class="row">
  <div class="tabs">
    <ul class="tab-links">
      <li class="active"><a href="#tab-taxis">Taxis Services</a></li>
      <li><a href="#tab-cars">Cars Services</a></li>
    </ul>
    <div class="tab-content">
      <div id="tab-taxis" class="tab active" style="display: block;">
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
            <td><s:property value="id"/></td>
            <td><s:property value="finalPrice"/></td>
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
      </div>
      <div id="tab-cars" class="tab" style="display: none;">
        <= render partial: 'home/partials/table_car_reservations', locals: { cars: @cars } %>
      </div>
    </div>
  </div>

</div>
