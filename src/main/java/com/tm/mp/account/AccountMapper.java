package com.tm.mp.account;

public interface AccountMapper {

	int regAccount(AccountDTO ac);

	AccountDTO accountLogin(AccountDTO ac);

	AccountDTO searchId(AccountDTO ac);

	int changePwDo(AccountDTO ac);

	int accountUpdate(AccountDTO ac);

	int accountDelete(AccountDTO ac);

}
