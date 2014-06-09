$(document).ready(function () {
    
    $('select#country').on('change', function () {
        var country_id = $(this).val();
        var city = $('select#city');
        $('select#pick_up_location').attr('disabled', true);
        $('select#drop_off_location').attr('disabled', true);
        $('select#city > option:gt(0)').remove();
        $('select#drop_off_location > option:gt(0)').remove();
        $('select#pick_up_location > option:gt(0)').remove();
        if (country_id !== '')
            fill_data('/SetareJava/taxis/country',country_id , city);
        else
            city.attr('disabled', true);
    });
    /*
    $('select#city').on('change', function () {
        var city_id = $(this).val();
        var pick_up = $('select#pick_up_location');
        $('select#drop_off_location').attr('disabled', true);
        $('select#pick_up_location > option:gt(0)').remove();
        $('select#drop_off_location > option:gt(0)').remove();
        if (city_id != '')
            fill_data('pick_up/' + city_id, pick_up);
        else
            pick_up.attr('disabled', true);
    });

    $('select#pick_up_location').on('change', function () {
        var pick_up_id = $(this).val();
        var drop_offs = $('select#drop_off_location');
        $('select#drop_off_location > option:gt(0)').remove();
        if (pick_up_id != '')
            fill_data('drop_off/' + pick_up_id, drop_offs);
        else
            drop_offs.attr('disabled', true);
    });

    $('input#begin-datepicker').datepicker({
        dateFormat: 'dd/mm/yy',
        showAnim: 'blind',
        minDate: 0
    });
    $('input#end-datepicker').datepicker({
        dateFormat: 'dd/mm/yy',
        showAnim: 'blind',
        minDate: 0
    });

    $('div#slider').slider({
        range: 'min',
        min: 1,
        max: 55,
        create: function (event, ui) {
            $(this).slider('value', $("input#passengers").val());
        },
        slide: function (event, ui) {
            $("input#passengers").val(ui.value);
        }
    });

    $('button#begin-calendar').click(function () {
        $('#begin-datepicker').datepicker('show');
    });
    $('button#end-calendar').click(function () {
        $('#end-datepicker').datepicker('show');
    });

    $('input[name=type_trip]').on('change', function () {
        $('div#return_date').slideToggle();
    });

    $('button#button-edit').on('click', function (event) {
        event.preventDefault();
        var all_inputs = $('fieldset#user-info input');
        var button_icon = $(this).find('i');

        if (button_icon.hasClass('fi-pencil')) {
            change_button_text($(this), 'fi-save', ' Save');
            turn_readonly_option(all_inputs, false);
        } else if (button_icon.hasClass('fi-save')) {
            change_button_text($(this), 'fi-pencil', ' Edit');
            turn_readonly_option(all_inputs, true);
        }

    });
*/
    $('.tabs .tab-links a').on('click', function (event) {
        var currentAttrValue = $(this).attr('href');
        var tabs = $('.tabs ' + currentAttrValue);
        // Show/Hide Tabs
        tabs.siblings().slideUp(400);
        tabs.delay(400).slideDown(400);
        // Change/remove current tab to active
        $(this).parent('li').addClass('active').siblings().removeClass('active');
        event.preventDefault();
    });


    // Funções auxiliares
    function turn_readonly_option(array, value) {
        $.each(array, function () {
            $(this).prop('readonly', value);
        });
    }

    function change_button_text(button, icon_class, text) {
        var content = $('<i>').addClass(icon_class);
        button.empty().append(content).append(text);
    }

    function fill_data(url, id, html_select) {
        
        $.getJSON(url , {id:id}, function (data) {
            html_select.attr('disabled', false);
            $.each(data.names, function (index, value) {
                var option = $('<option>').text(value).attr('value', index);
                html_select.append(option);
            });
        });
    }
});