<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<form:form action="/saveManyImages/${book.id}?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">

    <div id="images">
        <input type="file" name="images">
    </div>

    <input type="button" id="addMoreFile" value="addMoreFile">

    <button>save</button>

</form:form>

<script>

    document.getElementById('addMoreFile').onclick = function () {


        var imageInput= document.createElement('input');

        imageInput.name = 'images';
        imageInput.type = 'file';

        document.getElementById('images').appendChild(imageInput);


    }


</script>
