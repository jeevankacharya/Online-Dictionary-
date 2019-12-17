$(document).ready(function () {

    $("#button_lookup").click(function () {
        onLookUpClick();
    });

    function onLookUpClick() {
        // $.get("DictServlet", function (responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
        //     $("#somediv").text(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
        // });
        document.getElementById("loader").style.display = "block";

        var query = $('#query').val();
        $.ajax({
            url: "DictServlet",
            data: {"lookup": query},
            dataType: 'json',
            success: function (response) {

                var arr = response.wordTypeList;
                // The <ul> that we will add <li> elements to:
                var ol = $("#list");
                ol.empty();

                for (var i = 0; i < arr.length; i++) {

                    ol.append("<li> (" + response.wordTypeList[i] + ") :: " + response.definitionList[i] + "</li>")
                }

            },
            error: function (xhr) {
                //Do Something to handle error
            }
        });
    }

    // $(document).on("click", "#button_lookup", function () { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
    //     $.get("DictServlet", function (responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
    //         $("#somediv").text(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
    //     });
    // });

});