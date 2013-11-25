<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'comentManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="Stylesheet" type="text/css" href="<%=basePath %>jsp/themes/default/easyui.css" />
	<link rel="Stylesheet" type="text/css" href="<%=basePath %>jsp/themes/icon.css" />
    <link rel="Stylesheet" type="text/css" href="<%=basePath %>jsp/css/demo.css" />
    <script type="text/javascript" src="<%=basePath %>jsp/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>jsp/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>jsp/js/easyui-lang-zh_CN.js" mce_src="script/locale/easyui-lang-zh_CN.js"></script>  

	<script type="text/javascript">
		$(function() {
	
			$("#butsearch").click(function(){  //点击查询的时候
				  var nick = $("#nick").val() == null ? "" : $("#nick").val();
				  var goodName = $("#goodName").val() == null ? "" : $("#goodName").val();

				  var time1 = $("#time1").datebox("getValue") == null ? "" : $("#time1").datebox("getValue");
 				  var time2 = $("#time2").datebox("getValue") == null ? "" : $("#time2").datebox("getValue");

				  nick = encodeURI(encodeURI(nick));
				  goodName = encodeURI(encodeURI(goodName));
				  
// 				  $("#dg").datagrid("url","servlet/LoadCommentsServlet?type=search&nick="+nick+"&goodName="+goodName+"&time1="+time1+"&time2="+time2);
				  $("#dg").datagrid({url:"servlet/LoadCommentsServlet?type=search&nick="+nick+"&goodName="+goodName+"&time1="+time1+"&time2="+time2});
				  
				  
			});	
		});
		function showHint(str,sort){
			$.ajax({
			   type: "POST",
			   url: "<%=basePath%>servlet/SearchByUserServlet",
			   data: "name="+str+"&sort="+sort,
			   success: function(msg){
			     //动态生成表格
			     if(msg){
			     	if(sort==1){
				     	 $("#lx").css("display","block");
				     	 $("#lx").css("z-index",99999);
					     $("#lx").empty();
				     }else{
				     	$("#lxp").css("display","block");
				     	 $("#lxp").css("z-index",99999);
					     $("#lxp").empty();
				     }
				     var names=eval('('+msg+')');
				     var table=$("<table cellspacing =\"0\" cellpadding=\"2\" style=\"background-color:FFFFFF\"/>");
				     var tbody=$("<tbody></tbody>");
				     tbody.appendTo(table);
				     if(sort==1){
				     	table.appendTo($("#lx"));
				     }else {
				     	table.appendTo($("#lxp"));
				     }
				     for(var i=0;i<names.length;i++){
				     	var tr=$("<tr></tr>");
				     	$("<td class=\"ml\">"+names[i]+"</td>").appendTo(tr);
				     	tr.appendTo(tbody);
				     }
					$(".ml").mouseover(function(){
					  	$(this).css("background-color","EBEBEB");
					});
					$(".ml").mouseout(function(){
				  		$(this).css("background-color","FFFFFF");
					});
					if(sort==1){
						$("#lx").mouseleave(function(){
							$(this).css("display","none");
						});
						$(".ml").click(function(){
							$("#lx").css("display","none");
							$("input[name='username']").val($(this).text());
						});
					}else {
						$("#lxp").mouseleave(function(){
							$(this).css("display","none");
						});
						$(".ml").click(function(){
							$("#lxp").css("display","none");
							$("input[name='pro']").val($(this).text());
						});
					}
				 }
			   }
			});
		}
		function destroyUser() {
			var row = $('#dg').datagrid('getSelected');
			
			alert(row.cId);
			
			if (row) {
				$.messager.confirm('Confirm','您确定要删除选中的用户吗？', function(r) {
					if (r) {
						$.get('servlet/LoadCommentsServlet?type=del', {cId : row.cId}, function(data) {
							if (data == "1") {
								$("#messagebox").css("color","green").html("删除成功！").show(300).delay(2000).hide(0);
        				
								$('#dg').datagrid('reload'); // reload the user data  
							} else if(data == "0"){
								$("#messagebox").css("color","red").html("删除失败！").show(300).delay(2000).hide(0);
							}else{
								$("#messagebox").css("color","red").html("未选中行！").show(300).delay(2000).hide(0);
							}
						}, 'json');
					}
				});
			}
		}

	
