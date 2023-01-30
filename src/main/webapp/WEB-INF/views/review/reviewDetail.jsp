<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRIPPLE: Review</title>
</head>

<body>
	<div class="watch__container">

		<!-- watch 페이지 헤더 -->
		<div class="watch__header">
			<div class="watch__header-title">
				<a href="review.board.go?post_board=12" class="nav__link"
					style="font-size: 15px">REVIEW</a>
			</div>
			<div class="watch__header-title">
				스포츠 열기는<span> 모두와 함께</span>
			</div>
			<div class="move__button-wrapper">
				<c:choose>
					<c:when test="${sessionScope.loginAccount ne null}">
						<button class="action-button"
							onclick="location.href='review.reg.go?post_board=12'">
							<span>리뷰쓰기</span>
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								viewBox="0 0 24 24" fill="none" stroke="currentColor"
								stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
								class="feather feather-filter">
								<polygon points="22 3 2 3 10 12.46 10 19 14 21 14 12.46 22 3" /></svg>
						</button>
					</c:when>
					<c:otherwise>
						<button class="action-button" onclick="alert('로그인하세요')">
							<span>리뷰쓰기</span>
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								viewBox="0 0 24 24" fill="none" stroke="currentColor"
								stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
								class="feather feather-filter">
								<polygon points="22 3 2 3 10 12.46 10 19 14 21 14 12.46 22 3" /></svg>
						</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>

		<div class="reviewBoardDetail__main">
			<div class="post section">
				<div class="post__container">
					<hr>
					<div class="post__1st-line">
						<div class="post__title">${post.post_title}</div>
						<div class="post__date">
							<c:choose>
								<c:when test="${post.post_update_date eq null }">
									<fmt:formatDate value="${post.post_reg_date}"
										pattern="yy-MM-dd HH:mm" />
								</c:when>
								<c:otherwise>
						수정 <fmt:formatDate value="${post.post_update_date}"
										pattern="yy-MM-dd HH:mm" />
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<hr>
					<div class="post__2nd-line">
						<div class="post__nick">
							<img style="width: 20px; height: 20px;"
								src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxAQEBYQDxQQFhAQEA8WEBYQFhAPEBAQFhYXFxYSFhYZHikhGRsmHBYWIjIiKCosLy8vGCA1OjUuOSkuLywBCgoKDg0OGBAQGC4eHh4uLi4sLi4uLi4vLi4sLi4uLi4sLi4uLi4uLi4uLi4uLC4uLi4uLi4uLi4sLi4uLi4uLv/AABEIANgA6gMBIgACEQEDEQH/xAAcAAABBQEBAQAAAAAAAAAAAAAAAgMEBQYHAQj/xABAEAACAgACBgcFBgUDBAMAAAABAgADBBEFBhIhMVEHEyJBYXGBFDKRobEjQlJiwdEzcqKy8ENzgkRTdOEVJTT/xAAbAQACAwEBAQAAAAAAAAAAAAAAAQIDBAUGB//EADIRAAIBAgQEBAQFBQAAAAAAAAABAgMRBBIhMQUTQVEycbHwIoGh4RVhkcHRFCM0QvH/2gAMAwEAAhEDEQA/AO4whCABCEIAEIQgAQhCABCEpNJ6frqzWvtv35e4p8T3+QgTp051HaKuXLMAMzuA48pWYvTlCbgS55JvHx4TLYrH23HtsSO4Dco9I0qwOpS4bFa1Hf8AJfyXd2sVh9xVXz7RkRtJ3txdvTs/SQ1WOqsdjUqFKO0V78xbXueLOfMmeBm5n4mKCxQWPKPQcrxVo4PZ8TJFWlr14sGH5gPqJGCz3ZjylcoQlvFP5FrRp0f6i5eKnP5GWeHxddnuMD4cD8JltiebORzEMpmng6cvDobKEzmF0tYm5+2v9Q9e+XmGxSWDNDnz5jzEi0YKuHnT327j8ISNjcalKbdhyHdzY8gIipJt2W5JhMZjNYLrDlWdheS5bR82/aMpfaTmXsPmzfvHY6EeHTy3k0vqbmEyNONuTg7eTdofOW+A0wGOzYArHgR7p/aDRRVwc4K618i3hCERlCEIQAIQhAAhCEACNXWqilnICqMyTwAnt1qopZiAqjMk8AJhNN6Ya9shmK1PZXn+ZvH6QNOGw0q8rLRLd++pL0xp9rc0qzWvge5m8+Q8JTrGwY7WIj0NOlGlHLBaDqCPqI2gjyySQSYpRHVESsdWTRRJnoEUBPVEpdeNKHCYC65dz7BVP523CSKnKxC0tr7gMNaaWZ3sX3xUjWbPmRLfQWncNjV2sPYGy95TmrqeTKd4lL0Q6m4dsL7ViUWyy1my2+0PzMR3knP4SL0kaDGirqtJ4EbCbQW9F90rxI8ssyORHjLMkU8t9fp5e0cuOObleSSi/wBTcbMCsb0bi1vqS1TmrqpHqJJIkToXI7JEIzIdpCQRy/zfH7CACTuAGZPITO4bXLR1tvUpiF6zayAOahm5BjuJkWiWbSzNzo3Sq29luzZy7m8R+0ymn8cbb2/AhKoO7IcT6n9I7ixkNobiN4I4g85Usd8hazLcLhYQm6kf+dx+gSfVK2l5OqaBpqolrBlnitFbUkZdS30LpDa+yc9oDsE/eHLzEupiutKMHXipBH7TYJcpAI4EAjyMraOXjKKhJSitJeo7CEIjGEIQgAQhKLWrSnUVbKn7S3MLzVfvN/nOBOnTdSSiupSa06Y61+prP2aHtEffcfoJQgxoGOCI9RRoxpQUYjqSTVIySVXGWSHkjqCNLHkkkUSHUEeURpI8kkUSFqJgumq/ZwNa/jxNYPkAzfpN+s5z05f/AJcP/wCQP7HknsZa7/ty8mdA6KsQr6Lqy+4XVvA55/QxPS5s/wDxVu1+KvLzz/bOcd6N+kI6OJrtG1S2W0OGRHBgecmdJnSQukEXD4dStIO021vZmyIzOXgfnL7Lm81NW3+36nCv8GW2uxruh/Hdbo5VPGpmT0U7vllNyROXdBD/AGGIXuF2Y9VX9p1PKUx2R2oO8Yv8kZPpKxhp0ZeynJmAQEbiNs7P6w1J1FwF+iK1vpRmuQkv99d5A2T3ZSF0xj/6uz/cp/vEv+h/Sy4jRqICNuglWHeFPaX6kekk21CTX5fv9jFjNZxT7P1KHQFltNl+i8Sxe3B5Gl2963DN7jHxHD4R9zIXSFjRhtYMFYDkLqeqt8VZiFz9cvhLXSVOw/g31kJa6nX4ZWzwyvdEVHk2i2VpMcrtlZ0pRuW62xzrJVi+e+0QuU8on22bpe4HGMKk/wBtPoJj2xBM2mjtG501nnXWf6RISK6kYpK5eQhIGk9KV0Lm53n3VHvN5eHjGebjFydoq7ZPlfitMUV7mcE8k7R+Uy2M0tded52U/Am74nvjFdQEDpU+Hdaj+S/kvrdZPwVk+LED5DOZ7ShbE2dY+7cAqjgoEkrXFdXHlNlOlSpO8VqVDYDLhnGmrI4y8Ncj4jD5iPKao1ehWrJKGR8so6kRYyVWY8hkesx0OBGiqSJSx5JAGJWSKsQp75IonBktZzzpuQnBUnuGKTP1rsH7ToSGY7pcw5fRbsP9K2l/IBsj9ZIx118EvI4NYu+CDfLFMNtDPnB8NsgnlOl+Fz8Sem5wFXW3U6l0Dp9jiG7uuUf0D951Sc/6FsF1ejesIyN99rjPvUZID/TN/OdHY7VPwR8jH9LFW1oq/wDKEb4OJxjVbW7FaNs28O3Eb1O9SORHfO9664Y3aOxNY4nDW5eYUkfSfM2WYB8BJLMtV2MuLSbiW+ses2Ix2I9qvP2i7JXLcF2TmAOXCfQN4F9COPv1ow/5KD+s+ZlTcfKfSGqdm1o/DMe/DU/2iRd3q+pfw6WWTS6WKl2yOyeP1iC+Us9LYPPeJRNYVYK3A+6e8HkZUeijO6uS+tnptkYtPQYhk3CVG2xa14uwUevfOqJWAABwAAHkJi9RtGlmOIYdlM1r8XO5j6Dd6mbiI4HE6uaooL/X1ftEHS2kFw9RtbfluUd7MeCiYBsS91hssObN8AOQHcJO15x+1iFpB7NS5kfncA7/AEy+JlVhGgbuH4dQp53vL0LSkSQqyPSZJQxoumOAReUQDFZyZSwyiHEUWjTtAcblXilyYxKGLxx7XwjCNIs2R2Q+z5CR3sJjjbxGGEnHYtppBnPVsI74meASVi1ot9G4sncZI03o4YrC3Yc7uuqdAeTEdk+hykHR1Jzzl0hiZysVCObQ+e9FUFS+HuGzdQ7I6njmpyMVj8I1j14WgbV+IdVVR3Z/ePIDn4Gdg1l1IwWPfrbBZXfkAbMOwR2A4bYIIbzyzkjVjU7B6PJekO9zAhrb2FluyfujIAKPITo/iM/6fk212vfp5Hnfwx83NfQt9CaPXC4arDp7tNSJnzIG8+pzMmkxstGbsYiEBmUE8ASMzOfsddQ6IeuQOpU8GBB8iMp8yro8pbbSR2qLbEIPHssRPpgNORdJWiThcd7cFPs2KCi5gMxXeBlm3IMAD55zVg6sYVouW2z+Zh4hSlKlePQweMw2wjNyE7/q7QasHh6zxTDUg+ewJyHRej10jiqsNT2qttXxLgZolK7yCeZ4Dzna7rQvgO7ylnEqkJVrQ2Stp3FwinPK5NbjWIXMZSg0jhcwR8PA90tnxiyLewbznMaPR04yjuihQ8+Mt9AaGfFWZDMVr77chyHNpN0Jq2cUxdmC1KwDZe+TlnkOXnN9g8IlKCutQqrwA+p5mIx4zHqneENZen3FYXDpUi1oMlUZAR+EIjgb6s5NrS59utz/AO58tkZfLKNYe2WPSHgjXiRcPduUHPu21AUj4bMz9NsLHq8NJSowa7L6aepoaL5MrumeqxEk14uBOVO5fi2eG2U64yK9sjuV8ks2tjL3SvbFxo4qK5JUhzE2ZtEI0YNmZikaBdYmI0d2QZERpIRo7kGrbDooBj1WHWIRo8jR3ZXKUiTXkOEkK0hq0dVo0ZpRJIaK2owGi9qTuVuIjG4oVVvY3CtGY+QGc4bpHGX4i433FtpmJXecqxnuVeWU7TpbDm2i2scXrcDxJG4TmBwRsPVqpLFsgoHa2uWUyYibi1bqa8NhY1oS1s0dJ1VxbW4Ol2PaKDM8yN2fyllcqupR1VkYZMrgMrDkQdxkPRWE6iiukf6aKpI4Fst5+OckFpqWxkcUxrB4OmhSlFVVSE5laUWsE8zsjfIGk2OfhLEtIuKrDCK5fQShLYqI3Y5ElWUESJZWZK50bpo2Woduddg5Mh+IP7TVTKahJktv81f0aauUs8rxD/Jnb3oEIQgYyq1h0SmLoaptzca247DjgfLuPgZyLF4ayixqrVKsp3g/UHvB5zuUqNO6Boxa5WDJx7jrltr4eI8IG/BY3kPLLWL+nvqcjS2PLdLHS2qGLw5JCm2vuaoFzl4rxHzlE6spyIII7juPwjPQU6kKivBpk4Xz32iV+0Z5tGFiTuiecRBbc5A2o9U8LCuT1aPKZERo8jRDJSNH0aQ1aOo0Bk5Hj6PICPH0eBW4k5Xiw8iK8dV4ypxJQaKDyOHnoeO5XlJIeJCIG2gqBzxYKNs+bcY1tQ2o7kcg8WiC0bLRJaBJRFlo27RDNG3eK5ZGJ5a0h2GOWPIzNIsuSNrqRVlS7fis+gE0kqNV6djC158WBY/8iSPllLeB5fFSzVptdwhCECgIQhAAka/B1WfxK62/mVW+skwgCbWxktbNXcP7LY9FVaWIA+aKFJVfeG7wznKrCec6/rZrXhdH1/bHbscHYqXIu45n8K+J+c5Aty2KLEGSt3Z57P5c+/KC3O3w6c3B5r2vo/UFkitpFBj1ZkjpXJqNH0aRFaOo0TQyWrR1WkVWjitESJatHVaRFaOK0BkxXi1eRA8UrwFYmiyOB5CDxXWQI5SXtQ25F24bcBZSUXiC8ZLxsvAaiPs8Zd4gvGmeIkkeu89w1Rsda14uwUepyjDNNJqRgdu03H3ahkv87DL5DP4iBVXq8qm59vXobepAqhRwUADyG6OQhGeUCEIQAIQhAAmL1711TAr1VOy2KYbgd60g8Hfx5L3+Uka961ro+nZTI4m0Hqwd4Qd9jDkO4d59ZwbHYtrGZ3Yl3YlmY5szHiSYmzpYHBc345+Ht3+3qJ0npCy52stZmdzmzMc2J/zukjVrH5OaWO6zemfc/L1HzEp7DGCxG8biN4I4iQudmSsb5lygsiaJ0gMRXmcusTIWD6MPAyU0uTuJMfVo6jSMDHFaMkSVaPK0iK0cVorErktWi1aRFePB4hkgNFhpGDxQaIlckh4sPIoee7cAJW3DbkbbhtxASNuJLxgvPNuADxaNM0bLxJaAh2tSzBVBLMQABxJPATqehNHjD0LUOIGbnm54n9PSZvUjQ3/U2Dn1QPzs/Qes2kZwuI4jPLlx2W/n9ghCEDmBCEIAErdPaWrwdD4iz3UG4Di7n3UHiTLKcQ6TtZvacT1NZ+ww5Krlwss4O/jl7o9ecDVg8M69RR6dfIy2ndLW4q57rTmznM8clHAKvIAbpS2NHrHzkZzIM9WoKKsloNPGnjzRthEVSiKwOMeiwWJxHEHgw71M22DxKXp1lfD7w70bkZgyI/o/HPQ+2nkwPusORgnYoejN0YKZHwGPrxC7VZ3j3lPvL+48Y9LkxodVo6rSODFAxjJStFh5EDxwNEO5IDxe3I21PduFh3JYeG3Iwae7cVhkjbnu3I23PduIY+Xnm1GdqervibAczl/qpoP2mws+XV1kbYzG0xO8Ll3DxmO0ppZaeyuTW8uITxb9pT6G0xicLf7RVYwtJ7eeZWwfhde8fTukHPUnLC1qlN8t2fT30PpNEAAAAAAyAHADlFzO6o6z06Qq2l7NqgdamYzX8y81POaKTTueRq0p0puE1ZoIQhGVhCEIAZfpB057Fg2KnK609XVzGfvP6LmfPKfP9r8uA4Td9L2letxvUg9nDVhf+bhXc/DYHpOeu0TZ6nhlDl0U+stf4+mvzEuY0Y4Y3IHRaEGeERZiSIFbiMsIhljxEQREUSiJpuatgyEqw4EbjNPo3WFH7N+SN+Ie4fP8P0mYIjZWC0KHFo6NluzG8HgRvB9YmYfAaSuo/hscu9T2lPoZpdD6a9psSnqn62xgqdX2wzHw4j9JYphm7lnnFhpZ47V3F0/xKrMh3gba/Fc5WFJO4RkpK6dwDRW1E7M9ygTFhooNEARQQ8e7n3RXBCg0UsgYnS2Hqz2rAWH3U7Z8t24SqxGsbtupUIObZM3w4CQlNIshByeho7rUrG1YwUePf5DvlTi9NM2a0gqv4z75HgO6UbOznaclm5sc5KpWUuUmdKjhorV6iVqjnVx5Vi9iI2bC9EaStwly3UnZZT6MO/aHeDO9avaYrxuHW+v725lPFHHvKf8AOGU+f3rms6M9OHDYsUOT1WJIU58Ft+4/qd3/ACHKTjKzORxnArEUXUj4oL9V1X7o7VCEJceJCEIQA+aNb8WbMdiH54i34K5UfISjJlhrCMsTcOV9397StzlZ7Wj4I+SPZ5PZ5AvCJIiokxEWJMQRHGiTAqkhphPMo4RJuiNE34u5acMhexuAHADvZjwCjmYFE7JXZCwuFe11qqVmexgqKozZmPAAT6B6N9RE0dX11wVsbYO0eK0qcvs08ebd/lH9QtRKdGJ1jZWYt1yezLcgPFKweA8eJ+U2kmo2OBi8XzPgh4fX7BIl+Aps/iV1t/MqkyXCSMCbWqM7pPVPC2VWLVWldrI4rsUfw7CDsvlwORyOU+eMfpbHUWvTawWyt2RwUTcynI93Dxn1TOc9KOoPt6+1YUAYutcmHAYhBnkvIOO49/A9xEZI3YXFOMss3o/ocRbTuKP+q3oFX6CR7MRY/vu7fzMTG7KWRijgqykqysMmVgcipB4EGeoJA7cFdi6q5MRYykfWKx1KMUkP1CTaRIdZk2iDN0diSix9a55UJLrWVsdyK1Mj2IVIyzBBzBG4g9xEtykhYtYwTsd11ex/tOFqv77K1L/zjc/9QMs5iuirEbWBK/8AbucDyYK36mbWaFsfPMZRVHEVKa2TdvK+gQhCMzHzd0iYM0aSxCEZBresXkVsyfMc95I8wZmRO09MmrLXVLjahm9CFbgB2mqzzDj+U55+DHlOLMZW1qerwNdVKMX2Vn8hcIjOe5xG+57EmeZzwmAnI9MTJui9F34qzqsNW9lnJBnl4seCjxM6xqf0TpWRdpEh3GRFKE9Wp/O33/IbvOC1MWIxdKivievbqYLU7UjFaSYMo6vDA5Pa47O7iqD75+XMzu+rOrWG0fV1eHTInLrHbfZY3Nj+nAS2pqVFCoAqqAAFAAAHcAOEdliVjz2Jxk67s9F2CEIRmQIQhAAhCEAMNr90e06RBtqyrxYG58uxblwSwD+7iPHhOE6W0NiMFcaMShSwZ5Z71Zc/eU8GHjPq+VmnNCYbG1GnE1q6d2e5kPNWG9T5SLjc3YXGyo6PVeh8tqY8rTda29F2JwxNuDzvo3kqMhfWPEffHiN/hMDnkcjmCCQQdxBHEESNj0uGxUKivBkutpJpsykBGjyNEdSnURb03SwqtmfSySq8QZFotsmXpsGUr8XYIx7VGdpmIVQSzEBQN5Yk5AAc84kiSide6IkIwbt3NecvRFzm7lHqfor2PB1Un3wCz/7jHMj0zy9JeS9KyPneOrRrYipOOzbsEIQjMoTm2tXRRRiCbcG4osYkshBahieQG9PTMeEIQtcsp1p0nmg7HPcd0Z6WqOQoFg/FVZUQfRiG+UjLqBpcnIYS31akD4lp5CQcToR4nWtsvfzLbR/RRpOwjrFpqHf1liuw9K8x85stB9D+FrybGWPc34Uzor8tx2j8RCEllRnnxCvUXit5HQdHaOpw6CuitK6xwVAFH/uTIQjMYQhCABCEIAEIQgAQhCABCEIAEzmsepmBx/avqAty3W1/Z2jzI97yOc8hAlGcou8XZnONMdEGKrzbCW12L3LYOqsy5Z71J+EyWO1U0lh/4mFuHiim5fjXmIQkJKx08PxXEKWV2fn9irJZTkysCOIIII9DHqNtjkiux5KCx+AhCRPRxxM8tzQaN1Q0leRsYewA/esBqUeJ28vlnOnamahV4JhdcRZiR7uQ+zqJGRK5+835j6CEJKKueexvFsRWXLukmtbdfU3EIQkzkBCEIAf/2Q==">
							${post.member_nick}
						</div>
						<div class="post__element">
							조회수 <b>${post.post_hit_count }</b> 추천수 <b>${post.post_like_count}</b>
							스크랩수 <b>${post.post_scrap_count}</b>
						</div>
					</div>
					<hr>
					<div class="post__content">${post.post_content}</div>


					<div class="post__bot">
						<button class="post__bot-btn" onclick="history.back()">이전으로</button>

						<!-- 로그인하고 자신이 쓴글이면 수정/삭제버튼 나오도록 / 도중 세션만료시 로그인 / 로그인해야 추천할수 있음 -->
						<c:choose>
							<c:when
								test="${sessionScope.loginAccount.member_id eq post.post_member}">
								<c:choose>
									<c:when test="${sessionScope.loginAccount eq null}">
										<button onclick="alert('로그인하세요')">수정</button>
										<button onclick="alert('로그인하세요')">삭제</button>
									</c:when>
									<c:otherwise>
										<button class="post__bot-btn"
											onclick="location.href='review.update.go?post_id=${post.post_id}&post_member=${post.post_member}'">수정</button>
										<button class="post__bot-btn"
											onclick="location.href='review.delete.do?post_id=${post.post_id}&post_board=${post.post_board}'">
											삭제</button>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${sessionScope.loginAccount eq null}">
										<button id="LikeBtn" onclick="alert('로그인하세요')">추천</button>
									</c:when>
									<c:otherwise>
										<button id="LikeBtn"
											onclick="likeCheck(${likeCheck}, ${post.post_id}, ${sessionScope.loginAccount.member_id})">추천</button>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>


			<!--==================== 댓글 ====================-->
			<div class="reply__section">
				<!-- 댓글 리스트 -->
				<hr>
				<div style="font-size: 15px">댓글 리스트</div>
				<div class="reply__list">
					<c:forEach var="reply" items="${post.replies}">
						<div class="reply__div">
							<p>
							<hr>
							<input class="reply__id" type="hidden" name="reply_id"
								value="${reply.reply_id}">
							<div class="sortInfo">
								<div class="reply_writterNick">
									<b>${reply.member_nick }</b>
								</div>
								<div class="reply__date">
									<fmt:formatDate value="${reply.reply_reg_date }" type="both"
										dateStyle="short" timeStyle="short" />
									<c:if
										test="${reply.reply_member == sessionScope.loginAccount.member_id }">
										<button class="reply__update-btn">수정</button>
										<button class="reply__delete-btn">삭제</button>
									</c:if>
									<br>
								</div>
							</div>
							<div class="reply__content">${reply.reply_content}</div>
						</div>
					</c:forEach>
				</div>
				<hr>
				<!-- 댓글 등록 -->
				<div class="reply_reg_form">
					<!-- 로그인x면 댓글 쓸수 없다 -->
					<span>댓글 쓰기</span>
					<c:if test="${sessionScope.loginAccount != null }">
						<!-- 토큰으로 새로고침시 자동입력을 방지 -->
						<input class="reply__token" type="hidden" name="token"
							value="${token }">
						<!-- 등록후 등록한 사람의 닉네임을 보여줘야 되니까 담아서 js에 보내준다 -->
						<input type="hidden" id="reply_writterNick"
							value="${sessionScope.loginAccount.member_nick}">
						<!-- 리플을 DB에 등록할때 게시판의 id도 필요하니 담아서 js에 보내준다 -->
						<input type="hidden" id="reply_board" value="${post.post_board}">
						<!-- 리플을 DB에 등록할때 게시글의 id도 필요하니 담아서 js에 보내준다 -->
						<input type="hidden" id="reply_post" value=" ${post.post_id}">

						<!-- 댓글 입력내용 당연히 보내야겠지 -->
						<input class="reply__content-reg" name="reply__content"
							maxlength="80" autocomplete="off" required>
						<button class="reply__reg-btn">등록</button>
					</c:if>
				</div>
			</div>
		</div>

	</div>
</body>
</html>