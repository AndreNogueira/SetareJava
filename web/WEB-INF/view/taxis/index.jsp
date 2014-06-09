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


            </fieldset>            
        </s:form>       
    </div>
</div>