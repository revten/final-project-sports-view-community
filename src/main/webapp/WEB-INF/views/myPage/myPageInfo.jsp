<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link
	href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.css'
	rel='stylesheet' />
<link
	href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.print.css'
	rel='stylesheet' media='print' />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src='https://fullcalendar.io/releases/fullcalendar/3.9.0/lib/moment.min.js'></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.js'></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<br>
<br>
<br>
<br>
<br>
<br>
<body>

	<div class="container calendar-container">
		<div id="calendar" style="max-width: 900px; margin: 40px auto;"></div>
	</div>

	<script type="text/javascript">
$(document).ready(function(){
	  $('#calendar').fullCalendar({
	    header: {
	      right: 'custom2 prevYear,prev,next,nextYear'
	    },
        // 출석체크를 위한 버튼 생성
	    customButtons: { 
	        custom2: {
	          text: '출석체크하기',
	          id: 'check',
	          click: function() {	
	        	  let userId = $("#userId").text();
	          	console.log(userId);
	        	 $.ajax({
	        		 url: "users/attendances",
	        		 type: "POST",
	        		 data : {userId: userId},
	        		 dataType: "text",
	        		 success: function (date) {
	        		 $(".fc-custom2-button").prop('disabled', true);
	        		 $(".fc-custom2-button").html('출석완료');
	        	 }
                    // ajax 통신으로 출석 정보 저장하기 
                    // POST "/users/attendances" -> { status: "success", date:"2018-07-01"}
                    // 통신 성공시 버튼 바꾸고, property disabled 만들기 
	          }); 
	          }
	        }
	    },
       // 달력 정보 가져오기 
	    eventSources: [
	    	{
				// ajax 통신으로 달력 정보 가져오기 
                // GET "/users/attendances" -> {dateList:[ date: "2016-03-21", ... ]}
			    
	    	}
	    ]
});
});
$.ajax({
    url: 'users/attendances',
	type: 'GET',
	dataType: "JSON",
	success: function (data) {
		console.log('success!');
		console.log(data);
	},
	error: function() {
		alert('there was an error while fetching events!');
	},
    
	color: 'purple',   
	textColor: 'white' 

	});
</script>


	<h1>내정보 보기!</h1>

	ID :
	<span id="userId">${sessionScope.loginAccount.ac_id }</span>
	<br> PW : ${sessionScope.loginAccount.ac_pw }
	<br> NickName : ${sessionScope.loginAccount.ac_nick }
	<br> NAME: ${sessionScope.loginAccount.ac_name }
	<br> ADDR: ${sessionScope.loginAccount.ac_addr }
	<br> EMAIL: ${sessionScope.loginAccount.ac_email }
	<br> 가입날짜:
	<fmt:formatDate value="${sessionScope.loginAccount.ac_date }"
		pattern="MM/dd/yy" />
	<br>
	<button onclick="location.href='index.go'">home 으로 돌아가기</button>
	<div>
		<button onclick="location.href='account.modify.go'">내정보 수정하기</button>
	</div>

</body>
</html>