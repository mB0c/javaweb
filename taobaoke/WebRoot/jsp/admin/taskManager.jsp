<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'easyui_1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="Stylesheet" type="text/css" href="<%=basePath %>jsp/themes/default/easyui.css" />
	<link rel="Stylesheet" type="text/css" href="<%=basePath %>jsp/themes/icon.css" />
    <link rel="Stylesheet" type="text/css" href="<%=basePath %>jsp/css/demo.css" />
    <script type="text/javascript" src="<%=basePath %>jsp/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>jsp/js/jquery.easyui.min.js"></script>
	    <script type="text/javascript" src="<%=basePath %>jsp/js/easyui-lang-zh_CN.js" mce_src="script/locale/easyui-lang-zh_CN.js"></script>  
	<style type="text/css">
		#messagebox{
			display:none;
			width:500px;
			height: 150px;
			font-size:50px;
			font-weight:10px;
			z-index:500;
			position: relative;
			margin-top: 300px;
			margin-left: 300px;
		}

	</style>

  </head>
  
  <body>
  <div id="wrap">
  	  <!-- 引入头部 -->
      <jsp:include page="../header.jsp"></jsp:include>
<!--   <div class="center_content"> -->
  
  
     <div id="zhezhao">
   	 	<div id="messagebox" ></div>
 	 </div>   
    <table id="tt"></table> 

  <div id="newuser" style="margin-top:500px;">
 		<div id="dlg" class="easyui-dialog"  title="新建用户" style="width: 300px;" buttons='#dlg-buttons' closed="true">
		    <form id="ff" method="post">

			    	<input type="hidden" id="id" name="id" value="0"/>

			    	<table>
			    		<tr>
			    			<td>任务名称：</td>
			    			<td><input id="name" class="easyui-validatebox" type="text" name="name" data-options="required:true"></input></td>
			    		</tr>
			    		<tr>
			    			<td>关键字:</td>
			    			<td><input id="keyword" class="easyui-validatebox" type="text" name="keyword" data-options="required:true"></input></td>
			    		</tr>
			    		<tr>
			    			<td>类别ID：</td>
			    			<td><input id="cid" class="easyui-validatebox" type="text" name="cid" data-options="required:true"></input></td>
			    		</tr>

			    		<tr>
			    			<td>开始时间：</td>
			    			<td><input id="startTime" class="easyui-validatebox" type="text" name="startTime" data-options="required:true"></input></td>
			    		</tr>			    		
			    		<tr>
			    			<td>结束时间：</td>
			    			<td><input id="endTime" class="easyui-validatebox" type="text" name="endTime" data-options="required:true"></input></td>
			    		</tr>
			    		<tr>
			    			<td>最低佣金比率：</td>
			    			<td><input id="minRate" class="easyui-validatebox" type="text" name="minRate" data-options="required:true"></input></td>
			    		</tr>
			    		<tr>
			    			<td>月最低推广量：</td>
			    			<td><input id="minNum" class="easyui-validatebox" type="text" name="minNum" data-options="required:true"></input></td>
			    		</tr>
			    		<tr>
			    			<td>月最高推广量：</td>
			    			<td><input id="maxNum" class="easyui-validatebox" type="text" name="maxNum" data-options="required:true"></input></td>
			    		</tr>
			    	</table>
			    </form>
			    
		</div>
	<div id="dlg-buttons">  
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveUser()">保存</a>  <!-- 这里要用两次  所以可以公用代码  用form提交的方式   -->
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
    </div>
  </div>
    <script type="text/javascript">	
    
    //获取全部数据后  进行整体上的分页
		function pagerFilter(data){
			if (typeof data.length == 'number' && typeof data.splice == 'function'){	// is array
				data = {
					total: data.length,
					rows: data
				}
			}
			var dg = $(this);
			var opts = dg.datagrid('options');
			var pager = dg.datagrid('getPager');
			pager.pagination({
				onSelectPage:function(pageNum, pageSize){
					opts.pageNumber = pageNum;
					opts.pageSize = pageSize;
					pager.pagination('refresh',{
						pageNumber:pageNum,
						pageSize:pageSize
					});
					dg.datagrid('loadData',data);
				}
			});
			if (!data.originalRows){
				data.originalRows = (data.rows);
			}
			var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
			var end = start + parseInt(opts.pageSize);
			data.rows = (data.originalRows.slice(start, end));
			return data;
		}
    
    
        $(function(){ 
            $('#tt').datagrid({ 
                width:850,  
                height:300,
                pageList:[5,10,15,20],
                striped:true,   //交替显示行背景
                //idField:'xsbh',  
                url:"servlet/GetTaskConfServlet",
                singleSelect:false,
                rownumbers:true,//显示行数 默认为false
                columns:[[

                
                  {field:"id",checkbox:true},
                  {field:"name",title:"任务名称",width:50},
                  {field:"keyword",title:"关键字",width:50},
                  {field:"cid",title:"类别ID",width:50},
                  {field:"startTime",title:"开始时间",width:50},
                  {field:"endTime",title:"结束时间",width:50},             
                  {field:"minRate",title:"最低佣金比率",width:90},             
                  {field:"minNum",title:"月最低推广量",width:90},        
                  {field:"maxNum",title:"月最高推广量",width:90},      
                  {field:"status",title:"任务状态",width:50},  
                  

                  {field:'opt',title:'操作',width:100,
                  align:'center',  
                    formatter:function(value,rowdata,index){ //value:字段的值  rowdata：行数据   index:行索引
                    	
                    	var v = "<a href='javascript:void(0)' onclick='ve("+ rowdata.xsbh +")'>查看</a> ";
                    	var e = "<a href='javascript:void(0)' onclick='et("+ rowdata.xsbh +")'>编辑</a> ";
                    	var d = "<a href='javascript:void(0)' onclick='dl("+ index +")'>删除</a>";

                        return v + e + d ;
                    }
                  }
                ]],  
                toolbar:[
                {text:'定制任务',iconCls:'icon-add',handler:addItem },  
                {text:'编辑任务',iconCls:'icon-edit',handler:editItem },  
                {text:'查找',iconCls:'icon-search'},
                {text:'删除任务',iconCls:'icon-cancel',handler:deleteItem }
                ],  
               pagination:true  
            }); 
            
           $('#tt').datagrid({loadFilter:pagerFilter});  // 分页功能
        });  
        

        var url="";
        
        function addItem(){
        
        	//添加用户
        	$('#dlg').dialog('open');
        	$("#ff").form("clear");
        	url = "servlet/TaskServlet?type=add";
        }
        
        //点击保存用户按钮
        function saveUser(){
        alert(url);
        	var name = encodeURI($("#name").val());//ajax传中文要URI编码  后台解码
        	
        	var keyword = encodeURI($("#keyword").val());  //
        	var cid = $("#cid").val();
        	var startTime = $("#startTime").val();
        	var endTime = $("#endTime").val();
        	var minRate = $("#minRate").val();
        	var minNum = $("#minNum").val();
        	var maxNum = $("#maxNum").val();
        	
        	alert(name + keyword + cid + startTime + endTime + minRate + minNum + maxNum);
        	
        	//获取默认的值
        	var id = $("#id").val();

        	
        	//alert(status + pwdIsChanged + id + activeCode);
        	
        	$("#dlg").dialog("close");
        	//提交之前对表单数据再校验一下
        	if(!$("#ff").form('validate')){
        		//alert(url);
        		return;
        	}
        	$.get(
        		url,
        		{name:name,keyword:keyword,cid:cid,startTime:startTime,endTime:endTime,minRate:minRate,minNum:minNum,maxNum:maxNum},
        		function(data){
        			
        			alert(data);
        			data = decodeURI(data,"utf-8");
        			if("任务添加成功！" == data){
        				$("#messagebox").css("color","green").html("任务添加成功！").show(300).delay(2000).hide(0);
        				$("#tt").datagrid("reload");
        			}else if("修改成功！" == data){
        				$("#messagebox").css("color","green").html("修改成功！").show(300).delay(2000).hide(0);
        				$("#tt").datagrid("reload");
        			}else if("任务添加失败！"){
        				$("#messagebox").css("color","red").html("任务添加失败！").show(300).delay(2000).hide(0);
        			}
        		}
        	);
        }
        
        //如果修改了密码 则添加一个标记
        $("#password").change(function(){
        	alert("密码被修改了");
        	$("#pwdIsChanged").val("1");
        });
        
        function editItem(){
        	//编辑用户
        	var s = $("#tt").datagrid('getSelected');//获取选中的行
        	if (null == s || s.length == 0) {  
        		alert("请选择要编辑的用户！");
				return;  
			}
			alert(s.activeCode);
        	$('#dlg').dialog('setTitle','编辑用户').dialog('open');
        	$("#ff").form('load',s);
        	url = "servlet/AddUserServlet?type=editItem";
        	//alert(url);
        }
        
        
        function deleteItem(){
          	
          	//确认停止任务
          	$.messager.confirm('确认','确认停止该任务？',function(flag){
          	
          		if(flag){//确认
          			var s = $("#tt").datagrid('getSelections');//获取选中的行
          			if (null == s || s.length == 0) {  
        				alert("请选择要停止的任务！");
				        return;  
				     }
				     
				     var names=[];  
					 for(var i=0;i<s.length;i++){
					 	var name = encodeURI(s[i].name);//encodeURI(encodeURI(s[i].name))
					 	names.push(name);
					 }
				     //ajax后台进行
				     $.get(
				     	"servlet/TaskServlet",
				     	{name:names.join(";"),type:"stop"},
				     	function(data){
				     		alert(data);
				     		if("" == data){  //执行成功
				     			$("#messagebox").css("color","green").html("成功停止！").show(300).delay(2000).hide(0);
				     			$("#tt").datagrid('reload');
				     			
				     			$("#tt").datagrid('unselectAll'); //解决 删除一页后title栏依旧勾选但是行没选中的问题
				     			 
				     			//parent.refresh();//刷新上级页面  
				     		}else{
				     			alert(data);
				     		}
				     	}
				     );				          		
          		}          		
          	})
          }
        
        
        
        
        
        
 
        
        
        
        
        
        
        
          
          function ve(xsbh){  //转到查看页面  
              	var s = $('#tt').datagrid('getSelected');

	            alert("hahahahhahahahahha");
	            
            	$.messager.alert("信息",xsbh,function(){}); 
            };
          function et(bh){  //转到编辑页面  
          	alert(bh);
               // window.location.href='StuEdit.aspx?id='+bh;  
          }; 
          function dl(index){  //删除操作  
	          alert(index);
	          
            $.messager.confirm('确认','确认删除?',function(row){  
                if(row){  
    /*                 var selectedRow = $('#tt').datagrid('getSelected');  //获取选中行  
                    $.ajax({  
                        url:'delHandler.ashx?id='+selectedRow.xsbh+'&type=stu',   
//加了个type，作用是以后不管什么删除，都可以转到这个ashx中处理  
                        success:function(){alert('删除成功');}  
                    });  */
                    $('#tt').datagrid('deleteRow',index);  // 进行ajax后 如果成功则reload 并提醒删除成功   否则提醒删除失败
                } 
            })  
          };
      
</script>  

	
		

           <!-- 引入尾部 -->
       <jsp:include page="../footer.jsp"></jsp:include>
</div>
    
  </body>
</html>
