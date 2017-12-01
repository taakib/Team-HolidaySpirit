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
});
*/
