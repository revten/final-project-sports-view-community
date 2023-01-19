package com.tm.nmp.games;

import java.util.List;

public interface GamesAnalyzeBoardMapper {
	
	// 글
	int getAllAnalyzePostCount(GamesSelector gSel);
	
	public abstract List<GamesAnalyzeBoard> getAllAnalyzePost(GamesSelector gSel);
	
	int writeAnalyzePost(GamesAnalyzeBoard gp);
	
	int deleteAnalyzePost(GamesAnalyzeBoard gp);
	
	int updateAnalyzePost(GamesAnalyzeBoard gp);
	
	// 댓글
	GamesAnalyzeBoard getAnalyzePost(GamesAnalyzeBoard gp);

	List<GamesAnalyzeCmnt> getAllAnalyzeCmnt(GamesAnalyzeBoard gp);
	
	int deleteAnalyzeCmnt(GamesAnalyzeCmnt gc);
	
	int writeAnalyzeCmnt(GamesAnalyzeCmnt gc);
	
	
}
