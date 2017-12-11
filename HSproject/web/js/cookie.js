'use strict';

<<<<<<< HEAD:HSproject/web/js/cookie.js
function getCookie(name) {
=======
/*function getCookie(name) {
>>>>>>> annibranch:HSproject/web/js/cookie.js
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
    
<<<<<<< HEAD:HSproject/web/js/cookie.js
=======
    cookieId();
>>>>>>> annibranch:HSproject/web/js/cookie.js
    let checkAuth = getCookie("authentication");
    
    if (checkAuth !== null) {
        let username = getCookie('authentication');
<<<<<<< HEAD:HSproject/web/js/cookie.js
        //username.innerHTML = 'Hello ' + username;
    } else {
        alert("No activity within 1440 seconds; please log in again.");
        window.location.replace("login.html");
    }
};

document.onload = cookie();

// sets cookie value to null and redirects to login site
=======
        user_name.innerHTML = 'Hello ' + username;
    } else {
        alert("Session expired, please re-login");
        window.location.replace("login.html");
    }
};*/

/* sets cookie value to null and redirects to login site
>>>>>>> annibranch:HSproject/web/js/cookie.js
const logout = () => {
    
    let checkAuth = getCookie("auth");
    
    checkAuth = null;
<<<<<<< HEAD:HSproject/web/js/cookie.js
};

const cookieId = (evt) => {
    evt.preventDefault();
    const settings = {
        method: 'GET',
        credentials: 'same-origin', // # ILE
        body: data
    };
    fetch('//10.114.34.129:8080/HSproject/db/service/id', settings).then((response) => {
        return response.text();
    }).then((text) => {
        console.log(text);
        
    });  
};
=======
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
>>>>>>> annibranch:HSproject/web/js/cookie.js
