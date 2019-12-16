$(document).ready(function () {

    $("#button_lookup").click(function () {
        onLookUpClick();
    });

    function onLookUpClick() {
        var searchquery = document.getElementsByName("query");
        alert(searchquery);
    }
});