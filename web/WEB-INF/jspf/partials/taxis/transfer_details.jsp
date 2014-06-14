<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>


<fieldset class="fieldset-border">
  <legend><i class="fi-info"></i> Transfer Details</legend>

  <!-- Row Luggage -->
  <div class="row">
    <div class="large-9 columns">
        <s:label value="Do you have intentions to use the space reserved for luggage?" cssClass="inline" />
    </div>
    <div class="large-3 columns" style="padding:2% 0% 0 0;">
      <div class="row">
        <div class="large-6 columns">
            <s:radio list="%{'Yes'}" name="luggage" />
        </div>
        <div class="large-6 columns">
            <s:radio list="%{'No'}" name="luggage" checked="true" />
        </div>
      </div>
    </div>
  </div>

  <!-- Row Special Request -->
  <div class="row">
    <div class="large-12 columns">
        <s:label value="Special Request" />
        <s:textarea name="special_request" cssClass="taxi-textarea" />
    </div>
  </div>
</fieldset>