</script>
<style type="text/css">
#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}
#lx , #lxp{
	border: 1px solid #817F82;
    position: absolute;
}
#lx .ml , #lxp .ml {
    background: none repeat scroll 0 0 #FFFFFF;
    margin-right:0px;
    width:130px;
}
#lx table ,#lxp table{
	border-collapse: collapse;
    border-spacing: 0;
    width:100%;
    cursor: default;
}
#messagebox{
		display:none;
		width:500px;
		height: 150px;
		font-size:50px;
		font-weight:10px;
		z-index:500;
		position: fixed;
		margin-top: 300px;
		margin-left: 300px;
}
</style>


  </head>
  
  <body>
<!--  实现评论管理 
	1、查看评论 
	2、根据条件查询  a.某一用户的所有评论  所有的差评 中评 好评   b.查看某一商品的评论
	3、删除评论  
	
	A、加载评论 条件查询 1 用户查询   作用：可以作为用户信任度的判定  
				 2  商品查询   作用：可以联合销量查看某一商品的青睐度  决定是否继续推广
				 3  某商品差评 中品 好评率   作用：筛选热卖商品 给商品添加标签
	B、删除评论
	
	给评论表添加一个字段：level确定评论级别   1 差      2  中      3  好
	

	额外的
	1 评论级别     差中好累计  得出一系列信息   好评率 差评率 。。。。 几颗星 代替  一颗星 差  三颗星 好
	2给商品 添加标签  热卖。。。
	3每日好评榜
	
	需解决的
	给数据库 中评论表 添加一个字段    level 1 差评    2 中评  3 好评  至于是否评论 就不用加字段了 直接根据 user_id goods_id 查  如果没有则可以进行评论
-->
  <div id="wrap">
  	  <!-- 引入头部 -->
      <jsp:include page="../header.jsp"></jsp:include>
      <!-- 主体 -->
      <div id="messagebox" ></div>
      		<table width="100%" border="0" cellpadding="0" cellspacing="1"
			bgcolor="#D1DDAA" align="center">
			<tr>
				<td height="26">
					<table width="98%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td align="left"><input type='button' id="delbutton"
								style="border: 1px solid #CCCCCC;" value='删除' onclick="destroyUser()"/></td>
						</tr>
					</table></td>
			</tr>
		</table>

		<!-- 条件查询   -->
		<!-- 注:异步获取输入条件,需要用到Ajax技术 -->
		<table width='100%' border='0' cellpadding='1' cellspacing='1'
			bgcolor='#CBD8AC' align="center" style="margin-top:0px">
			<tr bgcolor='#EEF4EA'>
				<td align='left'>
					<table border='0' cellpadding='0' cellspacing='0'>
						<tr>
							<td width='90' align='center'>评价人用户名</td>
							<td width='110'><input id="nick" name='username' size="20" onkeyup="showHint(this.value,1)"/>
							<div style="display:none;width:130px;" id="lx">
							</div>
							</td>
							<td width='90' align='center'>评价商品</td>
							<td width='110'><input id="goodName" name='pro' size="20" onkeyup="showHint(this.value,2)"/>
							<div style="display:none;width:130px;" id="lxp">
							</div>
							</td>
<!-- 							<td width='110'><input name='pro' size='20' /></td> -->
							<td width='90' align='center'>评价时间</td>
							<td width='250'>
								<input id="time1" style="width:100px;" class='easyui-datetimebox' type="text"  name="birthdayfrom"></input>
								－
								<input id="time2" style="width:100px;" class='easyui-datetimebox' type="text" name="birthdayto"></input>
							</td>
							<td>
								<input name="imageField" type="image" id="butsearch" src="<%=basePath%>jsp/images/tool/search.gif" width="45" height="21" border="0" class="np" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		
		<table id="dg" title="评论列表" class="easyui-datagrid" width="100%"
			url="<%=basePath%>servlet/LoadCommentsServlet?type=load" 
			pagination="true" rownumbers="true" fitColumns="true"
			singleSelect="false" muilSelect="true">
			<thead>
				<tr>
					
					<th field="userName" width="10%">用户名</th>
					<th field="goodName" width="10%">商品名</th>
					<th field="content" width="10%">内容</th>
					<th field="time" width="10">时间</th>
					<th field="goodLevel" width="10%">好评</th>
					<th field="midLevel" width=10%">中评</th>
					<th field="badLevel" width="10%">差评</th>
					<th field="total" width="10%">总评数</th>
					<th field="goodRate" width="10%">好评率</th>
					<th field="badRate" width="10%">差评率</th>
				</tr>
			</thead>
		</table>
      

      
      
      
    
      <!-- 引入尾部 -->
      <jsp:include page="../footer.jsp"></jsp:include>  
   </div>
  </body>
</html>
