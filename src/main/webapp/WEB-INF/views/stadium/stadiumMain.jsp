<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/stadium/stadiumMain.css" />
</head>
<script type="text/javascript">
	//<![CDATA[
	$(document).ready(function() {
		$('.bxslider').bxSlider({
			auto : true,
			pause : 2000,
			autoHover : true,
			slideWidth : 800,
			slideMargin : 5,
		});
	});
	//]]>
</script>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<div class="stadiumMain__container">
		<p class="stadiumMain__header">오늘은 어떤 스포츠를 즐길까요?</p>
		<div class="stadiumMain__content">
			<div class="stadiumMain__wrapper-1">
				<div class="stadiumMain__box stadiumMain__vintage">
					<img src="resources/files/stadium/main/baseball.png" alt="baseball"> <!-- 그림크기 900x900이 반응형까지 최적화임 -->
					<h2>KBO</h2>
					<p>It ain't over till it's over.</p>
				</div>
			</div>
			<div class="stadiumMain__wrapper-2">
				<div class="stadiumMain__box stadiumMain__w-content">
					<img src="resources/files/stadium/main/soccer.png" alt="soccer">
					<div class="stadiumMain__frame">
						<h2>No sweat, no sweet!</h2>
					</div>
				</div>
			</div>
			<div class="stadiumMain__wrapper-3">
				<div class="stadiumMain__box stadiumMain__postcard">
					<img src="resources/files/stadium/main/basketballMen.png"
						alt="basketballMen">
					<h2>
						KBL, make each day
						<p class="stadiumMain__hide">MASTERPIECE</p>
					</h2>
				</div>
			</div>
			<div class="stadiumMain__wrapper-4">
				<div class="stadiumMain__box stadiumMain__zoom-in">
					<img src="resources/files/stadium/main/volleyball.png"
						"
						alt="volleyball">
					<h2>Invite from KOVO</h2>
					<p>V-league men</p>
				</div>
			</div>
			<div class="stadiumMain__wrapper-5">
				<div class="stadiumMain__box stadiumMain__blury-card">
					<img src="resources/files/stadium/main/volleyballWomen.png"
						"
						alt="volleyballWomen">
					<div class="stadiumMain__frame">
						<h2>V-league Women</h2>
						<p>Nothing Better</p>
					</div>
				</div>
			</div>
			<div class="stadiumMain__wrapper-6">
				<div class="stadiumMain__box stadiumMain__zoom-out">
					<img src="resources/files/stadium/main/basketballWomen.png"
						"
						alt="basketballWomen">
					<div class="stadiumMain__frame">
						<h2>
							<span>WKBL</span>
						</h2>
						<p>You have to expect things of yourself before you can do
							them</p>
					</div>
				</div>
			</div>
		</div>
	</div>

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
			<li><img
				src="http://ticketimage.interpark.com/TCMS3.0/SPORT/BIGBN/2301/230104022322_20230104022322.gif" /></li>
			<li><img
				src="http://ticketimage.interpark.com/TCMS3.0/SPORT/BIGBN/2212/221228102015_20221228102015.gif" /></li>
		</ul>
	</div>
	<script>
		/*=============== 스크롤 나타나는 효과 ===============*/
		const srSTM = ScrollReveal({ /* srSTM으로 한것은, sr이 메인에서 쓰여서. STM은 stadiumMain */
			origin : 'top',
			distance : '60px',
			duration : 2500,
			delay : 400
		//reset: true, // 애니메이션은 반복
		})

		srSTM.reveal(`.stadiumMain__header, .stadiumMain__wrapper-2`);
		srSTM.reveal(`.stadiumMain__wrapper-5`, {
			origin : 'bottom'
		});
		srSTM.reveal(`.stadiumMain__wrapper-1, .stadiumMain__wrapper-4`, {
			origin : 'left'
		});
		srSTM.reveal(`.stadiumMain__wrapper-3, .stadiumMain__wrapper-6`, {
			origin : 'right'
		});
		srSTM.reveal(`.popular__card`, {
			interval : 100
		});
	</script>
</body>
</html>