<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>

<div class="large-12 columns" id="results_list">
    <div class="row" id="result_list_inside_panel">
        <div class="large-3 columns">
            <div class="row">
                <div class="large-12 columns">
                    <div class="car_image" style="text-align: center">
                        <img src="../assets/images/cars/<s:property value="image"/>"  style="width: 150px; height: 150px;">
                    </div>
                </div>
            </div>
                
            <div class="row" style="margin-top: 40px;">
                <div class="large-12 columns">
                    <p class="provided_by">Provided by:</p>
                    <div style="text-align: center">
                        <img src="../assets/images/agencies/<s:property value="getAgency().getImage()"/>"  style="width: 70px; height: 35px;">
                    </div>
                </div>
            </div>
        </div>
            
        <div class="large-6 columns" id="car_info">
            <div class="row car_info_margin">
                <div class="large-12 columns">
                    <p style="font-size: 16px !important;"><s:property value="brand"/> <s:property value="model"/></p>
                    <p style="font-size: 14px !important;"> Ano:<s:property value="year"/></p>
                </div>
            </div>
            <div class="row car_info_margin">
                <div class="large-5 columns" id="border_left">
                    <p>Classe: <s:property value="getCategory().getName()"/>></p>
                </div>
                <div class="large-7 columns">
                    <img src="../assets/images/cars/SearchResults/icon_fuelpolicy.gif"  style="width: 18px; height: 18px;">
                    <p> <s:property value="fuelType"/>  <s:property value="fuelConsumption"/>L / 100Km</p>
                </div>
            </div>
            <div class="row car_info_margin">
                <div class="large-2 columns">
                    <img src="../assets/images/cars/SearchResults/nr_seats.png" style="width: 15px; height: 15px;"> <p>x<s:property value="capacity"/></p>
                </div>
                <div class="large-2 columns" style="text-align: center">
                    <img src="../assets/images/cars/SearchResults/doors-icon.jpg" style="width: 26px; height: 26px;"><p><s:property value="doorsNumber"/></p>
                </div>
                <div class="large-2 columns">
                    <s:if test="car.ac">
                        <img src="../assets/images/cars/SearchResults/icon-ac.png" style="width: 23px; height: 23px;"><p> yes</p>
                    </s:if>
                    <s:else>
                        <img src="../assets/images/cars/SearchResults/icon-ac.png" style="width: 23px; height: 23px;"><p> no</p>
                            
                    </s:else>
                </div>
                <div class="large-3 columns" style="text-align: center">
                    <s:if test="car.transmission">
                        
                        <img src="../assets/images/cars/SearchResults/icon-gear.png" style="width: 28px; height: 28px;"><p>manual</p>
                    </s:if>
                    <s:else>
                        <img src="../assets/images/cars/SearchResults/icon-gear.png" style="width: 28px; height: 28px;"><p>automatic</p>
                    </s:else>
                </div>
                            
                <div class="large-2 columns end" style="text-align: center">
                    <s:if test="car.abs">
                        <img src="../assets/images/cars/SearchResults/icon_abs.png" style="width: 25px; height: 25px;"><br><p>yes</p>
                        </s:if>
                        <s:else>
                        <img src="../assets/images/cars/SearchResults/icon-ac.png" style="width: 25px; height: 25px;"><br><p>no</p>
                    </s:else> 
                </div>
                
            </div>
            <div class="row car_info_margin">
                <div class="large-12 columns" style="text-align: center !important;">
                    
                    <p style="color: #749E3A">We offer for FREE:</p>
                </div>
            </div>
            <div class="row car_info_margin">
                <div class="large-7 columns">
                     <img src="../assets/images/cars/SearchResults/check-icon.png" style="width: 16px; height: 16px;"><p> Safe against Robbery</p>
                </div>
                <div class="large-5 columns">
                     <img src="../assets/images/cars/SearchResults/check-icon.png" style="width: 16px; height: 16px;"><p> Revocation</p>
                </div>
            </div>
            <div class="row car_info_margin">
                <div class="large-12 columns">
                     <img src="../assets/images/cars/SearchResults/check-icon.png" style="width: 16px; height: 16px;"><p> Own damage coverage</p>
                </div>
            </div>
        </div>
        
        <div class="large-3 columns" id="price_column">
            <div class="row">
                <div class="large-12 columns">
                    <p>Price:</p>
                </div>
            </div>
            <div class="row">
                <div class="large-12 columns" style="text-align: center !important;">
                    <h3><#%= calc_rent_price car.price, session[:service_params]["begin_date"],session[:service_params]["end_date"] %> &euro;</h3>
                </div>
            </div>
            <div class="row" style="margin-top: 30px!important">
                <div class="large-12 columns">
                    <#%= link_to 'Book Now',cars_service_extras_path(car), class: 'button medium radius expand' %>
                </div>
            </div>
        </div>
    </div>
    
    <div class="row">
        <div class="large-3 columns" id="terms_conditions">
            <div style="text-align: center">
                <p>Terms and Conditions</p>
            </div>
        </div>
    </div>
</div>