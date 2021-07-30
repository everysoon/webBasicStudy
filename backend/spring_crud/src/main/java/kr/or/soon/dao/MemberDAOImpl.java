package kr.or.soon.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.soon.dto.Member;

public class MemberDAOImpl implements MemberDAO{
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Member> selectAllMembers() throws Exception {
		return sqlSession.selectList("mapper.member.selectAllMemberList");
	}

	@Override
	public int insertMember(Member m) throws Exception {
		return sqlSession.insert("mapper.member.insertMember",m);
	}

	@Override
	public int deleteMember(String id) throws Exception {
		return sqlSession.delete("mapper.member.deleteMember",id);
	}

	@Override
	public int modMember(Member m) throws Exception {
		return sqlSession.update("mapper.member.updateMember",m);
	}
	
}
