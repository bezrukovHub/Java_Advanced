/**
 * Created by admin on 12.12.2016.
 */

window.onload = function () {

    load();
};


$('#save').click(function () {

    var city = {
        name: document.getElementById('nameCity').value,

        country: {
            id: document.getElementById('idCountry').value
        }

    };

    $.ajax({
        url: 'saveCity?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        contentType: 'application/json; charset=UTF-8',
        dataTypes: 'json',
        method: "POST",
        data: JSON.stringify(city),
        success : function () {
            load();
        }

    });
});

function load() {

    // document.getElementById('all').innerHTML = "";

    $.ajax({
        url: 'loadCity?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        contentType: 'application/json; charset=UTF-8',
        dataTypes: 'json',
        method: "POST",
        success : function (res) {

            var allCities = document.createElement('div');
            allCities.style.backgroundColor = 'aqua';
            allCities.style.border = 1+'px solid black';
            allCities.id = 'all';

            var all = '';

            for(var i = 0; i < res.length; i++){
                all += res[i].name + '<br>';
            }

            // allCities.innerHTML = all;

            // document.body.appendChild(allCities);

            document.getElementById('all').innerHTML = all;

        }

    });

};
