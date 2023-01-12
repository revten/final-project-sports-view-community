<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#test_north{
	width:700px;
	height:700px;
	position: absolute;
	top: 0px;
	left: 0px;
	z-index:1;
	transition: all 0.5s ease-in;
}
#test_east{
	width:700px;
	height:700px;
	position: absolute;
	top: 0px;
	left: 0px;
	z-index:1;
}
#test_south{
	width:700px;
	height:700px;
	position: absolute;
	top: 0px;
	left: 0px;
	z-index:1;}
#test_west{
	width:700px;
	height:700px;
	position: absolute;
	top: 0px;
	left: 0px;
	z-index:1;
}
</style>
</head>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<div style="position: relative; display: flex; border: 1px solid black; justify-content: center; align-items: center; width: 700px; height: 700px; margin: 0 auto;">
<div style="display: inline-block; border: 2px solid red" >
<img id="seat" usemap="#workmap" style="position: relative; width: 500px; height: 500px; " src="resources/files/stadium/baseball/seating_chart/${seat}"><br>
<map name="workmap">
    <area class="imgArea"  id="north" coords="73,0,432,114" shape="rect">
    <area class="imgArea" id="west"  coords="1,117,138,371" shape="rect">
    <area class="imgArea" id="east" coords="364,117,499,371" shape="rect">
    <area class="imgArea"  id="south" coords="84,373,419,498" shape="rect">
</map>
</div>

<img style="display:none" id="test_east" src="resources/files/stadium/baseball/seating_chart/test_e.jpg">
<img style="display:none" id="test_west" src="resources/files/stadium/baseball/seating_chart/test_w.jpg">
<img style="display:none" id="test_south" src="resources/files/stadium/baseball/seating_chart/test_s.jpg">
<img style="display:none" id="test_north" src="resources/files/stadium/baseball/seating_chart/test_n.jpg">
</div>
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
<script type="text/javascript">
$(".imgArea").mouseover(function() {
	let areaId = $(this).attr("id");
	let imgName = "#test_"+areaId;
	console.log(imgName);
	$(imgName).css("display", "block");
});
</script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1950a2b56dd3863d5c5f75c779612745"></script>
<script type="text/javascript">
stadium_map();

</script>

</body>
</html>