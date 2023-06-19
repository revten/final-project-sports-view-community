package com.tm.nmp.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTest {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		try (Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@VNFOZP5V0P896GE5_high?TNS_ADMIN=C:/wallet/Wallet_VNFOZP5V0P896GE5", 
				"admin", 
				"1q2w3e4r5t6Y")) {
			System.out.println(con);
		} catch (Exception e) {
			fail(e.getMessage());
			// TODO: handle exception
		}
	}
}
