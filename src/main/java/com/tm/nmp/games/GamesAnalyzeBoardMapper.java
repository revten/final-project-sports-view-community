package com.tm.nmp.games;

import java.util.List;

public interface GamesAnalyzeBoardMapper {
	
	// 글
	int getAllPostCount(GamesSelector gSel);
	
	public abstract List<GamesAnalyzeBoard> getAllPost(GamesSelector gSel);
	
	int writePost(GamesAnalyzeBoard gp);
	
	int deletePost(GamesAnalyzeBoard gp);
	
	int updatePost(GamesAnalyzeBoard gp);
	
	// 댓글
	GamesAnalyzeBoard getPost(GamesAnalyzeBoard gp);

	List<GamesAnalyzeCmnt> getAllCmnt(GamesAnalyzeBoard gp);
	
	int deleteCmnt(GamesAnalyzeCmnt gc);
	
	int writeCmnt(GamesAnalyzeCmnt gc);
	
	
}
