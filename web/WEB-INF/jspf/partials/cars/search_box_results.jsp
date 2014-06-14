<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div class="large-3 columns" id="search_box_results">
    <div class="row">
        <div class="large-12 columns">
            
            <s:form action="cars-search-results" namespace="/cars" data-abide="abide" method="post">
                <!-- title search box -->
                <div class="row">
                    <div class="large-12 large-centered columns" style="text-align: center!important">
                        <h5><b>Search for a Renting Car</b></h5>
                    </div>
                </div>
                <div class="row">
                    <div class="large-12 columns" style="text-align: center">
                        <#%= link_to "change locations", "#",class:'change_pick_location'%>
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
                            <s:select list="countries" listKey="id" listValue="name" headerKey="-1" headerValue="Please Select" name="country" id="pick_country" required="true" />
                            <small class="error">You need to choose a Country.</small>
                        </div>
                    </div>
                        
                        
                        
                    <#%= label_tag :pick_country, 'Country:', class: 'right inline' %>                        
                    <#%= select_tag :pick_country, options_from_collection_for_select(locations.countries, 'id', 'name',ids["pick_country"]), prompt: 'Please Select', id: 'pick_country',required:true %>
                        
                    <!-- pick cities select -->
                    <div class="row">
                        <div class="large-4 columns">
                            <#%= label_tag :pick_city, 'City:', class: 'right inline' %>
                        </div>
                        <div class="large-8 columns">
                            <#%= select_tag :pick_city, options_from_collection_for_select(locations.pick_cities, 'id', 'name',ids["pick_city"]), prompt: 'Please Select', id: 'pick_city',required:true %>
                            <small class="error">You need to choose a City.</small>
                        </div>
                    </div>
                    <!-- pick subsidiary select -->
                    <div class="row">
                        <div class="large-4 columns">
                            <#%= label_tag :pick_subsidiary, 'Subsidiary:', class: 'right inline' %>
                        </div>
                        <div class="large-8 columns">
                            <#%= select_tag :pick_subsidiary, options_from_collection_for_select(locations.pick_subs, 'id', 'name',ids["pick_subsidiary"]), prompt: 'Please Select', id: 'pick_subsidiary',required:true %>
                            <small class="error">You need to choose a Subsidiary.</small>
                        </div>
                    </div>
                </div>
                    
                    
            </s:form>
                
                
                
                
                
                
                
                
                
                
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
                            <#%= text_field_tag :begin_date, ids["begin_date"], id: 'begin-datepicker', readonly: true %>
                        </div>
                        <div class="large-2 columns">
                            <#%= button_tag type: 'button', class: 'button medium round postfix', id: 'begin-calendar' do %>
                            <i class="fi-calendar"></i>
                            <#% end %>
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
                        <div class="large-10 columns">
                            <#%= text_field_tag :timepicker_begin,ids["timepicker_begin"], id:'begin_timepicker', readonly: true %>
                        </div>
                        <div class="large-2 columns">
                            <#%= button_tag type: 'button',class: 'button medium round postfix begin_timepicker_button_trigger' do %>
                            <i class="fi-clock"></i>
                            <#% end %>
                        </div>
                    </div>
                </div>
            </div>
                
            <!-- Checkbox Deliver in the same place -->
            <div class="row" id="return_at_same">
                <div class="large-10 large-offset-1 columns">
                    <#%= check_box_tag(:return_at_same_location, value = "yes", checked = true) %>
                    <#%= label_tag :return_at_same_location, 'Return at same location' %>
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
                        <#%= label_tag :drop_country, 'Country:', class: 'right inline' %>
                    </div>
                    <div class="large-8 columns">
                        <#%= select_tag :drop_country, options_from_collection_for_select(locations.countries, 'id', 'name',ids["pick_country"]), prompt: 'Please Select', disabled: true,id: 'drop_country' %>
                    </div>
                </div>
                <!-- drop cities select -->
                <div class="row">
                    <div class="large-4 columns">
                        <#%= label_tag :drop_city, 'City:', class: 'right inline' %>
                    </div>
                    <div class="large-8 columns">
                        <#%= select_tag :drop_city, options_from_collection_for_select(locations.drop_cities, 'id', 'name',ids["drop_city"]), prompt: 'Please Select', id: 'drop_city' %>
                    </div>
                </div>
                <!-- drop subsidiary select -->
                <div class="row">
                    <div class="large-4 columns">
                        <#%= label_tag :drop_subsidiary, 'Subsidiary:', class: 'right inline' %>
                    </div>
                    <div class="large-8 columns">
                        <#%= select_tag :drop_subsidiary, options_from_collection_for_select(locations.drop_subs, 'id', 'name',ids["drop_subsidiary"]), prompt: 'Please Select', id: 'drop_subsidiary' %>
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
                            <#%= text_field_tag :end_date, ids["end_date"], id: 'end-datepicker', readonly: true %>
                        </div>
                        <div class="large-2 columns">
                            <#%= button_tag type: 'button', class: 'button medium round postfix', id: 'end-calendar' do %>
                            <i class="fi-calendar"></i>
                            <#% end %>
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
                        <div class="large-10 columns">
                            <#%= text_field_tag :timepicker_end,ids["timepicker_end"], id:'end_timepicker', readonly: true %>
                        </div>
                        <div class="large-2 columns">
                            <#%= button_tag type: 'button',class: 'button medium round postfix end_timepicker_button_trigger' do %>
                            <i class="fi-clock"></i>
                            <#% end %>
                        </div>
                    </div>
                </div>
            </div>
                
            <!-- Search Button -->
            <div class="row">
                <div class="large-6 large-offset-6 columns" style="text-align: right">
                    <#%= button_tag type: 'submit', class: 'button tiny radius expand' do %>
                    <i class="fi-magnifying-glass"></i> Search
                    <#% end %>
                </div>
            </div>
            <#% end %>
        </div>
    </div>
</div>