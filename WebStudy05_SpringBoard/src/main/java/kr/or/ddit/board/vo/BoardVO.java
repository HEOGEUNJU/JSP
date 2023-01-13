package kr.or.ddit.board.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of="boNo")
@ToString(exclude= {"boContent", "boPass"})
public class BoardVO implements Serializable{

	private int rnum;
	private Integer boNo;
	private String boMail;
	@JsonIgnore
	private transient String boPass;
	private String boContent;
	private String boDate;
	private String boTitle;
	private String boWriter;
	private String boIp;
	private Integer boHit;
	
	private List<AttatchVO> attachList; // has many
	
	private int[] deAttNos; // 게시글 수정시 삭제할 첨부파일 번호 유지
	
	private int attCount;
}
