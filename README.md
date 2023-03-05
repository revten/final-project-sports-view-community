# Sports View Community Site
## ✨Team Miracle✨

<img width="70%" src="https://user-images.githubusercontent.com/109392408/222941172-e5b38119-28fe-4004-8fc0-752ee8e79ef1.gif"/>
<br/><br/>

## 📌Intro
우리는 보통 스포츠 경기를 관람하기 위해 티켓사이트에서 예매를 주로 진행합니다.<br>
그러나 경기장마다 좌석별로 어떤 뷰를 보여주는지 어떤 느낌일지 제대로 알기 어렵습니다.<br>
우연히 배구경기장 좌석별로 직접 찍은 사진을 보여주는 사이트를 발견하였고, <br>
이 사이트를 기반으로 커뮤니티형 사이트로 확장시켜 구현해보자는 목표를 설정하였습니다.<br>
<br>
실제로 가서 느낄 현장감을 미리 전달하여 예매에 도움을 주고 후기를 공유할 공간을 마련하였고<br>
자유로운 소통과 함께 구단의 소식도 쉽게 접할 수 있는 사이트를 구현키로 하였습니다.<br>
https://myseatcheck.com의 초기 아이디어임을 다시한번 밝혀두며 오로지 학습용 프로젝트로 제작하였습니다.
<br/><br/><br/><br/>

## 📌기본정보
### 1. 진행기간
2023-01-08 ~ 2023-01-31
<br/><br/>

