'use strict';
// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = () => {
    scrollFunction();
};

const scrollFunction = () => {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.querySelector("#topBtn").style.display = "block";
    } else {
        document.querySelector("#topBtn").style.display = "none";
    }
}; 
// When the user clicks on the button, scroll to the top of the document
const topFunction = () => {
    document.body.scrollTop = 0; // For Safari
    document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera 
};

//search function
const search = () => {
    
};

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

/*img gallery lightbox
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

//comments


