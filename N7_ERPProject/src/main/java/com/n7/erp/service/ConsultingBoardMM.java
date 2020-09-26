package com.n7.erp.service;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.n7.erp.bean.ConsultingBoard;
import com.n7.erp.dao.HRIDeptDao;
import com.n7.erp.dao.IConsultingBoardDao;
import com.n7.erp.userClass.Paging;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ConsultingBoardMM {

	@Autowired
	private IConsultingBoardDao CBdao;

	ModelAndView mav = new ModelAndView();
	//게시판 이동시 목록 출력
	public ModelAndView moveBoardList(Integer pageNum) {
		System.out.println("pageNum="+pageNum);
		mav=new ModelAndView();
		String view= null;
		ArrayList<ConsultingBoard> bList=null;
		pageNum=(pageNum==null)?1:pageNum;
		if(pageNum<=0) {
			System.out.println("잘못된 페이지 번호");
		}
		bList= CBdao.getBoardList(pageNum);
		if(bList!=null && bList.size()!=0) {
			Gson gson=new Gson();
			String json=gson.toJson(bList);
			mav.addObject("bList", json);
			mav.addObject("paging", getPaging(pageNum));
			view="/home/erpboard";
		}
		mav.setViewName(view);
		return mav;
	}
	
	private String getPaging(Integer pageNum) {
		int maxNum = CBdao.getBoarCount();
		int listCount=10;
		int pageCount=2;
		String boardName="/erp/erpboard";
		Paging paging= new Paging(maxNum, pageNum, listCount, pageCount, boardName);
		return paging.makeHtmlPaging();
	}

	public ModelAndView writeBoard(ConsultingBoard board, HttpSession session, MultipartHttpServletRequest multi) {
		mav= new ModelAndView();
		String view= null;
		String title= multi.getParameter("CB_TITLE");
		String contents= multi.getParameter("CB_CONTENTS");
		int check= Integer.parseInt(multi.getParameter("filecheck"));
		String id= multi.getSession().getAttribute("m_id").toString();
		String pw= multi.getParameter("CB_PASSWORD");
		System.out.println("check="+check);
		System.out.println("id="+id);
		
		return null;
	}

//	//게시판 글 작성
//	public ModelAndView writeBoard(ConsultingBoard board) {
//		String view=null;
//		if(CBdao.writeBoard(board)) {
//			System.out.println("제발...");
//			view="/home/writeFrm";
//		}else {
//			view="/home/erpboard";
//		}
//		mav.setViewName(view);
//		return mav;
//	}
//	//게시글 수정 목록 출력
//	public String boardmodifyajax(Integer num) {
//		System.out.println("수정페이지 서비스 번호 값="+num);
//		ConsultingBoard cbList=CBdao.boardmodifyajax(num);
//		System.out.println("회원 정보="+cbList);
//		if(cbList!=null) {
//			Gson gson=new Gson();
//			String json=gson.toJson(cbList);
//			System.out.println("json타입으로 변경"+json);
//			return json;
//		}
//
//		return null;
//	}
//	//게시글 수정
//	public ModelAndView boardmodify(ConsultingBoard board) {
//		String view=null;
//		if(CBdao.boardmodify(board)) {
//			view="redirect:/home/erpboard";
//		}
//		mav.setViewName(view);
//		return mav;
//	}
//	//게시글 삭제
//	public ModelAndView writelistdelete(Integer num) {
//		String view=null;
//		if(num!=null) {
//			if(CBdao.writelistdelete(num)) {
//				view="/home/erpboard";
//			}else {
//				view="/home/erpboard";
//			}
//		}
//		mav.setViewName(view);
//		return mav;
//	}

}
