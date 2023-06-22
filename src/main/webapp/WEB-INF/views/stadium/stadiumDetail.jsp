<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	<span>아래 경기장 좌석을 클릭하여 상세 전경을 감상해보세요!</span>

	<c:forEach var="ci" items="${clubImages }">
		<c:set var="club_id" value="${ci.club_id }"></c:set>
		<c:if test="${ci.sort eq 0 }">
			<c:set var="logo" value="${ci.file_name }"></c:set>
		</c:if>
		<c:if test="${ci.sort eq 1 }">
			<c:set var="stadium" value="${ci.file_name }"></c:set>
		</c:if>
		<c:if test="${ci.sort eq 2 }">
			<c:set var="seat" value="${ci.file_name }"></c:set>
		</c:if>
		<c:if test="${ci.sort eq 3 && fn:contains(ci.file_name, '3') }">
			<c:set var="view_3_3" value="${ci.file_name }"></c:set>
		</c:if>
		<c:if test="${ci.sort eq 3 && fn:contains(ci.file_name, '6') }">
			<c:set var="view_3_6" value="${ci.file_name }"></c:set>
		</c:if>
		<c:if test="${ci.sort eq 3 && fn:contains(ci.file_name, '9') }">
			<c:set var="view_3_9" value="${ci.file_name }"></c:set>
		</c:if>
		<c:if test="${ci.sort eq 3 && fn:contains(ci.file_name, '12') }">
			<c:set var="view_3_12" value="${ci.file_name }"></c:set>
		</c:if>
	</c:forEach>

	<div id="start"
		style="position: relative; display: flex; flex-direction: column; justify-content: center; align-items: center; width: 1000px; height: 1000px;">
		<div style="display: inline-block; align-items: flex-start;">
			<img id="seat" usemap="#workmap"
				style="position: relative; width: 1024px; height: 800px; margin: 450px 0px 10px 0px;"
				src="/resources/files/club_images/${club_id }/${seat}"><br>
			<map name="workmap">
				<area style="cursor: pointer;" class="imgArea" id="${view_3_12}"
					coords="-1,273,1023,0" shape="rect">
				<area style="cursor: pointer;" class="imgArea" id="${view_3_9}"
					coords="0,274,410,560" shape="rect">
				<area style="cursor: pointer;" class="imgArea" id="${view_3_3}"
					coords="609,273,1023,561" shape="rect">
				<area style="cursor: pointer;" class="imgArea" id="${view_3_6}"
					coords="-1,561,1023,795" shape="rect">
			</map>
			<button id="reserveBtn">예매하러 가기</button>
			<button onclick="with_go_write_go()">같이 보러 가기</button>
			<br> <br> <br>
			<!-- map div -->
			<div id="map"
				style="margin: 20px 0px 15px 0px; width: 800px; height: 500px;"></div>
		</div>
		<!-- 전경 사진 -->
		<img style="display: none" id="test_3"
			src="/resources/final_img_file/baseball/seating_chart/${seatDetail }/test_3.jpg">
		<img style="display: none" id="test_9"
			src="/resources/final_img_file/baseball/seating_chart/${seatDetail }/test_9.jpg">
		<img style="display: none" id="test_6"
			src="/resources/final_img_file/baseball/seating_chart/${seatDetail }/test_6.jpg">
		<img style="display: none" id="test_12"
			src="/resources/final_img_file/baseball/seating_chart/${seatDetail }/test_12.jpg">
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<script type="text/javascript">
		$('.imgArea').click(
				function() {
					let view = $(this).attr("id");
					
					let urlParams = new URL(location.href).searchParams;
					let club_id = urlParams.get('club_id');
					
					window.open(
							"/resources/files/club_images/"
									+ club_id + "/" + view, "teamImg",
							"left=380px, height=800px, width=750px");
				});
	</script>
	
	<!-- ------------------map---------------------  -->
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1950a2b56dd3863d5c5f75c779612745"></script>
	<script type="text/javascript">
		stadium_map();
	</script>

</body>
</html>