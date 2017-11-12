
document.getElementById('save').onclick = function () {


    if(document.getElementById('nameCountry').value == ''){

        document.getElementById('error').innerHTML = 'error';
        document.getElementById('error').style.backgroundColor= 'red';

    }else{

        document.getElementById('error').innerHTML = '';

        var country = {

            name : document.getElementById('nameCountry').value

        }

        document.getElementById('nameCountry').value = '';

        $.ajax({


            url : 'saveCountry?'+$('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method : 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType : 'json',
            data : JSON.stringify(country),
            success : function (res) {

//                console.log(res);

                var all = '';

                for(var i = 0; i < res.length; i++){

                    all +='<div style="background-color: #30aed6; text-align: center;"> ' +
                        ' '+res[i].name+' <a href="deleteCountry/"+res[i].id>delete</a></div><br>';

                }

                document.getElementById('allCountries').innerHTML = all;

            }


        })
    }





}

window.onload = function () {

    $.ajax({

        url : 'loadCountries?'+$('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method : 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType : 'json',
        success : function (res) {

            var all = '';

            for(var i = 0; i < res.length; i++){
                var index = res[i].id;
                all +="<div>"+res[i].name+"<a href='deleteCountry/"+index+"'>delete</a></div><br>";
            }
            document.getElementById('allCountries').innerHTML = all;
        }
    })





}




