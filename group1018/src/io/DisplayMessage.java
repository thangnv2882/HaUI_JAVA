package io;

public class DisplayMessage extends Thread {

	String msg = "";

	public DisplayMessage(String msg) {
		super();
		this.msg = msg;
	}
	
	public void run() {
		int timeSleep = (int)Math.random()*20_000;
		
	}
}