### 2.프로젝트 진행과정 및 문서
* 배운 내용에 충실하며 기획단계부터 실제 회사에서 프로젝트를 진행한다는 자세로 임하였습니다.
* [팀홈페이지(노션)-click](https://dusty-mandible-fdc.notion.site/Team_Miracle-e577e65b76a7478f90e49c5b5507c894)<br>
: 노션의 팀스페이스를 활용하여 팀의 프로젝트 홈페이지 개념으로 활용하였습니다.<br>
  (프로젝트 기획 및 진행계획, 회의록, 사이트맵, IA다이아그램, 정보공유, 규칙, 팀정보 등)
* [발표PPT-click](https://github.com/RevTK/final-project-sports-view-community/blob/master/Miracleppt.pptx)<br>
: 웹사이트 사진과 개발과정 및 기능에 대해 간단한 소개를 보실 수 있습니다.
<br/><br/>

### 3.사용스텍
<img src="https://img.shields.io/badge/eclipse-2C2255?style=for-the-badge&logo=eclipse&logoColor=white"> <img src="https://img.shields.io/badge/vs code-0066CC?style=for-the-badge&logo=vscode&logoColor=white"> <img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white"> <img src="https://img.shields.io/badge/sourcetree-blue?style=for-the-badge&logo=sourcetree&logoColor=white"> <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/apache tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black"> 


<img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=JAVA&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white"> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> <img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/ajax-1572B6?style=for-the-badge&logo=ajax&logoColor=white"> <img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white"> <img src="https://img.shields.io/badge/mybatis-black?style=for-the-badge&logo=mybatis&logoColor=white"> <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> 

<img src="https://img.shields.io/badge/figma-black?style=for-the-badge&logo=figma&logoColor=white"> <img src="https://img.shields.io/badge/notion-000000?style=for-the-badge&logo=notion&logoColor=white"> <img src="https://img.shields.io/badge/discord-5865F2?style=for-the-badge&logo=discord&logoColor=white">
<br/><br/>

### 4.담당업무
* 팀장 김태형 : 팀관리 및 문서총괄, DB설계, css 구성/정리, 게시판 설계, 
* 팀원 임형규 : 회원가입 및 로그인, 소셜API, SIGHT페이지, THE FAN 게시판 CSS
* 팀원 송준우 : API(지도 및 뉴스), EVENT와 NEWS 페이지, 배경선수 CSS, 회원포인트
* 팀원 정권 : 마이페이지 담당, 전체자료수집, 게시판 초안 작성
<br/><br/><br/><br/>


## 📌페이지 및 메뉴별 기능

### STADIUM
  * 우리나라 스포츠 4대리그 각 구장별 페이지 마련 (52구장 좌석표, 구단 로고)
  * 구장별 페이지에서 4방향의 현장사진 확인 가능 (932개 이상 사진 수집)
  * 각 구장에 해당하는 예매하러가기 링크와 지도 위치를 넣어 편의성 도모 (카카오API)
  * 같이보러가기 글을 바로 쓸 수 있도록 설계

### WithGo
  * 경기를 함께 보러가는 글을 올릴 수 있는 공간
  * 심플한 바둑판형 게시판
    * The Fan의 게시판 CRUD 구조가 같아 샘플 게시글만 있고 CRUD 구현은 되어있지 않습니다
  
### Review
  * 경기관람 후기를 올리는 공간
  * 상단에 인기 리뷰글을 배치하여 다른 느낌의 게시판 구성
    * The Fan의 게시판 CRUD 구조가 같아 샘플 게시글만 있고 CRUD 구현은 되어있지 않습니다
  
### The Fan
  * 커뮤니티 사이트의 게시판 기본에 충실한 구성으로 CRUD 구현<br>
  * 스포츠별 게시판을 나누고 및 각 게시판별 잡담, 질문, 정보 등의 카테고리
  
### Event
  * 구단 이벤트 및 홍보할 수 있는 공간으로,
  * 대형 슬라이더에 구단의 이벤트를 등록하도록 디자인
  
### News
  * 언론사의 스포츠 뉴스를 종목별로 접할 수 있는 공간
  * 네이버 뉴스 api를 활용
  
### 마이페이지
  * 나의 가입 정보 보기 및 수정 그리고 내가 쓸 글을 확인할 수 있는 페이지
  * 글을 작성시 포인트 획득, 마이페이지에서 적립내역과 포인트 확인
  
### 회원관리
  * 회원가입
      *	일반가입과 소셜가입(네이버,구글,카카오) 회원 구분
      * 일반가입은 이메일 인증을 거쳐야만 가입 완료토록 설계
      * 소셜가입은 이메일 인증없이 추가정보 받아 가입

  * 로그인
      * 일반로그인과 소셜로그인 구분, API를 통하여 간편하게 로그인
  * 비밀번호 찾기
      * 이메일 인증을 통한 비밀번호 찾기
  * 회원정보 수정 및 탈퇴
  
### 그 외
  * 로그인후 홈화면이 아닌 보던 페이지로 이동
  * 첫 화면 접속시 전체 게시글 DB를 불러와 각 게시판 조회시 시간절약
  * 게시판 최소 7개가 필요하여 하나의 로직(BoardDAO)에서 컨트롤되도록 설계<br/>
    (각 게시판별로 DB 테이블과 DAO, Interface, Mapper를 만들며 시작했으나 삭제후 통합)
 * 글 등록시 CK4 에디터 적용
 * 게시글의 댓글 ajax 처리 / 새로고침후 자동등록방지
  *  라이브러리 사용 scrollreveal, flickity, TweenMax..
    * scrollreveal : 스크롤 내리면 화면이 나타나는 효과
    * flickity : 클릭을 떼지않고 움직여 슬라이더 이동
  * 홈화면 한정
    * 자바스크립트를 통해 화면이 일정부분 내려가면 스크롤업 버튼 효과
    * 미디어쿼리를 이용한 반응형 
  
  <br/><br/>

## 📌사이트 구조
![SiteMap](https://user-images.githubusercontent.com/109392408/215984046-90c81359-91e8-44b0-b035-d9cd642f1989.png)
<br/><br/><br/><br/>


## 📌주요구상 및 설계

### 1. IA DIAGRAM
<img src="https://user-images.githubusercontent.com/109392408/216013940-7c71cd60-f605-415a-8310-477e479e8537.png"  width="700" height="400"/><br/>
[피그마 문서 원본](https://www.figma.com/file/88oFAYgzGwmQusJZ6qw2zM/TM_Sports_IA-%2B-FLOW-Chart?node-id=0%3A1&t=cN2mjmtqNLmIzvpW-1)

### 2. 화면설계(초안)
<img src="https://user-images.githubusercontent.com/97932245/215462904-4746b0c1-bb2c-4b9f-ba35-85ad1080e296.jpg"  width="700" height="300"/>
<img src="https://user-images.githubusercontent.com/97932245/215463839-533bb48d-78c1-4092-8f1b-4c600d652f92.jpg"  width="700" height="300"/>
<br/><br/><br/><br/>

## 📌DB구조

### 1. ERD
<img src="https://user-images.githubusercontent.com/109392408/215984064-c0260cd6-5b84-47e0-9775-e56cd9f16f83.png"  width="700" height="400"/>
<br/><br/>

### 2. 주요 테이블

### *MEMBER*
COLUMN_NAME|DATA_TYPE|NULLABLE|CONSTRAINT_TYPE|
---|---|---|---|
MEMBER_ID|VARCHAR2(30 CHAR)|No|Primary Key|
MEMBER_PWD|VARCHAR2(200 CHAR)|No||
MEMBER_NICK|VARCHAR2(50 CHAR)|No||
MEMBER_AUTH_TYPE|NUMBER(1,0)|No||
MEMBER_REG_TYPE|NUMBER(1,0)|Yes||
MEMBER_REG_DATE|DATE|No||
MEMBER_REG_IP|VARCHAR2(50 CHAR)|No||
MEMBER_EMAIL|VARCHAR2(100 CHAR)|No||
MEMBER_INTRO|VARCHAR2(200 CHAR)|Yes||
CLUB_ID|NUMBER(5,0)|No|||
MEMBER_SUBS|NUMBER(1,0)|No||
MEMBER_SUBS_BEGIN|DATE|Yes||
MEMBER_SUBS_END|DATE|Yes||
MEMBER_UPDATE_DATE|DATE|Yes||
MEMBER_DATE_WITHDRAWN|DATE|Yes||
MEMBER_ADMIN|NUMBER(1,0)|Yes||

### *POST*

COLUMN_NAME|DATA_TYPE|NULLABLE|DATA_DEFAULT|CONSTRAINT_TYPE|
---|---|---|---|---|
POST_ID|NUMBER(10,0)|No||Primary Key|
POST_BOARD|NUMBER(2,0)|No||Foreign Key|
POST_MEMBER|VARCHAR2(20 CHAR)|No||Foreign Key|
POST_SPORTS|NUMBER(2,0)|Yes||Foreign Key|
POST_LEAGUE|NUMBER(3,0)|Yes||Foreign Key|
POST_CLUB|NUMBER(5,0)|Yes||Foreign Key|
POST_TITLE|VARCHAR2(100 CHAR)|No|||
POST_CATEGORY|NUMBER(1,0)|Yes|0||
POST_REG_DATE|DATE|No|||
POST_UPDATE_DATE|DATE|Yes|||
POST_IMG|VARCHAR2(100 CHAR)|Yes|||
POST_FILE|VARCHAR2(100 CHAR)|Yes|||
POST_HIT_COUNT|NUMBER(10,0)|No|0||
POST_LIKE_COUNT|NUMBER(5,0)|No|0||
POST_SCRAP_COUNT|NUMBER(5,0)|No|0||
POST_REPLY_COUNT|NUMBER(5,0)|No|0||
POST_REG_IP|VARCHAR2(100 CHAR)|No|||
POST_CONTENT|VARCHAR2(2000 BYTE)|Yes|||

<br/><br/><br/><br/>

## 📌기능별 사용코드
*(코드는 일부만 기재하였습니다)*
### 1. 팀별 경기장 좌석과 관람사진 
* 구장별 사진은 switch 문으로 값을 세팅<br>
* 사진 좌표값을 설정해서 방향별 사진을 새로운 창에서 뜨도록 설정<br>
```javascript
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
		
	// 코드가 길어지는 관계로 2팀으로 줄였습니다.
	
	default:
		break;
	}
	reserveBtn.addEventListener("click", function() {
		window.open(reserveUrl);
	})

}
```

<br/><br/>

### 2. 카카오맵 API
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

```

<br/><br/>

### 3. 회원가입 이메일 인증
```javascript
$(function() {
	$('#member_email_check').click(function() {
		let email = $('#search_member_email').val();
		console.log(email);
		let checkNum = $('#email_num');

		$.ajax({
			url : "member.email.check.do",
			type : "GET",
			dataType : "text",
			data : {
				"member_email" : email
			},
			success : function(data) {
				checkNum.attr('disabled', false);
				$('#valid').val(data);
				alert('인증번호가 전송되었습니다.')
			}
		});
	});
});
```

<br/><br/>

### 4. 게시글 조회수 및 댓글기능
* 중복조회수가 되지 않도록 설정
```java
	// 조회수
	public void postCountUpdate(HttpServletRequest req, HttpServletResponse res, PostVO p) {

		Cookie[] cookies = req.getCookies();
		int visitor = 0;

		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName());
			if (cookie.getName().equals("visit")) {
				visitor = 1;

				System.out.println("visit 통과");

				if (cookie.getValue().contains(req.getParameter("post_id"))) {
					System.out.println("visitif 통과");
				} else {
					cookie.setValue(cookie.getValue() + "-" + req.getParameter("post_id"));
					res.addCookie(cookie);

					ss.getMapper(BoardMapper.class).postCountUpdate(p);
				}
			}
		}

		if (visitor == 0) {
			Cookie cookie1 = new Cookie("visit", req.getParameter("post_id"));
			res.addCookie(cookie1);

			ss.getMapper(BoardMapper.class).postCountUpdate(p);
		}

		/*
		 * if(ss.getMapper(BoardMapper.class).postCountUpdate(p) == 1) {
		 * req.setAttribute("result", "조회수 성공"); }else { req.setAttribute("result",
		 * "조회수 실패"); }
		 */

	}
```

<br/>

* 댓글등록 - 새로고침을 하여도 등록되지 않도록 설계 등
```java
	public ResultVO regReply(HttpServletRequest req, ReplyVO rp) {
		String token = req.getParameter("token");
		// 리플등록시에 세션에 세팅해둔 토큰을 불러온다.
		String successToken = (String) req.getSession().getAttribute("successToken");
		System.out.println("token : " + token);
		
		// 리플등록 비동기 요청에 대한 대답으로 새토큰과 등록성공여부, 등록한 리플 정보를 조회해서 받은 ReplyVO를 담아줄 ResultVO 객체를 만든다.
		ResultVO resultVO = new ResultVO();

		// TokenMaker로 만든 토큰과 리플등록시에 만든 토큰을 비교한다.
		if (successToken != null && token.equals(successToken)) {
			resultVO.setResult(0);
			resultVO.setToken(token);
			System.out.println(resultVO.toString());
			return resultVO;
		}
		
		// 리플 등록시에 regIp가 not null이므로 세팅해주자
		String regIp = getClientIp(req);
		System.out.println(regIp);
		rp.setReply_reg_ip(regIp);
		
		// 리플을 등록한 사람도 세팅해주자
		AccountDTO ac = (AccountDTO) req.getSession().getAttribute("loginAccount");
		rp.setReply_member(ac.getMember_id());

		int a = ss.getMapper(BoardMapper.class).regReply(rp);
		System.out.println(a);
		if (a == -1) {
			req.setAttribute("result", "댓글쓰기 성공");
			// 생성토큰을 저장해두기
			req.getSession().setAttribute("successToken", token);
			
			// 성공한 값으로 1을 넘김
			resultVO.setResult(1);
			resultVO.setToken((String) req.getAttribute("token"));
			ReplyVO replyVO = ss.getMapper(BoardMapper.class).getReply();
			System.out.println(replyVO.toString());
			resultVO.setReplyVO(replyVO);
			System.out.println(resultVO.toString());
			return resultVO;
//			allReplyCount++;
		}
		return resultVO;

	}
```

<br/><br/>

### 5. 화면스크롤 라이브러리
```JSP
<!-- --------------- SCROLLREVEAL CDN --------------- -->
<script src="https://unpkg.com/scrollreveal"></script> 

<script> 
const srFan = ScrollReveal({
	  origin: 'left',
	  distance: '290px',
	  duration: 2400,
	  delay: 200
	  //reset: true, // Animations repeat
	})
	srFan.reveal(`.container-field`);
	srFan.reveal(`.board-main`, { origin: 'left' });
	srFan.reveal(`.app-content`, { origin: 'bottom' });
	srFan.reveal(`.fan_bg-leftTop`, { origin: 'left' });
	srFan.reveal(`.fan_bg-RightTop`, { origin: 'right' });
	srFan.reveal(`.app-container`, { origin: 'top' });
	srFan.reveal(`.`, { interval: 100 });
	</script>
```

<br/><br/>

## 팀원정보
팀원|이메일|
---|---|
김태형|trainst37@gamil.com|
임형규|frvlv6@gmail.com|
송준우|thdwnsdn98@gmail.com|
정권|jerot94@naver.com|
