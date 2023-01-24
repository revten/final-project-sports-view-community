package com.tm.nmp.message;

import java.util.List;

import com.tm.nmp.account.AccountDTO;

public interface MessageMapper {

	public List<AccountDTO> getMember();

	public List<MessageVO> getMsg(AccountDTO ac);

	public int deleteMsg(MessageVO mv);

	public int sendMsg(MessageVO mv);

}
