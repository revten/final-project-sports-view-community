<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="resources/css/admin/admin.css">
<link rel="stylesheet"
	href="https://vjs.zencdn.net/5-unsafe/video-js.css">
<script src="https://vjs.zencdn.net/5-unsafe/video.js"></script>
<script src="resources/js/admin/admin.js"></script>
<style>
html, #map {
	height: 700px;
	width: 100%;
}
</style>
<body>
	<div class="admin">
		<br> <br> <br> <br> <br> <br>
		
		<a href="admin.answerBoard.go">문의처리게시판</a>

		<h1>Google Maps</h1>

		<div class="jumbotron">
			<div class="container-fluid">
				<h1>Find The Distance Between Two Places.</h1>
				<p>This App Will Help You Calculate Your Travelling Distances.</p>
				<form class="form-horizontal">
					<div class="form-group">
						<label for="from" class="col-xs-2 control-label"><i
							class="far fa-dot-circle"></i></label>
						<div class="col-xs-4">
							<input type="text" id="from" placeholder="Origin"
								class="form-control">
						</div>
					</div>
					<div class="form-group">

						<label for="to" class="col-xs-2 control-label"><i
							class="fas fa-map-marker-alt"></i></label>
						<div class="col-xs-4">
							<input type="text" id="to" placeholder="Destination"
								class="form-control">
						</div>

					</div>

				</form>

				<div class="col-xs-offset-2 col-xs-10">
					<button class="btn btn-info btn-lg " onclick="calcRoute();">
						<i class="fas fa-map-signs"></i>
					</button>
				</div>
			</div>
			<div class="container-fluid">
				<div id="googleMap"></div>
				<div id="output"></div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	 1 contributor
	 68 lines (51 sloc)  2.38 KB

	 ﻿//javascript.js
	 //set map options
	 var myLatLng = { lat: 38.3460, lng: -0.4907 };
	 var mapOptions = {
	     center: myLatLng,
	     zoom: 7,
	     mapTypeId: google.maps.MapTypeId.ROADMAP

	 };

	 //create map
	 var map = new google.maps.Map(document.getElementById('googleMap'), mapOptions);

	 //create a DirectionsService object to use the route method and get a result for our request
	 var directionsService = new google.maps.DirectionsService();

	 //create a DirectionsRenderer object which we will use to display the route
	 var directionsDisplay = new google.maps.DirectionsRenderer();

	 //bind the DirectionsRenderer to the map
	 directionsDisplay.setMap(map);


	 //define calcRoute function
	 function calcRoute() {
	     //create request
	     var request = {
	         origin: document.getElementById("from").value,
	         destination: document.getElementById("to").value,
	         travelMode: google.maps.TravelMode.DRIVING, //WALKING, BYCYCLING, TRANSIT
	         unitSystem: google.maps.UnitSystem.IMPERIAL
	     }

	     //pass the request to the route method
	     directionsService.route(request, function (result, status) {
	         if (status == google.maps.DirectionsStatus.OK) {

	             //Get distance and time
	             const output = document.querySelector('#output');
	             output.innerHTML = "<div class='alert-info'>From: " + document.getElementById("from").value + ".<br />To: " + document.getElementById("to").value + ".<br /> Driving distance <i class='fas fa-road'></i> : " + result.routes[0].legs[0].distance.text + ".<br />Duration <i class='fas fa-hourglass-start'></i> : " + result.routes[0].legs[0].duration.text + ".</div>";

	             //display route
	             directionsDisplay.setDirections(result);
	         } else {
	             //delete route from map
	             directionsDisplay.setDirections({ routes: [] });
	             //center map in London
	             map.setCenter(myLatLng);

	             //show error message
	             output.innerHTML = "<div class='alert-danger'><i class='fas fa-exclamation-triangle'></i> Could not retrieve driving distance.</div>";
	         }
	     });

	 }

	 //create autocomplete objects for all inputs
	 var options = {
	     types: ['(cities)']
	 }

	 var input1 = document.getElementById("from");
	 var autocomplete1 = new google.maps.places.Autocomplete(input1, options);

	 var input2 = document.getElementById("to");
	 var autocomplete2 = new google.maps.places.Autocomplete(input2, options);
	</script>
</body>
</html>