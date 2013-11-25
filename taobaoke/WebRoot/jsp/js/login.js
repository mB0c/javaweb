$(function(){
	$("form").submit(function(){
		if($("#userName").val() == null || "" == $("#userName").val()){
			
			alert("wwwwwwwwwwwwww");
			return false;
		}
		if($("#password").val() == null || "" == $("#password").val()){
			alert("ÃÜÂëÎª¿Õ£¡£¡£¡");
			return false;
		}
		return true;
	});
});