<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<h1>ssgStadium 좌석배치도</h1>
<button onclick="window.open('https://ticket.interpark.com/Contents/Sports/GoodsInfo?SportsCode=07001&TeamCode=PB003')">예매하러 가기</button>
<br>
<br>
<br>
<br>
<br>
<br>
<h1>맵</h1>
<a href="withGoWrite.go?wg_cat=2">같이 보러 가기</a>
<!-- map div -->
<div id="map" style="width: 500px; height: 300px;"></div>

<!-- ------------------map---------------------  -->

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1950a2b56dd3863d5c5f75c779612745"></script>
<script type="text/javascript">
var mapContainer = document.getElementById('map'), 
mapOption = {
    center: new kakao.maps.LatLng(37.436998685442084,126.69327612453377), 
    level: 3 
};
var map = new kakao.maps.Map(mapContainer, mapOption);
var markerPosition  = new kakao.maps.LatLng(37.436998685442084,126.69327612453377); 
var marker = new kakao.maps.Marker({
	position: markerPosition
	});
marker.setMap(map);
var iwContent = '<div style="padding:5px;"> 인천SSG랜더스필드 <br><a href="https://map.kakao.com/link/map/인천 SSG 랜더스필드,37.436998685442084,126.69327612453377" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/인천 SSG 랜더스필드,37.436998685442084,126.69327612453377" style="color:blue" target="_blank">길찾기</a></div>',
iwPosition = new kakao.maps.LatLng(37.436998685442084,126.69327612453377);
iwRemoveable = true;
var infowindow = new kakao.maps.InfoWindow({
position : iwPosition, 
content : iwContent,
removable : iwRemoveable
});
infowindow.open(map, marker);
kakao.maps.event.addListener(marker, 'click', function() {
infowindow.open(map, marker);
});
</script>
</body>
</html>