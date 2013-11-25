package com.insigma.guobo.tbk.test;

public class CounterTask extends java.util.TimerTask {

	@Override
	public void run() {
		// 
		int index =0;
		
		while(index < 10){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(index++);
			
		}

	}

}
