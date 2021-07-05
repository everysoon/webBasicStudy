package kr.or.connect.spring_guestbook.dao;
import static kr.or.connect.spring_guestbook.dao.GuestbookDaoSqls.DELETE_BY_ID;
import static kr.or.connect.spring_guestbook.dao.GuestbookDaoSqls.SELECT_COUNT;
import static kr.or.connect.spring_guestbook.dao.GuestbookDaoSqls.SELECT_PAGING;

import java.util.Collections;
import java.util.HashMap;
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

import kr.or.connect.spring_guestbook.dto.Guestbook;
@Repository
public class GuestbookDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Guestbook> rowMapper = BeanPropertyRowMapper.newInstance(Guestbook.class);
	public GuestbookDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("guestbook")
				.usingGeneratedKeyColumns("id");	
	}
	public List<Guestbook> selectAll(Integer start, Integer limit){
		Map<String,Integer> params = new HashMap<>();
		params.put("start",start);
		params.put("limit", limit);
		return jdbc.query(SELECT_PAGING, params,rowMapper);
	}
	public Long insert(Guestbook guestbook) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(guestbook);
		
		return insertAction.executeAndReturnKey(params).longValue();
	}
	public int deleteById(Long id) {
		Map<String,?> params = Collections.singletonMap("id", id);
		return jdbc.update(DELETE_BY_ID, params);
	}
	
	public int selectCount() {
		//queryForObject : 하나의 컬럼을 가지고오거나 하나의 도메인으로 가지고 올 때 사용
		SqlParameterSource params = null;
		return jdbc.queryForObject(SELECT_COUNT,params, Integer.class);
	}
}
