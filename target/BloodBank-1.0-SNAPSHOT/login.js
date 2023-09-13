/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function loginFunc(){
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    if(username === ""){
        alert("Please fill the username data");
        return;
    }
    if(password === ""){
        alert("Please fill the password field");
        return;
    }
    $.ajax({
        url:"login_getAuthorization_AjaxServlet?"
        + "username=" + username
        + "&password=" + password,
        type: 'POST',
        success: function (data){
            if(data==="Success"){
                location.replace("index_AccessServlet");
            }else{
                alert("Error in Username Or password");
            }
        },
        error: function(xhr,status){
            Error("Error!");
        }
        
    });
    
}
function Success(Body){
    new PNotify({
        title: "تمت",
        delay: 2000,
        text: Body,
        type: 'success',
        position: 'top left',
        styling: 'bootstrap3'
    });
}
function Error(Body){
    new PNotify({
        title: "خطأ",
        delay: 5000,
        text: Body,
        type: 'error',
        styling: 'bootstrap3'
    });
}
function Warning(Body){
    new PNotify({
        title: "تحذير",
        delay: 2000,
        text: Body,
        styling: 'bootstrap3'
    });
}
function Info(Body){
    new PNotify({
        delay: 2000,
        text: Body,
        type: 'info',
        styling: 'bootstrap3'
    });
}
