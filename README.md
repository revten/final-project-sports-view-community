# TeamMiracleProjectSports
## 📌팀명 : Miracle ✨

## 📌소개
대한민국 4대 스포츠 축구, 야구, 농구, 배구 경기들을 관람하고 싶은데 예매를 할 경우 좌석 자리가<br>
실제로 어떻게 구성 되었는지 좌석도 와 구장 현장 사진을 제공해 주는 사이트는 흔하지 않다<br>
이런 스포츠 팬들의 니즈를 충족시켜주며 스포츠 팬들의 구단(팀)의 이슈 소통 소식 후기 등을 통해<br>
소통의 공간을 만들었고 스포츠 팬 들을 위한 웹사이트를 제작 하였다<br>
[아이디어 참고사이트](https://myseatcheck.com/)

## ⚾주요기능
* **Sight View**
  * 경기 좌석 구장 사진은 switch 문으로 값을 세팅 해주었고 구장현장사진을 보여주는 기능은 mouseover 함수를 이용해 사진 좌표값을 설정해서 사진이 띄어주게 설정함<br>
  * 예매하러가기 기능은 js를 사용해 window.open함수를 사용하여 구장 사이트에 있는 예매목록에 사이트 링크를 걸어놨고 하단에 있는 지도는 카카오맵 API를 이용해 구장 마다 값세팅을 해주어 구장 위치를 알 수 있게 표시 해놓음<br>
* **The Fan**
  * 새글쓰기에 ck에디터를 이용해 게시판을 사용하며 조회수 댓글 기능과 검색기능을 제공<br>
* **News**
  * 네이버 검색 api를 가져와서 카테고리를 뉴스로 설정하고 검색키워드에 스포츠이름을 넣어서
    나온 정보들을 each문을 사용해 element.innerHTML으로 jsp에 보내줘 뉴스가 나오는 기능 제공
* **Login**
  * 카카오, 네이버, 구글 로그인 API를 가져와 소셜로그인 제공함    
 
## ⚽기술스텍
<img src="https://img.shields.io/badge/eclipse-2C2255?style=for-the-badge&logo=eclipse&logoColor=white"> <img src="https://img.shields.io/badge/vs code-0066CC?style=for-the-badge&logo=vscode&logoColor=white"> <img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white"> <img src="https://img.shields.io/badge/sourcetree-blue?style=for-the-badge&logo=sourcetree&logoColor=white"> <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/apache tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black"> 


<img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=JAVA&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white"> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> <img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/ajax-1572B6?style=for-the-badge&logo=ajax&logoColor=white"> <img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white"> <img src="https://img.shields.io/badge/mybatis-black?style=for-the-badge&logo=mybatis&logoColor=white"> <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> 

<img src="https://img.shields.io/badge/figma-black?style=for-the-badge&logo=figma&logoColor=white"> <img src="https://img.shields.io/badge/notion-000000?style=for-the-badge&logo=notion&logoColor=white"> <img src="https://img.shields.io/badge/discord-5865F2?style=for-the-badge&logo=discord&logoColor=white">

## 🧑담당업무
* 팀장 김태형 : 총괄, Main페이지, WITH페이지, REVIEW페이지, DB설계
* 팀원 임형규 : Login, SIGHT페이지, THE FAN 페이지
* 팀원 송준우 : EVENT 페이지, NEWS 페이지, 지도API
* 팀원 정권 : THE FAN 페이지, My페이지, 자료수집

## 🏐ERD
![DB_설계](https://user-images.githubusercontent.com/97932245/215464069-100780fa-216c-428f-bb07-8783b07059c0.jpg)

## 🏀View
![view설게_1](https://user-images.githubusercontent.com/97932245/215462904-4746b0c1-bb2c-4b9f-ba35-85ad1080e296.jpg)
![view설게_2](https://user-images.githubusercontent.com/97932245/215463839-533bb48d-78c1-4092-8f1b-4c600d652f92.jpg)
## 📌기능 코드
### 카카오맵 API 
```javascript
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

야구부분
function baseballSetVal() {
	const url = new URL(location.href);
	const urlParams = url.searchParams;
	let team = urlParams.get("team");
	let reserveBtn = document.querySelector("#reserveBtn");
	let reserveUrl;
	console.log(team);
	switch (team) {
	case "ssg":
		reserveUrl = 'http://www.ssglanders.com/game/ticket';
		lat = 37.436998685442084;
		lon = 126.69327612453377;
		iwContent = '<div style="padding:10px;"> 인천SSG랜더스필드 <br><a href="https://map.kakao.com/link/map/인천 SSG 랜더스필드,37.436998685442084,126.69327612453377" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/인천 SSG 랜더스필드,37.436998685442084,126.69327612453377" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kiwoom":
		reserveUrl = 'https://www.heroesbaseball.co.kr/ticket/normal/viewCharge.do';
		lat = 37.4982338495579;
		lon = 126.867104761712;
		iwContent = '<div style="padding:10px;"> 고척 스카이돔 <br><a href="https://map.kakao.com/link/map/고척 스카이돔,37.4982338495579,126.867104761712" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/고척 스카이돔,37.4982338495579,126.867104761712" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "lg":
		reserveUrl = 'https://www.lgtwins.com/service/html.ncd?baRs=OUT_DS&view=%2Fpc_twins%2Fticket%2Fticketbuy&actID=BR_RetrieveTicketing';
		lat = 37.5121513808403;
		lon = 127.071909507224;
		iwContent = '<div style="padding:10px;">서울종합운동장야구장<br><a href="https://map.kakao.com/link/map/서울종합운동장 야구장,37.5121513808403,127.071909507224" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/서울종합운동장 야구장,37.5121513808403,127.071909507224" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kt":
		reserveUrl = 'https://www.ktwiz.co.kr/ticket/reservation';
		lat = 37.2997302532973;
		lon = 127.009772045935;
		iwContent = '<div style="padding:10px;"> 수원케이티위즈파크 <br><a href="https://map.kakao.com/link/map/수원 케이티 위즈 파크,37.2997302532973,127.009772045935" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/수원 케이티 위즈 파크,37.2997302532973,127.009772045935" style="color:blue" target="_blank">길찾기</a></div>';
		break;
	case "kia":
		reserveUrl = 'https://tigers.co.kr';
		lat = 35.16820922209541;
		lon = 126.88911206152956;
		iwContent = '<div style="padding:10px;">기아 챔피언스 필드 <br><a href="https://map.kakao.com/link/map/기아 챔피언스 필드,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/기아 챔피언스 필드,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';		
		break;
	case "nc":
		reserveUrl = 'https://www.ncdinos.com';
		lat = 35.222421136924;
		lon = 128.58208582293415;
		iwContent = '<div style="padding:10px;">창원NC파크 <br><a href="https://map.kakao.com/link/map/창원NC파크,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/창원NC파크,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';		
		break;
	case "samsung":
		reserveUrl = 'https://www.samsunglions.com/score/score_4_7.asp';
		lat = 35.8410595632468;
		lon = 128.681659448344;
		iwContent = '<div style="padding:10px;">대구삼성라이온즈파크 <br><a href="https://map.kakao.com/link/map/대구삼성라이온즈파크,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/대구삼성라이온즈파크,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';		
		break;
	case "lotte":
		reserveUrl = 'https://www.giantsclub.com/html/?pcode=339';
		lat = 35.194017568250274;
		lon = 129.06154402103502;
		iwContent = '<div style="padding:10px;">사직야구장 <br><a href="https://map.kakao.com/link/map/사직야구장,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/사직야구장,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';		
		break;
	case "doosan":
		reserveUrl = 'https://www.doosanbears.com/season/ticket';
		lat = 37.5121513808403;
		lon = 127.071909507224;
		iwContent = '<div style="padding:10px;">서울종합운동장야구장 <br><a href="https://map.kakao.com/link/map/서울종합운동장야구장,'+lat+','+lon+'"style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/서울종합운동장야구장,'+lat+','+lon+'" style="color:blue" target="_blank">길찾기</a></div>';		
		break;
	case "hanwha":
		reserveUrl = 'https://www.hanwhaeagles.co.kr/ticketInfo.do';
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


```


