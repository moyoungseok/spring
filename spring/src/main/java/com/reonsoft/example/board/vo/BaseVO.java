package com.reonsoft.example.board.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int pageIndex = 1; //현재 페이지 인덱스
	
	private int pageSize = 10; //페이지 당 게시글 수

	public int getPageIndex() {
		return pageIndex;
	}

	
	public void setPageIndex(int pageIndex) {
		if(pageIndex<=0) {
			this.pageIndex=1;
			return;
		}
		this.pageIndex = pageIndex;
	}


	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
