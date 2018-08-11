var geocoder;
var map;
var ponto1;
var ponto2;
var marker1;
var marker2;

function initialize() {
	var latlng = new google.maps.LatLng(-23.6444789, -46.5274354);

	var options = {
		zoom : 16,
		center : latlng,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};

	map = new google.maps.Map(document.getElementById("mapa"), options);

	geocoder = new google.maps.Geocoder();

	 //var json = [{"id":48,"title":"Helgelandskysten","longitude":"12.63376","latitude":"66.02219"},{"id":46,"title":"Tysfjord","longitude":"16.50279","latitude":"68.03515"},{"id":44,"title":"Sledehunds-ekspedisjon","longitude":"7.53744","latitude":"60.08929"},{"id":43,"title":"Amundsensydpolferd","longitude":"11.38411","latitude":"62.57481"},{"id":39,"title":"Vikingtokt","longitude":"6.96781","latitude":"60.96335"},{"id":6,"title":"Tungtvann-sabotasjen","longitude":"8.49139","latitude":"59.87111"}];

	var json;

	$.getJSON('localhost:8080/pontos', function(data) { json = data });
	
	console.log(json);
	
	// Looping through all the entries from the JSON data
	for (var i = 0; i < json.length; i++) {

		// Current object
		var obj = json[i];

		// Adding a new marker for the object
		var marker = new google.maps.Marker({
			position : new google.maps.LatLng(obj.latitude, obj.longitude),
			map : map,
			title : obj.title
		// this works, giving the marker a title with the correct title
		});

		// Adding a new info window for the object
		var clicker = addClicker(marker, obj.title);

	} // end loop

	// Adding a new click event listener for the object
	function addClicker(marker, content) {
		google.maps.event.addListener(marker, 'click', function() {

			if (infowindow) {
				infowindow.close();
			}
			infowindow = new google.maps.InfoWindow({
				content : content
			});
			infowindow.open(map, marker);

		});
	}

	/*
	 * var ponto1 = new google.maps.LatLng(-23.6523755, -46.5273431);
	 * 
	 * marker1 = new google.maps.Marker({ map: map, title: 'Terminal Celso
	 * Daniel' });
	 * 
	 * marker1.setPosition(ponto1);
	 * 
	 * var contentString1 = '<h3>Terminal Celso Daniel</h3>' + '<a
	 * href="http://pt.wikipedia.org/wiki/Pra%C3%A7a_Rio_Branco_(Recife)">Clique
	 * aqui para reservar sua bicicleta.</a>';
	 * 
	 * var infowindow1 = new google.maps.InfoWindow({ content: contentString1
	 * });
	 * 
	 * google.maps.event.addListener(marker1, 'click', function() {
	 * infowindow1.open(map,marker1); });
	 * 
	 * var ponto2 = new google.maps.LatLng(-23.644148, -46.5299671);
	 * 
	 * marker2 = new google.maps.Marker({ map: map, title: 'UFABC Santo André'
	 * });
	 * 
	 * marker2.setPosition(ponto2);
	 * 
	 * var contentString2 = '<h3>UFABC Santo André</h3>' + '<a
	 * href="http://pt.wikipedia.org/wiki/Pra%C3%A7a_Rio_Branco_(Recife)">Clique
	 * aqui para reservar sua bicicleta.</a>';
	 * 
	 * var infowindow2 = new google.maps.InfoWindow({ content: contentString2
	 * });
	 * 
	 * google.maps.event.addListener(marker2, 'click', function() {
	 * infowindow2.open(map,marker2); });
	 */
}

$(document).ready(function() {
	initialize();
	// Initialize the map
	// google.maps.event.addDomListener(window, 'load', initialize);
});