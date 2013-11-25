
//检验昵称
function checkNick(){
	//检验昵称
		var nick = $("#inpu_userName").val();
		//不能为空
		if(null == nick || "" == nick){
			$("#tip").html("昵称不能为空").css("color","red");
			flag = false;
			return false;
		}
		//不能超过40字节
		var len = 0;
		for(var i = 0;i < nick.length;i++){
			var str = nick.substr(i,i+1);
			//如果有中文
			if(escape(str).indexOf("%u") != -1){
				len += 2;
			}else{
				len += 1;
			}
		}
		if(len > 40){
			$("#tip").html("昵称有点长啊！！").css("color","red");
			return false;
		}
		//可以用的话
		$("#tip").html(" ");
		return true;
}

//检验邮箱
function checkEmail(){
		var email = $("#inpu_email").val();
		//邮箱不能为空
		if(null == email || "" == email){
			$("#tip").html("邮箱不能为空").css("color","red");
			return false;
		}
		//邮箱格式要正确
		 var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		 if (filter.test(email)){
			 
			 $("#tip").html("");
		 }else{
			 $("#tip").html("邮箱格式不对啊").css("color","red");
			 return false;
		 }
		 $("#tip").html("");
		 return true;
}

//检验密码
function checkPassword(){
	var password = $("#inpu_password").val();
	//不能为空
	if(null == password || "" == password){
		$("#tip").html("密码不能为空啊").css("color","red");
		return false;
	}
	//密码不能少于6位高于16位
	if(password.length < 6){
		$("#tip").html("密码太短了").css("color","red");
		return false;
	}
	if(password.length > 16){
		$("#tip").html("密码太长了").css("color","red");
		return false;
	}
	$("#tip").html("");
	return true;
}


$(function(){
	
		//先把注册按钮置灰
	if(!$("#inpu_checkbox").is(":checked")){
		$("#submit").prop("disabled", true).css("color","grey");
	}
	//昵称校验
	$("#inpu_userName").blur(function(){
		checkNick();
	});
	
	
	//邮箱的校验
	$("#inpu_email").blur(function(){
		//如果输入不对则不进行ajax校验
		if(checkEmail()){
			var email = $("#inpu_email").val();
			$.ajax({
			type: "post",
			url: "servlet/CheckServlet",
			data: "email=" + email,
			success: function(data){
				if("1" == data){
					$("#tip").html("");
				}else{
					$("#tip").html(email + "已被注册过，请直接登录！！").css("color","red");
					return false;
				}
			}
		});
		}

	});
	
	//检测密码
	$("#inpu_password").blur(function(){
		//如果不合格就清空
		if(!checkPassword()){
			$("#inpu_password").val("");
		}
	});
	
	$("#inpu_password1").blur(function(){
		var password = $("#inpu_password").val();
		var password1 = $("#inpu_password1").val();
		if(password != password1){
			$("#tip").html("确认密码不对请重输").css("color","red");
		}else{
			$("#tip").html("");
		}
	});
	
	//当勾选同意约束时  点亮注册按钮
	$("#inpu_checkbox").click(function(){
		var f = $("#inpu_checkbox").is(":checked");
		if(f){
			$("#submit").prop("disabled", false).addClass("register").css("color","white").css("cursor","hand");
		}else{
			$("#submit").prop("disabled", true).css("color","grey").css("cursor","auto");
		}
	});
	
	//表单提交时检验  把注册按钮置灰   前台限制一下重复提交
	$("form").submit(function(){
		alert("woshisjsjsj");
		if(checkNick() && checkEmail() && checkPassword()){
			alert("进来了");
			//表单提交时再进行验证
			var value = $("#validataImg").val();
			value = encodeURI(value);
			$.get("servlet/CheckImagValue", {value:value},
					function(data){
					   if("1" === data){
						   //如果验证码正确则提交
						   alert("提交了注册");
						   $("#submit").prop("disabled", true);
						   return true;
					   }else{
						   $("#tip").html("验证码不对").css("color","red");
						   return false;
					   }
			});
		}else{
			return false;
		}		
	});
	
});
//验证码图片
$(function(){
	$("#changeValidataImg").css("cursor","hand");

	$("#changeValidataImg").click(function(){
		$(this).attr("src","/taobaoke/servlet/YanzhengmaImag?ddd=" + new Date().getTime());
	});
	
	$("#validataImg").blur(function(){
		//进行ajax校验
		var value = $("#validataImg").val();
		value = encodeURI(value);
		$.get("servlet/CheckImagValue", {value:value},
				function(data){
				   if("1" != data){
					   $("#tip").html("验证码不对").css("color","red");
				   }
				   if("1" === data){
					   $("#tip").html("验证码正确").css("color","green");
				   }
		});
	});
});
