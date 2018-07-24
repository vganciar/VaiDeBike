var geocoder;
var map;
var marker;
 
function initialize() {
    var latlng = new google.maps.LatLng(-23.6517023, -46.528313);
    var options = {
        zoom: 16,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
 
    map = new google.maps.Map(document.getElementById("mapa"), options);
 
    geocoder = new google.maps.Geocoder();
 
    marker = new google.maps.Marker({
        map: map,
        draggable: true,
    });
 
    marker.setPosition(latlng);
}
 
$(document).ready(function () {
    initialize();
});