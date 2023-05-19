package com.tm.nmp.account;

import java.util.List;

import com.tm.nmp.admin.ClubImageDTO;
import com.tm.nmp.board.PostVO;

public interface AccountMapper {
	
	// 아이디 중복체크
	int idCheck(String id);
	
	// 회원가입하기
	int regAccount(AccountDTO ac);
	
	// 회원가입창 구단 로고들 불러오기
	List<ClubImageDTO> getAllClubLogos();
	
	// 회원가입시 관심 구단 등록
	void regFavoriteClub(List<FavoriteClubDTO> favoriteClubs);

	AccountDTO accountLogin(AccountDTO ac);


	
	
	int changePwDo(AccountDTO ac);

	AccountDTO searchId(AccountDTO ac);

	int accountUpdate(AccountDTO ac);

	int accountDelete(AccountDTO ac);

	int socialIdCheck(AccountDTO ac);

	
	void regProfile(AccountDTO ac);

	List<AccountDTO> showAccount(AccountDTO ac);
	
	List<PostVO> getMyPosts(PostVO pVO);

	PostVO getMyDeatailPosts(PostVO pvo);




}
