/* 야구 */
function stadiumBaseball() {
	location.href = "baseball.go";
}

function baseballStadiumGo(team) {
	location.href = "baseball.stadium.go.detail?team=" + team;
}

function stadium_map() {
	baseballSetVal();
	soccerSetVal();
	basketballSetVal();
	volleyballSetVal();
	
	var mapContainer = document.getElementById('map'), mapOption = {
		center : new kakao.maps.LatLng(lat, lon),
		level : 3
	};
	var map = new kakao.maps.Map(mapContainer, mapOption);
	var markerPosition = new kakao.maps.LatLng(lat, lon);
	var marker = new kakao.maps.Marker({
		position : markerPosition
	});
	marker.setMap(map);
	iwContent;
	iwPosition = new kakao.maps.LatLng(lat, lon);
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
	let reserveBtn = document.querySelector("#reserveBtn");
	let reserveUrl;
	console.log(team);
	switch (team) {
	case "ssg":
		//reserveUrl = '';
		lat = 37.436998685442084;
		lon = 126.69327612453377;
		iwContent = '<div style="padding:10px;"> 인천SSG랜더스필드 <br><a href="https://map.kakao.com/link/map/인천 SSG 랜더스필드,37.436998685442084,126.69327612453377" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/인천 SSG 랜더스필드,37.436998685442084,126.69327612453377" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kiwoom":
		reserveUrl = 'https://ticket.interpark.com/Contents/Sports/GoodsInfo?SportsCode=07001&TeamCode=PB003';
		lat = 37.4982338495579;
		lon = 126.867104761712;
		iwContent = '<div style="padding:10px;"> 고척 스카이돔 <br><a href="https://map.kakao.com/link/map/고척 스카이돔,37.4982338495579,126.867104761712" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/고척 스카이돔,37.4982338495579,126.867104761712" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "lg":
		// reserveUrl = '';
		lat = 37.5121513808403;
		lon = 127.071909507224;
		iwContent = '<div style="padding:10px;">서울종합운동장야구장<br><a href="https://map.kakao.com/link/map/서울종합운동장 야구장,37.5121513808403,127.071909507224" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/서울종합운동장 야구장,37.5121513808403,127.071909507224" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kt":
		// reserveUrl = '';
		lat = 37.2997302532973;
		lon = 127.009772045935;
		iwContent = '<div style="padding:10px;"> 수원케이티위즈파크 <br><a href="https://map.kakao.com/link/map/수원 케이티 위즈 파크,37.2997302532973,127.009772045935" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/수원 케이티 위즈 파크,37.2997302532973,127.009772045935" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kia":
		// reserveUrl = '';
		lat = 35.16820922209541;
		lon = 126.88911206152956;
		iwContent = '<div style="padding:10px;">기아 챔피언스 필드 <br><a href="https://map.kakao.com/link/map/기아 챔피언스 필드,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/기아 챔피언스 필드,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';		
		break;
	case "nc":
		// reserveUrl = '';
		lat = 35.222421136924;
		lon = 128.58208582293415;
		iwContent = '<div style="padding:10px;">창원NC파크 <br><a href="https://map.kakao.com/link/map/창원NC파크,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/창원NC파크,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';		
		break;
	case "samsung":
		// reserveUrl = '';
		lat = 35.8410595632468;
		lon = 128.681659448344;
		iwContent = '<div style="padding:10px;">대구삼성라이온즈파크 <br><a href="https://map.kakao.com/link/map/대구삼성라이온즈파크,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/대구삼성라이온즈파크,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';		
		break;
	case "lotte":
		// reserveUrl = '';
		lat = 35.194017568250274;
		lon = 129.06154402103502;
		iwContent = '<div style="padding:10px;">사직야구장 <br><a href="https://map.kakao.com/link/map/사직야구장,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/사직야구장,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';		
		break;
	case "doosan":
		reserveUrl = 'https://ticket.interpark.com/Contents/Sports/GoodsInfo?SportsCode=07001&TeamCode=PB004';
		lat = 37.5121513808403;
		lon = 127.071909507224;
		iwContent = '<div style="padding:10px;">서울종합운동장야구장 <br><a href="https://map.kakao.com/link/map/서울종합운동장야구장,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/서울종합운동장야구장,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';		
		break;
	case "hanwha":
		// reserveUrl = '';
		lat = 36.3170804578898;
		lon = 127.429163729933;
		iwContent = '<div style="padding:10px;">대전한화생명이글스파크 <br><a href="https://map.kakao.com/link/map/대전한화생명이글스파크,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/대전한화생명이글스파크,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';		
		break;

	default:
		break;
	}
	reserveBtn.addEventListener("click", function() {
		window.open(reserveUrl);
	})

}

