package com.tm.nmp.account;

import java.util.List;

import com.tm.nmp.board.PostVO;

public interface AccountMapper {

	AccountDTO accountLogin(AccountDTO ac);

	int changePwDo(AccountDTO ac);

	AccountDTO searchId(AccountDTO ac);

	int accountUpdate(AccountDTO ac);

	int accountDelete(AccountDTO ac);

	int socialIdCheck(AccountDTO ac);

	int regAccount(AccountDTO ac);

	int idCheck(String id);
	
	void regProfile(AccountDTO ac);

	List<AccountDTO> showAccount(AccountDTO ac);
	
	List<PostVO> getMyPosts(PostVO pVO);

}
