package com.tm.nmp.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AccountVO {
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
