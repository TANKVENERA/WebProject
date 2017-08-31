var links = document.getElementsByClassName('changeable');
function changeColor(e) {
    e.target.style.color = e.target.style.color ? null : 'red';
}
for (var i = 0; i < links.length; i++) {
    links[i].addEventListener('click', changeColor);
}
