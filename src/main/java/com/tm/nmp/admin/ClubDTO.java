package com.tm.nmp.admin;

import java.util.Date;
import java.util.List;

public class ClubDTO {
	private int id;
	private String name;
	private String name_eng;
	private int sports_id;
	private int league_id;
	private String city;
	private String stadium_name;
	private String stadium_address;
	private String found_year;
	private String website;
	private String intro;
	private Date reg_date;
	private Date update_date;

	public ClubDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClubDTO(int id, String name, String name_eng, int sports_id, int league_id, String city, String stadium_name,
			String stadium_address, String found_year, String website, String intro, Date reg_date, Date update_date) {
		super();
		this.id = id;
		this.name = name;
		this.name_eng = name_eng;
		this.sports_id = sports_id;
		this.league_id = league_id;
		this.city = city;
		this.stadium_name = stadium_name;
		this.stadium_address = stadium_address;
		this.found_year = found_year;
		this.website = website;
		this.intro = intro;
		this.reg_date = reg_date;
		this.update_date = update_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_eng() {
		return name_eng;
	}

	public void setName_eng(String name_eng) {
		this.name_eng = name_eng;
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

	public String getFound_year() {
		return found_year;
	}

	public void setFound_year(String found_year) {
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

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	@Override
	public String toString() {
		return "ClubDTO [id=" + id + ", name=" + name + ", name_eng=" + name_eng + ", sports_id=" + sports_id
				+ ", league_id=" + league_id + ", city=" + city + ", stadium_name=" + stadium_name
				+ ", stadium_address=" + stadium_address + ", found_year=" + found_year + ", website=" + website
				+ ", intro=" + intro + ", reg_date=" + reg_date + ", update_date=" + update_date + ", clubImages="
				+ "]";
	}

}
