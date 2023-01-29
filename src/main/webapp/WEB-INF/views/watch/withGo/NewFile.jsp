<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 경로 맞게 수정해주기 -->
<link rel="stylesheet" href="resources/css/watch/withGo.css" />
</head>

<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="app-container">
	
		<!-- 맨위의 게시판 제목 -->
		<div class="app-content">
			
			<!-- 1번줄 헤더 -->
			<div class="app-content-header">
				<!-- 왼쪽게시판 제목 -->
				<h1 class="app-content-headerText">With Go</h1>
			</div>
			
			<!-- 2번줄 헤더 -->
			<div class="app-content-actions">
				
				<!-- 왼쪽 검색바 -->
				<input class="search-bar" placeholder="Search..." type="text">
				
				<!-- 검색바 오른쪽 메뉴들 -->
				<div class="app-content-actions-wrapper">
				
					<!-- 필터버튼 -->
					<div class="filter-button-wrapper">
						<button class="action-button filter jsFilter">
							<span>Filter</span>
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								viewBox="0 0 24 24" fill="none" stroke="currentColor"
								stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
								class="feather feather-filter">
								<polygon points="22 3 2 3 10 12.46 10 19 14 21 14 12.46 22 3" /></svg>
						</button>
						<div class="filter-menu">
							<label>Category</label> <select>
								<option>All Categories</option>
								<option>Furniture</option>
								<option>Decoration</option>
								<option>Kitchen</option>
								<option>Bathroom</option>
							</select> <label>Status</label> <select>
								<option>All Status</option>
								<option>Active</option>
								<option>Disabled</option>
							</select>
							<div class="filter-menu-buttons">
								<button class="filter-button reset">Reset</button>
								<button class="filter-button apply">Apply</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			
			
			
			<!-- 게시글 테이블 시작 -->
			<div class="products-area-wrapper tableView">
			
				<!-- 게시판 칼럼 (제목, 닉네임, 조회수 등등)-->
				<div class="products-header">
				
					<div class="product-cell image">
						Items
						<button class="sort-button">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								viewBox="0 0 512 512">
								<path fill="currentColor"
									d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z" /></svg>
						</button>
					</div>
					
					<div class="product-cell category">
						Category
						<button class="sort-button">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								viewBox="0 0 512 512">
								<path fill="currentColor"
									d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z" /></svg>
						</button>
					</div>
					
					<div class="product-cell status-cell">
						Status
						<button class="sort-button">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								viewBox="0 0 512 512">
								<path fill="currentColor"
									d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z" /></svg>
						</button>
					</div>
					
					<div class="product-cell sales">
						Sales
						<button class="sort-button">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								viewBox="0 0 512 512">
								<path fill="currentColor"
									d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z" /></svg>
						</button>
					</div>
					
					<div class="product-cell stock">
						Stock
						<button class="sort-button">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								viewBox="0 0 512 512">
								<path fill="currentColor"
									d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z" /></svg>
						</button>
					</div>
					
					<div class="product-cell price">
						Price
						<button class="sort-button">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								viewBox="0 0 512 512">
								<path fill="currentColor"
									d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z" /></svg>
						</button>
					</div>
				</div>
				
				<!-- forEach문으로 돌릴 구간, 샘플을 위해서 일단 게시글 4개정도 남김, function 할땐 하나만 하면됨 -->
				<div class="products-row">
					<button class="cell-more-button">
						<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-more-vertical">
							<circle cx="12" cy="12" r="1" />
							<circle cx="12" cy="5" r="1" />
							<circle cx="12" cy="19" r="1" /></svg>
					</button>
					<div class="product-cell image">
						<img
							src="https://images.unsplash.com/photo-1555041469-a586c61ea9bc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1950&q=80"
							alt="product"> <span>Ocean</span>
					</div>
					<div class="product-cell category">
						<span class="cell-label">Category:</span>Furniture
					</div>
					<div class="product-cell status-cell">
						<span class="cell-label">Status:</span> <span
							class="status active">Active</span>
					</div>
					<div class="product-cell sales">
						<span class="cell-label">Sales:</span>11
					</div>
					<div class="product-cell stock">
						<span class="cell-label">Stock:</span>36
					</div>
					<div class="product-cell price">
						<span class="cell-label">Price:</span>$560
					</div>
				</div>
				
				
				<div class="products-row">
					<button class="cell-more-button">
						<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-more-vertical">
							<circle cx="12" cy="12" r="1" />
							<circle cx="12" cy="5" r="1" />
							<circle cx="12" cy="19" r="1" /></svg>
					</button>
					<div class="product-cell image">
						<img
							src="https://images.unsplash.com/photo-1484154218962-a197022b5858?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8a2l0Y2hlbnxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=900&q=60"
							alt="product"> <span>Lou</span>
					</div>
					<div class="product-cell category">
						<span class="cell-label">Category:</span>Kitchen
					</div>
					<div class="product-cell status-cell">
						<span class="cell-label">Status:</span> <span
							class="status disabled">Disabled</span>
					</div>
					<div class="product-cell sales">
						<span class="cell-label">Sales:</span>6
					</div>
					<div class="product-cell stock">
						<span class="cell-label">Stock:</span>46
					</div>
					<div class="product-cell price">
						<span class="cell-label">Price:</span>$710
					</div>
				</div>
				
				<div class="products-row">
					<button class="cell-more-button">
						<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-more-vertical">
							<circle cx="12" cy="12" r="1" />
							<circle cx="12" cy="5" r="1" />
							<circle cx="12" cy="19" r="1" /></svg>
					</button>
					<div class="product-cell image">
						<img
							src="https://images.unsplash.com/photo-1586023492125-27b2c045efd7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDR8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=900&q=60"
							alt="product"> <span>Yellow</span>
					</div>
					<div class="product-cell category">
						<span class="cell-label">Category:</span>Decoration
					</div>
					<div class="product-cell status-cell">
						<span class="cell-label">Status:</span> <span
							class="status active">Active</span>
					</div>
					<div class="product-cell sales">
						<span class="cell-label">Sales:</span>61
					</div>
					<div class="product-cell stock">
						<span class="cell-label">Stock:</span>56
					</div>
					<div class="product-cell price">
						<span class="cell-label">Price:</span>$360
					</div>
				</div>
				
				<div class="products-row">
					<button class="cell-more-button">
						<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-more-vertical">
							<circle cx="12" cy="12" r="1" />
							<circle cx="12" cy="5" r="1" />
							<circle cx="12" cy="19" r="1" /></svg>
					</button>
					<div class="product-cell image">
						<img
							src="https://images.unsplash.com/photo-1595526114035-0d45ed16cfbf?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8YmVkcm9vbXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=900&q=60"
							alt="product"> <span>Dreamy</span>
					</div>
					<div class="product-cell category">
						<span class="cell-label">Category:</span>Bedroom
					</div>
					<div class="product-cell status-cell">
						<span class="cell-label">Status:</span> <span
							class="status disabled">Disabled</span>
					</div>
					<div class="product-cell sales">
						<span class="cell-label">Sales:</span>41
					</div>
					<div class="product-cell stock">
						<span class="cell-label">Stock:</span>66
					</div>
					<div class="product-cell price">
						<span class="cell-label">Price:</span>$260
					</div>
				</div>
				
				<div class="products-row">
					<button class="cell-more-button">
						<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-more-vertical">
							<circle cx="12" cy="12" r="1" />
							<circle cx="12" cy="5" r="1" />
							<circle cx="12" cy="19" r="1" /></svg>
					</button>
					<div class="product-cell image">
						<img
							src="https://images.unsplash.com/photo-1554995207-c18c203602cb?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8aW50ZXJpb3J8ZW58MHwwfDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=900&q=60"
							alt="product"> <span>Boheme</span>
					</div>
					<div class="product-cell category">
						<span class="cell-label">Category:</span>Furniture
					</div>
					<div class="product-cell status-cell">
						<span class="cell-label">Status:</span> <span
							class="status active">Active</span>
					</div>
					<div class="product-cell sales">
						<span class="cell-label">Sales:</span>32
					</div>
					<div class="product-cell stock">
						<span class="cell-label">Stock:</span>40
					</div>
					<div class="product-cell price">
						<span class="cell-label">Price:</span>$350
					</div>
				</div>
				
			</div>
			
		</div>
	</div>
</body>
</html>