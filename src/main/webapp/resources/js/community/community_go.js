function communityGo() {
		location.href='community.go';
}

function commnunity_one_go() {
		location.href='communityone.go';
}

function commnunity_two_go() {
	location.href='communitytwo.go';
}

function commnunity_three_go() {
	location.href='communitythree.go';
}

$(document).ready(function(){

	$('#community .community_menu').hide();

	$('#community').mouseover(function(){
		$('.community_menu').slideDown();

	});
	$('#community').mouseleave(function(){
		$('.community_menu').hide();
	});
});