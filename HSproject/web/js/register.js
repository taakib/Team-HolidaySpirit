'use strict';

//check for required fields
//global variable to allow form submission
let formOK = 0;
let responseText = document.querySelector('#response');
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
        //element.style='border: red solid 1px';
        responseText.innerHTML = "username and password is required"
        responseText.classList.replace('hidden','responsetext');
    }
    else {
        formOK--;
        element.removeAttribute('style');
        responseText.classList.replace('responsetext', 'hidden');
        responseText.innerHTML = "";
    }
};

const checkPattern = (element) => {
  const pattern = new RegExp(element.getAttribute('pattern'), 'i');
  const value = element.value;
  if (!pattern.exec(value)){
      formOK++;
      element.setAttribute('style', 'border: yellow solid 1px');
      responseText.innerHTML = "username and/or password is too short"
      responseText.classList.replace('hidden','responsetext');
  }else {
      formOK--;
      element.removeAttribute('style');
      responseText.classList.replace('responsetext', 'hidden');
      responseText.innerHTML = "";
  }
};

const formBtn = document.querySelector('#submitBtn');
formBtn.addEventListener('submit', (evt) => {
    evt.preventDefault();
    formOK = 0;
    checkAttribute(inputs, 'required', checkEmpty);
    checkAttribute(inputs, 'pattern', checkPattern);
    console.log(formOK);
    if (formOK === -4){
        register(); 
    }
});

/*
 * author: anniluo
 */

//registers returns a response if successful
const register = (evt) => {
    evt.preventDefault();
    const upform = document.querySelector('#registerForm');
    const nameInput = document.querySelector('input[name="username"]');
    const data = new FormData(upform);
    const settings = {
        method: 'POST',
        credentials: 'same-origin', // this might be needed for some servers
        body: data
     };
     fetch('//10.114.34.129:8080/HSproject/db/service/register', settings).then((response) => {
        return response.text();
     }).then((text) => {
            if(text === "username is taken") {
                console.log(text);
                const responseText = document.querySelector('#response');
                responseText.innerHTML = text;
                responseText.classList.replace('hidden', 'responsetext'); 
           } else {
               const responseText = document.querySelector('#response');
               responseText.innerHTML = text;
               responseText.classList.replace('hidden', 'responsetext');
           }
        });
};
