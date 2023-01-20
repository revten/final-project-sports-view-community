package com.tm.nmp.account;

public interface AccountMapper {

	AccountDTO accountLogin(AccountDTO ac);

	int regAccount(AC_US_TITLE ac);

	int changePwDo(AccountDTO ac);

	AccountDTO searchId(AccountDTO ac);

	int accountUpdate(AccountDTO ac);

	int accountDelete(AccountDTO ac);

	int socialIdCheck(AccountDTO ac);

	int socialIdCheck(AC_US_TITLE ac);

	AC_US_TITLE accountLogin(AC_US_TITLE ac);

	int regAccount(AccountDTO ac);

	void regProfile(AC_PF_TITLE ac);

}
