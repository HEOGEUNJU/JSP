package kr.or.ddit.alba.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of="alId")
@NoArgsConstructor
public class AlbaVO {
	private int rnum;
	private String alId;
	private String alName;
	private String alAge;
	private String alZip;
	private String alAddr1;
	private String alAddr2;
	private String alHp;
	private String grCode;
	private String alGen;
	private String alMail;
	private String alCareer;
	private String alSpec;
	private String alDesc;
	private String alImg;
}
