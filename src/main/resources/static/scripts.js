window.onscroll = function() {
    shrinkNavbar();
};

function shrinkNavbar() {
    var navbar = document.querySelector('.navbar');
    if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
        navbar.style.padding = "10px 0";
        navbar.style.fontSize = "18px";  /* Reduce el tamaño del texto en el scroll */
    } else {
        navbar.style.padding = "20px 0";
        navbar.style.fontSize = "20px";  /* Tamaño normal cuando está en la parte superior */
    }
}