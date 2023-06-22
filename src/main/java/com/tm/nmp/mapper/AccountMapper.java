package com.tm.nmp.mapper;

import java.util.List;
import java.util.Map;

import com.tm.nmp.board.PostVO;
import com.tm.nmp.model.AccountVO;
import com.tm.nmp.model.ClubImageDTO;
import com.tm.nmp.model.FavoriteClubDTO;

public interface AccountMapper {
	
	// 아이디 중복체크
	int idCheck(String id);
	
	// 회원가입하기
	int regAccount(AccountVO ac);
	
	// 회원가입창 구단 로고들 불러오기
	List<ClubImageDTO> getAllClubLogos();
	
	// 회원가입시 관심 구단 등록
	void regFavoriteClub(List<FavoriteClubDTO> favoriteClubs);
	
	// 로그인 하기
	AccountVO accountLogin(AccountVO ac);
	
	// 아이디 찾기
	String searchId(Map<String, String> findId);
	
	// 비밀번호 변경하기
	int changePwDo(AccountVO ac);
	
	// 탈퇴하기
	int deleteAccount(String id);



	int accountUpdate(AccountVO ac);

	int socialIdCheck(AccountVO ac);



	List<AccountVO> showAccount(AccountVO ac);
	
	List<PostVO> getMyPosts(PostVO pVO);

	PostVO getMyDeatailPosts(PostVO pvo);


}
