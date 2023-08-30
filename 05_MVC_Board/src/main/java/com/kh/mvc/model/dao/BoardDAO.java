package com.kh.mvc.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Board;
@Repository
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insertBoard(Board board) {
		int result = sqlSession.insert("board.insert", board);
		
		return result;
	}
	
	public List<Board> selectAll(){
		return sqlSession.selectList("board.selectAll");
	}
	
	public List<Board> select(String word){
		return sqlSession.selectList("board.select", word);
	}
	
	public int updateBoard(Board board) {
		int result = sqlSession.update("board.update", board);
		return result;
	}
	
	public int deleteBoard(String no) {
		int result = sqlSession.delete("board.delete", no);
		return result;
	}
}
