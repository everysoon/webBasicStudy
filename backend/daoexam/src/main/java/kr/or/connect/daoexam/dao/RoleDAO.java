package kr.or.connect.daoexam.dao;

// static import하면 RoleDaoSqls.해서 가져오지않아도 됨
import static kr.or.connect.daoexam.dao.RoleDaoSqls.DELETE_BY_ROLE_ID;
import static kr.or.connect.daoexam.dao.RoleDaoSqls.SELECT_ALL;
import static kr.or.connect.daoexam.dao.RoleDaoSqls.SELECT_BY_ROLE_ID;
import static kr.or.connect.daoexam.dao.RoleDaoSqls.UPDATE;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.daoexam.dto.Role;
@Repository
public class RoleDAO {
	// NamedParameterJdbcTemplate : ? 사용해서 매핑하면 알아서 헷갈릴수있어서
	// 이름을 이용해서 바인딩하거나 값을 가져올 수 있다.
	private NamedParameterJdbcTemplate jdbc;
	//BeanPropertyRowMapper dbms와 자바의 이름규칙을 맞춰줌!
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
	private SimpleJdbcInsert insertAction;
	public RoleDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("role");
	}
	public List<Role> selectAll(){
		// Collections.emptyMap() : 비어있는 Map객체
		// rowMapper은 바인딩할 값이 있을 때 바인딩할 값 전달할 목적
		// select한건 한건을 dto에 저장할 목적
		return jdbc.query(SELECT_ALL,rowMapper);
	}
	public int insert(Role r) {
		// 프라이머리키 직접 넣어주기
		SqlParameterSource params = new BeanPropertySqlParameterSource(r);
		return insertAction.execute(params);
	}
	public int update(Role r) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(r);
		return jdbc.update(UPDATE, params);
	}
	public int delete(Integer roleId) {
		Map<String,?> params = Collections.singletonMap("roleId", roleId);
		return jdbc.update(DELETE_BY_ROLE_ID,params);
	}
	public Role select(Integer roleId) {
		try {
			Map<String,?> params = Collections.singletonMap("roleId", roleId);
			return jdbc.queryForObject(SELECT_BY_ROLE_ID,params,rowMapper);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
