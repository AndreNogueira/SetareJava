<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<fieldset class="fieldset-border" id="user-info">
  <legend><i class="fi-info"></i> Passenger Information</legend>
  <!-- Row Name and E-mail -->
  <div class="row">
    <div class="large-6 columns">
        <s:label value="Name" />
        <s:textfield name="name" value="%{#session['user'].name}" readonly="true"/>
    </div>
    <div class="large-6 columns">
        <s:label value="E-mail" />
        <s:textfield name="email" value="%{#session['user'].email}" readonly="true" />
    </div>
  </div>

  <!-- Row BI and PhoneNumber -->
  <div class="row">
    <div class="large-6 columns">
        <s:label value="BI" />
        <s:textfield name="bi" value="%{#session['user'].bi}" readonly="true" />
    </div>
    <div class="large-6 columns">        
        <s:label value="Phone Number" />
        <s:textfield name="phoneNumber" value="%{#session['user'].phoneNumber}" readonly="true" />
    </div>
  </div>

  <!-- Row NIF and Driver License -->
  <div class="row">
    <div class="large-6 columns">
        <s:label value="NIF" />
        <s:textfield name="nif" value="%{#session['user'].nif}" readonly="true" />
    </div>
    <div class="large-6 columns">
        <s:label value="Driver License" />
        <s:textfield name="driverLicense" value="%{#session['user'].driverLicense}" readonly="true" />
    </div>
  </div>

  <!-- Row Address -->
  <div class="row">
    <div class="large-12 columns">
        <s:label value="Address" />
        <s:textfield name="address" value="%{#session['user'].address}" readonly="true" />
    </div>
  </div>

  <div class="row" style="margin: 3% 0 -3% 0 !important;">
    <div class="large-6 large-centered columns end" style="text-align: center;">
        <s:submit type="button" id="button-edit" cssClass="button small radius expand" >
            <i class="fi-pencil"></i> Edit
        </s:submit>
    </div>
  </div>
</fieldset>