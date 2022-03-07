package com.alo0onge.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//어떤 함수를 구현해야 하는지 명세하는 인터페이스
public interface MemberService {
	public List<MemberDto> getAllMemberList(int start, int end, String search_select, String search_word);
	public Map<MemberDto, Object> getAllMemberListJson(int start, int end, String search_select, String search_word);
	public MemberDto getSelectOne(String id);
	public MemberDto getLoggedMember(MemberDto pMemberDto);
	public int deleteMember(MemberDto memberDto);
	public int insertMember(MemberDto memberDto);
	public int updateMember(MemberDto memberDto);
	public int idCheck(String id);
	public int getTotal(String search_select, String search_word);
}
