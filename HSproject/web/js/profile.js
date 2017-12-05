'use strict';
// Create function 'showImages' which
// loads images.json which has links to images as an array.

// create a loop which builds the following HTML from every image in the array:
/*
 <li>
 <figure>
 <a href="img/original/filename.jpg"><img src="img/thumbs/filename.jpg"></a>
 <figcaption>
 <h3>Title</h3>
 </figcaption>
 </figure>
 </li>
 */
// After the loop print the HTML into <ul> element using innerHTML.

/*

const showImages = () => {
    const ul = document.querySelector('ul');

    fetch('images.json').then((response) => {
        return response.json();
    }).then((json) => {
        let html = '';
        json.forEach((image) => {
            html +=
                `<li>
          <figure>
            <a href="img/original/${image.mediaUrl}"><img src="img/thumbs/${image.mediaThumb}"></a>
            <figcaption>
                <h3>${image.mediaTitle}</h3>
            </figcaption>
          </figure>
        </li>`;
        });
        ul.innerHTML = html;
        //now links can be selected
        linkActions();
    });
};

showImages(); */

/*
const modal = document.querySelector('#modal');
const linkActions = () => {
    //select all a elemtns inside ul (to not select closing button X)
    const a = document.querySelector('ul').querySelectorAll('a');
    //loop links
    a.forEach((imageLink) => {
        imageLink.addEventListener('click', (evt) => {
            //when link is clicked, prevent default action
            evt.preventDefault();
            //get href value of link
            const href = imageLink.getAttribute('href');
            //set modal image src to href value
            modal.querySelector('img').setAttribute('src', href);
            //display modal (use lightbox class)
            modal.classList.replace('hidden', 'lightbox');
        });
    });
};

//select close button of modal
const closeButton = document.querySelector('.closeBtn');
closeButton.addEventListener('click', (evt) => {
    //when close button is clicked hide modal
    //classlist replace lightbox with hidden
    modal.classList.replace('lightbox', 'hidden');
});*/





//this is for the image testing before getting images from database.
//try to get pictures from the page to open in modal/lightbox

const photoArea = document.querySelector('#photoarea');
const linkActions = () => {
    const a = document.querySelector('section').querySelectorAll('a');
    //const a = document.querySelector('a');
    //const img = document.querySelectorAll('img');
    a.forEach((link) => {
        link.addEventListener('click', (evt) => {
            console.log("clicked " + link);
            evt.preventDefault();
            const href=link.getAttribute('href');
            photoArea.querySelector('a').setAttribute('src',href);
            photoArea.classList.replace('default', 'lightboxi');
            //get image , title, description and tags for the image?
        })
    })
};

linkActions();


const closeButton = document.querySelector('.closeBtn');
closeButton.addEventListener('click', (evt) => {
    photoArea.classList.replace('lightboxi', 'hidden');
});




//here to make tabs working
//favorites and uploads tab

//also set tablinks to be active when clicked and removed when clicked something else
const favoriteTab = document.querySelector('#favoritetab');
const photoTab = document.querySelector('#uploadtab');
const uploadedPhotos = document.getElementById('photoarea');
const favoritedPhotos = document.getElementById('favorites');

favoriteTab.addEventListener('click', (evt) => {
    //console.log("clicked " + evt);
    //id favorites show display block
    favoritedPhotos.setAttribute('style', 'display:block');
    favoriteTab.classList.replace('tablinks', 'active');
    photoTab.classList.replace('active', 'tablinks');
    //id photoarea dispaly none
    uploadedPhotos.setAttribute('style', 'display:none');
});

photoTab.addEventListener('click', (evt) => {
    favoritedPhotos.setAttribute('style', 'display:none');
    uploadedPhotos.setAttribute('style', 'display:block');
    photoTab.classList.replace('tablinks', 'active');
    favoriteTab.classList.replace('active', 'tablinks');
});

