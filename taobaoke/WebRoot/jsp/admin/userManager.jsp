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
			position: fixed;
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
		    		<input type="hidden" id="pwdIsChanged" value="0"/>
			    	<input type="hidden" id="status" name="status" value="0"/>
			    	<input type="hidden" id="id" name="id" value="0"/>
			    	<input type="hidden" id="activeCode" name="activeCode" value="0"/>
			    	<table>
			    		<tr>
			    			<td>昵称：</td>
			    			<td><input id="nick" class="easyui-validatebox" type="text" name="nick" data-options="required:true"></input></td>
			    		</tr>
			    		<tr>
			    			<td>Email:</td>
			    			<td><input id="email" class="easyui-validatebox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
			    		</tr>
			    		<tr>
			    			<td>密码：</td>
			    			<td><input id="password" class="easyui-validatebox" type="password" name="password" data-options="required:true"></input></td>
			    		</tr>

			    		<tr>
			    			<td>角色：</td>
			    			<td>
			    				<select id="role" name="role" ><!-- class="easyui-combobox" -->
				    				<option value="0">普通用户</option>
				    				<option value="1">管理员</option>		
			    				</select>
			    			</td>
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
                url:'servlet/GiveJsonDate',
                singleSelect:false,
                rownumbers:true,//显示行数 默认为false
                columns:[[
                
                  {field:'id',checkbox:true},
                  {field:'nick',title:'昵称',width:50},
                  {field:'email',title:'邮箱',width:200},
                  {field:'status',title:'状态',width:50},                

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
                toolbar:[{  
                    text:'增加',iconCls:'icon-add',handler:addItem  
                },  
                {text:'编辑',iconCls:'icon-edit',handler:editItem},  
                {text:'查找',iconCls:'icon-search'},
                {text:'删除',iconCls:'icon-cancel',handler:deleteItem}
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
        	url = "servlet/AddUserServlet?type=addItem";
        }
        
        //点击保存用户按钮
        function saveUser(){
        alert(url);
        	var nick = $("#nick").val();
        	var email = $("#email").val();
        	var password = $("#password").val();
        	var role = $("#role").val();
        	//alert(nick + email + password + role);
        	//获取默认的值
        	var status = $("#status").val();
        	var pwdIsChanged = $("#pwdIsChanged").val();
        	var id = $("#id").val();
        	var activeCode = $("#activeCode").val();
        	
        	//alert(status + pwdIsChanged + id + activeCode);
        	
        	$("#dlg").dialog("close");
        	//提交之前对表单数据再校验一下
        	if(!$("#ff").form('validate')){
        		//alert(url);
        		return;
        	}
        	$.get(
        		url,
        		{nick:nick,email:email,password:password,role:role,status:status,pwdIsChanged:pwdIsChanged,id:id,activeCode:activeCode},
        		function(data){
        			
        			//alert(data);
        			if("用户注册成功！" == data){
        				$("#messagebox").css("color","green").html(data).show(300).delay(2000).hide(0);
        				$("#tt").datagrid("reload");
        			}else if("修改成功！" == data){
        				$("#messagebox").css("color","green").html(data).show(300).delay(2000).hide(0);
        				$("#tt").datagrid("reload");
        			}else{
        				$("#messagebox").css("color","red").html(data).show(300).delay(2000).hide(0);
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
          	
          	//确认删除
          	$.messager.confirm('确认','确认删除？',function(flag){
          	
          		if(flag){//确认删除
          			var s = $("#tt").datagrid('getSelections');//获取选中的行
          			if (null == s || s.length == 0) {  
        				alert("请选择要删除的用户！");
				        return;  
				     }
				     
				     var ids=[];  
					 for(var i=0;i<s.length;i++){  
					 	ids.push(s[i].id);
					 }
				     //ajax后台进行
				     $.get(
				     	"servlet/UsersOptServlet",
				     	{ids:ids.join(";"),type:"user"},
				     	function(data){
				     		if(data == "1"){ //删除成功
				     			alert("删除成功！");
				     			
				     			
				     			$("#messagebox").css("color","green").html("删除成功!").show(300).delay(2000).hide(0);
				     			$("#tt").datagrid('reload');
				     			
				     			$("#tt").datagrid('unselectAll'); //解决 删除一页后title栏依旧勾选但是行没选中的问题
				     			 
				     			parent.refresh();//刷新上级页面  
				     		}else{
				     			alert("删除失败！");
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
