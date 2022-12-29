package kr.or.ddit.vo;

import java.io.Serializable;

public class MemoVO implements Serializable{
	private Integer code;
	private String writer;
	private String content;
	private String date2;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	@Override
	public String toString() {
		return "MemoVO [code=" + code + ", writer=" + writer + ", content=" + content + ", date2=" + date2 + "]";
	}
	
}
