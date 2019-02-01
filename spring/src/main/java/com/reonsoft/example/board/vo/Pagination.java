package com.reonsoft.example.board.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

//하단 페이징 처리를 위한 클래스 
public class Pagination {
	
	private int startPage; //시작페이지
	private int endPage; //끝페이지
	private int totalCount; //전체게시물 수
	private boolean prev; //이전페이지
	private boolean next; //다음페이지
	
	//하단 페이지 번호의 갯수
	private int displayPageNum = 10;
	
	private BaseVO base;

	public void setBase(BaseVO base) {
		this.base = base;
	}
	
	//총 게시물 개수
	public void setTotalCount(int totalCount) {
		this.totalCount=totalCount;
		calcData();
	}
	
	//페이지 계산
	private void calcData() {
		//끝 페이지
		endPage = (int) (Math.ceil(base.getPageIndex() / (double) displayPageNum) * displayPageNum);
		//시작 페이지 
		startPage = (endPage - displayPageNum)+1;
	
		int tempEndPage = (int)(Math.ceil(totalCount/(double) base.getPageSize()));
		
		if(endPage>tempEndPage) {
			endPage=tempEndPage;
		}
		prev = startPage == 1?false:true;
		next = endPage * base.getPageSize()>=totalCount ? false : true;
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

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public BaseVO getBase() {
		return base;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this);
	}
	
	
}
