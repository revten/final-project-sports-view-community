/*=============== 모바일 네비바 ===============*/
const navMenu = document.getElementById('nav-menu'), navToggle = document.getElementById('nav-toggle'), navClose = document.getElementById('nav-close')

/*=============== 모바일 네비바===============*/
/* Validate if constant exists */
if (navToggle) {
  navToggle.addEventListener('click', () => {
    navMenu.classList.add('show-menu')
  })
}

/*=============== 모바일 네비바 ===============*/
/* Validate if constant exists */
if (navClose) {
  navClose.addEventListener('click', () => {
    navMenu.classList.remove('show-menu')
  })
}

/*=============== 메뉴클릭시 메뉴바가 사라지는 모션 ===============*/
const navLink = document.querySelectorAll('.nav__link');

const linkAction = () => {
  const navMenu = document.getElementById('nav-menu')
  // When we click on each nav__link, we remove the show-menu class
  navMenu.classList.remove('show-menu')
}
navLink.forEach(n => n.addEventListener('click', linkAction))


/*=============== 헤더 배경 변경  ===============*/
const scrollHeader = () => {
  const header = document.getElementById('header')
  // When the scroll is greater than 50 viewport height, add the scroll-header class to the header tag
  this.scrollY >= 15 ? header.classList.add('bg-header') : header.classList.remove('bg-header')
  // bg-header css로도 연결
}
window.addEventListener('scroll', scrollHeader)

/*=============== 스크롤업 버튼 보여주기 ===============*/
const scrollUp = () => {
  const scrollUp = document.getElementById('scroll-up')
  // When the scroll is higher than 350 viewport height, add the show-scroll class to the a tag with the scrollup
  this.scrollY >= 350 ? scrollUp.classList.add('show-scroll') : scrollUp.classList.remove('show-scroll')
}
window.addEventListener('scroll', scrollUp)

/*=============== 다크/라이트 모드 ===============*/
const themeButton = document.getElementById('theme-button');
const darkTheme = 'dark-theme';
const iconTheme = 'ri-sun-line';

// 직전에 선택해둔 테마
const selectedTheme = localStorage.getItem('selected-theme');
const selectedIcon = localStorage.getItem('selected-icon');

// 어두운 테마 클래스를 확인하여 인터페이스에 있는 현재 테마를 얻는다
const getCurrentTheme = () => document.body.classList.contains(darkTheme) ? 'dark' : 'light';
const getCurrentIcon = () => themeButton.classList.contains(iconTheme) ? 'ri-moon-line' : 'ri-sun-line';

// 사용자가 이전에 주제를 선택했는지 확인한다.
if (selectedTheme) {
  // 유효성 검사가 이행되면 문제가 무엇인지 묻고 활성화했는지 확인
  document.body.classList[selectedTheme === 'dark' ? 'add' : 'remove'](darkTheme);
  themeButton.classList[selectedIcon === 'ri-moon-line' ? 'add' : 'remove'](iconTheme);
}

// 버튼으로 활성/비활성
themeButton.addEventListener('click', () => {
  // 다크, 아이콘 테마 추가 혹은 삭제
  document.body.classList.toggle(darkTheme);
  themeButton.classList.toggle(iconTheme);
  // 유저가 선택한 테마를 저장한다
  localStorage.setItem('selected-theme', getCurrentTheme());
  localStorage.setItem('selected-icon', getCurrentIcon());
})

/*=============== 스크롤하면 나오는 애니메이션 효과 ===============*/
const sr = ScrollReveal({
  origin: 'top',
  distance: '60px',
  duration: 2000,
  delay: 200
  //reset: true, // Animations repeat
})

sr.reveal(`.home__img, .newsletter__container, .footer__logo, .footer__description, .footer__content, .footer__info`);
sr.reveal(`.home__data`, { origin: 'bottom' });
sr.reveal(`.about__data, .recently__data`, { origin: 'left' });
sr.reveal(`.about__img, .recently__img`, { origin: 'right' });
sr.reveal(`.popular__card`, { interval: 100 });

/*<script> 
const sr = ScrollReveal({
	  origin: 'top',
	  distance: '60px',
	  duration: 2000,
	  delay: 200
	  //reset: true, // Animations repeat
	})

	sr.reveal(`.`);
	sr.reveal(`.`, { origin: 'bottom' });
	sr.reveal(`.`, { origin: 'left' });
	sr.reveal(`.`, { origin: 'right' });
	sr.reveal(`.`, { interval: 100 });
</script>*/

