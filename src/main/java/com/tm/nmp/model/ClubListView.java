package com.tm.nmp.model;

import java.util.Date;

public class ClubListView extends ClubDTO {

	private String sports_name;
	private String league_name;
	private int league_gender;
	private int images_count;

	public ClubListView() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public ClubListView(int id, String name, String city,
			String stadium_name, String stadium_address, Date reg_date,
			Date update_date, String sports_name, String league_name, int league_gender, int images_count) {
		super(id, name, "", 0, 0, city, stadium_name, stadium_address, "", "", "",
				reg_date, update_date);
		
		this.sports_name = sports_name;
		this.league_name = league_name;
		this.league_gender = league_gender;
		this.images_count = images_count;
		// TODO Auto-generated constructor stub
	}

	public String getSports_name() {
		return sports_name;
	}

	public void setSports_name(String sports_name) {
		this.sports_name = sports_name;
	}

	public String getLeague_name() {
		return league_name;
	}

	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}

	public int getLeague_gender() {
		return league_gender;
	}

	public void setLeague_gender(int league_gender) {
		this.league_gender = league_gender;
	}

	public int getImages_count() {
		return images_count;
	}

	public void setImages_count(int images_count) {
		this.images_count = images_count;
	}

}
