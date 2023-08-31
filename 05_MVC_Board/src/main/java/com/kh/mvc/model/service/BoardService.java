package com.kh.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mvc.model.dao.BoardDAO;
import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	public int insertBoard(Board board) {
		return dao.insertBoard(board);
	}
	
	public List<Board> selectAll(Criteria cri){
		return dao.selectAll(cri);
	}
	
	public int getTotal() {
		return dao.getTotal();
	}
	
	public Board select(int no){
		return dao.select(no);
	}
	
	public int updateBoard(Board board) {
		return dao.updateBoard(board);
	}
	
	public int deletBoard(int no) {
		return dao.deleteBoard(no);
	}
}
