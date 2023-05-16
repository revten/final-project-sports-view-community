package com.tm.nmp.account;

import java.util.Date;
import java.util.List;

public class AccountDTO {
	private String id;

	private String password;
	private String salt;
	private Date password_update_date;

	private String nickname;
	private int join_type;
	private String email;
	private String cellphone;
	private int gender;
	private String birthday;
	private Date reg_date;
	private Date update_date;

	private List<FavoriteClubDTO> favorite_clubs;

	public AccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountDTO(String id, String password, String salt, Date password_update_date, String nickname,
			int join_type, String email, String cellphone, int gender, String birthday, Date reg_date, Date update_date,
			List<FavoriteClubDTO> favorite_clubs) {
		super();
		this.id = id;
		this.password = password;
		this.salt = salt;
		this.password_update_date = password_update_date;
		this.nickname = nickname;
		this.join_type = join_type;
		this.email = email;
		this.cellphone = cellphone;
		this.gender = gender;
		this.birthday = birthday;
		this.reg_date = reg_date;
		this.update_date = update_date;
		this.favorite_clubs = favorite_clubs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getPassword_update_date() {
		return password_update_date;
	}

	public void setPassword_update_date(Date password_update_date) {
		this.password_update_date = password_update_date;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getJoin_type() {
		return join_type;
	}

	public void setJoin_type(int join_type) {
		this.join_type = join_type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	public List<FavoriteClubDTO> getFavorite_clubs() {
		return favorite_clubs;
	}

	public void setFavorite_clubs(List<FavoriteClubDTO> favorite_clubs) {
		this.favorite_clubs = favorite_clubs;
	}

}
