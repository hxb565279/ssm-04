$(document).ready(
    function (){
        $("#shadow-password2").blur(
            function (){
                if ($("#shadow-password2").val().length>0){
                   let password2 = $("#shadow-password2").val();
                   let password1 = $("#shadow-password1").val();
                   if (password1===password2){

                   }else{
                   alert("两次密码不一致");}
                }
            }
        )
    }
)

function first() {
    let username = $("#username_check1").val();
    if (username===""){
        quit();
    }
}

function quit(){
    $("#shadow1").hide();
}
// setTimeout(check1,"10000");
//     function check1(){
//         let username = $("#username_check1").val();
//         let password= $("#username-check2").val();
//         if (username===""&&password===""){
//             $("#username_check1").hide();
//             $("#username-check2").hide();
//         }else {
//             $("#username-check3").hide();
            // $("#username_check1").visible();
            // $("#username-check2").visible();

    //     }
    // }
    //

















$("#shadow1").hide();
