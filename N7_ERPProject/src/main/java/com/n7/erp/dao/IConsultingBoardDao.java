package com.n7.erp.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import com.n7.erp.bean.ConsultingBoard;

public interface IConsultingBoardDao {
	
	ArrayList<ConsultingBoard> getBoardList(Integer pageNum);
	
	@Select("SELECT COUNT(*) FROM CONSULTING_BOARD")
	int getBoarCount();

	boolean boardWrite(ConsultingBoard board);

	ConsultingBoard getBoardContents(int cB_NUM);
	
	//상담 게시판 	
//	@Select("SELECT * FROM CONSULTING_BOARD")
//	ArrayList<ConsultingBoard> moveBoardList();
//
//	boolean writeBoard(ConsultingBoard board);
//	
//	ConsultingBoard boardmodifyajax(Integer num);
//
//	boolean boardmodify(ConsultingBoard board);
//
//	boolean writelistdelete(Integer num);
//
//	Integer getBoardList();
}
