$(document).ready(function(){
    $("p").click(function(){
        $(this).hide();
    });
    $("#words").click(function(){
        $("#definitions").show();
    });
});
