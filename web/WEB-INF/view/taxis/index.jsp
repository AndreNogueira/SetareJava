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


            </fieldset>            
        </s:form>       
    </div>
</div>