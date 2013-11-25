package com.insigma.guobo.tbk.task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;

import com.insigma.guobo.tbk.log.LogStyle;
import com.insigma.guobo.tbk.pojo.TaskConf;
import com.insigma.guobo.tbk.pojo.TempGoods;
import com.insigma.guobo.tbk.services.taskservice.AddTempGoodsServiceImpl;
import com.insigma.guobo.tbk.utils.Configuration;
import com.insigma.guobo.tbk.utils.Constants;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.TaobaokeItem;
import com.taobao.api.internal.ws.push.Logger;
import com.taobao.api.request.TaobaokeItemsGetRequest;
import com.taobao.api.response.TaobaokeItemsGetResponse;

public class GetGoodsTask extends TimerTask {
	
	//传入一个任务配置对象
	private TaskConf taskConf;
	
	public GetGoodsTask(TaskConf task){
		this.taskConf = task;
	}
	
	
	@Override
	public void run() {
		
		LogStyle.taskLog(GetGoodsTask.class, "============"+taskConf.getName() + "已经启动====="+ Calendar.getInstance().getTimeInMillis() +"=======", "error");
		
		//进行任务定制  配置要执行的任务以及组装发送的请求
		//判断任务是否有
		if(null == taskConf){
			LogStyle.taskLog(GetGoodsTask.class, "任务不存在", "warn");
			return;
		}
		//产生taobaoclient
		TaobaoClient client = new DefaultTaobaoClient(Configuration.getUrl(), Configuration.getAppKey2(), Configuration.getAppSecret2());
		//产生获取商品api对象
		TaobaokeItemsGetRequest request = new TaobaokeItemsGetRequest();
		//产生响应的api对象
		TaobaokeItemsGetResponse response = new TaobaokeItemsGetResponse();
		
		
		//判断传入的keyword 
		String[] keyWords = null;
		if(null == taskConf.getKeyword() || "".equals(taskConf.getKeyword())){
			keyWords = new String[]{""};
		}else{
			keyWords = taskConf.getKeyword().split(",");
		}

		//设置返回字段  volum  30天内交易量
		request.setFields("num_iid,title,nick,pic_url,price,click_url,commission,commission_rate,commission_num,commission_volume,shop_click_url,seller_credit_score,item_location,volume");

		//设置商品的最低佣金  最高用佣金默认
		if(taskConf.getMinRate() == null){  //Double  是 null   double 是  0.0
			request.setStartCommissionRate("0000");   //此处暂且这样写
		}else{
			
			String t = Math.floor(taskConf.getMinRate()*100)+"";
			
			request.setStartCommissionRate(t.substring(0,t.indexOf('.')));   //此处暂且这样写
		}
		//设置默认的最大佣金
		request.setEndCommissionRate("10000");
		
		//设置销量
		if(taskConf.getMinNum() == null){
			request.setStartCommissionNum("10");
		}else{
			request.setStartCommissionNum(taskConf.getMinNum() + "");
		}
		
		if(taskConf.getMaxNum() == null){
			request.setEndCommissionNum("500000");  //
		}else{
			request.setEndCommissionNum(taskConf.getMaxNum() + "");
		}
		
		
		//根据传入的关键字进行抓取商品
		for (String key : keyWords) {
			//设置关键字
			request.setKeyword(key);
			//取前400条  一页默认10条 取十次
			for(int i = 1;i <= 10; i++){
				
				request.setPageNo((long)i);
				//发送请求
				try {
					response = client.execute(request);
					List<TaobaokeItem> list = response.getTaobaokeItems();
					if(null == list){
						break;
					}
					List<TempGoods> listTemGoods = new ArrayList<TempGoods>();
					//如果有值 则进行遍历封装
					for (TaobaokeItem taobaokeitems : list) {
						TempGoods goods = new TempGoods();
						
						goods.setTaobaoId(taobaokeitems.getNumIid().toString());
						//设置商品的名称
						goods.setName(taobaokeitems.getTitle());
						//设置商品的价格
						goods.setPrice(Double.parseDouble(taobaokeitems.getPrice()));
						//设置商品的链接地址
						goods.setUrl(taobaokeitems.getClickUrl());
						//设置佣金比率
						goods.setCommissionRate(Double.parseDouble(taobaokeitems.getCommissionRate()) / 100);
						//设置30天内的推广量
						goods.setCommissionNum(Integer.parseInt(taobaokeitems.getCommissionNum()));
						
						//设置30天内总支出的佣金
						goods.setCommissionVolumn(Double.parseDouble(taobaokeitems.getCommissionVolume()));
						//设置商品的介绍
						goods.setContent(taobaokeitems.getItemLocation());
						//设置商品的收录状态
						goods.setStatus(Constants.TEMP_GOODS_STATUS_NOT_COMMIT);
						//图片路径
						goods.setPicUrl(taobaokeitems.getPicUrl());
						//30天内交易量
						goods.setVolum(Integer.parseInt((taobaokeitems.getVolume().toString())));
						
						listTemGoods.add(goods);

					}
					//把获取的数据放入数据库中
					new AddTempGoodsServiceImpl().addTempGood(listTemGoods);
					
					
				} catch (ApiException e) {
					
					e.printStackTrace();
					LogStyle.taskLog(GetGoodsTask.class, "请求失败！！！", "error");
				}
				
				
			}
			
		}
		
		
		
		
		
	}

}
