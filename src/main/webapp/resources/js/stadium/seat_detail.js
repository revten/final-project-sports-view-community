$(function() {
	var seat = $('#seat');
	seat.click(function(event) {
		x = event.pageX;
		y = event.pageY;
		alert('x좌표:' + x + ', y좌표:' + y);
	})
}); 

$(document).ready(function() {
	$('#seat').mouseover(function(e) {
		console.log(event.pageX, event.pageY)
		$('#test_e').toggle('slow');
		
	});
});