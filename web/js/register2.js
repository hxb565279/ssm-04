$(document).ready(
    function () {
        $("#id_card").blur(
            function () {
                if ($("#id_card").val().length > 0) {
                    $.ajax({
                        url: "/checkId.action",
                        type: "POST",
                        data: JSON.stringify({id_card: $("#id_card").val()}),
                        contentType: "application/json;charset=UTF-8",
                        dataType: "json",
                        success: function (data) {
                            if (data != null) {
                                $("#message2").html("该身份证已经被使用,请登录");
                            }
                        },
                        error: function () {
                            $("#message2").html("");
                        }
                    })
                }else{
                    $("#message2").html("");
                }


            }
        )
    }
)
