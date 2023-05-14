<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="stadiumMain__container">
		<p class="stadiumMain__header">오늘은 어떤 스포츠를 즐길까요?</p>
		
		<!-- 검색 -->
		<div> 검색 영역 </div>
		
		<div class="stadiumMain__content">
			<div class="stadiumMain__wrapper-1" onclick="location.href='league.clubList.go?league_id=101'">
				<div class="stadiumMain__box stadiumMain__vintage">
					<img src="resources/files/stadium/main/baseball.png" alt="baseball">
					<!-- 그림크기 900x900이 반응형까지 최적화임 -->
					<h2>KBO</h2>
					<p>It ain't over till it's over.</p>
				</div>
			</div>
			<div class="stadiumMain__wrapper-2" onclick="location.href='league.clubList.go?league_id=201'">
				<div class="stadiumMain__box stadiumMain__w-content">
					<img src="resources/files/stadium/main/soccer.png" alt="soccer">
					<div class="stadiumMain__frame">
						<h2>No sweat, no sweet!</h2>
					</div>
				</div>
			</div>
			<div class="stadiumMain__wrapper-3" onclick="location.href='league.clubList.go?league_id=301'">
				<div class="stadiumMain__box stadiumMain__postcard">
					<img src="resources/files/stadium/main/basketballMen.png"
						alt="basketballMen">
					<h2>
						KBL, make each day
						<p class="stadiumMain__hide">MASTERPIECE</p>
					</h2>
				</div>
			</div>
			<div class="stadiumMain__wrapper-4" onclick="location.href='league.clubList.goleague_id=401'">
				<div class="stadiumMain__box stadiumMain__zoom-in">
					<img src="resources/files/stadium/main/volleyball.png"
						alt="volleyball">
					<h2>Invite from KOVO</h2>
					<p>V-league men</p>
				</div>
			</div>
			<div class="stadiumMain__wrapper-5" onclick="location.href='league.clubList.go?league_id=351'">
				<div class="stadiumMain__box stadiumMain__blury-card">
					<img src="resources/files/stadium/main/volleyballWomen.png"
						alt="volleyballWomen">
					<div class="stadiumMain__frame">
						<h2>V-league Women</h2>
						<p>Nothing Better</p>
					</div>
				</div>
			</div>
			<div class="stadiumMain__wrapper-6" onclick="location.href='league.clubList.go?league_id=451'"><!-- stadiumBasketball2 -->
				<div class="stadiumMain__box stadiumMain__zoom-out">
					<img src="resources/files/stadium/main/basketballWomen.png"
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
	<script>
		/*=============== 스크롤 나타나는 효과 ===============*/
		const srWithGo = ScrollReveal({ /* srSTM으로 한것은, sr이 메인에서 쓰여서. STM은 stadiumMain */
			origin : 'top',
			distance : '60px',
			duration : 2500,
			delay : 400
		//reset: true, // 애니메이션은 반복
		})

		srWithGo.reveal(`.stadiumMain__header, .stadiumMain__wrapper-2`);
		srWithGo.reveal(`.stadiumMain__wrapper-5`, {
			origin : 'bottom'
		});
		srWithGo.reveal(`.stadiumMain__wrapper-1, .stadiumMain__wrapper-4`, {
			origin : 'left'
		});
		srWithGo.reveal(`.stadiumMain__wrapper-3, .stadiumMain__wrapper-6`, {
			origin : 'right'
		});
		srWithGo.reveal(`.popular__card`, {
			interval : 100
		});
	</script>
</body>
</html>