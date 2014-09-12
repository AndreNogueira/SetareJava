<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>

<div style="  background: linear-gradient(to bottom, #D5D5D5 0%,#D5D5D5 100%);
     border-radius: 7px;">
         
    <div class="row" >
        <div class="large-3 columns">
            <div class="row">
                <div class="large-12 columns">
                    <div class="car_image" style="text-align: center">           
                        <img src="/assets/images/cars/<s:property value="car.image"/>.jpg"  style="width: 150px; height: 100px;">
                    </div>
                </div>
            </div>
                
            <div class="row" style="margin-top: 40px;">
                <div class="large-12 columns">
                    <p class="provided_by">Provided by:</p>
                    <div style="text-align: center">
                        <img src="/assets/images/agencies/<s:property value="car.agency.image"/>.png"  style="width: 70px; height: 35px;">          
                    </div>
                </div>
            </div>
        </div>
        <div class="large-9 columns">
            
            <div class="row">
                <div class="large-8 columns" id="car_info">
                    <div class="row car_info_margin">
                        <div class="large-12 columns">
                            <p style="font-size: 16px !important;"><s:property value="car.brand"/> <s:property value="car.model"/></p>
                            <p style="font-size: 14px !important;"> Ano: <s:property value="car.year"/></p>
                        </div>
                    </div>
                    <div class="row car_info_margin">
                        <div class="large-5 columns" id="border_left">
                            <p>Classe: <s:property value="car.category.name"/></p>
                                
                        </div>
                        <div class="large-7 columns">
                            <img src="/assets/images/cars/SearchResults/icon_fuelpolicy.gif" style="width: 15px; height: 15px;"><p> <s:property value="car.fuelType"/>  <s:property value="car.fuelConsumption"/>L / 100Km</p>
                        </div>
                    </div>
                    <div class="row car_info_margin">
                        <div class="large-2 columns">
                            <img src="/assets/images/cars/SearchResults/nr_seats.png" style="width: 13px; height: 13px;"><p>x<s:property value="car.capacity"/></p>
                        </div>
                        <div class="large-2 columns" style="text-align: center">
                            <img src="/assets/images/cars/SearchResults/doors-icon.jpg" style="width: 20px; height: 20px;"><p>x<s:property value="car.doorsNumber"/></p>
                        </div>
                        <div class="large-2 columns">
                            <s:if test="car.ac">
                                <img src="/assets/images/cars/SearchResults/icon-ac.png" style="width: 18px; height: 18px;"><p> yes</p>
                            </s:if>
                            <s:else>
                                <img src="/assets/images/cars/SearchResults/icon-ac.png" style="width: 18px; height: 18px;"><p> no</p>
                            </s:else>                                
                        </div>
                        <div class="large-3 columns" style="text-align: center">
                            <s:if test="car.transmission">
                                <img src="/assets/images/cars/SearchResults/icon-gear.png" style="width: 22px; height: 22px;"><p>manual</p>
                            </s:if>
                            <s:else>
                                <img src="/assets/images/cars/SearchResults/icon-gear.png" style="width: 22px; height: 22px;"><p>automatic</p>
                            </s:else>                   
                        </div>
                            
                        <div class="large-2 columns end" style="text-align: center">
                            <s:if test="car.abs">
                                <img src="/assets/images/cars/SearchResults/icon_abs.png" style="width: 22px; height: 22px;"><p>yes</p>
                            </s:if>
                            <s:else>
                                <img src="/assets/images/cars/SearchResults/icon_abs.png" style="width: 22px; height: 22px;"><p>no</p>
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
                            <img src="/assets/images/cars/SearchResults/check-icon.png"  style="width: 13px; height: 13px;"><p> Safe against Robbery</p>
                        </div>
                        <div class="large-5 columns">
                            <img src="/assets/images/cars/SearchResults/check-icon.png"  style="width: 13px; height: 13px;"><p> Revocation</p>
                        </div>
                    </div>
                    <div class="row car_info_margin">
                        <div class="large-12 columns">
                            <img src="/assets/images/cars/SearchResults/check-icon.png"  style="width: 13px; height: 13px;"><p> Own damage coverage</p>
                        </div>
                    </div>
                </div>
                    
                <div class="large-4 columns" >
                    <div class="row">
                        <div class="large-12 columns" style="text-align: center !important;margin-top: 60px;">
                            <h5>Only <s:property value="car.price"/> &euro; per day</h5>
                        </div>
                        <div class="large-12 columns" style="text-align: center !important;">
                            <h8>Price of your rental car <s:property value="cost"/> &euro; </h8>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
        
