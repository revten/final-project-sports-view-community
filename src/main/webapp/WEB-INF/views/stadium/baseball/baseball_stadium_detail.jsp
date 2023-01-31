<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/stadium/stadium_go.js"></script>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<span class="stadium__notice">아래 경기장 좌석을 클릭하여 상세 전경을 감상해보세요</span>
	<div id="start"
		style="position: relative; display: flex; flex-direction: column; justify-content: center; align-items: center; width: 1000px; height: 1000px;">
		<div class="stadium__seat" style="display: inline-block; align-items: flex-start;">
			<img id="seat" usemap="#workmap"
				style="position: relative; width: 1024px; height: 800px; margin: 450px 0px 10px 0px;"
				src="resources/files/stadium/baseball/seating_chart/${seat}"><br>
			<map name="workmap">
				<area style="cursor: pointer;" class="imgArea" id="12"
					coords="-1,273,1023,0" shape="rect">
				<area style="cursor: pointer;" class="imgArea" id="9"
					coords="0,274,410,560" shape="rect">
				<area style="cursor: pointer;" class="imgArea" id="3"
					coords="609,273,1023,561" shape="rect">
				<area style="cursor: pointer;" class="imgArea" id="6"
					coords="-1,561,1023,795" shape="rect">
			</map>
			<div>
			<a id="reserveBtn">예매하러가기</a>
			<a href="withGo.reg.go?post_board=11"
								onclick="alert('로그인하세요')">함께보기</a>
			</div>
			<br><br><br>
			<!-- map div -->
			<div id="map"
				style="margin: 20px 0px 15px 0px; width: 800px; height: 500px;"></div>
		</div>
		<!-- 전경 사진 -->
		<img style="display: none" id="test_3"
			src="resources/final_img_file/baseball/seating_chart/${seatDetail }/test_3.jpg">
		<img style="display: none" id="test_9"
			src="resources/final_img_file/baseball/seating_chart/${seatDetail }/test_9.jpg">
		<img style="display: none" id="test_6"
			src="resources/final_img_file/baseball/seating_chart/${seatDetail }/test_6.jpg">
		<img style="display: none" id="test_12"
			src="resources/final_img_file/baseball/seating_chart/${seatDetail }/test_12.jpg">
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<!-- 스크롤 이동  
	<script>
		$(document).ready(function() {
			$('html, body').animate({
				scrollTop : $('#start').offset().top
			});
		});
	</script>
	<!-- 가이드 라인
	<script>
	$(".imgArea").mouseover(function() {
		 let areaId = $(this).attr("id");
		 let imgName = "#guide_line_"+areaId;
		 console.log(imgName);
		 $(imgName).css("display", "block");
		 });
	
	$(".imgArea").mouseleave(function() {
		 let areaId = $(this).attr("id");
		 let imgName = "#guide_line_"+areaId;
		 console.log(imgName);
		 $(imgName).css("display", "none");
		 });
	</script>
	<!-- 전경 -->
	<script type="text/javascript">
		$('.imgArea').click(function() {
			let areaId = $(this).attr("id");
			let urlParams = new URL(location.href).searchParams;
			let team = urlParams.get('team');
			let imgName = "test_" + areaId + ".jpg";
			window.open("resources/final_img_file/baseball/seating_chart/"+team+"/"+imgName,"teamImg","left=380px, height=800px, width=750px");
		});

		/*$(".imgArea").mouseover(function() {
		 let areaId = $(this).attr("id");
		 let imgName = "#test_"+areaId;
		 console.log(imgName);
		 $(imgName).css("display", "block");
		 });

		 $(".imgArea").mouseleave(function(){
		 let areaId = $(this).attr("id");
		 let imgName = "#test_"+areaId;
		 console.log(imgName);
		 $(imgName).css("display", "none");
		 });*/
	</script>
	<!--  <script>
		$('.imgArea').mouseleave(function() {
			let areaId = $(this).attr("id");
			let imgName = "#test_" + areaId;
			$(imgName).toggle('slow');
		});
	</script> -->
	<!-- ------------------map---------------------  -->
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1950a2b56dd3863d5c5f75c779612745"></script>
	<script type="text/javascript">
		stadium_map();
	</script>
	
	   	<script>
		/*=============== 스크롤 나타나는 효과 ===============*/
		const srStad2 = ScrollReveal({ 
			origin : 'bottom',
			distance : '90px',
			duration : 2500,
			delay : 400
		//reset: true, // 애니메이션은 반복
		})
		
		srStad2.reveal(`.stadium__seat`, {
			origin : 'bottom'
		});
		
		srStad2.reveal(`.stadium__notice`, {
			origin : 'bottom'
		});

	</script>

</body>
</html>