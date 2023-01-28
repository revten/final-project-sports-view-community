<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/myPage/chart.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/jquery.selectric/1.10.1/selectric.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
<!--=============== [JS]===============-->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.selectric/1.10.1/jquery.selectric.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.bundle.min.js"></script>
<script src="resources/js/fan/fanBoard.js"></script>
<!-- JS링크는 맨밑에 있음!! -->
<style>
body {
	background-color: #1b2431;
	color: #202020;
	font-family: "Montserrat", "Helvetica", "Open Sans", "Arial";
	font-size: 13px;
}

a:hover {
	text-decoration: none;
}

p, figure {
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>

	<div class="chart-data">
		<div class="row">
			<div class="col-12 col-md-4">
				<div class="chart radar-chart dark">
					<div class="actions">
						<button type="button" class="btn btn-link" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">
							<i class="zmdi zmdi-more-vert"></i>
						</button>
						<div class="dropdown-menu dropdown-menu-right">
							<button class="dropdown-item" type="button">Action</button>
							<button class="dropdown-item" type="button">Another
								action</button>
							<button class="dropdown-item" type="button">Something
								else here</button>
						</div>
					</div>
					<h3 class="title">Household Expenditure</h3>
					<p class="tagline">Yearly</p>
					<canvas height="400" id="radarChartDark"></canvas>
				</div>
			</div>
			<div class="col-12 col-md-4">
				<div class="chart bar-chart light">
					<div class="actions">
						<button type="button" class="btn btn-link" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">
							<i class="zmdi zmdi-more-vert"></i>
						</button>
						<div class="dropdown-menu dropdown-menu-right">
							<button class="dropdown-item" type="button">Action</button>
							<button class="dropdown-item" type="button">Another
								action</button>
							<button class="dropdown-item" type="button">Something
								else here</button>
						</div>
					</div>
					<h3 class="title">Monthly revenue</h3>
					<p class="tagline">2015 (in thousands US$)</p>
					<canvas height="400" id="barChartHDark"></canvas>
				</div>
			</div>
			<div class="col-12 col-md-4">
				<div class="chart doughnut-chart dark">
					<div class="actions">
						<button type="button" class="btn btn-link" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">
							<i class="zmdi zmdi-more-vert"></i>
						</button>
						<div class="dropdown-menu dropdown-menu-right">
							<button class="dropdown-item" type="button">Action</button>
							<button class="dropdown-item" type="button">Another
								action</button>
							<button class="dropdown-item" type="button">Something
								else here</button>
						</div>
					</div>
					<h3 class="title">Exports of Goods</h3>
					<p class="tagline">2015 (in billion US$)</p>
					<canvas height="400" id="doughnutChartDark"></canvas>
				</div>
			</div>
		</div>
	</div>
</body>

<script>
"use strict";
class Selectize {
    constructor() {
        this.init();
    }
    init() {
        var initValue;
        $('.action-box').selectric({
            onInit: function (element) {
                initValue = $(this).val();
            },
            onChange: function (element) {
                if ($(this).val() !== initValue)
                    $(element).parents('form').submit();
            }
        });
    }
}
class Charts {
    constructor() {
        this.colors = ["#DB66AE", "#8185D6", "#89D9DF", "#E08886"];
        this.tickColor = "#757681";
        this.initRadar();
        this.initBarHorizontal();
        this.initDoughnut();
    }
    initRadar() {
        var ctxD = $('#radarChartDark'), chartData = {
            type: 'radar',
            data: {
                labels: ["Education", "Food", "Transport", "Drinks", "Other"],
                datasets: [
                    {
                        label: "2014",
                        backgroundColor: this.convertHex(this.colors[0], 20),
                        borderColor: this.colors[0],
                        borderWidth: 1,
                        pointRadius: 2,
                        data: [51, 67, 90, 31, 16],
                    },
                    {
                        label: "2015",
                        backgroundColor: this.convertHex(this.colors[1], 20),
                        borderColor: this.colors[1],
                        borderWidth: 1,
                        pointRadius: 2,
                        data: [75, 44, 19, 22, 43],
                    },
                    {
                        label: "2015",
                        backgroundColor: this.convertHex(this.colors[2], 20),
                        borderColor: this.colors[2],
                        borderWidth: 1,
                        pointRadius: 2,
                        data: [7, 14, 29, 82, 33]
                    }
                ]
            },
            options: {
                scale: {
                    pointLabels: {
                        fontColor: this.tickColor
                    },
                    ticks: {
                        display: false,
                        stepSize: 25
                    }
                },
                legend: {
                    position: "bottom",
                    labels: {
                        boxWidth: 11,
                        fontColor: this.tickColor,
                        fontSize: 11
                    }
                }
            }
        }, myDarkRadarChart = new Chart(ctxD, chartData);
    }
    initBarHorizontal() {
        var ctxD = $("#barChartHDark"), chartData = {
            type: 'horizontalBar',
            data: {
                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                datasets: [{
                        data: [27, 59, 68, 26, 79, 55, 36, 43, 44, 30, 55, 64],
                        backgroundColor: this.colors[0],
                        hoverBackgroundColor: this.convertHex(this.colors[0], 70)
                    },
                    {
                        data: [136, 23, 44, 30, 79, 55, 61, 94, 27, 59, 98, 91],
                        backgroundColor: this.colors[1],
                        hoverBackgroundColor: this.convertHex(this.colors[1], 70)
                    },
                    {
                        data: [88, 31, 87, 61, 77, 27, 59, 58, 136, 26, 79, 85],
                        backgroundColor: this.colors[2],
                        hoverBackgroundColor: this.convertHex(this.colors[2], 70)
                    }]
            },
            options: {
                barThickness: 10,
                scales: {
                    xAxes: [{
                            stacked: true,
                            ticks: {
                                fontColor: this.tickColor,
                            },
                            gridLines: {
                                drawOnChartArea: false
                            }
                        }],
                    yAxes: [{
                            stacked: true,
                            ticks: {
                                fontColor: this.tickColor,
                                min: 0,
                                max: 175,
                                stepSize: 25
                            }
                        }]
                },
                legend: {
                    display: false
                }
            }
        }, myDarkRadarChart = new Chart(ctxD, chartData);
    }
    initDoughnut() {
        var ctxD = $('#doughnutChartDark'), chartData = {
            type: 'doughnut',
            data: {
                labels: ["Brasil", "India", "China"],
                datasets: [{
                        data: [300, 50, 100],
                        borderWidth: 0,
                        backgroundColor: [
                            this.convertHex(this.colors[0], 60),
                            this.convertHex(this.colors[1], 60),
                            this.convertHex(this.colors[2], 60),
                        ],
                        hoverBackgroundColor: [
                            this.colors[0],
                            this.colors[1],
                            this.colors[2],
                        ]
                    }]
            },
            options: {
                responsive: true,
                legend: {
                    position: "bottom",
                    labels: {
                        boxWidth: 11,
                        fontColor: this.tickColor,
                        fontSize: 11
                    }
                }
            }
        }, myDarkRadarChart = new Chart(ctxD, chartData);
    }
    convertHex(hex, opacity) {
        hex = hex.replace('#', '');
        var r = parseInt(hex.substring(0, 2), 16);
        var g = parseInt(hex.substring(2, 4), 16);
        var b = parseInt(hex.substring(4, 6), 16);
        var result = 'rgba(' + r + ',' + g + ',' + b + ',' + opacity / 100 + ')';
        return result;
    }
}
new Selectize();
new Charts();
</script>
</html>