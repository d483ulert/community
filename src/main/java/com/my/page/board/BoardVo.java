package com.my.page.board;
import java.util.Date;
import lombok.Data;

@Data
public class BoardVo {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcnt;
	private int page;
	private int perPageNum;

    public BoardVo() {
    	this.page=1;
    	this.perPageNum=5;
    }
    public int getPage() {
    	return page;
    }
    public void setPage(int page) {
    	if(page<=0) {
    		this.page=1;
    		return;
    	}
    	this.page=page;
    }
    public int getPerPageNum() {
    	return perPageNum;

    }
    public void setPerPageNum(int perPageNum) {
    	if(perPageNum <=0 || perPageNum > 100) {
    		this.perPageNum=10;
    	return;
    }
    this.perPageNum=perPageNum;
    }
    
    public int getPageStart() {
    	return (this.page -1) * perPageNum;
    }    
}
