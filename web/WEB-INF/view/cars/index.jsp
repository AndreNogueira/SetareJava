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
        <s:form action="cars-search-results" namespace="/cars" data-abide="abide">
            
            
            
            
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
                    <s:select list="countries" listKey="id" listValue="name" headerKey="-1" headerValue="Please Select" name="country" id="pick_country" required="true" />
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
                
                <div class="large-6 large-offset-2 columns">
                    <div class="row collapse">
                        <div class="row">
                            <div class="large-12 columns">
                                Pick-Up Date:
                            </div>
                        </div>
                        <div class="large-10 columns">
                            <#%= text_field_tag :begin_date, DateTime.now.strftime('%d/%m/%Y'), id: 'begin-datepicker', readonly: true %>
                        </div>
                        <div class="large-2 columns">
                            <#%= button_tag type: 'button', class: 'button large round postfix', id: 'begin-calendar' do %>
                            <i class="fi-calendar"></i>
                            <#% end %>
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
                        <div class="large-10 columns">
                            <#%= text_field_tag :timepicker_begin,Time.now.strftime('%H:%M'), id:'begin_timepicker', readonly: true %>
                        </div>
                        <div class="large-2 columns">
                            <#%= button_tag type: 'button',class: 'button large round postfix begin_timepicker_button_trigger' do %>
                            <i class="fi-clock"></i>
                            <#% end %>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- Row Date of Drop-Off Time -->
            <div class="row">
                
                <div class="large-6 large-offset-2 columns">
                    <div class="row collapse">
                        <div class="row">
                            <div class="large-12 columns">
                                Drop-Off Date:
                            </div>
                        </div>
                        <div class="large-10 columns">
                            <#%= text_field_tag :end_date, DateTime.now.strftime('%d/%m/%Y'), id: 'end-datepicker', readonly: true %>
                        </div>
                        <div class="large-2 columns">
                            <#%= button_tag type: 'button', class: 'button large round postfix', id: 'end-calendar' do %>
                            <i class="fi-calendar"></i>
                            <#% end %>
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
                        <div class="large-10 columns">
                            <#%= text_field_tag :timepicker_end,Time.now.strftime('%H:%M'), id:'end_timepicker', readonly: true %>
                        </div>
                        <div class="large-2 columns">
                            <#%= button_tag type: 'button',class: 'button large round postfix end_timepicker_button_trigger' do %>
                            <i class="fi-clock"></i>
                            <#% end %>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- Search Button -->
            <div class="row">
                <div class="large-5 large-centered columns" style="padding-top: 2%;">
                    <#%= button_tag type: 'submit', class: 'button large radius expand' do %>
                    <i class="fi-magnifying-glass"></i> Search
                    <#% end %>
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









