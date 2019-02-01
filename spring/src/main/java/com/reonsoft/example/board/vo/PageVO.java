package com.reonsoft.example.board.vo;

public class PageVO {

	private int startPage;
	private int endPage;
	private int totalCount; //총 게시글 수
	private int  displayPageNum = 5;
	private BaseVO base;

	public PageVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageVO(int startPage, int endPage, int totalCount, BaseVO base) {
		super();
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalCount = totalCount;
		this.base = base;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;	
	}
	
	public void calcData() {
		endPage = (int) (Math.ceil(base.getPageIndex()/(double) displayPageNum) * displayPageNum);
		startPage = (endPage-displayPageNum)+1;
	}
	public BaseVO getBase() {
		return base;
	}

	public void setBase(BaseVO base) {
		this.base = base;
	}
	
	
	
}
