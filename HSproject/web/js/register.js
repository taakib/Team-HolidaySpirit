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

/*const submit = document.getElementById('#submit');
submit.addEventListener('click', (evt) => {

});*/

const checkEmpty = (element) => {
    if(element.value === '') {
        formOK ++;
        element.setAttribute('style', 'border: red solid 1px');
        //element.setAttribute('p', 'display: block');
        //element.classList.replace('formerror', 'visible');
        //modern browsers:
        //element.style = border:"red solid 1px";
    }
    else {
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
  }else {
      formOK--;
      element.removeAttribute('style');
  }
};


checkAttribute(inputs, 'required', checkEmpty);

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

//return a response if the username is taken
const checkName = () => {
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
                console.log(json);
                responseText.innerHTML = json.toString();
            } else {
               responseText.innerHTML = json.toString();
               form.submit(); 
           }
        });
 
    //responseText.classList.replace('hidden', ''); 
};
