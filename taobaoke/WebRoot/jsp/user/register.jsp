<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String validataImag = (String)request.getSession().getAttribute("validataImag");
validataImag = validataImag == null ? "" : validataImag;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
    <base href="<%=basePath%>">
    
    <title>淘宝客-注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<%=basePath%>jsp/css/style.css" />
	
	<script type="text/javascript" src="<%=basePath%>jsp/js/jquery-1.9.1.min.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>jsp/js/register.js" charset="gb2312"></script>
  </head>
  
<body>
	<div id="wrap">
	
 	<%=validataImag %>
    
    <!-- 引入头部 -->
       <jsp:include page="../header.jsp"></jsp:include>    
    
    <div class="center_content">
    	<div id="goRegister">
       	<div class="left_content">
            <div class="title"><span class="title_icon"><img src="<%=basePath%>jsp/images/bullet1.gif" alt="" title="" /></span>用户注册</div>
        
        	<div class="feat_prod_box_details">
            
              	<div class="contact_form">
                <div class="form_subtitle">创建新账号</div>
                 <form name="register" action="<%=basePath%>servlet/RegisterServlet">
                 <p id="tip" style="color:red;margin-left:70px;">&nbsp;${registerMessage}</p>
                    <div class="form_row">
                    <label class="contact"><strong>昵称:</strong></label>
                    <input type="text" class="contact_input" id="inpu_userName" name="nick"/>
                    </div>


                    <div class="form_row">
                    <label class="contact"><strong>邮箱:</strong></label>
                    <input type="text" class="contact_input" id="inpu_email" name="email"/>
                    </div> 

                    <div class="form_row">
                    <label class="contact"><strong>密码:</strong></label>
                    <input type="password" class="contact_input" id="inpu_password" name="password"/>
                    </div>


                    <div class="form_row">
                    <label class="contact"><strong>确认密码:</strong></label>
                    <input type="password" class="contact_input" id="inpu_password1" name="password1"/>
                    </div>
                                                     
                    <div class="form_row">
                    <label class="contact"><strong>验证码:</strong></label>
                    <input type="text" class="contact_input" id="validataImg" name="validataImg" value="<%=validataImag %>"/><img id="changeValidataImg"  src="<%=basePath %>servlet/YanzhengmaImag"></img>
                    </div>
                    
                    <div class="form_row">
                        <div class="terms">
                        <input type="checkbox" name="terms" id="inpu_checkbox" checked="checked"/>
                        我同意用户约束条款</div>
                    </div>

                    
                    <div class="form_row">
                    <input type="submit" class="register" value="注册" id="submit"/>
                    </div>   
                  </form>
                </div>
            </div>
      </div>
      
      <div class="clear"></div>
       </div>
       <!--end of center content-->
       
              
   <!-- 引入尾部 -->
       <jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>

</html>
