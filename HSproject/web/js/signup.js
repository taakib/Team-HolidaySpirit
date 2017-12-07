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

const form = document.querySelector('form');

form.addEventListener('submit', (evt) => {
    evt.preventDefault();
    formOK=0;
    checkAttribute(inputs, 'required', checkEmpty);
    checkAttribute(inputs, 'pattern', checkPattern);
    console.log(formOK);
    if (formOK===-4){
        form.submit();
    }
});

/*
 * author: anniluo
 */
//return a response if the username is taken
const checkName = () => {
    const responseText = document.querySelector("#response");
    responseText.innerHTML = ("username is taken.");
    responseText.classList.replace("hidden", ""); 
};
