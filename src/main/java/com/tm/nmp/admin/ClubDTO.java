package com.tm.nmp.admin;

import java.util.Date;

public class ClubDTO {
	private int club_id;
	private String club_name;
	private String club_name_eng;
	private int sports_id;
	private int league_id;
	private String city;
	private String stadium_name;
	private String stadium_address;
	private int found_year;
	private String website;
	private String intro;
	private Date reg_date;

	public ClubDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClubDTO(int club_id, String club_name, String club_name_eng, int sports_id, int league_id, String city,
			String stadium_name, String stadium_address, int found_year, String website, String intro, Date reg_date) {
		super();
		this.club_id = club_id;
		this.club_name = club_name;
		this.club_name_eng = club_name_eng;
		this.sports_id = sports_id;
		this.league_id = league_id;
		this.city = city;
		this.stadium_name = stadium_name;
		this.stadium_address = stadium_address;
		this.found_year = found_year;
		this.website = website;
		this.intro = intro;
		this.reg_date = reg_date;
	}

	public int getClub_id() {
		return club_id;
	}

	public void setClub_id(int club_id) {
		this.club_id = club_id;
	}

	public String getClub_name() {
		return club_name;
	}

	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}

	public String getClub_name_eng() {
		return club_name_eng;
	}

	public void setClub_name_eng(String club_name_eng) {
		this.club_name_eng = club_name_eng;
	}

	public int getSports_id() {
		return sports_id;
	}

	public void setSports_id(int sports_id) {
		this.sports_id = sports_id;
	}

	public int getLeague_id() {
		return league_id;
	}

	public void setLeague_id(int league_id) {
		this.league_id = league_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStadium_name() {
		return stadium_name;
	}

	public void setStadium_name(String stadium_name) {
		this.stadium_name = stadium_name;
	}

	public String getStadium_address() {
		return stadium_address;
	}

	public void setStadium_address(String stadium_address) {
		this.stadium_address = stadium_address;
	}

	public int getFound_year() {
		return found_year;
	}

	public void setFound_year(int found_year) {
		this.found_year = found_year;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "ClubDTO [club_id=" + club_id + ", club_name=" + club_name + ", club_name_eng=" + club_name_eng
				+ ", sports_id=" + sports_id + ", league_id=" + league_id + ", city=" + city + ", stadium_name="
				+ stadium_name + ", stadium_address=" + stadium_address + ", found_year=" + found_year + ", website="
				+ website + ", intro=" + intro + ", reg_date=" + reg_date + "]";
	}

}
