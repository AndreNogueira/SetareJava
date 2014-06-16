    <div id="sub" class="lifestyle_img">
    <div class="content">
        <div id="title">
            <h1 style="font-size: 35px;"><b>The best prices for hire a car in one place - Guaranteed</b></h1>
        </div>
        <div id="subTitle">
            <p id="h1sub" style="font-size: 17px;">Complete the form below to search for cheap car hire in over 6000 destinations worldwide, Find Out!</p>
        </div>
    </div>
</div>

<div class="row">
    
    <div class="large-6 columns" id="search_box">
        <s:form action="search-results" namespace="/cars" data-abide="abide">
            <!-- title search box -->
            <div class="row">
                <div class="large-12 large-centered columns">
                    <h2><b>Search for a Renting Car</b></h2>
                </div>
            </div>
            <!-- pick Countries select -->
            <div class="row">
                <div class="large-3 columns">
                    <s:label name="pick_country" value="Country : " cssClass="right_inline"></s:label>          
                    </div>
                    <div class="large-9 columns">
                    <s:select list="countries" listKey="id" listValue="name" headerKey="-1" headerValue="Please Select" name="pick_country" id="pick_country" required="true" />
                    <small class="error">You need to choose a Country.</small>
                </div>
            </div>
            <!-- pick cities select -->
            <div class="row">
                <div class="large-3 columns">
                    <s:label name="pick_city" value="City : " cssClass="right_inline"></s:label>    
                    </div>
                    <div class="large-9 columns">                        
                    <s:select name="pick_city" list="%{{}}" headerKey="-1" headerValue="Please Select" id="pick_city" required="true" disabled="true" />
                    <small class="error">You need to choose a City.</small>
                </div>
            </div>
            <!-- pick subsidiary select -->
            <div class="row">
                <div class="large-3 columns">
                    <s:label name="pick_subsidiary" value="Subsidiary : " cssClass="right_inline"></s:label>            
                    </div>
                    <div class="large-9 columns">
                    <s:select name="pick_subsidiary" list="%{{}}" headerKey="-1" headerValue="Please Select" id="pick_subsidiary" required="true" disabled="true" />
                    <small class="error">You need to choose a Subsidiary.</small>
                </div>
            </div>
            
            <!-- Checkbox Deliver in the same place -->
            <div class="row">
                <div class="large-9 large-offset-3 columns">
                    <s:checkbox id="return_at_same_location" name="return_at_same_location" value="true"/>
                    <s:label name="pick_subsidiary">Return at same Location</s:label>  
                    </div>
                </div>
                
                <div id="drop_location">
                    <div class="row">
                        <div class="large-3 columns">
                            <h5><b> Deliver at:</b> </h5>
                        </div>
                    </div>
                    
                    <!-- drop Countries select -->
                    <div class="row">
                        <div class="large-3 columns">            
                        <s:label name="drop_country" value="Country : " cssClass="right_inline"></s:label>       
                        </div>
                        <div class="large-9 columns">
                        <s:select list="countries" listKey="id" listValue="name" headerKey="-1" headerValue="Please Select" name="drop_country" id="drop_country" required="true" />
                    </div>
                </div>
                <!-- drop cities select -->
                <div class="row">
                    <div class="large-3 columns">
                        <s:label name="drop_city" value="City : " cssClass="right_inline"></s:label>  
                        </div>
                        <div class="large-9 columns">
                        <s:select name="drop_city" list="%{{}}" headerKey="-1" headerValue="Please Select" id="drop_city" required="true" disabled="true" />
                    </div>
                </div>
                <!-- drop subsidiary select -->
                <div class="row">
                    <div class="large-3 columns">
                        <s:label name="drop_subsidiary" value="Subsidiary : " cssClass="right_inline"></s:label>  
                        </div>
                        <div class="large-9 columns">
                        <s:select name="drop_subsidiary" list="%{{}}" headerKey="-1" headerValue="Please Select" id="drop_subsidiary" required="true" disabled="true" />
                    </div>
                </div>
            </div>
            <!-- Row Date of Pick-Up Time -->
            <div class="row">
                
                <div class="large-5 large-offset-3 columns">
                    <div class="row collapse">
                        <div class="row">
                            <div class="large-12 columns">
                                Pick-Up Date:
                            </div>
                        </div>
                        <div class="large-10 columns">
                            <sj:datepicker id="begin_date" name="pick_date" value="today" 
                                           minDate="today" displayFormat="dd/mm/yy" showOn="focus" readonly="true"/>
                        </div>
                        <div class="large-2 columns">
                            <s:submit type="button" cssClass="button small round postfix" id="begin-calendar">
                                <i class="fi-calendar"></i>
                            </s:submit>
                        </div>
                    </div>
                </div>
                
                <div class="large-4 columns">
                    <div class="row collapse">
                        <div class="row">
                            <div class="large-12 columns">
                                Pick-Up Time:
                            </div>
                        </div>
                        <div class="large-12 columns">
                            <sj:datepicker name="pick_time" id="begin_time" placeholder="Choose a Time" showOn="focus" readonly="true"
                                           timepicker="true" timepickerOnly="true" timepickerStepHour="1" timepickerStepMinute="5" required="true"/>
                            <small class="error" style="width: 289px;margin-top: 0 !important">
                                You need to choose an hour and minutes.
                            </small>                           
                        </div>                     
                    </div>
                </div>
            </div>
            
            <!-- Row Date of Drop-Off Time -->
            <div class="row">
                
                <div class="large-5 large-offset-3 columns">
                    <div class="row collapse">
                        <div class="row">
                            <div class="large-12 columns">
                                Drop-Off Date:
                            </div>
                        </div>
                        <div class="large-10 columns">
                            <sj:datepicker id="end_date" name="drop_date" value="tomorrow"
                                           displayFormat="dd/mm/yy" showOn="focus" readonly="true" minDate="today" />
                            
                        </div>
                        <div class="large-2 columns">
                            <s:submit type="button" cssClass="button small round postfix" id="end-calendar">
                                <i class="fi-calendar"></i>
                            </s:submit>
                        </div>
                    </div>
                </div>
                
                <div class="large-4 columns">
                    <div class="row collapse">
                        <div class="row">
                            <div class="large-12 columns">
                                Drop-Off Time:
                            </div>
                        </div>
                        <div class="large-12 columns">
                            <sj:datepicker name="drop_time" id="end_time" placeholder="Choose a Time" showOn="focus" readonly="true"
                                           timepicker="true" timepickerOnly="true" timepickerStepHour="1" timepickerStepMinute="5" />
                            <small class="error" style="width: 289px;margin-top: 0 !important">
                                You need to choose an hour and minutes.
                            </small>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- Search Button -->
            <div class="row">
                <div class="large-5 large-centered columns" style="padding-top: 2%;">
                    <s:submit type="button" cssClass="button large radius expand" >
                        <i class="fi-magnifying-glass"></i> Search
                    </s:submit>
                </div>
            </div>            
        </s:form>
    </div>
    
    
    <div class="large-6 columns">
        
        <div class="area">
            
            <h3 id="title_logos"><b>Great brands. Huge choice. Great Savings!</b></h3>
            <div class="logos-wrap">
                <div class="logos">
                    <img src="../assets/images/agencies/hertz_logo.png" class="subsidiaries_list"/>
                    <img src="../assets/images/agencies/avis_logo.png" class="subsidiaries_list"/>
                    <img src="../assets/images/agencies/europcar_logo.png" class="subsidiaries_list"/>
                    <img src="../assets/images/agencies/alamo_logo.png" class="subsidiaries_list"/>
                    <img src="../assets/images/agencies/budget_logo.png" class="subsidiaries_list"/>
                    <img src="../assets/images/agencies/national_logo.png" class="subsidiaries_list"/>
                    <img src="../assets/images/agencies/dollar_logo.png" class="subsidiaries_list"/>
                    <img src="../assets/images/agencies/thrifty_logo.png" class="subsidiaries_list"/>                    
                </div>
            </div>
            <br>
            <div class="row">
                <div class="large-12 columns">
                    <p id="reviewcentre">
                        Rated <em>No.1</em> by real users of <span>review centre</span>
                    </p>
                </div>
            </div>
        </div>
    </div>
    
</div>

<div class="row">
    <div class="large-8 large-centered columns">
        <p id="callHours">
            Our team is here to help you 24 hours a day, 7 days a week
        </p>
        <p id="callus">
            Do you want to book by phone ?
            Contact Us
            <span style="color: #000000">913 626 859</span>
        </p>
    </div>
</div>









