/* global fetch */
'use strict';

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

//fetch imgs from server
//this could be used to get username to profilepage as well
//fetch images that have same id as current user
//test this to set fetched img id as testnumber, like 9
const fetchImagerinos = () => {
    const ul = document.querySelector('ul');
    const settings = {
        method: 'GET',
        credentials: 'same-origin' // this might be needed for some servers
                //body: data
    };
    fetch('//10.114.34.129:8080/PTHS/db/service/fetchImgs', settings).then((response) => {
        return response.json();
    }).then((json) => {
        let html = '';
        json.forEach((Post) => {
            //here to take id
            //if loggedinuserid=uploader id
            html +=
                    `<li>
            <a href="${Post.sourceUrl}"><img src="${Post.sourceUrl}"></a>
          </li>`;
        });
        ul.innerHTML = html;
        linkActions();
    });
};

//when page is loaded, upload imgs from a server directory
window.onload = fetchImagerinos;

const modal = document.querySelector('#modalIMAGE');
const linkActions = () => {
    const linkerinos = document.querySelector('profilephotoarea').querySelectorAll('a');
    //const a = document.querySelector('a');
    //const img = document.querySelectorAll('img');
    linkerinos.forEach((link) => {
        link.addEventListener('click', (evt) => {
            console.log("clicked " + link);
            evt.preventDefault();
            const href = link.getAttribute('href');
            modal.querySelector('img').setAttribute('src', href);
            modal.classList.replace('hidden', 'lightboxi');
            //get image , title, description and tags for the image
        });
    });
};

const closeButton = document.querySelector('.closeBtnn');
closeButton.addEventListener('click', (evt) => {
    modal.classList.replace('lightboxi', 'hidden');
});




//practice version for NON fetched images
const photoArea = document.getElementById('photoarea').querySelectorAll('a');
window.onload = defaultPicModal;
const defaultPicModal = () => {
    //const a = document.querySelector('a');
    //const img = document.querySelectorAll('img');
    photoArea.forEach((link) => {
        link.addEventListener('click', (evt) => {
            console.log("clicked " + link);
            evt.preventDefault();
            const hrefVal = link.getAttribute('href');
            modal.querySelector('a').setAttribute('src', hrefVal);
            modal.classList.replace('hidden', 'lightboxi');
            //get image , title, description and tags for the image
        });
    });
};