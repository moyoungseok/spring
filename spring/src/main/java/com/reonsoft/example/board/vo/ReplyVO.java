package com.reonsoft.example.board.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ReplyVO {
	private int replyNo; //댓글 번호
	private String replyContent; //댓글 내용
	private char useYn; //댓글 사용여부
	private String regDate; //댓글 등록일
	private String modDate; //수정일
	private int topReplyNo; //상위 댓글 번호
	private String name; //이름
	private int bbsNo; //게시글번호
	
	public ReplyVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReplyVO(int replyNo, String replyContent, char useYn, String regDate, String modDate, int topReplyNo,
			String name, int bbsNo) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.useYn = useYn;
		this.regDate = regDate;
		this.modDate = modDate;
		this.topReplyNo = topReplyNo;
		this.name = name;
		this.bbsNo = bbsNo;
	}


	public int getReplyNo() {
		return replyNo;
	}



	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}



	public String getReplyContent() {
		return replyContent;
	}



	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}



	public char getUseYn() {
		return useYn;
	}



	public void setUseYn(char useYn) {
		this.useYn = useYn;
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



	public int getTopReplyNo() {
		return topReplyNo;
	}



	public void setTopReplyNo(int topReplyNo) {
		this.topReplyNo = topReplyNo;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getBbsNo() {
		return bbsNo;
	}



	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
	}



	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	
	
}
