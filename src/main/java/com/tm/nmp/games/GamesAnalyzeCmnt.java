package com.tm.nmp.games;

import java.math.BigDecimal;
import java.util.Date;

public class GamesAnalyzeCmnt {
	
	public BigDecimal anlyz_cmnt_no;
	public String anlyz_cmnt_blngd;
	public String anlyz_cmnt_content;
	public Date anlyz_cmnt_date_created;
	public String ac_nick;

	public GamesAnalyzeCmnt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GamesAnalyzeCmnt(BigDecimal anlyz_cmnt_no, String anlyz_cmnt_blngd, String anlyz_cmnt_content,
			Date anlyz_cmnt_date_created, String ac_nick) {
		super();
		this.anlyz_cmnt_no = anlyz_cmnt_no;
		this.anlyz_cmnt_blngd = anlyz_cmnt_blngd;
		this.anlyz_cmnt_content = anlyz_cmnt_content;
		this.anlyz_cmnt_date_created = anlyz_cmnt_date_created;
		this.ac_nick = ac_nick;
	}

	public BigDecimal getAnlyz_cmnt_no() {
		return anlyz_cmnt_no;
	}

	public void setAnlyz_cmnt_no(BigDecimal anlyz_cmnt_no) {
		this.anlyz_cmnt_no = anlyz_cmnt_no;
	}

	public String getAnlyz_cmnt_blngd() {
		return anlyz_cmnt_blngd;
	}

	public void setAnlyz_cmnt_blngd(String anlyz_cmnt_blngd) {
		this.anlyz_cmnt_blngd = anlyz_cmnt_blngd;
	}

	public String getAnlyz_cmnt_content() {
		return anlyz_cmnt_content;
	}

	public void setAnlyz_cmnt_content(String anlyz_cmnt_content) {
		this.anlyz_cmnt_content = anlyz_cmnt_content;
	}

	public Date getAnlyz_cmnt_date_created() {
		return anlyz_cmnt_date_created;
	}

	public void setAnlyz_cmnt_date_created(Date anlyz_cmnt_date_created) {
		this.anlyz_cmnt_date_created = anlyz_cmnt_date_created;
	}

	public String getAc_nick() {
		return ac_nick;
	}

	public void setAc_nick(String ac_nick) {
		this.ac_nick = ac_nick;
	}

}
