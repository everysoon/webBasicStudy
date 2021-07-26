package kr.or.soon.service;

import java.util.List;

import kr.or.soon.dto.Member;

public interface MemberService {
	public List<Member> listMembers() throws Exception; 
	public int addMember(Member m) throws Exception;
	public int removeMember(String id) throws Exception;
	public int modMember(Member m) throws Exception;
	
}
