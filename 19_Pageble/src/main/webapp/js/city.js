/**
 * Created by admin on 14.12.2016.
 */

document.getElementById('saveCity').onclick = function () {

    var city = {

        name : $('#nameCity').val(),

        country : {

            id : document.getElementById('idCountry').value

        }

    }

    document.getElementById('nameCity').value = '';

    $.ajax({

        url: 'saveCity?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(city),
        success : function (res) {



        }


    })



}


