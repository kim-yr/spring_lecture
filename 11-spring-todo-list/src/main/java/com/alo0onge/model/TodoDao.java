package com.alo0onge.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class TodoDao {
	@Autowired
	public SqlSessionFactory sqlSessionFactory;

	public int insertTodo(TodoDto todoDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("insertTodo", todoDto);
		sqlSession.close();
		return result;
	}
	
	public int deleteTodo(int no) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.delete("deleteTodo", no);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	public int updateTodo(TodoDto todoDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.update("updateTodo", todoDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	public List<TodoDto> getAllList(String pickedDate){
		List<TodoDto> todoList = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		todoList = sqlSession.selectList("getAllList", pickedDate); //이건 mapper에 같은 이름의 쿼리스트링이 있어야 함
		sqlSession.close();
		return todoList;
	}
}
