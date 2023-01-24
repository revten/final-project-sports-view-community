$(function() {
	$('#questionMark1').mouseover(function(){
		$('#accountCondition1').css("display", "block");
	});
	
	$('#questionMark1').mouseleave(function(){
		$('#accountCondition1').css("display", "none");
	});
	
	$('#questionMark2').mouseover(function(){
		$('#accountCondition2').css("display", "block");
	});
	
	$('#questionMark2').mouseleave(function(){
		$('#accountCondition2').css("display", "none");
	});
});