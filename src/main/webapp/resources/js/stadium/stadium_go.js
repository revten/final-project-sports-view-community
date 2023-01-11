/* 야구 */
function stadiumBaseball() {
	location.href = "baseball.go";
}

function baseballStadiumGo(team) {
	location.href="baseball.stadium.go.detail?team=" + team;
}

function stadiumSoccer() {
	location.href = "soccer.go";
}

function soccerStadiumGo() {
	location.href = "soccer.stadium.go.detail?team=" + team;
}

function stadiumBasketball() {
	location.href = "basketball.go";
}

function basketballStadiumGo() {
	location.href = "basketball.stadium.go.detail?team=" + team;
}

function stadiumVolleyball() {
	location.href = "volleyball.go";
}

function volleyballStadiumGo() {
	location.href = "volleyball.stadium.go.detail?team=" + team;
}

function stadium_map() {
	baseballSetVal();
	soccerSetVal();
	basketballSetVal();
	volleyballSetVal();
	var mapContainer = document.getElementById('map'), 
	mapOption = {
	    center: new kakao.maps.LatLng(lat,lon), 
	    level: 3 
	};
	var map = new kakao.maps.Map(mapContainer, mapOption);
	var markerPosition  = new kakao.maps.LatLng(lat,lon); 
	var marker = new kakao.maps.Marker({
		position: markerPosition
		});
	marker.setMap(map);
	iwContent;
	iwPosition = new kakao.maps.LatLng(lat,lon);
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
}

function baseballSetVal() {
	const url = new URL(location.href);
	const urlParams = url.searchParams;
	let team = urlParams.get("team");
	let teamImg;
	let reserveBtn = document.querySelector("#reserveBtn");
	let reserveUrl;
	console.log(team);
	switch (team) {
	case "ssg":
		teamImg = '/.resources/files/stadium/baseball/seating_chart/ssg.png';
		//reserveUrl = '';
		lat = 37.436998685442084;
		lon = 126.69327612453377;
		iwContent = '<div style="padding:5px;"> 인천SSG랜더스필드 <br><a href="https://map.kakao.com/link/map/인천 SSG 랜더스필드,37.436998685442084,126.69327612453377" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/인천 SSG 랜더스필드,37.436998685442084,126.69327612453377" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kiwoom":
		//teamImg = "이미지 경로";
		reserveUrl = 'https://ticket.interpark.com/Contents/Sports/GoodsInfo?SportsCode=07001&TeamCode=PB003';
		lat = 37.4982338495579;
		lon = 126.867104761712;
		iwContent = '<div style="padding:5px;"> 고척 스카이돔 <br><a href="https://map.kakao.com/link/map/고척 스카이돔,37.4982338495579,126.867104761712" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/고척 스카이돔,37.4982338495579,126.867104761712" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "lg":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		lat = 37.5121513808403;
		lon = 127.071909507224;
		iwContent = '<div style="padding:5px;">서울종합운동장야구장<br><a href="https://map.kakao.com/link/map/서울종합운동장 야구장,37.5121513808403,127.071909507224" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/서울종합운동장 야구장,37.5121513808403,127.071909507224" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kt":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		lat = 37.2997302532973;
		lon = 127.009772045935;
		iwContent = '<div style="padding:5px;"> 수원케이티위즈파크 <br><a href="https://map.kakao.com/link/map/수원 케이티 위즈 파크,37.2997302532973,127.009772045935" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/수원 케이티 위즈 파크,37.2997302532973,127.009772045935" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kia":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "nc":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "samsung":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "lotte":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "doosan":
		//teamImg = "이미지 경로";
		reserveUrl = 'https://ticket.interpark.com/Contents/Sports/GoodsInfo?SportsCode=07001&TeamCode=PB004';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "hanwha":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;

	default:
		break;
	}	
	reserveBtn.addEventListener("click", function() {
		window.open(reserveUrl);
	})
	
}

/* 축구 */
function soccerSetVal() {
	const url = new URL(location.href);
	const urlParams = url.searchParams;
	let team = urlParams.get("team");
	let teamImg;
	let reserveBtn = document.querySelector("#reserveBtn");
	let reserveUrl;
	console.log(team);
	switch (team) {
	case "ssg":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "kiwoom":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "lg":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "kt":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "kia":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "nc":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "samsung":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "lotte":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "doosan":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "hanwha":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;

	default:
		break;
	}	
	reserveBtn.addEventListener("click", function() {
		window.open(reserveUrl);
	})
	
}
/* 농구 */
function basketballSetVal() {
	const url = new URL(location.href);
	const urlParams = url.searchParams;
	let team = urlParams.get("team");
	let teamImg;
	let reserveBtn = document.querySelector("#reserveBtn");
	let reserveUrl;
	console.log(team);
	switch (team) {
	case "kbl":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "kogas":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "kt":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "samsung":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "sk":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "kgc":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "hyundai":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "db":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "kcc":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "kcc2":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "lg":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "bnk":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "hana":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "won":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "samsung2":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "shinhan":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "kb":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	default:
		break;
	}	
	reserveBtn.addEventListener("click", function() {
		window.open(reserveUrl);
	})
	
}
/* 배구 */
function volleyballSetVal() {
	const url = new URL(location.href);
	const urlParams = url.searchParams;
	let team = urlParams.get("team");
	let teamImg;
	let reserveBtn = document.querySelector("#reserveBtn");
	let reserveUrl;
	console.log(team);
	switch (team) {
	case "ssg":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "kiwoom":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "lg":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "kt":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "kia":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "nc":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "samsung":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "lotte":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "doosan":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;
	case "hanwha":
		//teamImg = "이미지 경로";
		//reserveUrl = '';
		//lat = ;
		//lon = ;
		//iwContent =	'';
		break;

	default:
		break;
	}	
	reserveBtn.addEventListener("click", function() {
		window.open(reserveUrl);
	})
	
}