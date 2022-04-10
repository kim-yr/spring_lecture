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
	public List<MemberDto> getAllMemberList(String search_position, String search_subject, String search_name) {
		HashMap<String, Object> pageMap = new HashMap<>();
		pageMap.put("searchPosition", search_position);
		pageMap.put("searchSubject", search_subject);
		pageMap.put("searchName", search_name);
		System.out.println(search_position+"/"+search_subject+"/"+search_name);
		List<MemberDto> memberList = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		memberList = sqlSession.selectList("getAllMemberList", pageMap);
		sqlSession.close();
		return memberList;
	}
//	@Override
//	public MemberDto getSelectOne(String code) {
//		MemberDto memberDto = null;
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		memberDto = sqlSession.selectOne("getMemberSelectOne", code);
//		sqlSession.close();
//		return memberDto;
//	}
//
//	@Override
//	public int deleteMember(MemberDto memberDto) {
//		int result = 0;
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		result = sqlSession.delete("deleteMember", memberDto);
//		sqlSession.commit();
//		sqlSession.close();
//		return result;
//	}
//
//	@Override
//	public int insertMember(MemberDto memberDto) {
//		int result = 0;
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		result = sqlSession.insert("insertMember", memberDto);
//		sqlSession.commit();
//		sqlSession.close();
//		return result;
//	}
//
//	@Override
//	public int updateMember(MemberDto memberDto) {
//		int result = 0;
//		SqlSession sqlSession = sqlSessionFactory.openSession(); // 세션 열기
//		result = sqlSession.insert("updateMember", memberDto); // mybatis/membermapper안에 있어야 함
//		sqlSession.commit();
//		sqlSession.close();
//		return result;
//	}
//
//	@Override
//	public int getTotal(String search_select, String search_word) {
//		return 0;
//	}

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
	public MemberDto getSelectOne(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteMember(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
<<<<<<< HEAD
=======
	public int insertMember(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
>>>>>>> 1d47a5ac238cedf094f54b7188ee357784fd36ac
	public int updateMember(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotal(String search_select, String search_word) {
		// TODO Auto-generated method stub
		return 0;
	}
}
