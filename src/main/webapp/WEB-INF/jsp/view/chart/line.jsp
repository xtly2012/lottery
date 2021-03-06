<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>线性图</title>
		<meta name="Description" content="The ichartjs's gallery center,ichartjs 示例中心" />
		<meta name="Keywords" content="ichartjs demo,Html5 demo,ichartjs示例,ichartjs示例,Html5示例,Html5示例" />
		<script type="text/javascript" src="../../js/ichart.1.2.min.js"></script>
		<link rel="stylesheet" href="../../css/demo.css" type="text/css"/>
		<script type="text/javascript">
			$(function(){
				var data = <%=request.getAttribute("data")%>;
						         
				//创建x轴标签文本   
				var labels = <%=request.getAttribute("label")%>;
				
				var chart = new iChart.LineBasic2D({
					render : 'canvasDiv',
					data: data,
					align:'center',
					title : 'A网站近5天流量趋势,按每2小时分组统计',
					subtitle : '平均每个人访问2-3个页面(访问量单位：次数)',
					footnote : '数据来源：模拟数据',
					width : 7200,
					height : 1200,
					background_color:'#FEFEFE',
					tip:{
						enable:true,
						shadow:true,
						move_duration:400,
						border:{
							 enable:true,
							 radius : 5,
							 width:2,
							 color:'#3f8695'
						},
						listeners:{
							 //tip:提示框对象、name:数据名称、value:数据值、text:当前文本、i:数据点的索引
							parseText:function(tip,name,value,text,i){
								return name+"出现次数:"+value+"次";
							}
						}
					},
					tipMocker:function(tips,i){
						return "<div style='font-weight:600'>"+
								labels[Math.floor(i/12)]+" "+//日期
								(((i%12)*2<10?"0":"")+(i%12)*2)+":00"+//时间
								"</div>"+tips.join("<br/>");
					},
					legend : {
						enable : true,
						row:1,//设置在一行上显示，与column配合使用
						column : 'max',
						valign:'top',
						sign:'bar',
						background_color:null,//设置透明背景
						offsetx:-80,//设置x轴偏移，满足位置需要
						border : true
					},
					crosshair:{
						enable:true,
						line_color:'#62bce9'//十字线的颜色
					},
					sub_option : {
						label:false,
						point_size:10
					},
					coordinate:{
						width:7000,
						height:1000,
						axis:{
							color:'#dcdcdc',
							width:1
						},
						scale:[{
							 position:'left',	
							 start_scale:0,
							 end_scale:100,
							 scale_space:10,
							 scale_size:2,
							 scale_color:'#9f9f9f'
						},{
							 position:'bottom',	
							 labels:labels
						}]
					}
				});
			
			//开始画图
			chart.draw();
		});
		</script>
	</head>
	<body>
		<div id='canvasDiv'></div>
		<div class='ichartjs_info'>
			<span class='ichartjs_author'>
				writen by <a title="示例的贡献者" href="mailto:taylor@ichartjs.com">taylor</a>
			</span> 
			<span class='ichartjs_btn' onmouseover="this.style.color='#2f99ff'" onmouseout="this.style.color='#0b2946'" onclick="window.top.viewCode(document);">预览代码</span>
			<div class='ichartjs_sm'>说明</div>
			<div class='ichartjs_details'>
				应用实例欣赏，此示例展示了A网站近5天访问流量情况，此示例中设置了多种样式，以达到所需的视觉效果。<br />
				这里设置了tipMocker，这样可以将多组数据展示在同一Tip中。达到所需要的效果。
			</div>
			<span class='ichartjs_sm'>备注：</span> <span class='ichartjs_details'>数据均为模拟。 </span>
		</div>
	</body>
</html>