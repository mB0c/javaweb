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

	
  </head>
  
  <body>
  
   <!--   <div class="easyui-window" title="easyui首测窗口" style="width: 300px;height: 50px">就是这样用</div><br>
    -->
 <!--    <table id="dg" title="Client Side Pagination" style="width:700px;height:300px" data-options="
				rownumbers:true,
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10">
		<thead>
			<tr>
				<th field="inv" width="80">Inv No</th>
				<th field="date" width="100">Date</th>
				<th field="name" width="80">Name</th>
				<th field="amount" width="80" align="right">Amount</th>
				<th field="price" width="80" align="right">Price</th>
				<th field="cost" width="100" align="right">Cost</th>
				<th field="note" width="110">Note</th>
				<th data-options="field:'ck',checkbox:true"></th>
				
			</tr>
		</thead>
	</table>
 
    <script>
		function getData(){
			var rows = [];
			for(var i=1; i<=8; i++){
				var amount = Math.floor(Math.random()*1000);
				var price = Math.floor(Math.random()*1000);
				rows.push({
					inv: 'Inv No '+i,
					date: $.fn.datebox.defaults.formatter(new Date()),
					name: 'Name '+i,
					amount: amount,
					price: price,
					cost: amount*price,
					note: 'Note '+i
				});
			}
			
			return rows;
		}
		
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
		
			$("#dg").datagrid({
				striped:true,   //交替显示行背景
				loadMsg:"正在载入数据。。。。",  // 在加载数据时显示短消息
				idField:"date",   //指定唯一列 
				rownumbers:true,//显示行数 默认为false
				pagination:true,  //设置为true 时在表格底部显示 分页工具
				singleSelect:false   // 设置为true时  行单选模式 只能选中一行   
			});
			$('#dg').datagrid({loadFilter:pagerFilter}).datagrid('loadData', getData());
		});
	</script> 
 -->   
    
    <form id="form1" runat="server">  
	    <table id="tt">  
	          
	    </table>  
      
    
    </form> 
    
    
    <script type="text/javascript">	
    
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
                width:600,  
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
                    text:'增加',iconCls:'icon-add',handler:function(){  
                        window.location.href='StuAdd.aspx';  
                    }  
                },  
                {text:'删除',iconCls:'icon-remove',handler:function(){  
                    window.location.href='StuImport.aspx'  
                    }  
                },  
                {text:'查找',iconCls:'icon-search'},
                {text:'删除',iconCls:'icon-cancel',handler:deleteItem}
                ],  
               pagination:true  
            }); 
            
           $('#tt').datagrid({loadFilter:pagerFilter});  // 分页功能
        });  
        
        function deleteItem(){
          	
          	//确认删除
          	$.messager.confirm('确认','确认删除？',function(flag){
          	
          		if(flag){//确认删除
          			var s = $("#tt").datagrid('getSelections');//获取选中的行
          			//var s = $("#tt").datagrid('getSelected');//获取选中的行
          			alert(s[0].id);
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
				     			$("#tt").datagrid('reload');
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
    
    
  </body>
</html>
