package com.demo.beans;

public class Team {
	private int tid;
	private String tname;
	private Player p1;
	
	
	public Team() {
		super();
	}


	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}


	public String getTname() {
		return tname;
	}


	public void setTname(String tname) {
		this.tname = tname;
	}


	public Player getP1() {
		return p1;
	}


	public void setP1(Player p1) {
		this.p1 = p1;
	}


	@Override
	public String toString() {
		
		return "Team [tid=" + tid + ", tname=" + tname + ", p1=" + p1 + "]";
	}
	
	

}
