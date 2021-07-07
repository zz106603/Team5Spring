package com.mycompany.webapp.dto;

import java.util.Date;

public class MainBoard {
	private int mainNoticeId;
	private String mainNoticeTitle;
	private String mainNoticeContent;
	private Date mainNoticeRegdate;
	private String mainNoticeWriter;
	
	public int getMainNoticeId() {
		return mainNoticeId;
	}
	public void setMainNoticeId(int mainNoticeId) {
		this.mainNoticeId = mainNoticeId;
	}
	public String getMainNoticeTitle() {
		return mainNoticeTitle;
	}
	public void setMainNoticeTitle(String mainNoticeTitle) {
		this.mainNoticeTitle = mainNoticeTitle;
	}
	public String getMainNoticeContent() {
		return mainNoticeContent;
	}
	public void setMainNoticeContent(String mainNoticeContent) {
		this.mainNoticeContent = mainNoticeContent;
	}
	public Date getMainNoticeRegdate() {
		return mainNoticeRegdate;
	}
	public void setMainNoticeRegdate(Date mainNoticeRegdate) {
		this.mainNoticeRegdate = mainNoticeRegdate;
	}
	public String getMainNoticeWriter() {
		return mainNoticeWriter;
	}
	public void setMainNoticeWriter(String mainNoticeWriter) {
		this.mainNoticeWriter = mainNoticeWriter;
	}
}
