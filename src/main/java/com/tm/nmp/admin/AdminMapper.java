package com.tm.nmp.admin;

import java.util.List;

public interface AdminMapper {

	int getAllANSPostCount(AnswerSelector asSel);
	
	List<AnswerDTO> getAnswerAll(AnswerSelector asSel);

	AnswerDTO getAnswer(AnswerDTO as);

	int updateAnswer(AnswerDTO as);

	int deleteAnswer(AnswerDTO as);

	int insertAnswer(AnswerDTO as);

	List<AnswerComment> getAllComment(AnswerDTO as);

	int writeComment(AnswerComment asc);

	int deleteComment(AnswerComment asc);

	int updateComment(AnswerComment asc);



}
