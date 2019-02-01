package com.reonsoft.example.board.vo;

import java.io.Serializable;

public class BBSVO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 게시글일련번호
	 */
	private int bbsNo = 0;
	
	/**
	 * 제목
	 */
	private String title = "";
	
	/**
	 * 내용
	 */
	private String content = "";
	
	/**
	 * 이름
	 */
	private String name = "";
	
	/**
	 * 사용여부
	 */
	private String useYn = "";
	
	/**
	 * 조회수
	 */
	private int viewCnt = 0;
	
	/**
	 * 등록년월일시
	 */
	private String regDate = "";
	
	/**
	 * 수정년월일시
	 */
	private String modDate = "";

	public int getBbsNo() {
		return bbsNo;
	}

	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getModDate() {
		return modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

}