</div>
    
<div style="background-color:#666666 ;border-top-left-radius: 7px; border-top-right-radius: 7px;margin-top: 20px">
    <div class="row">
        <div class="large-12 columns" style="text-align: center">
            <h5>Please select the Extra Equipment</h5>
        </div>
    </div>
</div>
<div style="background-color:#D5D5D5 ">
    <div class="row" >
        <div class="large-8 columns" style="text-align: center">
            <p>Item description</p>
        </div>
        <div class="large-2 columns" style="text-align: center">
            <p>Quantity</p>
        </div>
        <div class="large-2 columns" style="text-align: center">
            <p>Add</p>
        </div>
    </div>
</div>
    
    
<s:form namespace="/cars" action="payment" data-abide="abide" method="POST">    
    
    <div style="background-color:#D5D5D5 ">
        <div class="row" style="border-top: 1px solid #FFFFFF;">
            <div class="large-2 columns">
                <img src="/assets/images/cars/MainImages/extra-driver.jpg" style="width: 80px; height: 80px; margin-left:15px; margin-top:5px; margin-bottom:5px">
            </div>
            <div class="large-6 columns">
                <p style="font-size: 12px">Each <b>additional driver</b> costs 6.15&euro; per day.
                    Share driving and enjoy the tranquility knowing that someone else is covered by insurance if necessary.</p>
            </div>
            <div class="large-2 columns" style="text-align: center">
                <div style="margin-top: 20px">
                    <s:select name="additional_driver_quantity" id="additional_driver_quantity" list="{0,1,2,3,4}" style="width: 40px;" />               
                </div>
            </div>
            <div class="large-2 columns" style="text-align: center">
                <div style="margin-top: 25px">
                    <s:checkbox name="additional_driver" id="additional_driver"/>
                </div>
            </div>
        </div>
            
        <div class="row" style="border-top: 1px solid #FFFFFF;">
            <div class="large-2 columns">
                <img src="/assets/images/cars/MainImages/extra-gps.jpg" style="width: 80px; height: 80px; margin-left:15px; margin-top:5px; margin-bottom: 5px">
            </div>
            <div class="large-6 columns">
                <p style="font-size: 12px"><b>GPS</b> costs 8.61&euro; per day.
                    GPS provides turn directions after every curve.</p>
            </div>
            <div class="large-2 columns" style="text-align: center">
                <div style="margin-top: 20px">
                    <s:select name="gps_quantity" id="gps_quantity" list="{0,1,2,3}" style="width: 40px;"/>
                </div>
            </div>
            <div class="large-2 columns" style="text-align: center">
                <div style="margin-top: 25px">
                    <s:checkbox name="gps" id="gps"/>
                </div>
            </div>
        </div>
            
            
        <div class="row" style="border-top: 1px solid #FFFFFF;" >
            <div class="large-2 columns">
                <img src="/assets/images/cars/MainImages/extra-booster.jpg" style=" width: 80px; height: 80px; margin-left:15px; margin-top:5px; margin-bottom:5px;">
            </div>
            <div class="large-6 columns">
                <p style="font-size: 12px"><b>Child Seat</b> costs 10.46&euro; per day.
                    Recommended for children weighing 20 to 40lbs / 9 to 18kg (Age approx. 1-3 years)</p>
            </div>
            <div class="large-2 columns" style="text-align: center">
                <div style="margin-top: 20px">
                    <s:select name="baby_seat_quantity" id="baby_seat_quantity" list="{0,1,2,3}" style="width: 40px;"/>                    
                </div>
            </div>
            <div class="large-2 columns" style="text-align: center">
                <div style="margin-top: 25px">
                    <s:checkbox name="baby_seat" id="baby_seat"/>
                </div>
            </div>
        </div>
    </div>
        
    <div class="row" style="margin-top: 10px">
        <div class="large-4 large-offset-4 columns" style="text-align: center">
            <s:submit type="button" cssClass="button tiny radius expand" >
                <img src="/assets/images/cars/MainImages/key-icon.png" style="width: 30px; height: 30px;"/> Continue
            </s:submit>
        </div>
    </div>
</s:form>