/* 축구 */
function stadiumSoccer() {
	location.href = "soccer.go";
}

function soccerStadiumGo(team) {
	location.href = "soccer.stadium.go.detail?team=" + team;
}

function soccerSetVal() {
	const url = new URL(location.href);
	const urlParams = url.searchParams;
	let team = urlParams.get("team");
	let reserveBtn = document.querySelector("#reserveBtn");
	let reserveUrl;
	console.log(team);
	switch (team) {
	case "gangwon":
		// reserveUrl = '';
		 lat = 37.77365338873246;
		 lon = 128.8975709883576;
		 iwContent = '<div style="padding:10px;">강릉종합운동장 <br><a href="https://map.kakao.com/link/map/강릉종합운동장,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/강릉종합운동장,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "gwangju":
		// reserveUrl = '';
		 lat = 35.13092412328473;
		 lon = 126.87489926605762;
		 iwContent = '<div style="padding:10px;">광주축구전용경기장 <br><a href="https://map.kakao.com/link/map/광주축구전용경기장,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/광주축구전용경기장,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "daegu":
		// reserveUrl = '';
		 lat = 35.881249474718;
		 lon = 128.588242697948;
		 iwContent = '<div style="padding:10px;">DGB대구은행 파크 <br><a href="https://map.kakao.com/link/map/DGB대구은행 파크,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/DGB대구은행 파크,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "djhc":
		// reserveUrl = '';
		 lat = 36.365171091983576;
		 lon = 127.32513866896132;
		 iwContent = '<div style="padding:10px;">대전월드컵경기장 <br><a href="https://map.kakao.com/link/map/대전월드컵경기장,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/대전월드컵경기장,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "seoul":
		// reserveUrl = '';
		 lat = 37.5681599278475;
		 lon = 126.89723246166358;
		 iwContent = '<div style="padding:10px;">서울월드컵경기장 <br><a href="https://map.kakao.com/link/map/서울월드컵경기장,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/서울월드컵경기장,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "suwon":
		// reserveUrl = '';
		 lat = 37.2864976648853;
		 lon = 127.036920677186;
		 iwContent = '<div style="padding:10px;">수원월드컵경기장 <br><a href="https://map.kakao.com/link/map/수원월드컵경기장,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/수원월드컵경기장,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "suwon2":
		// reserveUrl = '';
		 lat = 37.297755038633156;
		 lon = 127.01136094698745;
		 iwContent = '<div style="padding:10px;">수원종합운동장 <br><a href="https://map.kakao.com/link/map/수원종합운동장,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/수원종합운동장,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "uh":
		// reserveUrl = '';
		 lat = 35.535270194906;
		 lon = 129.259531018386;
		 iwContent = '<div style="padding:10px;">울산문수축구경기장 <br><a href="https://map.kakao.com/link/map/울산문수축구경기장,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/울산문수축구경기장,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "incheon":
		// reserveUrl = '';
		 lat = 37.4661006825387;
		 lon = 126.64300229167716;
		 iwContent = '<div style="padding:10px;">인천축구전용경기장 <br><a href="https://map.kakao.com/link/map/인천축구전용경기장,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/인천축구전용경기장,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "hyundai":
		// reserveUrl = '';
		 lat = 35.867998689310745;
		 lon = 127.06449519014078;
		 iwContent = '<div style="padding:10px;">전주월드컵경기장 <br><a href="https://map.kakao.com/link/map/전주월드컵경기장,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/전주월드컵경기장,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "jeju":
		// reserveUrl = '';
		 lat = 33.246151627502;
		 lon = 126.509381090559;
		 iwContent = '<div style="padding:10px;">제주월드컵경기장 <br><a href="https://map.kakao.com/link/map/제주월드컵경기장,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/제주월드컵경기장,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "steelers":
		// reserveUrl = '';
		 lat = 35.9977222824466;
		 lon = 129.38441519469;
		 iwContent = '<div style="padding:10px;">포항스틸야드 <br><a href="https://map.kakao.com/link/map/포항스틸야드,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/포항스틸야드,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	default:
		break;
	}
	reserveBtn.addEventListener("click", function() {
		window.open(reserveUrl);
	})

}
/* 농구 */
function stadiumBasketball() {
	location.href = "basketball.go";
}

function basketballStadiumGo(team) {
	location.href = "basketball.stadium.go.detail?team=" + team;
}

