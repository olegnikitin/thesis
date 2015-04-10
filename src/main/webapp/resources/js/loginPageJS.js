/**
 * Created by Oleg on 06.04.2015.
 */
window.alert = function(){};
var defaultCSS = document.getElementById('bootstrap-css');
function changeCSS(css){
    if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />');
    else $('head > link').filter(':first').replaceWith(defaultCSS);
}
$( document ).ready(function() {
    var iframe_height = parseInt($('html').height());
    window.parent.postMessage( iframe_height, 'http://bootsnipp.com');
});

function showPassword() {

    var key_attr = $('#key').attr('type');

    if(key_attr != 'text') {

        $('.checkbox').addClass('show');
        $('#key').attr('type', 'text');

    } else {

        $('.checkbox').removeClass('show');
        $('#key').attr('type', 'password');

    }

};