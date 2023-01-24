package com.tm.nmp.message;

import java.util.Date;

public class MessageVO {

	 private int message_id; 
	 private String message_from; 
	 private String message_to; 
	 private String message_txt; 
	 private Date message_when;
	 
	 public MessageVO() {
		// TODO Auto-generated constructor stub
	}

	public MessageVO(int message_id, String message_from, String message_to, String message_txt, Date message_when) {
		super();
		this.message_id = message_id;
		this.message_from = message_from;
		this.message_to = message_to;
		this.message_txt = message_txt;
		this.message_when = message_when;
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public String getMessage_from() {
		return message_from;
	}

	public void setMessage_from(String message_from) {
		this.message_from = message_from;
	}

	public String getMessage_to() {
		return message_to;
	}

	public void setMessage_to(String message_to) {
		this.message_to = message_to;
	}

	public String getMessage_txt() {
		return message_txt;
	}

	public void setMessage_txt(String message_txt) {
		this.message_txt = message_txt;
	}

	public Date getMessage_when() {
		return message_when;
	}

	public void setMessage_when(Date message_when) {
		this.message_when = message_when;
	}
	 
	
}
