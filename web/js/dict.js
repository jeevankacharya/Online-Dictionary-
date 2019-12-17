$(document).ready(function () {

    $("#button_lookup").click(function () {
        // onLookUpClick();
        validateinput();
    });
    //on enter click
    $("#query").on('keypress', function (e) {
        if (e.which == 13) {
            //  onLookUpClick();
            validateinput();
        }
    });

    function validateinput() {
        if ($('#query').val().trim() === "") {
            alert("Please enter keyword");
            $('#query').focus();
            return false;
        } else {
            onLookUpClick();
        }
    }

    function onLookUpClick() {
        $('#message').css('display', 'none');
        var ol = $("#list");
        ol.empty();

        var query = $('#query').val();
        $.ajax({
            url: "DictServlet",
            data: {"lookup": query},
            dataType: 'json',
            success: function (response) {


                var arr;
                if(response == null){
                    $('#message').show();
                    $('#message').html("Not Found !!!");

                }else{
                    $('#message').css('display', 'none');

                    arr = response.wordTypeList;



                    // The <ul> that we will add <li> elements to:


                    for (var i = 0; i < arr.length; i++) {

                        ol.append("<li> (" + response.wordTypeList[i] + ") :: " + response.definitionList[i] + "</li>")
                    }
                }
            },
            error: function (xhr) {

            }
        });
    }

    // $(document).on("click", "#button_lookup", function () { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
    //     $.get("DictServlet", function (responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
    //         $("#somediv").text(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
    //     });
    // });

});