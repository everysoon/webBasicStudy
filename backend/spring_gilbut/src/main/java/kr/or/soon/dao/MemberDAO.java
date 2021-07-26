package kr.or.soon.dao;

import java.util.List;

import kr.or.soon.dto.Member;

public interface MemberDAO {
	public List<Member> selectAllMembers() throws Exception;
	public int insertMember(Member m) throws Exception;
	public int deleteMember(String id) throws Exception;
	public int modMember(Member m) throws Exception;
}
