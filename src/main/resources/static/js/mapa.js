var geocoder;
var map;

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

	$.getJSON('http://localhost:8080/pontos', function(data) {
		
		var json = data;
		
		// Looping through all the entries from the JSON data
		for (var i = 0; i < json.length; i++) {

			// Current object
			var obj = json[i];

			// Adding a new marker for the object
			var marker = new google.maps.Marker({
				position : new google.maps.LatLng(obj.longitude, obj.latitude),
				map : map,
				title : obj.nome
			// this works, giving the marker a title with the correct title
			});

			// Adding a new info window for the object
			var clicker = addClicker(marker, obj);

		} // end loop		
	});		

	// Adding a new click event listener for the object
	function addClicker(marker, obj) {
		google.maps.event.addListener(marker, 'click', function() {			
			
			var contentHTML;
			
			if (obj.bicicletasDisponiveis > 0){				
				contentHTML = '<p><b>'+ obj.nome +'</b></p>' + '<p>' + obj.endereco + '</p>' + '<p>Horário de funcionamento: ' + obj.horaInicial + ' às ' + obj.horaFinal + '</p>' + '<p>Bicicletas disponíveis: ' + obj.bicicletasDisponiveis + '</p>' + '<a href="/emprestimo/' + obj.id + '"><input type"button" class="btn btn-primary" value="Reservar bicicleta"/></a>';	
			}
			else
			{
				contentHTML = '<p><b>'+ obj.nome +'</b></p>' + '<p>' + obj.endereco + '</p>' + '<p>Nenhuma bicicleta disponível.</p>';					
			}
			
			var infowindow = new google.maps.InfoWindow({
				content : contentHTML
			});
			
			infowindow.open(map, marker);

		});
	}
}

$(document).ready(function() {
	initialize();
	// Initialize the map
	// google.maps.event.addDomListener(window, 'load', initialize);
});