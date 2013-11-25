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
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jsp/css/style.css" />
	<script type="text/javascript" src="<%=basePath%>jsp/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jsp/js/jquery.masonry.js"></script>
		
	<!--Passit BUTTON BEGIN-->
	<script type="text/javascript">
	var passit_title = "";//自定义分享标题，删除和留空表示使用默认
	var passit_url = "";//自定义分享网址，删除和留空表示使用默认
	var passit_content= "";//自定义分享内容，删除和留空表示使用默认Meta中的描述
	var passit_image= "";//自定义分享图片，删除和留空表示不分享图片
	var sina_appkey= "";//sina微博appkey,删除和留空表示使用默认
	var qq_appkey= "";//腾讯微博appkey,删除和留空表示使用默认
	</script>
	<script type="text/javascript">
	bookmark_service="share,qqkj,sinaweibo,xnzt,qqweibo,more";</script>
	<script type="text/javascript" src="http://www.passit.cn/js/passit_float_new.js?pub=0&img_src=btn19&move=0&simple=1" charset="UTF-8"></script>
	<!--Passit BUTTON END-->

	
	
	<style type="text/css">
		.item {
			
			  padding-top:10px;
			  padding-left:6px;
			  padding-right:6px;
			  width: 170px;
			  margin: 10px;
			  float: left;
			  background-color: gray;
			}
		.item .price{
			font-size: 20px;
			color:red;
			font-style: italic;
		}
		.item .volum{
			text-align: left;
			color:green;
			
		}
		.toTop{
			position:fixed;
			bottom:72px;
			right:10px;
			display:block;
			width:60px;
			height:62px;
			background-image: url("<%=basePath%>jsp/images/tool/globe-sider.png");
			background-position:1px -1px;
		}
		a{
			outline: none;
		}
		.toTop:HOVER {
			background-position:61px -1px;
		}
		.erweima{
			position:fixed;
			bottom:10px;
			right:10px;
			display:block;
			width:60px;
			height:62px;
			background-image: url("<%=basePath%>jsp/images/tool/globe-sider.png");
			background-position:0px -127px;
		}
		.erweima:HOVER {
			background-position:61px -127px;
		}
		#hideErweima{
			display: none;
			position:fixed;
			bottom:62px;
			right:70px;
			width:150px;
			height:150px;
		}
		#hideErweima img{
			border:none;
		}
	</style>
	
	
	<script type="text/javascript">
		var pageNo = 2;
		$(function(){
			  $('#container').masonry({
			    // options
			    itemSelector : '.item',
			    columnWidth: '170px',
			   	columnWidth: function( containerWidth ) {
    					return containerWidth / 4;
				 }
			  });
		});
	
		$(window).scroll(function(){
			//获取可视区域的高度
			var a = document.body.clientHeight;
			//获取滚动被隐藏的高度
			var b = document.body.scrollTop;
			//获取整个可滚动的高度
			var c = document.body.scrollHeight;
			//如果有footer的话 获取他的高度
			var d = $("#footer").height();
			
			//动态加载 商品
			if(a+b == c){
				//如果滑到了底部 则进行加载图片  用ajax 加载
				
				setTimeout(loadMore, 500);
				
				//loadMore();
				$("#tip").show();
			}
			
			//是否隐藏  回到顶部
			if(b == 0){
				$("#a1").css("display","none");
			}else if(b >= 300){
				$("#a1").css("display","block");
			}
			
		});
		function loadMore(){
			
			//去后台取数据进行加载  一次获取20张  
			$.get("servlet/GetImgServlet",{pageNo:pageNo},function(data){
				if(data != ""){ //取到了数据
					//解析数据
					var dt = eval(data);
					var html ="";
					//遍历获取到的数据
					$.each(dt,function(i){
						html += "<div class='item'><div><a href='"
						+dt[i].url+"'><img src='"
						+dt[i].picUrl+"' width='170px'/></a></div><div><a href='"
						+dt[i].url+"'>"+dt[i].name+"</a><span class='price'>  ￥"
						+dt[i].price+"元</span></div><div class='volum'>月销量："
						+dt[i].volum+"</div> </div>";
						
					});
					var $boxes = $(html);
					$("#container").append( $boxes ).masonry( 'appended', $boxes );  // .ppend($boxes).masonry("reload");
					pageNo = pageNo + 1;
					$("#tip").hide();
				}
			});
		}
		
		$(function(){
			//页面打开后即加载
			$.get("servlet/GetImgServlet",{pageNo:1},function(data){   //默认显示一页
				if(data != ""){ //取到了数据
					//解析数据
					var dt = eval(data);
					var html ="";
					$.each(dt,function(i){
						
						html += "<div class='item'><div><a href='"+dt[i].url+"'><img src='"+dt[i].picUrl+"' width='170px'/></a></div><div><a href='"+dt[i].url+"'>"+dt[i].name+"</a><span class='price'>  ￥"+dt[i].price+"元</span></div><div class='volum'>月销量："+dt[i].volum+"</div> </div>";
						
					});
					var $boxes = $(html);
					$("#container").prepend($boxes).masonry("reload");
					
				}
			});

		$("#a1").click(function(){
			//点击回到顶部
			document.body.scrollTop = 0;
		})
		$("#a2").mouseover(function() {
				$("#hideErweima").css("display", "block");
			});
		$("#a2").mouseout(function() {
				$("#hideErweima").css("display", "none");
			});
		//初始化时 隐藏 回到顶部
		$("#a1").css("display","none");

	});
	</script>
	
</head>
  
  <body>
 <div id="wrap">
       
       <!-- 引入头部 -->
       <jsp:include page="../header.jsp"></jsp:include>
       <div id="hideErweima">
       	<img alt="二维码" src="<%=basePath%>jsp/images/tool/99.png">
       </div>
       <div>
       	<a id="a1" href="javascript:void(0)" class="toTop"></a>
       	<a id="a2" href="javascript:void(0)" class="erweima"></a>
       </div>
       <div id="container">
	   </div>
       <div id='tip' style="display: none; width:900px; text-align: center;" >
       	<img src="<%=basePath%>jsp/images/tool/loading.gif"/>
       </div>
       <!-- 引入尾部 -->
       <jsp:include page="../footer.jsp"></jsp:include>
   
	</div>
</body>
</html>
