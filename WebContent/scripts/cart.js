$(document).ready(function(){
	
$(".cartButton").click(function() {
	var count = parseInt($('#lblCartCount').text());
		$('#lblCartCount').text(parseInt(count+=1));
	});
});