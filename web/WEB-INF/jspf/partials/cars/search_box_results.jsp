<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div class="large-3 columns" id="search_box_results">
    <div class="row">
        <div class="large-12 columns">
            
            <s:form action="search-results" namespace="/cars" data-abide="abide">
                
                <!-- title search box -->
                <div class="row">
                    <div class="large-12 large-centered columns" style="text-align: center!important">
                        <h5><b>Search for a Renting Car</b></h5>
                    </div>
                </div>
                    
                <div class="row">
                    <div class="large-12 columns" style="text-align: center">                    
                        <a href="#" class="change_pick_location">change locations</a>
                    </div>
                </div>
                    
                <div class="row">
                    <div class="large-12 columns" style="text-align: center">
                        <h7><b><div id="pcity_name"></div></b></h7>
                    </div>
                </div>
                    
                <div id="pick_location">
                    <!-- pick Countries select -->
                    <div class="row">
                        <div class="large-4 columns">
                            <s:label name="pick_country" value="Country : " cssClass="right_inline"></s:label>  
                            </div>
                            <div class="large-8 columns">   
                            <s:select list="locations.countries" listKey="value" listValue="key" headerKey="-1" 
                                      headerValue="Please Select" name="pick_country" id="pick_country" required="true" 
                                      value="#session['service_params'].pick_country" />                                      
                            <small class="error">You need to choose a Country.</small>
                        </div>
                    </div>
                    <!-- pick cities select -->
                    <div class="row">
                        <div class="large-4 columns">
                            <s:label name="pick_city" value="City : " cssClass="right_inline"></s:label>
                            </div>
                            <div class="large-8 columns">
                                
                            <s:select list="locations.pick_cities" listKey="value" listValue="key" value="#session['service_params'].pick_city"
                                      headerKey="-1" headerValue="Please Select" name="pick_city" id="pick_city" required="true" />
                            <small class="error">You need to choose a City.</small>
                        </div>
                    </div>
                    <!-- pick subsidiary select -->
                    <div class="row">
                        <div class="large-4 columns">
                            <s:label name="pick_subsidiary" value="Subsidiary:" cssClass="right_inline"></s:label>  
                            </div>
                            <div class="large-8 columns">
                            <s:select list="locations.pick_subs" listKey="value" listValue="key" value="#session['service_params'].pick_subsidiary"
                                      headerKey="-1" headerValue="Please Select" name="pick_subsidiary" id="pick_subsidiary" required="true" />
                            <small class="error">You need to choose a Subsidiary.</small>
                        </div>
                    </div>
                </div>
                    
                <!-- Row Date of Pick-Up Time -->
                <div class="row">
                    <div class="large-6 columns">
                        <div class="row collapse">
                            <div class="row">
                                <div class="large-12 columns" style="margin-bottom: -20px;">
                                    <p id="p_date_hour">Pick-Up Date:</p>
                                </div>
                            </div>
                            <div class="large-10 columns">
                                
                                <sj:datepicker id="pick_date" name="pick_date" value="%{#session['service_params'].pick_date}"
                                               minDate="today" displayFormat="dd/mm/yy" showOn="focus" readonly="true"/>
                                                   
                            </div>
                            <div class="large-2 columns">
                                <s:submit type="button" cssClass="button small round postfix" id="begin-calendar">
                                    <i class="fi-calendar"></i>
                                </s:submit>
                            </div>
                        </div>
                    </div>
                        
                    <div class="large-6 columns">
                        <div class="row collapse">
                            <div class="row">
                                <div class="large-12 columns" style="margin-bottom: -20px;">
                                    <p id="p_date_hour">Pick-Up Time:</p>
                                </div>
                            </div>
                            <div class="large-12 columns">                                
                                <sj:datepicker name="pick_time" id="pick_time" placeholder="Choose a Time" showOn="focus" readonly="true"
                                               timepicker="true" timepickerOnly="true" timepickerStepHour="1" timepickerStepMinute="5" 
                                               required="true" value="%{#session['service_params'].pick_time}"/>
                            </div>
                            
                        </div>
                    </div>
                </div>
                    
                <!-- Checkbox Deliver in the same place -->
                <div class="row" id="return_at_same">
                    <div class="large-10 large-offset-1 columns">                        
                        <s:checkbox id="return_at_same_location" name="return_at_same_location" value="%{#session['service_params'].return_at_same_location}"/>
                        <s:label name="return_at_same" id="return_at_same_location">Return at same Loc.</s:label>  
                        </div>
                    </div>
                        
                        
                    <div class="row">
                        <div class="large-12 columns" style="text-align: center">
                            <h7><b><div id="dcity_name"></div></b></h7>
                        </div>
                    </div>
                        
                    <div id="drop_location">
                        <!-- drop Countries select -->
                        <div class="row">
                            <div class="large-4 columns">
                            <s:label name="drop_country" value="Country : " cssClass="right_inline"></s:label>
                            </div>
                            <div class="large-8 columns">
                            <s:select list="locations.countries" listKey="id" listValue="name" headerKey="-1" 
                                      headerValue="Please Select" name="pick_country" id="pick_country" required="true" 
                                      value="#session['service_params'].pick_country" disabled="true" />  
                        </div>
                    </div>
                    <!-- drop cities select -->
                    <div class="row">
                        <div class="large-4 columns">
                            <s:label name="drop_city" value="City : " cssClass="right_inline"></s:label> 
                            </div>
                            <div class="large-8 columns">
                            <s:select list="locations.drop_cities" listKey="value" listValue="key" value="#session['service_params'].drop_city"
                                      headerKey="-1" headerValue="Please Select" name="drop_city" id="drop_city" required="true" />
                        </div>
                    </div>
                    <!-- drop subsidiary select -->
                    <div class="row">
                        <div class="large-4 columns">
                            <s:label name="drop_subsidiary" value="Subsidiary:" cssClass="right_inline"></s:label> 
                            </div>
                            <div class="large-8 columns">
                            <s:select list="locations.drop_subs" listKey="value" listValue="key" value="#session['service_params'].drop_subsidiary"
                                      headerKey="-1" headerValue="Please Select" name="drop_subsidiary" id="drop_subsidiary" required="true" />
                        </div>
                    </div>
                </div>
                        
                <!-- Row Date of Drop-Off Time -->
                <div class="row">
                    
                    <div class="large-6 columns">
                        <div class="row collapse">
                            <div class="row">
                                <div class="large-12 columns" style="margin-bottom: -20px;">
                                    <p id="p_date_hour">Drop-Off Date:</p>
                                </div>
                            </div>
                            <div class="large-10 columns">
                                <sj:datepicker id="drop_date" name="drop_date" value="%{#session['service_params'].drop_date}"
                                               minDate="today" displayFormat="dd/mm/yy" showOn="focus" readonly="true"/>
                            </div>
                            <div class="large-2 columns">
                                <s:submit type="button" cssClass="button small round postfix" id="begin-calendar">
                                    <i class="fi-calendar"></i>
                                </s:submit>
                            </div>
                        </div>
                    </div>
                        
                    <div class="large-6 columns">
                        <div class="row collapse">
                            <div class="row">
                                <div class="large-12 columns" style="margin-bottom: -20px;">
                                    <p id="p_date_hour">Drop-Off Time:</p>
                                </div>
                            </div>
                            <div class="large-12 columns">
                                <sj:datepicker name="drop_time" id="drop_time" placeholder="Choose a Time" showOn="focus" readonly="true"
                                               timepicker="true" timepickerOnly="true" timepickerStepHour="1" timepickerStepMinute="5" 
                                               required="true" value="%{#session['service_params'].drop_time}"/>   
                            </div>                            
                        </div>
                    </div>
                </div>
                    
                <!-- Search Button -->
                <div class="row">
                    <div class="large-6 large-offset-3 columns end" style="text-align: center">
                        <s:submit type="button" cssClass="button tiny radius expand" >
                            <i class="fi-magnifying-glass"></i> Search
                        </s:submit>
                    </div>
                </div>
            </s:form>
        </div>
    </div>
</div>