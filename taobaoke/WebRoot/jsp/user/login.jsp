<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>淘宝客-登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<%=basePath%>jsp/css/style.css" />

	<script type="text/javascript" src="<%=basePath%>jsp/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jsp/js/jquery.cookie.js"></script>
	jsp/js/jquery.cookie.js
	<script type="text/javascript">
	    
		$(function(){
			//校验表单数据
			$("form").submit(function(){
				var userName = $("#userName1").val();
				if(null == userName){
					
					alert("用户名不能为空！！！");
					return false;
				}
				if($("#password1").val() == null || "" == $("#password1").val()){
					alert("密码不能为空！！！");
					return false;
				}
				return true;
			});
			
		});
		
			var userName2 = $.cookie("userName");
			var password2 = $.cookie("password");
			var keepLogin2 = $.cookie("keepLogin");
		
		$(function(){
			//默认填充 
			//判断cookie中是否有用户的信息

			if(null != userName2 && null != password2){
				$("#userName1").val(userName2);
				$("#password1").val(password2);
				$("form input[name='terms']").attr("checked", keepLogin2=="1"? true : false);
			//是否需要自动提交
				if(keepLogin2=="1"){
					$("form").submit();
				}
			}
		});

	</script>
	
  </head>
  
<body>

<div id="wrap">

              
      <!-- 引入头部 -->
      <jsp:include page="../header.jsp"></jsp:include>
      
       
       <div class="center_content">
       	<div class="left_content">
       		<div id="goLogin">

          <div class="title"><span class="title_icon"><img src="<%=basePath%>jsp/images/bullet1.gif" alt="" title="" /></span>我的账号</div>
        
        	<div class="feat_prod_box_details">
            	
              	<div class="contact_form">
                <div class="form_subtitle">输入用户名和密码</div>
                 <form id="loginForm" name="login" action="<%=basePath%>servlet/LoginServlet" method="post">  
                    <p style="color:red;margin-left:70px;">&nbsp;${msg }</p>
                    <div class="form_row">
                    <label class="contact"><strong>用户名:</strong></label>
                    <input id="userName1" type="text" class="contact_input" name="userName" value="邮箱"/>
                    </div>


                    <div class="form_row">
                    <label class="contact"><strong>密码:</strong></label>
                    <input id="password1" type="password" class="contact_input" name="password"/>
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>用户身份:</strong></label>
                    <select style="width:253px;" name="role">
                    	<option value="1">普通用户</option>
                    	<option value="0">管理员</option>
                    </select>
                    </div>                     

                    <div class="form_row">
                        <div class="terms">
                        <input type="checkbox" name="terms" value="1"/>
                        保持登录状态
                        </div>
                    </div> 

                    
                    <div class="form_row">
                    <input type="submit" class="register" value="登录" />
                    </div>   
                    
                  </form>     
                    
                </div>  
            
            </div>	
            </div>
        <div class="clear"></div>
        </div><!--end of left content-->
        
       <div class="clear"></div>
       </div><!--end of center content-->
       
              
       <!-- 引入尾部 -->
       <jsp:include page="../footer.jsp"></jsp:include>
</div>

</body>
</html>
