package com.tis.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MemberDao implements MemberService {
	@Autowired
	public SqlSessionFactory sqlSessionFactory;
	
	@Override
	public List<MemberDto> getAllMemberList(int start, int end, String search_select, String search_word) {
		HashMap<String, Object> pageMap = new HashMap<>();
		pageMap.put("start", start);
		pageMap.put("end", end);
		pageMap.put("searchSelect", search_select);
		pageMap.put("searchWord", search_word);

		List<MemberDto> memberList = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		memberList = sqlSession.selectList("getAllMemberList", pageMap);
		sqlSession.close();
		return memberList;
	}

	@Override
	public MemberDto getSelectOne(String code) {
		MemberDto memberDto = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		memberDto = sqlSession.selectOne("getMemberSelectOne", code);
		sqlSession.close();
		return memberDto;
	}

	@Override
	public int deleteMember(MemberDto memberDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.delete("deleteMember", memberDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int insertMember(MemberDto memberDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("insertMember", memberDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int updateMember(MemberDto memberDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession(); // 세션 열기
		result = sqlSession.insert("updateMember", memberDto); // mybatis/membermapper안에 있어야 함
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int getTotal(String search_select, String search_word) {
		return 0;
	}
}
