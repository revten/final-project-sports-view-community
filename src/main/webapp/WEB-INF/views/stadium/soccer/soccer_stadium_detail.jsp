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
<img src="resources/files/stadium/soccer/seating_chart/${seat}"><br>
<button id="reserveBtn">예매하러 가기</button>
<br>
<br>
<br>
<br>
<br>
<br>
<button onclick="with_go_write_go()">같이 보러 가기</button>


<!-- map div -->
<div id="map" style="width: 500px; height: 300px;"></div>

<!-- ------------------map---------------------  -->

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1950a2b56dd3863d5c5f75c779612745"></script>
<script type="text/javascript">
stadium_map();

</script>

</body>
</html>