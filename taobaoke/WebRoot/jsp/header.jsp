<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'header.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jsp/css/style.css" />

<!-- 	<script type="text/javascript" src="<%=basePath%>jsp/js/jquery-1.9.1.min.js"></script> -->
	<style type="text/css">
		#background{
			width: 100%;
			height: 100%;
			background: gray;
			opacity:0.8;
			position: fixed;
			z-index:999;
		}
		
		#contact_form{
			margin: 177px 0 0 -177px;
			left: 50%;
			position: fixed;
			background: white;
			z-index: 65535;
		}	
	</style>

	
	<script type="text/javascript">
		$(function(){
			$("#login").click(function(){
				$("#background").css("display","block");
				$("#contact_form").css("display","block");			
			});
			$("#background").click(function(){
				$("#background").css("display","none");
				$("#contact_form").css("display","none");	
			});
			
		});
	</script>
  </head>
  
  <body>
  
  <!-- 弹出层开始 -->
  <div id="background" style="display:none"></div>
  <div id="contact_form" class="contact_form" style="display:none">
                <div class="form_subtitle">输入用户名和密码</div>
                 <form method="post" action="<%=basePath%>servlet/LoginServlet" name="login" id="loginForm">  
                    <p style="color:red;margin-left:70px;">&nbsp;</p>
                    <div class="form_row">
                    <label class="contact"><strong>用户名:</strong></label>
                    <input type="text" name="userName" class="contact_input" id="userName">
                    </div>  


                    <div class="form_row">
                    <label class="contact"><strong>密码:</strong></label>
                    <input type="password" name="password" class="contact_input" id="password">
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>用户身份:</strong></label>
                    <select name="role" style="width:253px;">
                    	<option value="1">普通用户</option>
                    	<option value="0">管理员</option>
                    </select>
                    </div>                     

                    <div class="form_row">
                        <div class="terms">
                        <input type="checkbox" value="1" name="terms">
                        保持登录状态
                        </div>
                    </div> 

                    
                    <div class="form_row">
                    <input type="submit" value="登录" class="register">
                    </div>   
                    
                  </form>     
                    
                </div>
    <!-- 弹出层结束 -->
  
  
  
  	<div id="wrap">
      <div class="header">
       	<div class="logo"><a href="index.html"><img src="<%=basePath%>jsp/images/logo.gif" alt="" title="" border="0" /></a></div>
        <div id="menu">
            <ul>
            <li class="selected"><a href="/taobaoke/jsp/user/indexp.jsp">首页</a></li>
            <li><a href="javascript:void(0)">分类</a></li>
            <li><a href="javascript:void(0)">畅销榜</a></li>
            <li><a href="javascript:void(0)">团购</a></li>
            
            <li><a href="javascript:void(0)">特价品牌</a></li>
            
            </ul>
        </div>
        <%String userName = (String)request.getAttribute("userName"); %>
        <div id="account">
        <%if(null == userName || "".equals(userName)){ %>
        	<div id="nouser">
        		<a href="javascript:void()" id="login" >登录</a>
        		<a href="<%=basePath%>jsp/user/register.jsp">注册</a>
        	</div>
        <%}else{ %>
        	<div id="hasuser">
        		
        		<a href="login.html">欢迎您，${userName }</a>
        		<a href="<%=basePath%>servlet/LoginServlet?logout=1">退出</a>
        	</div>  
        <%} %>	
        </div>
            
       </div> 
     </div> 
  </body>
</html>
