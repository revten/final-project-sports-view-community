package com.tm.nmp.games;

import java.util.Date;
import java.util.List;

public class GamesAnalyzeBoard {
	private int anlyz_no;
	private String anlyz_id;
	private String anlyz_ncknm;
	private String anlyz_sports;
	private String anlyz_title;
	private String anlyz_content;
	private String anlyz_img;
	private String anlyz_video;
	private Date anlyz_date_created;

	private List<GamesAnalyzeCmnt> anlyz_cmnts;
	private String ac_nick;
	public GamesAnalyzeBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GamesAnalyzeBoard(int anlyz_no, String anlyz_id, String anlyz_ncknm, String anlyz_sports, String anlyz_title,
			String anlyz_content, String anlyz_img, String anlyz_video, Date anlyz_date_created,
			List<GamesAnalyzeCmnt> anlyz_cmnts, String ac_nick) {
		super();
		this.anlyz_no = anlyz_no;
		this.anlyz_id = anlyz_id;
		this.anlyz_ncknm = anlyz_ncknm;
		this.anlyz_sports = anlyz_sports;
		this.anlyz_title = anlyz_title;
		this.anlyz_content = anlyz_content;
		this.anlyz_img = anlyz_img;
		this.anlyz_video = anlyz_video;
		this.anlyz_date_created = anlyz_date_created;
		this.anlyz_cmnts = anlyz_cmnts;
		this.ac_nick = ac_nick;
	}
	public int getAnlyz_no() {
		return anlyz_no;
	}
	public void setAnlyz_no(int anlyz_no) {
		this.anlyz_no = anlyz_no;
	}
	public String getAnlyz_id() {
		return anlyz_id;
	}
	public void setAnlyz_id(String anlyz_id) {
		this.anlyz_id = anlyz_id;
	}
	public String getAnlyz_ncknm() {
		return anlyz_ncknm;
	}
	public void setAnlyz_ncknm(String anlyz_ncknm) {
		this.anlyz_ncknm = anlyz_ncknm;
	}
	public String getAnlyz_sports() {
		return anlyz_sports;
	}
	public void setAnlyz_sports(String anlyz_sports) {
		this.anlyz_sports = anlyz_sports;
	}
	public String getAnlyz_title() {
		return anlyz_title;
	}
	public void setAnlyz_title(String anlyz_title) {
		this.anlyz_title = anlyz_title;
	}
	public String getAnlyz_content() {
		return anlyz_content;
	}
	public void setAnlyz_content(String anlyz_content) {
		this.anlyz_content = anlyz_content;
	}
	public String getAnlyz_img() {
		return anlyz_img;
	}
	public void setAnlyz_img(String anlyz_img) {
		this.anlyz_img = anlyz_img;
	}
	public String getAnlyz_video() {
		return anlyz_video;
	}
	public void setAnlyz_video(String anlyz_video) {
		this.anlyz_video = anlyz_video;
	}
	public Date getAnlyz_date_created() {
		return anlyz_date_created;
	}
	public void setAnlyz_date_created(Date anlyz_date_created) {
		this.anlyz_date_created = anlyz_date_created;
	}
	public List<GamesAnalyzeCmnt> getAnlyz_cmnts() {
		return anlyz_cmnts;
	}
	public void setAnlyz_cmnts(List<GamesAnalyzeCmnt> anlyz_cmnts) {
		this.anlyz_cmnts = anlyz_cmnts;
	}
	public String getAc_nick() {
		return ac_nick;
	}
	public void setAc_nick(String ac_nick) {
		this.ac_nick = ac_nick;
	}
	
	

	

}
