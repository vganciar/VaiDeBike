var geocoder;
var map;
var ponto1;
var ponto2;
var marker1;
var marker2;
 
function initialize() {
    var latlng = new google.maps.LatLng(-23.6444789, -46.5274354);
    
    var options = {
        zoom: 16,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
 
    map = new google.maps.Map(document.getElementById("mapa"), options);
 
    geocoder = new google.maps.Geocoder();
 
    var ponto1 = new google.maps.LatLng(-23.6523755, -46.5273431);
       
    marker1 = new google.maps.Marker({
        map: map,
        title: 'Terminal Celso Daniel'
    });
    
    marker1.setPosition(ponto1);
    
    var contentString1 = '<h3>Terminal Celso Daniel</h3>' + '<a href="http://pt.wikipedia.org/wiki/Pra%C3%A7a_Rio_Branco_(Recife)">Clique aqui para reservar sua bicicleta.</a>';
    
    var infowindow1 = new google.maps.InfoWindow({
    	  content: contentString1    	
    }); 
    
    google.maps.event.addListener(marker1, 'click', function() {
    	  infowindow1.open(map,marker1);
    });
    
    var ponto2 = new google.maps.LatLng(-23.644148, -46.5299671);    
    
    marker2 = new google.maps.Marker({
        map: map,
        title: 'UFABC Santo André'
    });
 
    marker2.setPosition(ponto2);
    
    var contentString2 = '<h3>UFABC Santo André</h3>' + '<a href="http://pt.wikipedia.org/wiki/Pra%C3%A7a_Rio_Branco_(Recife)">Clique aqui para reservar sua bicicleta.</a>';
    
    var infowindow2 = new google.maps.InfoWindow({
    	  content: contentString2    	
    }); 
    
    google.maps.event.addListener(marker2, 'click', function() {
    	  infowindow2.open(map,marker2);
    });
}
 
$(document).ready(function () {
    initialize();
});