package com.insigma.guobo.tbk.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Entity
public class YanzhengmaImag extends HttpServlet {

	@Id
	@GeneratedValue
	private static final int WIDTH = 120;
	private static final int HEIGHT = 25;
	//创建变量记录生成的汉字
	private String validataImag = "";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//response.setHeader("refresh", "3"); 控制浏览器隔3秒刷新一次
		
		
		//创建图像 指定 宽高 以及显示格式
		BufferedImage img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		//得到该图像的画笔工具    往图像上画  背景  边框  干扰线  以及常用字符
		Graphics g = img.getGraphics();
		
		//1.画背景
		setBackground(g);
		
		//2.设置边框
		setBorder(g);
		
		//3.画干扰线
		drawLine(g);
		
		//4.画字符
		drawRadomNum((Graphics2D) g);
		request.getSession().setAttribute("validataImag", validataImag);
		System.out.println(validataImag);
		validataImag = "";
		//5.向浏览器输出该图片   使用  ImageIo.write();写给response.getoutputstream
		response.setContentType("image/jpeg");
		//发头控制浏览器 不要缓存 
		response.setDateHeader("exprise", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		ImageIO.write(img, "jpg", response.getOutputStream());//写给response.getoutputstream后 须设置浏览器的显示方式
	}

	//汉字 区间  [\u4e00-\u9fa5] 
	// 
	private void drawRadomNum(Graphics2D g) {//Graphics2D可以旋转
		// TODO Auto-generated method stub
		
		//常用的有  
		String base ="\u7684\u4e00\u4e86\u662f\u6211\u4e0d\u5728\u4eba\u4eec\u6709\u6765\u4ed6\u8fd9\u4e0a\u7740\u4e2a\u5730\u5230\u5927\u91cc\u8bf4\u5c31\u53bb\u5b50\u5f97\u4e5f\u548c\u90a3";
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("隶书", Font.ITALIC, 20));
		int x = 5;
		for(int i =0;i<4;i++){
			int jiaodu = new Random().nextInt()%30;//旋转  -30° - 30°之间
			String hanZi = base.charAt(new Random().nextInt(base.length()))+"";
			g.rotate(jiaodu * Math.PI / 180, x, 20);//在画之前  调整旋转角度
			g.drawString(hanZi, x, 20);
			g.rotate(-jiaodu * Math.PI / 180, x, 20);//再把角度调整过来   
			x += 30;
			validataImag += hanZi;
		}
	}


	private void drawLine(Graphics g) {
		// TODO Auto-generated method stub
		
		g.setColor(Color.RED);

		for(int i = 0;i<4;i++){
			int x1 = new Random().nextInt(WIDTH);
			int y1 = new Random().nextInt(HEIGHT);
			
			int x2 = new Random().nextInt(WIDTH);
			int y2 = new Random().nextInt(HEIGHT);
			
			g.drawLine(x1, y1, x2, y2);
		}
	}


	private void setBorder(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.RED);
		g.drawRect(1, 1, WIDTH-2, HEIGHT-2);
		//g.drawRect(0, 0, WIDTH, HEIGHT);
	}


	private void setBackground(Graphics g) {
		// TODO Auto-generated method stub
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//g.fillRect(1, 1, WIDTH-2, HEIGHT-2);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
