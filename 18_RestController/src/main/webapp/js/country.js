document.getElementById('save').onclick = function () {


    if (document.getElementById('nameCountry').value == '') {

        document.getElementById('error').innerHTML = 'error';
        document.getElementById('error').style.backgroundColor = 'red';

    } else {

        document.getElementById('error').innerHTML = '';

        var country = {

            name: document.getElementById('nameCountry').value

        }

        document.getElementById('nameCountry').value = '';

        $.ajax({


            url: 'saveCountry?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: JSON.stringify(country),
            success: function (res) {
                var all = '';

                for (var i = 0; i < res.length; i++) {
                    var index = res[i].id;
                    all += '<div class="box">'+res[i].name +'<a onclick="deleteCountry(' + index + ')"> delete </div><br>';
                }
                document.querySelector('.all').innerHTML = all;
            }

        })
    }

}

window.onload = function () {

    $.ajax({

        url: 'loadCountries?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        success: function (res) {

            var all = '';

            for (var i = 0; i < res.length; i++) {
                var index = res[i].id;
                all += '<div class="box">'+res[i].name +'<a onclick="deleteCountry(' + index + ')"> delete </div><br>';
            }
            document.querySelector('.all').innerHTML = all;
        }
    })

}

function deleteCountry(index) {

    $.ajax({

        url: 'deleteCountry?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: '' + index,
        success: function (res) {

            var all = '';

            for (var i = 0; i < res.length; i++) {
                var index = res[i].id;
                all += '<div class="box">'+res[i].name +'<a onclick="deleteCountry(' + index + ')"> delete </div><br>';
            }
            document.querySelector('.all').innerHTML = all;
        }
    })


}

/////////////form style

$('.show-list').click(function(){
    $('.wrapper').addClass('list-mode');
});

$('.hide-list').click(function(){
    $('.wrapper').removeClass('list-mode');
});