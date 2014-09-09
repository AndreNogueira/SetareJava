<div class="row">
    <!-- Result List -->
    <div class="large-8 columns">
        <s:include value="/WEB-INF/jspf/partials/taxis/form_extra_info.jsp" />      
    </div>
    <div class="large-4 columns">

        <s:form action="search-taxis" method="post" namespace="/taxis" data-abide="abide" validate="true">
            <fieldset class="fieldset-border">
                <!-- Row Country -->
                <div class="row">
                    <div class="large-12 columns">
                        <s:label value="Country" />
                        <s:select list="taxiLocations.countries" listKey="value" listValue="key" value="#session['taxiForm'].country"
                                  headerKey="-1" headerValue="Please Select" name="country" id="country" required="true" />          
                        <small class="error">You need to choose a Country.</small>
                    </div>
                </div>

                <!-- Row City -->
                <div class="row">
                    <div class="large-12 columns">
                        <s:label value="City" />
                        <s:select list="taxiLocations.cities" listKey="value" listValue="key" value="#session['taxiForm'].city"
                                  headerKey="-1" headerValue="Please Select" name="city" id="city" required="true" />
                        <small class="error">You need to choose a City.</small>
                    </div>
                </div>

                <!-- Row Pick Up Location -->
                <div class="row">
                    <div class="large-12 columns">
                        <s:label value="Pick-Up Location" />
                        <s:select list="taxiLocations.pickUpLocations" listKey="value" listValue="key"  id="pick_up_location"
                                  value="#session['taxiForm'].pickUpLocation" headerKey="-1" headerValue="Please Select" 
                                  name="pickUpLocation" required="true" />
                        <small class="error">You need to choose a Pick-Up Location.</small>
                    </div>
                </div>

                <!-- Row Drop Off Location -->
                <div class="row">
                    <div class="large-12 columns">
                        <s:label value="Drop-Off Location" />
                        <s:select list="taxiLocations.dropOffLocations" listKey="value" listValue="key"  id="drop_off_location"
                                  value="#session['taxiForm'].dropOffLocation" headerKey="-1" headerValue="Please Select" 
                                  name="dropOffLocation" required="true" />
                        <small class="error">You need to choose a Drop-Off Location.</small>
                    </div>
                </div>

                <!-- Row Passengers -->
                <div class="row" style="padding-left: 3%;">
                    <div class="large-5 columns">
                        <s:label value="Passengers :" cssClass="left inline" />
                    </div>
                    <div class="large-5 columns end">
                        <s:textfield  value="%{#session['taxiForm'].passengers}" id="passengers" name="passengers" readonly="true" cssClass="input-center left" />
                    </div>
                </div>
                <div class="row">
                    <div class="large-11 large-offset-1 columns">
                        <sj:slider value="%{#session['taxiForm'].passengers}" id="slider" min="1" max="55" range="min" onSlideTopics="slideSlider"/>
                    </div>
                </div>

                <!-- Row Type of Trip -->
                <div class="row" style="padding-top: 8%;">
                    <div class="large-6 columns">
                        <label class="type-trip-align">
                            <s:if test="%{#session['taxiForm'].type_trip.equals('One-Way')}">
                                <s:radio list="%{'One-Way'}" name="type_trip" checked="true" />
                            </s:if>
                            <s:else>
                                <s:radio list="%{'One-Way'}" name="type_trip"/>
                            </s:else>
                        </label>
                    </div>
                    <div class="large-6 columns">
                        <label class="type-trip-align">
                            <s:if test="%{#session['taxiForm'].type_trip.equals('Round Trip')}">
                                <s:radio list="%{'Round Trip'}" name="type_trip" checked="true" />
                            </s:if>
                            <s:else>
                                <s:radio list="%{'Round Trip'}" name="type_trip"/>
                            </s:else>
                        </label>
                    </div>
                </div>
                <!-- Row Date of Pick-Up -->
                <div class="row">
                    <div class="large-12 columns">
                        <s:label value="Pick-Up Date" />
                        <div class="row collapse">
                            <div class="large-10 columns">
                                <sj:datepicker id="begin_date" name="begin_date" value="%{#session['taxiForm'].begin_date}"
                                               minDate="today" displayFormat="dd/mm/yy" showOn="focus" readonly="true"/>
                            </div>
                            <div class="large-2 columns">
                                <s:submit type="button" cssClass="button small round postfix" id="begin-calendar">
                                    <i class="fi-calendar"></i>
                                </s:submit>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="large-12 columns">
                        <s:label value="Pick-Up Time" />
                        <sj:datepicker name="begin_time" id="begin_time" placeholder="Choose a Time" showOn="focus" readonly="true"
                                       timepicker="true" timepickerOnly="true" timepickerStepHour="1" timepickerStepMinute="5" 
                                       required="true" value="%{#session['taxiForm'].begin_time}"/>
                        <small class="error" style="width: 257px;margin-top: 0 !important">
                            You need to choose an hour and minutes.
                        </small>
                    </div>
                </div>

                <!-- Row Return Date -->
                <s:set name="type">
                    <s:if test="%{#session['taxiForm'].type_trip.equals('One-Way')}">
                        display:none;
                    </s:if>
                </s:set>
                <div id="return_date" style="<s:property value="#type"/>">
                    <div class="row">
                        <div class="large-12 columns">
                            <s:label value="Return Date" />
                            <div class="row collapse">
                                <div class="large-10 columns">
                                    <sj:datepicker id="end_date" name="end_date" value="%{#session['taxiForm'].end_date}"
                                                   displayFormat="dd/mm/yy" showOn="focus" readonly="true" minDate="today" />
                                </div>
                                <div class="large-2 columns">
                                    <s:submit type="button" cssClass="button small round postfix" id="end-calendar">
                                        <i class="fi-calendar"></i>
                                    </s:submit>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="large-12 columns">
                            <s:label value="Pick-Up Time" />
                            <sj:datepicker name="end_time" id="end_time" placeholder="Choose a Time" showOn="focus" 
                                           value="%{#session['taxiForm'].end_time}" timepicker="true" timepickerOnly="true" 
                                           timepickerStepHour="1" timepickerStepMinute="5" readonly="true" />
                            <small class="error" style="width: 257px;margin-top: 0 !important;">
                                You need to choose an hour and minutes.
                            </small>
                        </div>
                    </div>
                </div>

                <!-- Row Submit Button -->
                <div class="row">
                    <div class="large-12 columns">
                        <s:submit type="button" cssClass="button small radius expand">
                            <i class="fi-magnifying-glass"></i> Search
                        </s:submit>
                    </div>
                </div>
            </fieldset>
        </s:form>

    </div>
</div>
