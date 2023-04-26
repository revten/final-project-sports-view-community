$(function() {
	// 메뉴 스위치
	$('.adminClub__list__item').click(
			function() {
				$('.adminClub__list__item').removeClass(
						'adminClub__category__selected');
				$(this).addClass('adminClub__category__selected');

				let val = $(this).children('span').text();

				$('.adminClub__category__item-1').removeClass(
						'adminClub__category__item-on');
				$('.adminClub__category__item-2').removeClass(
						'adminClub__category__item-on');

				if (val == '구단 등록')
					$('.adminClub__category__item-1').addClass(
							'adminClub__category__item-on');
				else if (val == '관계자 등록') {
					$('.adminClub__category__item-2').addClass(
							'adminClub__category__item-on');
				}
			});
});