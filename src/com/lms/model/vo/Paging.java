package com.lms.model.vo;

public class Paging {

	private int totalCount; // 전체 게시물 수
	private int totalPage; // 전체 페이지 수 = 전체 게시물수 / block
	private int num = 10; // 한 페이지에 출력될 게시물 수
	private int block = 5;
	
	private int nowpage = 1;
	private int startnum = 1;
	private int endnum = 1;
	private int prevpage = 1;
	private int nextpage = 1;
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage() {
		totalPage = totalCount / num;
		if (totalCount % num > 0) totalPage++;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getStartnum() {
		return startnum;
	}
	public void setStartnum() {
		startnum = (nowpage - 1) * num + 1;
	}
	public int getEndnum() {
		return endnum;
	}
	public void setEndnum() {
		endnum = startnum + num - 1;
	}
	public int getPrevpage() {
		return prevpage;
	}
	public void setPrevpage() {
		prevpage = 1;
		if (nowpage > block) {
			prevpage = nowpage - block;
		}
	}
	public int getNextpage() {
		return nextpage;
	}
	public void setNextpage() {
		nextpage = 1;
		nextpage = nowpage + block;
		if (nextpage > totalPage) {
			nextpage = totalPage;
		}
	}
	@Override
	public String toString() {
		return "Paging [totalCount=" + totalCount + ", totalPage=" + totalPage + ", num=" + num + ", block=" + block
				+ ", nowpage=" + nowpage + ", startnum=" + startnum + ", endnum=" + endnum + ", prevpage=" + prevpage
				+ ", nextpage=" + nextpage + "]";
	}
	

	
	
	
	
	
}
