$(document).ready(function() {
	initializeMapCanvas();
	showStation();
	showTaxi();
});

var baseURL = document.getElementById("page:navigation:ctx").value + "/";
var taxiStandIcon = baseURL + "image/taxi-stand.png";
var taxiIconGreen = baseURL + "image/taxi-green.png";
var taxiIconYellow = baseURL + "image/taxi-yellow.png";
var taxiIconBlack = baseURL + "image/taxi-black.png";
var taxiIconRed = baseURL + "image/taxi-red.png";

var map;
var marker;
var operator = document.getElementById("page:header:operatorUsername").innerHTML;
var markers = [];

function initializeMapCanvas() {
	var myOptions = {
		center : new google.maps.LatLng(39.897391, 32.776501),
		zoom : 11,
		zoomControl : true,
		disableDoubleClickZoom : false,
		scrollwheel : false,
		streetViewControl : false,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	map = new google.maps.Map(document.getElementById("page:content:mapLayout:mapContent:mapCanvas"), myOptions);
}

function showStation() {
	$.ajax({
		url : baseURL + "api/get/status/station",
		dataType : 'json',
		data : "o=" + operator,
		success : function(response) {
			var data = response;
			addStationMarker(data.latlng, data.sname);
		}
	});
}

function showTaxi() {
	clearOverlays();
	$.ajax({
		url : baseURL + "api/get/status/taxi",
		dataType : 'json',
		data : "o=" + operator,
		success : function(response) {
			for ( var i = 0; i < response.tlist.length; i++) {
				var data = response.tlist[i];
				addTaxiMarker(data.latlng, data.tplate, data.tstate);
			}
		}
	});

	window.setTimeout('showTaxi()', 2000);
}

function addStationMarker(latlng, title) {
	var coordinates = latlng.split(",");
	var latlng = new google.maps.LatLng(coordinates[0], coordinates[1]);

	marker = new google.maps.Marker({
		position : latlng,
		title : title,
		icon : taxiStandIcon
	});

	marker.setMap(map);
	map.setCenter(latlng);
}

function addTaxiMarker(latlng, title, state) {
	var coordinates = latlng.split(",");
	var coordinate = new google.maps.LatLng(coordinates[0], coordinates[1]);

	// default animation
	var animation = google.maps.Animation.DROP;

	// set icon
	var icon = null;
	switch (state) {
	case "1":
		icon = taxiIconGreen;
		break;
	case "2":
		icon = taxiIconYellow;
		break;
	case "3":
		icon = taxiIconBlack;
		break;
	case "4":
		icon = taxiIconRed;
		animation = google.maps.Animation.BOUNCE;
		break;
	default:
		break;
	}

	marker = new google.maps.Marker({
		position : coordinate,
		title : title,
		icon : icon
	});

	marker.setMap(map);
	markers.push(marker);
}

function clearOverlays() {
	if (markers) {
		for ( var i = 0; i < markers.length; i++) {
			markers[i].setMap(null);
		}
	}
}