function basketballSetVal() {
	const url = new URL(location.href);
	const urlParams = url.searchParams;
	let team = urlParams.get("team");
	let reserveBtn = document.querySelector("#reserveBtn");
	let reserveUrl;
	console.log(team);
	switch (team) {
	case "kbl":
		// reserveUrl = '';
		 lat = 37.6745773792369;
		 lon = 126.741820500325;
		 iwContent = '<div style="padding:10px;">고양체육관 <br><a href="https://map.kakao.com/link/map/고양체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/고양체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kogas":
		// reserveUrl = '';
		 lat = 35.8934361897145;
		 lon = 128.603454695703;
		 iwContent = '<div style="padding:10px;">대구실내체육관 <br><a href="https://map.kakao.com/link/map/대구실내체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/대구실내체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kt":
		// reserveUrl = '';
		 lat = 37.276272539357;
		 lon = 126.948290984046;
		 iwContent = '<div style="padding:10px;">수원KT소닉붐아레나 <br><a href="https://map.kakao.com/link/map/수원KT소닉붐아레나,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/수원KT소닉붐아레나,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "samsung":
		// reserveUrl = '';
		 lat = 37.5161781208174;
		 lon = 127.075980950481;
		 iwContent = '<div style="padding:10px;">잠실실내체육관 <br><a href="https://map.kakao.com/link/map/잠실실내체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/잠실실내체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "sk":
		// reserveUrl = '';
		 lat = 37.51219787219792;
		 lon = 127.07537857414752;
		 iwContent = '<div style="padding:10px;">잠실학생체육관 <br><a href="https://map.kakao.com/link/map/잠실학생체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/잠실학생체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kgc":
		// reserveUrl = '';
		 lat = 37.4050604844652;
		 lon = 126.94845109346;
		 iwContent = '<div style="padding:10px;">안양실내체육관 <br><a href="https://map.kakao.com/link/map/안양실내체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/안양실내체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "hyundai":
		// reserveUrl = '';
		 lat = 35.562344053715;
		 lon = 129.350433515541;
		 iwContent = '<div style="padding:10px;">울산동천체육관 <br><a href="https://map.kakao.com/link/map/울산동천체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/울산동천체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "db":
		// reserveUrl = '';
		 lat = 37.33904735282294;
		 lon = 127.94206507436623;
		 iwContent = '<div style="padding:10px;">원주종합체육관 <br><a href="https://map.kakao.com/link/map/원주종합체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/원주종합체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kcc":
		// reserveUrl = '';
		 lat = 35.8443011580978;
		 lon = 127.129248627871;
		 iwContent = '<div style="padding:10px;">전주실내체육관 <br><a href="https://map.kakao.com/link/map/전주실내체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/전주실내체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kcc2":
		// reserveUrl = '';
		 lat = 35.9637869096188;
		 lon = 126.749087028188;
		 iwContent = '<div style="padding:10px;">군산월명체육관 <br><a href="https://map.kakao.com/link/map/군산월명체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/군산월명체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "lg":
		// reserveUrl = '';
		 lat = 35.2327367366309;
		 lon = 128.666283189427;
		 iwContent = '<div style="padding:10px;">창원실내체육관 <br><a href="https://map.kakao.com/link/map/창원실내체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/창원실내체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "bnk":
		// reserveUrl = '';
		 lat = 35.1924185304639;
		 lon = 129.0607198031;
		 iwContent = '<div style="padding:10px;">사직실내체육관 <br><a href="https://map.kakao.com/link/map/사직실내체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/사직실내체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "hana":
		// reserveUrl = '';
		 lat = 37.513420835860586;
		 lon = 126.7632385988074;
		 iwContent = '<div style="padding:10px;">부천 실내 체육관 <br><a href="https://map.kakao.com/link/map/부천 실내 체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/부천 실내 체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "won":
		// reserveUrl = '';
		 lat = 36.76952716220382;
		 lon = 127.02446247383006;
		 iwContent = '<div style="padding:10px;">아산이순신체육관 <br><a href="https://map.kakao.com/link/map/아산이순신체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/아산이순신체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "samsung2":
		// reserveUrl = '';
		 lat = 37.23740975113005;
		 lon = 127.21341259333057;
		 iwContent = '<div style="padding:10px;">용인실내체육관 <br><a href="https://map.kakao.com/link/map/용인실내체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/용인실내체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "shinhan":
		// reserveUrl = '';
		 lat = 37.4662778536466;
		 lon = 126.640813029151;
		 iwContent = '<div style="padding:10px;">인천도원체육관 <br><a href="https://map.kakao.com/link/map/인천도원체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/인천도원체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kb":
		// reserveUrl = '';
		 lat = 36.63657016468344;
		 lon = 127.47344511906337;
		 iwContent = '<div style="padding:10px;">청주실내체육관 <br><a href="https://map.kakao.com/link/map/청주실내체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/청주실내체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	default:
		break;
	}
	reserveBtn.addEventListener("click", function() {
		window.open(reserveUrl);
	})

}
/* 배구 */
function stadiumVolleyball() {
	location.href = "volleyball.go";
}

