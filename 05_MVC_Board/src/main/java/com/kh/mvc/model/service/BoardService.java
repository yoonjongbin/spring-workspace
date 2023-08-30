package com.kh.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mvc.model.dao.BoardDAO;
import com.kh.mvc.model.vo.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	public int insertBoard(Board board) {
		return dao.insertBoard(board);
	}
	
	public List<Board> selectAll(){
		return dao.selectAll();
	}
	
	public List<Board> select(String word){
		return dao.select(word);
	}
	
	public int updateBoard(Board board) {
		return dao.updateBoard(board);
	}
	
	public int deletBoard(String no) {
		return dao.deleteBoard(no);
	}
}
