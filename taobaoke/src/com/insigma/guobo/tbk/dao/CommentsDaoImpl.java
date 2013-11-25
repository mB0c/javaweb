package com.insigma.guobo.tbk.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.insigma.guobo.tbk.pojo.Comments;
import com.insigma.guobo.tbk.pojo.Goods;
import com.insigma.guobo.tbk.pojo.HibernateSessionFactory;
import com.insigma.guobo.tbk.pojo.Users;
import com.insigma.guobo.tbk.vo.CommentsVo;

public class CommentsDaoImpl implements CommentsDao {

	//现根据条件查询出列表  然后在对列表进行统计
	//直接在数据库中查询

	@SuppressWarnings("unchecked")
	public List<CommentsVo> getList(String nick, String goodName, String time1,String time2) {
		List<CommentsVo> list = new ArrayList<CommentsVo>();
		Session s = HibernateSessionFactory.getSession();
		//先确定 用户id 商品id
		int userId = -1;
		int goodId = -1;
		if(nick != ""){
			List<Users> list1 = s.createQuery("from Users where nick='" + nick + "'").list();
			if(null != list1 && list1.size() != 0){
				userId = list1.get(0).getId();
			}
		}
		if(goodName != ""){
			List<Goods> list1 = s.createQuery("from Goods where name='" + goodName + "'").list();
			if(null != list1 && list1.size() != 0){
				goodId = list1.get(0).getId();
			}
		}
		
		CommentsVo cv1 = new CommentsVo();
		List<CommentsVo> list2 = new ArrayList<CommentsVo>();
		StringBuilder HQL = new StringBuilder();//,
		HQL.append("select new com.insigma.guobo.tbk.vo.CommentsVo(c.id,u.nick,g.name,c.content,c.time,c.level) from Users u,Goods g,Comments c where c.users.id=u.id and c.goods.id=g.id ");
		if(userId != -1){
			HQL.append("AND u.id=" + userId + " ");
		}
		if(goodId != -1){
			HQL.append("and g.id=" + goodId + " ");
		}
		//查询某一时间间段的评论数  如果后一个时间为"" 则在前台控制默认的时间为当前时间
		if(time1 != "" && time2 != ""){
			HQL.append("and c.time between'" + time1 +"' and '"+ time2 +"'");
		}
		
		Query q = s.createQuery(HQL.toString());
		list2 = q.list();
		//统计评论数  好评率 差评率
		//
		if(list2.size() != 0 ){
			
			int goodLevelCount = 0;
			int badLevelCount = 0;
			for (CommentsVo cv : list2) {
				if(null != cv.getBadLevel() && 1 == cv.getBadLevel()){
					badLevelCount++;
				}
				if(null != cv.getGoodLevel() && 1 == cv.getGoodLevel()){
					goodLevelCount++;
				}
			}
			//总评书
			cv1.setUserName(nick);
			cv1.setGoodName(goodName);
			cv1.setTotal(list2.size());
			cv1.setGoodLevel(goodLevelCount);
			cv1.setBadLevel(badLevelCount);
			cv1.setMidLevel(cv1.getTotal() - goodLevelCount - badLevelCount);
			//好评率 差评率
			cv1.setBadRate((double)badLevelCount/cv1.getTotal());
			cv1.setGoodRate((double)goodLevelCount/cv1.getTotal());
			//先把cv1  (统计结果)  放到 list中
			list.add(cv1);
			list.addAll(list2);
			
		}

		return list;
	}

	public boolean delCommentById(int cId) {
		boolean flag = false;
		Comments c = new Comments();
		c.setId(cId);
		Session s = HibernateSessionFactory.getSession();
		try{
			s.beginTransaction();
			s.createQuery("delete from Comments where id=" + cId).executeUpdate();
			//s.delete(c);
			s.flush();
			s.getTransaction().commit();
			flag = true;
		}catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
			flag = false;
		}
		return flag;
	}

}
