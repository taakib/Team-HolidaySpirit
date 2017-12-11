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
        element.style = 'border: red solid 1px';
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
    //match database's user
    if (formOK === -4){
        login();
    } 
});

const login = () => {
    const form = document.querySelector('form');
    const data = new FormData(form);
    const settings = {
        method: 'POST',
        credentials: 'same-origin', // this might be needed for some servers
        body: data
    };
    fetch('//10.114.34.129:8080/HSproject/login', settings).then((response) => {
        return response.text();
    }).then((text) => {
        const responseText = document.querySelector('#response');
        console.log(text);
        responseText.innerHTML = text;
    });
    
};
