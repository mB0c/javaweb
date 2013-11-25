<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>淘宝客-首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">b
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jsp/css/style.css" />
	<script type="text/javascript" src="<%=basePath%>jsp/js/jquery-1.9.1.min.js"></script></head>
  
  <body>
 <div id="wrap">
       
       <!-- 引入头部 -->
       <jsp:include page="../header.jsp"></jsp:include>
       
       <div class="center_content">
       	<div class="left_content">
        	
            <div class="title"><span class="title_icon"><img src="<%=basePath%>jsp/images/bullet1.gif" alt="" title="" /></span>精品推荐</div>
            
        	<div class="content">
	        	<div class="feat_prod_box">
	            
	            	<div class="prod_img"><a href="details.html"><img class="low_img" src="<%=basePath%>jsp/images/huapi2_high.jpg" alt="画皮2" title="" border="0" /></a></div>
	                
	                <div class="prod_det_box">
	                	<div class="box_top"></div>
	                    <div class="box_center">
	                    <div class="prod_title"><a href="details.html">Product name</a></div>
	                    <p class="details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
	                    <span class="price">¥<em>24.6</em></span><a href="details.html" class="more">- 详细 -</a>
	                    <div class="clear"></div>
	                    </div>
	                    
	                    <div class="box_bottom"></div>
	                </div>    
	            <div class="clear"></div>
	            </div>	
            
            
	        	<div class="feat_prod_box">
	            
	            	<div class="prod_img"><a href="details.html"><img src="<%=basePath%>jsp/images/prod2.gif" alt="" title="" border="0" /></a></div>
	                
	                <div class="prod_det_box">
	                	<div class="box_top"></div>
	                    <div class="box_center">
	                    <div class="prod_title"><a href="details.html">Product name</a></div>
	                    <p class="details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
	                    <span class="price">¥<em>24.6</em></span><a href="details.html" class="more">- 详细 -</a>
	                    <div class="clear"></div>
	                    </div>
	                    
	                    <div class="box_bottom"></div>
	                </div>    
	            <div class="clear"></div>
	            </div>      
            
	        	<div class="feat_prod_box">
	            
	            	<div class="prod_img"><a href="details.html"><img src="<%=basePath%>jsp/images/prod1.gif" alt="" title="" border="0" /></a></div>
	                
	                <div class="prod_det_box">
	                	<div class="box_top"></div>
	                    <div class="box_center">
	                    <div class="prod_title"><a href="details.html">Product name</a></div>
	                    <p class="details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
	                    <span class="price">¥<em>24.6</em></span><a href="details.html" class="more">- 详细 -</a>
	                    <div class="clear"></div>
	                    </div>
	                    
	                    <div class="box_bottom"></div>
	                </div>    
	            <div class="clear"></div>
	            </div>	
            
            
	        	<div class="feat_prod_box">
	            
	            	<div class="prod_img"><a href="details.html"><img src="<%=basePath%>jsp/images/prod2.gif" alt="" title="" border="0" /></a></div>
	                
	                <div class="prod_det_box">
	                	<div class="box_top"></div>
	                    <div class="box_center">
	                    <div class="prod_title"><a href="details.html">Product name</a></div>
	                    <p class="details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
	                    <span class="price">¥<em>24.6</em></span><a href="details.html" class="more">- 详细 -</a>
	                    <div class="clear"></div>
	                    </div>
	                    
	                    <div class="box_bottom"></div>
	                </div>    
	            <div class="clear"></div>
	            </div>      
            
            </div>
            
           <div class="title">
           	<span class="title_icon">
           		<img src="<%=basePath%>jsp/images/bullet2.gif" alt="" title="" />
           	</span>
           	小说类
           	<span class="title_more">
           		<a href="bookList.html">更多&gt;&gt;</a>
           	</span>
           </div> 
           
           <div class="new_products">
           
                    <div class="new_prod_box">
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="<%=basePath%>jsp/images/new_icon.gif" alt="" title="" /></span>
                        <a href="details.html"><img src="<%=basePath%>jsp/images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>
                        <a href="details.html">product name</a>
                        <span class="price">¥<em>24.6</em></span>
                    </div>
                    
                    <div class="new_prod_box">
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="<%=basePath%>jsp/images/new_icon.gif" alt="" title="" /></span>
                        <a href="details.html"><img src="<%=basePath%>jsp/images/thumb2.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>
                        <a href="details.html">product name</a>
                        <span class="price">¥<em>24.6</em></span>    
                    </div>                    
                    
                    <div class="new_prod_box">
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="<%=basePath%>jsp/images/new_icon.gif" alt="" title="" /></span>
                        <a href="details.html"><img src="<%=basePath%>jsp/images/thumb3.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>
                        <a href="details.html">product name</a>
                        <span class="price">¥<em>24.6</em></span>          
                    </div>
                    
                    <div class="new_prod_box">
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="<%=basePath%>jsp/images/new_icon.gif" alt="" title="" /></span>
                        <a href="details.html"><img src="<%=basePath%>jsp/images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>
                        <a href="details.html">product name</a>
                        <span class="price">¥<em>24.6</em></span>
                    </div>
                    
                    <div class="new_prod_box">
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="<%=basePath%>jsp/images/new_icon.gif" alt="" title="" /></span>
                        <a href="details.html"><img src="<%=basePath%>jsp/images/thumb2.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>
                        <a href="details.html">product name</a>
                        <span class="price">¥<em>24.6</em></span>
                    </div>                    
                    
            </div> 
            
            <div class="title">
           	<span class="title_icon">
           		<img src="<%=basePath%>jsp/images/bullet2.gif" alt="" title="" />
           	</span>
           	传记类
           	<span class="title_more">
           		<a href="bookList.html">更多&gt;&gt;</a>
           	</span>
           </div> 
            
            <div class="new_products">
           
                    <div class="new_prod_box">
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="<%=basePath%>jsp/images/new_icon.gif" alt="" title="" /></span>
                        <a href="details.html"><img src="<%=basePath%>jsp/images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>
                        <a href="details.html">product name</a>
                        <span class="price">¥<em>24.6</em></span>
                    </div>
                    
                    <div class="new_prod_box">
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="<%=basePath%>jsp/images/new_icon.gif" alt="" title="" /></span>
                        <a href="details.html"><img src="<%=basePath%>jsp/images/thumb2.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>
                        <a href="details.html">product name</a>
                        <span class="price">¥<em>24.6</em></span>
                    </div>                    
                    
                    <div class="new_prod_box">
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="<%=basePath%>jsp/images/new_icon.gif" alt="" title="" /></span>
                        <a href="details.html"><img src="<%=basePath%>jsp/images/thumb3.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>
                        <a href="details.html">product name</a>
                        <span class="price">¥<em>24.6</em></span>
                    </div>
                    
                    <div class="new_prod_box">
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="<%=basePath%>jsp/images/new_icon.gif" alt="" title="" /></span>
                        <a href="details.html"><img src="<%=basePath%>jsp/images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>
                        <a href="details.html">product name</a>
                        <span class="price">¥<em>24.6</em></span>
                    </div>
                    
                    <div class="new_prod_box">
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="<%=basePath%>jsp/images/new_icon.gif" alt="" title="" /></span>
                        <a href="details.html"><img src="<%=basePath%>jsp/images/thumb2.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>
                        <a href="details.html">product name</a>
                        <span class="price">¥<em>24.6</em></span>
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
