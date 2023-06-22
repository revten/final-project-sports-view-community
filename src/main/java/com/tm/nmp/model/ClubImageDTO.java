package com.tm.nmp.model;

import java.util.Date;

public class ClubImageDTO {
	private int id;
	private int club_id;
	private int sort;
	private String file_name;
	private Date reg_date;
	private Date update_date;

	private int league_id;
	private String club_name;

	private int favored;

	public ClubImageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClubImageDTO(int id, int club_id, int sort, String file_name, Date reg_date, Date update_date, int league_id,
			String club_name, int favored) {
		super();
		this.id = id;
		this.club_id = club_id;
		this.sort = sort;
		this.file_name = file_name;
		this.reg_date = reg_date;
		this.update_date = update_date;
		this.league_id = league_id;
		this.club_name = club_name;
		this.favored = favored;
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

	public int getLeague_id() {
		return league_id;
	}

	public void setLeague_id(int league_id) {
		this.league_id = league_id;
	}

	public String getClub_name() {
		return club_name;
	}

	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}

	public int getFavored() {
		return favored;
	}

	public void setFavored(int favored) {
		this.favored = favored;
	}

}
