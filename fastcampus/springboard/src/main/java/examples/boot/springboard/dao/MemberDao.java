package examples.boot.springboard.dao;

import examples.boot.springboard.dto.Member;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

@Repository
public class MemberDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;

    public MemberDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);

        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("member")
                .usingGeneratedKeyColumns("id");
    }

    public Long addMember(Member member){
        SqlParameterSource params = new BeanPropertySqlParameterSource(member);
        return insertAction.executeAndReturnKey(params).longValue();
    }

    public Member getMember(String email) {
        String sql = "select id, name, email, regdate, password     " +
                "from member where email = :email";
        try{
            RowMapper<Member> rowMapper = BeanPropertyRowMapper.newInstance(Member.class);
            Map<String, ?> params = Collections.singletonMap("email", email);
            return jdbc.queryForObject(sql, params, rowMapper);
            //sql은 쿼리문 , param은 바인딩을 위함, roMapper는 조회한 DB를 DTO로 변환하기 위함
        }catch(Exception ex){
            return null;
        }
    }

}
