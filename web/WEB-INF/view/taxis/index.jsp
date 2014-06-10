<div class="row">
    <div class="large-10 large-centered columns">
        <h2 style="text-align: center;">Taxis Rent</h2>
    </div>
</div>


<div class="row">
    <div class="large-12 columns">
        <s:form action="#" data-abide="abide" validate="true">
            <fieldset class="fieldset-border">

                <!-- Row Country -->
                <div class="row">
                    <div class="large-2 columns">
                        <s:label value="Country : " cssClass="right inline" />
                    </div>
                    <div class="large-10 columns">
                        <s:select list="countries" listKey="id" listValue="name" headerKey="-1" headerValue="Please Select" name="country" id="country" required="true" />
                        <small class="error">You need to choose a Country.</small>
                    </div>
                </div>

                <!-- Row City -->
                <div class="row">
                    <div class="large-2 columns">
                        <s:label value="City : " cssClass="right inline" />
                    </div>
                    <div class="large-10 columns">
                        <s:select name="city" list="%{{}}" headerKey="-1" headerValue="Please Select" id="city" required="true" disabled="true" />
                        <small class="error">You need to choose a City.</small>
                    </div>
                </div>

                <!-- Row Pick Up Location -->
                <div class="row">
                    <div class="large-2 columns">
                        <s:label value="Pick-Up Location : " cssClass="right inline" />
                    </div>
                    <div class="large-10 columns">
                        <s:select name="pickUpLocation" list="%{{}}" headerKey="-1" headerValue="Please Select" id="pick_up_location" required="true" disabled="true" />
                        <small class="error">You need to choose a Pick-Up Location.</small>
                    </div>
                </div>

                <!-- Row Drop Off Location -->
                <div class="row">
                    <div class="large-2 columns">
                        <s:label value="Drop-Off Location : " cssClass="right inline" />
                    </div>
                    <div class="large-10 columns">
                        <s:select name="dropOffLocation" list="%{{}}" headerKey="-1" headerValue="Please Select" id="drop_off_location" required="true" disabled="true" />                   
                        <small class="error">You need to choose a Drop-Off Location.</small>
                    </div>
                </div>

                <!-- Row Passengers and Type of Trip -->
                <div class="row">
                    <div class="large-2 columns">
                        <s:label value="Passengers : " cssClass="right inline" />
                    </div>
                    <div class="large-5 columns">
                        <div class="row">
                            <div class="large-2 columns">
                                <s:textfield value="1" id="passengers" readonly="true" cssClass="input-center" />
                            </div>
                            <div class="large-10 columns" style="padding-top: 2%;">
                                <!--<div id="slider"></div> -->
                                <sj:slider id="slider" min="1" max="55" range="min" onSlideTopics="slideSlider"/>
                            </div>
                        </div>
                    </div>
                    <div class="large-5 columns">
                        <div class="row">
                            <div class="large-6 columns">
                                <label class="type-trip-align">
                                    <s:radio list="%{'One-Way'}" name="type_trip" checked="true" />
                                </label>
                            </div>
                            <div class="large-6 columns">
                                <label class="type-trip-align">
                                    <s:radio list="%{'Round Trip'}" name="type_trip"/>
                                </label>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Row Date of Pick-Up Time -->
                <div class="row">
                    <div class="large-2 columns">
                        <s:label value="Date : " cssClass="right inline" />
                    </div>
                    <div class="large-4 columns">
                        <div class="row collapse">
                            <div class="large-10 columns">
                                <sj:datepicker id="begin_date" name="begin_date" value="today" 
                                               minDate="today" displayFormat="dd/mm/yy" showOn="focus" readonly="true"/>
                            </div>
                            <div class="large-2 columns">
                                <s:submit type="button" cssClass="button small round postfix" id="begin-calendar">
                                    <i class="fi-calendar"></i>
                                </s:submit>
                            </div>
                        </div>
                    </div>
                    <div class="large-2 columns">
                        <s:label value="Pick-Up Time : " cssClass="right inline" />
                    </div>
                    <div class="large-4 columns">
                        <sj:datepicker name="begin_time" id="begin_time" placeholder="Choose a Time" showOn="focus" readonly="true"
                                       timepicker="true" timepickerOnly="true" timepickerStepHour="1" timepickerStepMinute="5" required="true"/>
                        <small class="error" style="width: 289px;margin-top: 0 !important">
                            You need to choose an hour and minutes.
                        </small>
                    </div>
                </div>

                <!-- Row Return Date of Pick-Up Time -->
                <div class="row" id="return_date" style="display: none">
                    <div class="large-2 columns">
                        <s:label value="Return Date : " cssClass="right inline" />
                    </div>
                    <div class="large-4 columns">
                        <div class="row collapse">
                            <div class="large-10 columns">
                                <sj:datepicker id="end_date" name="end_date" value="tomorrow"
                                               displayFormat="dd/mm/yy" showOn="focus" readonly="true" minDate="today" />

                            </div>
                            <div class="large-2 columns">
                                <s:submit type="button" cssClass="button small round postfix" id="end-calendar">
                                    <i class="fi-calendar"></i>
                                </s:submit>
                            </div>
                        </div>
                    </div>

                    <div class="large-2 columns">
                        <s:label value="Pick-Up Time : " cssClass="right inline" />
                    </div>
                    <div class="large-4 columns">
                        <sj:datepicker name="end_time" id="end_time" placeholder="Choose a Time" showOn="focus" readonly="true"
                                       timepicker="true" timepickerOnly="true" timepickerStepHour="1" timepickerStepMinute="5" required="true"/>
                        <small class="error" style="width: 289px;margin-top: 0 !important">
                            You need to choose an hour and minutes.
                        </small>
                    </div>
                </div>
                        <div class="row">
            <div class="large-6 large-centered columns" style="padding-top: 2%;">
                <s:submit type="button" cssClass="button small radius expand" >
                    <i class="fi-magnifying-glass"></i> Search
                </s:submit>
            </div>
          </div>
            </fieldset>            
        </s:form>       
    </div>
</div>