function volleyballStadiumGo(team) {
	location.href = "volleyball.stadium.go.detail?team=" + team;
}

function volleyballSetVal() {
	const url = new URL(location.href);
	const urlParams = url.searchParams;
	let team = urlParams.get("team");
	let reserveBtn = document.querySelector("#reserveBtn");
	let reserveUrl;
	console.log(team);
	switch (team) {
	case "kal":
		// reserveUrl = '';
		 lat = 37.5339610690414;
		 lon = 126.748058093851;
		 iwContent = '<div style="padding:10px;">계양체육관 <br><a href="https://map.kakao.com/link/map/계양체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/계양체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kb":
		// reserveUrl = '';
		 lat = 37.7600237892506;
		 lon = 127.0280079284;
		 iwContent = '<div style="padding:10px;">의정부실내체육관 <br><a href="https://map.kakao.com/link/map/의정부실내체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/의정부실내체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kepco":
		// reserveUrl = '';
		 lat = 37.2983643371609;
		 lon = 127.009072589574;
		 iwContent = '<div style="padding:10px;">수원실내체육관 <br><a href="https://map.kakao.com/link/map/수원실내체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/수원실내체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "won":
		// reserveUrl = '';
		 lat = 37.558178171371;
		 lon = 127.006808757736;
		 iwContent = '<div style="padding:10px;">장충체육관 <br><a href="https://map.kakao.com/link/map/장충체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/장충체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "ok":
		// reserveUrl = '';
		 lat = 37.3009660228191;
		 lon = 126.868603113729;
		 iwContent = '<div style="padding:10px;">상록수체육관 <br><a href="https://map.kakao.com/link/map/상록수체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/상록수체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "samsung":
		// reserveUrl = '';
		 lat = 34.8511298443812;
		 lon = 128.429011387714;
		 iwContent = '<div style="padding:10px;">충무체육관 <br><a href="https://map.kakao.com/link/map/충무체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/충무체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "hyundai":
		// reserveUrl = '';
		 lat = 36.82087703646577;
		 lon = 127.11422320390537;
		 iwContent = '<div style="padding:10px;">유관순체육관 <br><a href="https://map.kakao.com/link/map/유관순체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/유관순체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "hyundai2":
		// reserveUrl = '';
		 lat = 37.2983643371609;
		 lon = 127.009072589574;
		 iwContent = '<div style="padding:10px;">수원실내체육관 <br><a href="https://map.kakao.com/link/map/수원실내체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/수원실내체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "hipass":
		// reserveUrl = '';
		 lat = 36.1429855290724;
		 lon = 128.08683885683;
		 iwContent = '<div style="padding:10px;">김천실내체육관 <br><a href="https://map.kakao.com/link/map/김천실내체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/김천실내체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "gs":
		// reserveUrl = '';
		 lat = 37.558178171371;
		 lon = 127.006808757736;
		 iwContent = '<div style="padding:10px;">장충체육관 <br><a href="https://map.kakao.com/link/map/장충체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/장충체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kgc":
		// reserveUrl = '';
		 lat = 34.8511298443812;
		 lon = 128.429011387714;
		 iwContent = '<div style="padding:10px;">충무체육관 <br><a href="https://map.kakao.com/link/map/충무체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/충무체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "ibk":
		// reserveUrl = '';
		 lat = 37.13830760228957;
		 lon = 126.92247625610617;
		 iwContent = '<div style="padding:10px;">화성실내체육관 <br><a href="https://map.kakao.com/link/map/화성실내체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/화성실내체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "heungkuk":
		// reserveUrl = '';
		 lat = 37.5077372629283;
		 lon = 126.737627861133;
		 iwContent = '<div style="padding:10px;">인천삼산월드체육관 <br><a href="https://map.kakao.com/link/map/인천삼산월드체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/인천삼산월드체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "gwangju":
		// reserveUrl = '';
		 lat = 35.13537187069592;
		 lon = 126.87886447703993;
		 iwContent = '<div style="padding:10px;">염주종합체육관 <br><a href="https://map.kakao.com/link/map/염주종합체육관,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/염주종합체육관,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	default:
		break;
	}
	reserveBtn.addEventListener("click", function() {
		window.open(reserveUrl);
	})

}