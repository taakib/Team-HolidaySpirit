'use strict';

function getCookie(name) {
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

    let checkAuth = getCookie("authentication");

    if (checkAuth !== null) {
        let username = getCookie('authentication');
        //username.innerHTML = 'Hello ' + username;
    } else {
        alert("No activity within 1440 seconds; please log in again.");
        window.location.replace("login.html");
    }
};

document.onload = cookie();

// sets cookie value to null and redirects to login site
const logout = () => {

    let checkAuth = getCookie("auth");

    checkAuth = null;
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
