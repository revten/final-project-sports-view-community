package com.tm.nmp.admin;

import java.util.List;

public interface AdminMapper {

	int getAllAnswerPostCount(AnswerSelector asSel);
	
	List<AnswerDTO> getAnswerAll(AnswerSelector asSel);

	AnswerDTO getAnswer(AnswerDTO as);

	int updateAnswer(AnswerDTO as);

	int deleteAnswer(AnswerDTO as);

	int insertAnswer(AnswerDTO as);

	List<AnswerComment> getAllAnswerComment(AnswerDTO as);

	int writeAnswerComment(AnswerComment asc);

	int deleteAnswerComment(AnswerComment asc);

	int updateAnswerComment(AnswerComment asc);



}
