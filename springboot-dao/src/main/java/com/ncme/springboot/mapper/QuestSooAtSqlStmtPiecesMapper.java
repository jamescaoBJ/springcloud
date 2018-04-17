package com.ncme.springboot.mapper;

import com.ncme.springboot.model.QuestSooAtSqlStmtPieces;

public interface QuestSooAtSqlStmtPiecesMapper {
    int insert(QuestSooAtSqlStmtPieces record);

    int insertSelective(QuestSooAtSqlStmtPieces record);
}