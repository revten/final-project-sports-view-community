package com.tm.nmp.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tm.nmp.model.AccountVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class AccountMapperTests {
	
	@Autowired
	//AccountMapper.java 인터페이스 의존성 주입
	private AccountMapper accountMapper;
	
	@Test
	public void accountReg() throws Exception{
		AccountVO accountVO = new AccountVO();
		
		accountVO.setId("test");
		
		accountMapper.regAccount(accountVO);
	}
}
