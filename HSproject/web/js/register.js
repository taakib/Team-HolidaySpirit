'use strict';
//check for required fields
//global variable to allow form submission
let formOK = 0;
//select all input elements
const inputs = document.querySelectorAll('input');

const checkAttribute = (elements, attr, func) => {
    elements.forEach((element) => {
        if (element.hasAttribute(attr)) {
            func(element);
        }
    });
};

const checkEmpty = (element) => {
    if(element.value === '') {
        formOK ++;
        element.setAttribute('style', 'border: red solid 1px');
        //modern browsers:
        element.style='border: red solid 1px';
    } else {
        formOK--;
        element.removeAttribute('style');
    }
};

const checkPattern = (element) => {
  const pattern = new RegExp(element.getAttribute('pattern'), 'i');
  const value = element.value;
  if (!pattern.exec(value)){
      formOK++;
      element.setAttribute('style', 'border: yellow solid 1px');
  } else {
      formOK--;
      element.removeAttribute('style');
  }
};

//checkAttribute(inputs, 'required', checkEmpty);
let reqform = document.querySelector('form');

reqform.addEventListener('submit', (evt) => {
    evt.preventDefault();
    formOK = 0;
    const responseText = document.querySelector('#response');
    checkAttribute(inputs, 'required', checkEmpty);
    checkAttribute(inputs, 'pattern', checkPattern);
    console.log(formOK);
    if (formOK === -4){
        if (responseText.classList.contains('responsetext')){
            responseText.classList.replace('responsetext','hidden');
        }
        register();
    } else {
        responseText.innerHTML = "invalid username and/or password";
        responseText.classList.replace('hidden', 'responsetext');
    }
});

const register = () => {
    const form = document.querySelector('form');
    const data = new FormData(form);
    const settings = {
        method: 'POST',
        credentials: 'same-origin', // this might be needed for some servers
        body: data,
        headers: {'Accept': 'application/json, application/xml, text/plain, text/html, *.*',
        'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
        }
    };
    fetch('//10.114.34.129:8080/HSproject/db/service/register', settings).then((response) => {
        return response.text();
    }).then((text) => {
        const responseText = document.querySelector('#response');
        if(text.stringify === "Username already exists") {
            console.log(text.stringify);
            responseText.innerHTML = text.stringify;
            responseText.classList.replace('hidden', 'responsetext');
        } else {
            responseText.innerHTML = text.stringify;
            responseText.classList.replace('hidden', 'responsetext');
        }
    });
};