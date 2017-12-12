'use strict';

//upload lightbox
const uploadBtn = document.querySelector('#uploadButton');
uploadBtn.addEventListener('click',(evt) => {
  evt.preventDefault();
  const modal = document.querySelector('#uploadModal');
  modal.classList.replace('hidden', 'lightbox-upload');
  const closeButton = document.querySelector('.closeBtn');
  closeButton.addEventListener('click', (evt) => {
    modal.classList.replace('lightbox-upload', 'hidden');
  });
});

//upload img function
const upload = (evt) => {
  evt.preventDefault();
  const upform = document.querySelector('#uploadForm');
  const input = document.querySelector('input[type="file"]');
  //makes FormData -object and adds the file selected byt the user into the object
  const data = new FormData(upform);
  data.append('imgfile', input.files[0]);
   //make an object for settings
  const settings = {
         method: 'POST',
         credentials: 'same-origin', // this might be needed for some servers
         body: data
     };
  //send the file to the same url as in task a by using fetch -method
  fetch('//10.114.34.129:8080/HSproject/imgupload', settings).then((response) => {
    return response.json();
  }).then((json) => {
    //when file upload is complete, user server response to display uploaded image
    //console.log(json);
    upform.classList.replace('replaceme','hidden');
    //const response = document.querySelector('#response');
    //response.innerHTML = "Success!";
    //response.classList.replace('hidden', 'responsetext');
    //direct to profilepage?
    location.reload();
  });
};

// make an event listener which calls upload function when the form is submitted
document.querySelector('#uploadForm').addEventListener('submit', upload);