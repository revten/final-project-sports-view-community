package com.tm.nmp.admin;

import java.util.Date;

public class ClubImageDTO {
	private int id;
	private int club_id;
	private int sort;
	private String file_name;
	private Date reg_date;
	private Date update_date;

	public ClubImageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClubImageDTO(int id, int club_id, int sort, String file_name, Date reg_date, Date update_date) {
		super();
		this.id = id;
		this.club_id = club_id;
		this.sort = sort;
		this.file_name = file_name;
		this.reg_date = reg_date;
		this.update_date = update_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClub_id() {
		return club_id;
	}

	public void setClub_id(int club_id) {
		this.club_id = club_id;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	@Override
	public String toString() {
		return "ClubImageDTO [id=" + id + ", club_id=" + club_id + ", sort=" + sort + ", file_name=" + file_name
				+ ", reg_date=" + reg_date + ", update_date=" + update_date + "]";
	}

}
