// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = () => {
    scrollFunction();
};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("topBtn").style.display = "block";
    } else {
        document.getElementById("topBtn").style.display = "none";
    }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    document.body.scrollTop = 0; // For Safari
    document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
}

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

/*fetch imgs from server
const fetchImages = () => {
  const ul = document.querySelector('ul');
  fetch('images.json').then((response) => { //how to fetch imgs from the server
    return response.json();
  }).then((json) => {
    let html ='';
    json.forEach((image) => {
      html +=
          `<li>
            <a href="img/original/${image.mediaUrl}"><img src="img/thumbs/${image.mediaThumb}"></a>
          </li>`;
    });
    ul.innerHTML = html;
    biggerImgs();
  });
};*/

/*img lightbox
const biggerImgs = () => {
  //select all a elements inside ul
  const links = document.querySelector('ul').querySelectorAll('a');
  //loop links
  links.forEach((link) => {
    //when link is clicked
    link.addEventListener('click', (evt) => {
      //prevent default action
      evt.preventDefault();
      //get href value of link
      const hrefValue = link.getAttribute('href');
      //set modal image src to href value
      const modal = document.querySelector('#imgModal');
      modal.querySelector('img').setAttribute('src', hrefValue);
      //display modal (use lightbox class)
      modal.classList.replace('hidden', 'lightbox-img');
      //select close button of modal
      const closeButton = document.querySelector('.closeBtn');
      //when close button is clicked hide modal
      closeButton.addEventListener('click', (evt) => {
        //const modal = document.querySelector('#modal');
         modal.classList.replace('lightbox-img', 'hidden');
      });
    });
  });
};*/

//
const upload = (evt) => {
    // - prevents the form from sending
    evt.preventDefault();
    // - selects the file input field
    const input = document.querySelector('input[type="file"]');
    // - makes FormData -object and adds the file selected byt the user into the object
    const data = new FormData();
    data.append('uploadedImg', input.files[0]);
    // make an object for settings
    const settings = {
        method: 'POST',
        //credentials: 'same-origin', // this might be needed for some servers
        body: data
    };
    // - send the file to the same url as in task a by using fetch -method
    fetch('fileupload', settings).then((response) => {
        return response.json();
    }).then((json) => {
        // - when file upload is complete, user server response to display uploaded image
        console.log(json);
        document.querySelector('#testupload').src = json.src;
    });
};// function ends

// make an event listener which calls upload function when the form is submitted
document.querySelector('form').addEventListener('submit', upload);
