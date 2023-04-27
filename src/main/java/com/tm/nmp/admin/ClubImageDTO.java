package com.tm.nmp.admin;

import java.util.Date;

public class ClubImageDTO {
	private int club_image_id;
	private int club_id;
	private String sort;
	private Date reg_date;

	public ClubImageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClubImageDTO(int club_image_id, int club_id, String sort, Date reg_date) {
		super();
		this.club_image_id = club_image_id;
		this.club_id = club_id;
		this.sort = sort;
		this.reg_date = reg_date;
	}

	public int getClub_image_id() {
		return club_image_id;
	}

	public void setClub_image_id(int club_image_id) {
		this.club_image_id = club_image_id;
	}

	public int getClub_id() {
		return club_id;
	}

	public void setClub_id(int club_id) {
		this.club_id = club_id;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "ClubImageDTO [club_image_id=" + club_image_id + ", club_id=" + club_id + ", sort=" + sort
				+ ", reg_date=" + reg_date + "]";
	}

}
