package com.alo0onge.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReplyBoardDao implements ReplyBoardService {

	@Autowired
	SqlSessionFactory sqlSessionFactory;

	// 새글 쓰기....(1 / 2)
	@Override
	public int insertBoard(ReplyBoardDto replyBoardDto) {
		int result = 0;

		int reGroup = 0;
		int reStep = 1;
		int reLevel = 1;
		reGroup = getMaxRegroup() + 1; // 자동증가가 없어서 제일큰거 받아서 더하기 1하면 제일 큰 숫자가 됨.

		replyBoardDto.setReGroup(reGroup);
		replyBoardDto.setReStep(reStep);
		replyBoardDto.setReLevel(reLevel);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("insertBoard", replyBoardDto);
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public int insertReplyBoard(ReplyBoardDto replyBoardDto) {
		int result = 0;

		int reGroup = replyBoardDto.getReGroup();
		int reStep = replyBoardDto.getReStep();
		int reLevel = replyBoardDto.getReLevel();

		updateReLevel(replyBoardDto);
		replyBoardDto.setReGroup(reGroup);
		replyBoardDto.setReStep(reStep + 1);
		replyBoardDto.setReLevel(reLevel + 1);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("insertBoard", replyBoardDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	// 글 수정
	@Override
	public int updateBoard(ReplyBoardDto replyBoardDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.update("updateBoard", replyBoardDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	// 답글 쓰기
	@Override
	public int updateReLevel(ReplyBoardDto replyBoardDto) {
		int result = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateReLevel", replyBoardDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int getMaxRegroup() {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.selectOne("getMaxReGroup");
		System.out.println("result===" + result);
		// select는 resultType이 존재 한다. 나머지 것들(inser,delete,update)은 없다.
		// 1. 연결 2. mapper에서 id들고 오기 3. 리턴값 담고 4. commit하고 5.close
		sqlSession.close();
		return result;
	}

	@Override
	public List<ReplyBoardDto> getAllList(int start, int end, String search_select, String search_word) {
		// PageDto를 만들어도 됨 두개밖에 없어서 Map으로 쓰고 있음....
		HashMap<String, Object> pageMap = new HashMap<>();
		pageMap.put("start", start);
		pageMap.put("end", end);
		pageMap.put("searchSelect", search_select);
		pageMap.put("searchWord", search_word);

		List<ReplyBoardDto> boardList = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		boardList = sqlSession.selectList("getAllList", pageMap); // 마이바티스 메서드는 매개변수 하나밖에 못넘기...
		sqlSession.close();
		return boardList;
	}

	@Override
	public List<ReplyBoardDto> getSearchAllList(String search_select, String search_word) {

		HashMap<String, String> searchMap = new HashMap<>();
		searchMap.put("searchSelect", search_select);
		searchMap.put("searchWord", search_word);

		List<ReplyBoardDto> boardList = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		boardList = sqlSession.selectList("getSearchAllList", searchMap); // 마이바티스 메서드는 매개변수 하나밖에 못넘기...
		sqlSession.close();
		return boardList;
	}

	@Override
	public ReplyBoardDto getSelectOne(int no) {
		ReplyBoardDto replyBoardDto = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		replyBoardDto = sqlSession.selectOne("getSelectOne", no);
		sqlSession.close();
		return replyBoardDto;
	}

	@Override
	public ReplyBoardDto getPrevSelect(int num) {
		ReplyBoardDto replyBoardDto = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		replyBoardDto = sqlSession.selectOne("getPrevSelect", num);
		sqlSession.close();
		return replyBoardDto;
	}

	@Override
	public ReplyBoardDto getNextSelect(int num) {
		ReplyBoardDto replyBoardDto = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		replyBoardDto = sqlSession.selectOne("getNextSelect", num);
		sqlSession.close();
		return replyBoardDto;
	}

	@Override
	public int updateHit(int no) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.update("updateHit", no);
		sqlSession.commit();
		sqlSession.close();

		return result;
	}

	@Override
	public int deleteBoard(ReplyBoardDto replyBoardDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.delete("deleteBoard", replyBoardDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int getTotal(String search_select, String search_word) {
		HashMap<String, String> searchMap = new HashMap<>();
		searchMap.put("searchSelect", search_select);
		searchMap.put("searchWord", search_word);
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.selectOne("getTotal", searchMap);
		sqlSession.close();
		return result;
	}
}
