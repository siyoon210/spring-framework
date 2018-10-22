package examples.daoexam.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import examples.daoexam.dto.Role;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

    public RoleDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("role");
//		this.insertAction = new SimpleJdbcInsert(dataSource)
//				.withTableName("role")
//				.usingGeneratedKeyColumns("role_id");
    }
    
    public List<Role> selectAll() {
        return jdbc.query(RoleDaoSqls.SELECT_ALL, Collections.emptyMap(), rowMapper);
    }


	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
//		return insertAction.executeAndReturnKey(params);

		// role이 가지고 있는 roleId
		// insert into role(role_id, de....) values (?, ?)
		return insertAction.execute(params);
	}
	
	public Role selectById(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", id);
			return jdbc.queryForObject(RoleDaoSqls.SELECT_BY_ROLE_ID, params, rowMapper);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public int update(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return jdbc.update(RoleDaoSqls.UPDATE, params);
	}
	
	public int deleteById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("roleId", id);
		return jdbc.update(RoleDaoSqls.DELETE_BY_ROLE_ID, params);
	}
}
