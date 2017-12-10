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
    const responseText = document.querySelector('#response');
    if(element.value === '') {
        formOK ++;
        element.setAttribute('style', 'border: red solid 1px');
        //modern browsers:
        //element.style='border: red solid 1px';
        responseText.innerHTML = ("username and password is required");
        responseText.classList.replace('hidden','responsetext');
    }
    else {
        if (responseText.classList.contains('responsetext')) {
          responseText.classList.replace('responsetext', 'hidden');
          responseText.innerHTML = "";
        } else {
            formOK--;
            element.removeAttribute('style');
        }
    }
};

const checkPattern = (element) => {
  const responseText = document.querySelector('#response');
  const pattern = new RegExp(element.getAttribute('pattern'), 'i');
  const value = element.value;
  if (!pattern.exec(value)){
      formOK++;
      element.setAttribute('style', 'border: yellow solid 1px');
      responseText.innerHTML = ("username and/or password is too short");
      responseText.classList.replace('hidden','responsetext');
  } else {
      if (responseText.classList.contains('responsetext')) {
          responseText.classList.replace('responsetext', 'hidden');
          responseText.innerHTML = "";
      } else {
        formOK--;
        element.removeAttribute('style');
      }
  }
};

const form = document.querySelector('#registerForm');

form.addEventListener('submit', (evt) => {
    evt.preventDefault();
    formOK=0;
    checkAttribute(inputs, 'required', checkEmpty);
    checkAttribute(inputs, 'pattern', checkPattern);
    console.log(formOK);
    if (formOK===-4){
        checkName(); 
    }
});

/*
 * author: anniluo
 */

//registers returns a response if successful
const register = () => {
    const nameInput = document.querySelector('input[name="username"]');
    const data = new FormData(form);
    const settings = {
        method: 'POST',
        credentials: 'same-origin', // this might be needed for some servers
        body: data
    };
    fetch('//10.114.34.129:8080/HSproject/db/service/register', settings).then((response) => {
        return response.json();
    }).then((json) => {
        const responseText = document.querySelector('#response');
            if(json.toString() === "username is taken") {
                console.log(json);;
                responseText.innerHTML = json;
                responseText.classList.replace('hidden', 'responsetext'); 
            } else {
               responseText.innerHTML = json;
               responseText.classList.replace('hidden', 'responsetext');
           }
        });
};
