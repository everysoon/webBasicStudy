package kr.or.soon.service;

import java.util.List;

import kr.or.soon.dao.MemberDAO;
import kr.or.soon.dto.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDAO dao;

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Member> listMembers() throws Exception{
		List members = null;
		members =dao.selectAllMembers();
		return members;
	}

	@Override
	public int addMember(Member m) throws Exception {
		return dao.insertMember(m);
	}

	@Override
	public int removeMember(String id) throws Exception {
		return dao.deleteMember(id);
	}

	@Override
	public int modMember(Member m) throws Exception {
	return dao.modMember(m);
	}
	

}
