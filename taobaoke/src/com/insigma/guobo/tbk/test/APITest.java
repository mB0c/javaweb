package com.insigma.guobo.tbk.test;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.UserGetRequest;
import com.taobao.api.response.UserGetResponse;
public class APITest {
   //  protected static String url = "http://gw.api.tbsandbox.com/router/rest";//沙箱环境调用地址
     protected static String url = "http://gw.api.taobao.com/router/rest";//沙箱环境调用地址
     //正式环境需要设置为:http://gw.api.taobao.com/router/rest
     
     protected static String appkey = "21502543";
     protected static String appSecret = "8b44d3d6c1ae584403466b077f38f28c";
     public static void testUserGet() {
         TaobaoClient client = new DefaultTaobaoClient(url, appkey, appSecret);//实例化TopClient类
         UserGetRequest req = new UserGetRequest();//实例化具体API对应的Request类
         req.setFields("nick,sex,buyer_credit,seller_credit ,created,last_visit");
         req.setNick("飘_渺oo7");
         UserGetResponse response;
         try {
             response = client.execute(req); //执行API请求并打印结果
             System.out.println("result:"+response.getBody());
             System.out.println("nick:"+response.getUser().getNick());
         } catch (ApiException e) {
         // deal error
         }
     }
     public static void main(String[] args) {
         APITest.testUserGet();
     }
 
}

//不包含sdk的例子
/*import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
public class APITest {
     // protected static String testUrl = "http://gw.api.tbsandbox.com/router/rest";//沙箱环境调用地址
    protected static String testUrl = "http://gw.api.taobao.com/router/rest";//线上环境
     protected static String appkey = "21502543";
     protected static String secret = "8b44d3d6c1ae584403466b077f38f28c";
     public static String testUserGet(){
         TreeMap<String, String> apiparamsMap = new TreeMap<String, String>();
         apiparamsMap.put("format", "xml");
         apiparamsMap.put("method", "taobao.user.get");
         apiparamsMap.put("sign_method","md5");
         apiparamsMap.put("app_key",appkey);
         apiparamsMap.put("v", "2.0");
         //apiparamsMap.put("session",request.getParameter("session"));他用型需要sessionkey
         String timestamp =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
         apiparamsMap.put("timestamp",timestamp);
         apiparamsMap.put("fields","user_id,uid,nick");//需要获取的字段
        // apiparamsMap.put("nick","andyy_tan");
         apiparamsMap.put("nick","飘_渺oo7");
         //生成签名
         String sign = Util.md5Signature(apiparamsMap,secret);
         apiparamsMap.put("sign", sign);
         StringBuilder param = new StringBuilder();
         for (Iterator<Map.Entry<String, String>> it = apiparamsMap.entrySet()
         .iterator(); it.hasNext();) {
             Map.Entry<String, String> e = it.next();
             param.append("&").append(e.getKey()).append("=").append(e.getValue());
         }
         return param.toString().substring(1);
     }
     public static void main(String[] args) {
         String result = Util.getResult(testUrl,testUserGet());
         System.out.print(result);
     }
}
*/