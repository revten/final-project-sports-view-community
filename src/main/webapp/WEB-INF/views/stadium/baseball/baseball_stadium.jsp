<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div id="baseball_club_area">
		<div id="baseball_club">
			<div id="baseball_club_one">
				<div id="landers">
					<a style="cursor: pointer" onclick="baseballStadiumGo('ssg')">
						<img style="width: 100px; cursor: pointer"
						src=resources/files/stadium/baseball/ssg_landers.svg>
					</a>
				</div>
				<div id="kiwoom">
					<a style="cursor: pointer" onclick="baseballStadiumGo('kiwoom')">
						<img style="width: 100px; cursor: pointer"
						src=resources/files/stadium/baseball/kiwoom.svg>
					</a>
				</div>
				<div id="twins">
					<a style="cursor: pointer" onclick="baseballStadiumGo('lg')"> <img
						style="width: 100px; cursor: pointer"
						src=resources/files/stadium/baseball/lg_twins.svg>
					</a>
				</div>
				<div id="wiz">
					<a style="cursor: pointer" onclick="baseballStadiumGo('kt')"> <img
						style="width: 100px; cursor: pointer"
						src=resources/files/stadium/baseball/kt_wiz.svg>
					</a>
				</div>
			</div>
			<div id="baseball_club_two">
				<div id="tigers">
					<a style="cursor: pointer" onclick="baseballStadiumGo('kia')">
						<img style="width: 100px"
						src=resources/files/stadium/baseball/kia_tigers.svg>
					</a>
				</div>
				<div id="dinos">
					<a style="cursor: pointer" onclick="baseballStadiumGo('nc')"> <img
						style="width: 100px"
						src=resources/files/stadium/baseball/nc_dinos.svg>
					</a>
				</div>
				<div id="lions">
					<a style="cursor: pointer" onclick="baseballStadiumGo('samsung')">
						<img style="width: 100px"
						src=resources/files/stadium/baseball/samsung_lions.svg>
					</a>
				</div>
				<div id="giants">
					<a style="cursor: pointer" onclick="baseballStadiumGo('lotte')">
						<img style="width: 100px"
						src=resources/files/stadium/baseball/lotte_giants.svg>
					</a>
				</div>
			</div>
			<div id="baseball_club_three">
				<div id="bears">
					<a style="cursor: pointer" onclick="baseballStadiumGo('doosan')">
						<img style="width: 100px"
						src=resources/files/stadium/baseball/doosan_bears.svg>
					</a>
				</div>
				<div id="eagles">
					<a style="cursor: pointer" onclick="baseballStadiumGo('hanwha')">
						<img style="width: 100px"
						src=resources/files/stadium/baseball/hanwha_eagles.svg>
					</a>
				</div>
				<div style="width: 200px; visibility: hidden"></div>
				<div style="width: 200px; visibility: hidden"></div>
			</div>
		</div>
	</div>
	  <h3> Unsplash.it </h3>
      <div class="carousel">
        <a class="carousel-item" href="#one!"><img src="https://unsplash.it/200/300/?random"></a>
        <a class="carousel-item" href="#two!"><img src="https://unsplash.it/200/300/?random"></a>
        <a class="carousel-item" href="#three!"><img src="https://unsplash.it/300/300/?random"></a>
        <a class="carousel-item" href="#four!"><img src="https://unsplash.it/g/200/300/?random"></a>
        <a class="carousel-item" href="#five!"><img src="https://unsplash.it/200/250/?random"></a>
      </div>
	   <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>

    <script type="text/javascript">
    $( document ).ready(function() {
       $('.carousel').carousel();
    });

    </script>
</body>
</html>