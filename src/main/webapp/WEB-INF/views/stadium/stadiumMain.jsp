<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
//<![CDATA[
	$( document ).ready( function() {
    $( '.bxslider' ).bxSlider( {
      auto: true,
      pause: 2000,
      autoHover: true,
      slideWidth: 800,
      slideMargin: 5,
    } );
  } );
//]]>
</script>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<div id="stadium_area">
<ul id="sports_list">
<li><a style="cursor: pointer" onclick="stadiumBaseball()">야구</a></li>
<li><a style="cursor: pointer" onclick="stadiumSoccer()">축구</a></li>
<li><a style="cursor: pointer" onclick="stadiumBasketball()">농구</a></li>
<li><a style="cursor: pointer" onclick="stadiumVolleyball()">배구</a></li>
</ul>
</div>
<br>
<br>
<br>
<div id="content_area">
<ul class="bxslider">
	<!-- <li><img src="resources/files/slider/aa.jpg" /></li> -->
	<li><img src="http://ticketimage.interpark.com/TCMS3.0/SPORT/BIGBN/2301/230104022322_20230104022322.gif" /></li>
	<li><img src="http://ticketimage.interpark.com/TCMS3.0/SPORT/BIGBN/2212/221228102015_20221228102015.gif" /></li>
</ul>
</div>
</body>
</html>