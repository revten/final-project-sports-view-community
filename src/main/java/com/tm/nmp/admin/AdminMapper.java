package com.tm.nmp.admin;

import java.util.List;

public interface AdminMapper {

	List<AnswerDTO> getAnswerAll();

	AnswerDTO getAnswer(AnswerDTO as);

	int updateAnswer(AnswerDTO as);

	int deleteAnswer(AnswerDTO as);

	int insertAnswer(AnswerDTO as);

}
