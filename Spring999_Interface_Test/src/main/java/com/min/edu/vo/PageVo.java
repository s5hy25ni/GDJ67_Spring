package com.min.edu.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PageVo {
	private int curPage;
		
	private int totalUser;
	private int cntOnePage;
	
	private int totalPage;
	private int cntViewPage;
	
	private int startPage;
	private int endPage;

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		if(curPage<1) {
			this.curPage = 1;			
		} else if(curPage>totalPage) {
			this.curPage = totalPage;						
		} else {			
			this.curPage = curPage;			
		}
	}

	public int getTotalUser() {
		return totalUser;
	}

	public void setTotalUser(int totalUser) {
		this.totalUser = totalUser;
	}

	public int getCntOnePage() {
		return cntOnePage;
	}

	public void setCntOnePage(int cntOnePage) {
		this.cntOnePage = cntOnePage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		int totalPageResult = totalUser/cntOnePage;
		if(totalPageResult == 0 && totalUser%cntOnePage == 0) {
			this.totalPage = 1;
		} else {			
			this.totalPage = (totalUser%cntOnePage!=0)?totalPageResult+1:totalPageResult;
		}
	}

	public int getCntViewPage() {
		return cntViewPage;
	}

	public void setCntViewPage(int cntViewPage) {
		this.cntViewPage = cntViewPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = ((curPage-1)/cntViewPage)*cntViewPage+1;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = (startPage+cntViewPage-1)>totalPage?totalPage:(startPage+cntViewPage-1);
	}
}

