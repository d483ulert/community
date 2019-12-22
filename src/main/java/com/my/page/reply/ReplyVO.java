package com.my.page.reply;
import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {

	private int bno;
	private int rno;
	private String content;
	private String writer;
	private Date regdate;
	
	private int getBno() {
		
		return bno;
	}
	
}
