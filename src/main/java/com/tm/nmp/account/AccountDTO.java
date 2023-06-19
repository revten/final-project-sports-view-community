package com.tm.nmp.account;

import java.util.Date;

import lombok.Data;

@Data
public class AccountDTO {
	private String id; // tb_user 테이블

	private String password; // tb_password 테이블
	private String salt;
	private Date password_update_date;

	private String nickname;
	private int join_type;
	private String email;
	private String phone;
	private int gender;
	private String birthday;
	private Date reg_date;
	private Date update_date;

}
