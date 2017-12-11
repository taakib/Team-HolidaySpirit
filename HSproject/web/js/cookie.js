'use strict';

/*function getCookie(name) {
    var dc = document.cookie;
    var prefix = name + "=";
    var begin = dc.indexOf("; " + prefix);
    if (begin == -1) {
        begin = dc.indexOf(prefix);
        if (begin !=0){
            return null;
        }
    } else {
        begin += 2;
        var end = document.cookie.indexOf(";", begin);
        if (end == -1) {
            end = dc.length;
        }
    }
    return decodeURI(dc.substring(begin + prefix.length, end));
}

// katsotaan authentikaatio cookien valuesta
const cookie = () => {
    
    cookieId();
    let checkAuth = getCookie("authentication");
    
    if (checkAuth !== null) {
        let username = getCookie('authentication');
        user_name.innerHTML = 'Hello ' + username;
    } else {
        alert("Session expired, please re-login");
        window.location.replace("login.html");
    }
};*/

/* sets cookie value to null and redirects to login site
const logout = () => {
    
    let checkAuth = getCookie("auth");
    
    checkAuth = null;
};*/

const checkCookie = () => {
    const username = getCookie("username");
    if (username !== "") {
        //alert("Welcome again " + username);
        const responseText = document.querySelector('#response');
        responseText.innerHTML = "Welcome again " + username;
    } else {
        username = prompt("Please enter your name:", "");
        if (username !== "" && username !== null) {
            setCookie("username", username, 365);
        }
    }
};

document.onload = checkCookie;