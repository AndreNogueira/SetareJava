    
<!-- status bar -->    
<s:include value="/WEB-INF/jspf/partials/cars/progress_status.jsp">
    <s:param name="search_results">passed</s:param>
    <s:param name="optional_extras">passed</s:param>
    <s:param name="payment">active</s:param>
</s:include>    
<!-- end of status bar -->
    
<div class="row" id="results_main_container">
    
    <!-- style="border-radius: 5px;background: #C9D9F0" -->
    <div class="large-4 columns" id="service_resume_price">
        <div class="row" id="border_car_rent_price">
            <div class="large-8 columns" >
                <p>Your car rent price is:</p>
            </div>
            <div class="large-4 columns">
                <p> <s:property value="getText('{0,number,#,##0.00}',{#session['total_price']})"/> &euro;</p>
            </div>
        </div>
      
        <div class="row" id="border_extra_equipment_price">
            <div class="large-8 columns" >
                <p>Your extra-equipment price is:</p>
            </div>
            <div class="large-4 columns">
                <p> <s:property value="getText('{0,number,#,##0.00}',{#session['extras_price']})"/> &euro;</p>
            </div>
        </div>
        <div class="row" id="border_total_price">
            <div class="large-8 columns" >
                <p><b>Total Price:</b></p>
            </div>
            <div class="large-4 columns">
                <p> <s:property value="getText('{0,number,#,##0.00}',{#session['final_price']})"/> &euro;</p>
            </div>
        </div>
      
        <div class="row" id="top_border" style="background-color: #D5D5D5; border-bottom: dashed;margin-top: 10px">
            <div class="large-12 columns" style="text-align: center">
                <p><b>Service Resume</b></p>
            </div>
        </div>
        <div class="row" id="middle_border">
            <div class="large-12 columns" style="margin-top: 10px">
                <p style="font-size: 12px">
                    <img src="../assets/images/cars/MainImages/pick-icon.gif" style="width: 18px; height: 18px;"> 
                    <s:property value="#session['location_names'].get('pcity_name')"/> ,<s:property value="#session['location_names'].get('pcountry_name')"/> at <s:property value="#session['service_params'].pick_time"/> <s:property value="#session['service_params'].pick_date"/></p>
            </div>
        </div>
        <div class="row" id="middle_border">
            <div class="large-12 columns" >
                <p style="font-size: 12px">
                    <img src="/SetareJava/assets/images/cars/MainImages/drop-icon.gif" style="width: 18px; height: 18px;"> <s:property value="#session['location_names'].get('dcity_name')"/> ,<s:property value="#session['location_names'].get('pcountry_name')"/> at <s:property value="#session['service_params'].drop_time"/> <s:property value="#session['service_params'].drop_date"/></p>
            </div>
        </div>
      
        <div class="row" id="bottom_border">
            <div class="large-7 columns" >
                <p style="font-size: 16px !important;">
                    <s:property value="car.brand"/> <s:property value="car.model"/></p>
                <img src="../assets/images/cars/<s:property value="car.image"/>.jpg" style="width: 150px; height: 100px;">
                <div class="row" style="margin-top: 20px;">
                    <div class="large-12 columns">
                        <p style="font-size: 12px;margin-bottom: 5px">Provided by:</p>
                        <div style="text-align: center">
                            <img src="/SetareJava/assets/images/agencies/<s:property value="car.getAgency().getImage()"/>.png" style="width: 70px; height: 35px;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="large-5 columns">
        
                <div class="row" >
                    <div class="large-12 columns">
                        <p><img src="/SetareJava/assets/images/cars/SearchResults/nr_seats.png" style="width: 13px; height: 13px;">x<s:property value="car.capacity"/></p>
                    </div>
                </div>
          
                <div class="row" >
                    <div class="large-12 columns" >
                        <p><img src="/SetareJava/assets/images/cars/SearchResults/doors-icon.jpg" style="width: 20px; height: 20px;">x<s:property value="car.doorsNumber"/></p>
                    </div>
                </div>
          
                <div class="row" >
                    <div class="large-12 columns">
                        <s:if test="car.ac">
                            <img src="/SetareJava/assets/images/cars/SearchResults/icon-ac.png" style="width: 18px; height: 18px;"> yes
                        </s:if>
                        <s:else>
                            <img src="/SetareJava/assets/images/cars/SearchResults/icon-ac.png" style="width: 18px; height: 18px;"> no
                        </s:else>
                    </div>
                </div>
                <br>
                <div class="row" >
                    <div class="large-12 columns" >
                        <s:if test="car.transmission">
              
                            <img src="/SetareJava/assets/images/cars/SearchResults/icon-gear.png" style="width: 28px; height: 28px;">manual
                        </s:if>
                        <s:else>
                            <img src="/SetareJava/assets/images/cars/SearchResults/icon-gear.png" style="width: 28px; height: 28px;">automatic
                        </s:else>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="large-12 columns end" >
                        <s:if test="car.abs">
                            <img src="/SetareJava/assets/images/cars/SearchResults/icon_abs.png" style="width: 25px; height: 25px;">yes
                        </s:if>
                        <s:else>
                            <img src="/SetareJava/assets/images/cars/SearchResults/icon-ac.png" style="width: 25px; height: 25px;">no
                        </s:else> 
                    </div>
                </div>
            </div>
        </div>
      
        <div class="row" >
            <div class="large-8 large-offset-2 columns end" id="border_image_norton">
                <img src="/SetareJava/assets/images/cars/MainImages/norton_x150.png" >
            </div>
        </div>
    </div>
    
    <div class="large-8 columns" >
    
        <div class="large-12 columns" id="user_info_form">
            <div class="row">
                <div class="large-12 columns">
                    <h3><img src="/SetareJava/assets/images/cars/MainImages/form-user.png"> <b>Main driver data</b></h3>
                </div>
            </div>
            <!-- Row Name and E-mail -->
            <div class="row">
                <div class="large-6 columns">
                    <label value="Name"/>
                    <s:textfield name="name" value="%{#session['user'].name}" readonly="true"/>
                </div>
                <div class="large-6 columns">
                    <label value="E-mail" />
                    <s:textfield name="email" value="%{#session['user'].email}" readonly="true"/>
                </div>
            </div>
        
            <!-- Row BI and PhoneNumber -->
            <div class="row">
                <div class="large-6 columns">
                    <label value="B.I." />
                    <s:textfield name="bi" value="%{#session['user'].bi}" readonly="true"/>
                </div>
                <div class="large-6 columns">
                    <label value="Phone Number" />
                    <s:textfield name="phone_number" value="%{#session['user'].phoneNumber}" readonly="true"/>
                </div>
            </div>
        
            <!-- Row NIF and Driver License -->
            <div class="row">
                <div class="large-6 columns">
                    <label value="NIF" />
                    <s:textfield name="nif" value="%{#session['user'].nif}" readonly="true"/>
                </div>
                <div class="large-6 columns">
                    <label value="Driver License" />
                    <s:textfield name="driver_license" value="%{#session['user'].driverLicense}" readonly="true"/>
                </div>
            </div>
        </div>
      
      
        <div class="large-12 columns" id="user_info_form" style="margin-top: 10px">
            <div class="row">
                <div class="large-7 columns">
                    <h3><img src="/SetareJava/assets/images/cars/MainImages/card_icon.png"> <b>Payment Details</b></h3>
                </div>
                <div class="large-5 columns" style="text-align: right">
                    <p style="font-size: 11px; margin-bottom: 0px">We accept all major payment methods</p>
                    <img src="/SetareJava/assets/images/cars/MainImages/cards.png" >
                </div>
            </div>
            <s:form action="car-reservation" namespace="/cars" data-abide="abide" validate="true" >
       
                <!-- Row CardHolder Name -->
                <div class="row">
                    <div class="large-6 columns">
                        <s:label value="First Name" />
                        <s:textfield name="firstName" placeholder="Insert your first name..." required="true" pattern="alpha" />
                        <small class="error">You need to insert your first name.</small>
                    </div>
                    <div class="large-6 columns">
                        <s:label value="Last Name" />
                        <s:textfield name="lastName" placeholder="Insert your last name..." required="true" pattern="alpha" />
                        <small class="error">You need to insert your last name.</small>
                    </div>
                </div>
            
                <!-- Row Card Type e Card Number -->
                <div class="row">
                    <div class="large-6 columns">
                        <s:label value="Card Type" />
                        <s:select name="cardType" list="creditCards" headerKey="-1" headerValue="Choose your card type" required="true" />
                        <small class="error">You need to choose your credit card type.</small>
                    </div>
                    <div class="large-6 columns">
                        <s:label value="Credit Card Number" />
                        <s:textfield name="cardNumber" placeholder="Insert your credit card number..." required="true" pattern="number" />
                        <small class="error">You need to insert your credit card number.</small>
                    </div>
                </div>
            
                <!-- Row CVV and Expire Date -->
                <div class="row">
                    <div class="large-6 columns">
                        <s:label value="CVV/Security Number" />
                        <s:textfield name="cvv" placeholder="Insert your credit card security number..." required="true" maxLength="3" />
                        <small class="error">You need to insert your credit card security number.</small>
                    </div>
                    <div class="large-6 columns">
                        <s:label value="Expiry Date" />
                        <s:select name="year" headerKey="-1" headerValue="Choose year" list="years" 
                                  cssClass="taxi-expiry-year" required="true" />
                        <s:select name="month" headerKey="-1" headerValue="Choose month" list="months" 
                                  cssClass="taxi-expiry-month" required="true"/>
                        <small class="error" style="margin-top: 0 !important;width: 281px;">
                            You need to choose an year and a month.
                        </small>
                    </div>
                </div>
            
                <!-- Row for Book Button -->
                <div class="row" style="margin: 3% 0 0 0 !important;">
                    <div class="large-12 columns">
                        <s:submit type="button" cssClass="button small radius expand" >
                            <i class="fi-bookmark"></i> Book Now!!
                        </s:submit>
                    </div>
                </div>
            
            </s:form>
        
        </div>
    </div>
</div>