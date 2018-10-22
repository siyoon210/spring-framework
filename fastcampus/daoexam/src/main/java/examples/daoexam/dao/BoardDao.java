package examples.daoexam.dao;

import examples.daoexam.dto.Board;
import examples.daoexam.dto.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDao {
    private NamedParameterJdbcTemplate jdbc;
    // insert
    private SimpleJdbcInsert insertAction;

    public BoardDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);

        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("board")
                .usingGeneratedKeyColumns("id");
    }

    public int updateCount(Long id){
        String sql = "update board set read_count = read_count + 1 where id = :id";
        Map<String, Long> map = Collections.singletonMap("id", id);
        return jdbc.update(sql, map);
    }

    public Long addBoard(Board board){
        SqlParameterSource params = new BeanPropertySqlParameterSource(board);
        return insertAction.executeAndReturnKey(params).longValue();
    }

    public int deleteBoard(Long id){
        String sql = "delete from board where id = :id";
        Map<String, Long> map = new HashMap<>();
        map.put("id", 1L);
        return jdbc.update(sql, map);
    }

    public int updateBoard(Board board){
        String sql = "update board " + // 문자열 뒤에 공백 조심.
                "set name = :name , " +
                "title = :title, " +
                "content = :content " +
                "where id = :id";
//        Map<String, Object> map = new HashMap<>();
//        map.put("id", board.getId());
//        map.put("name", board.getName());
//        map.put("title", board.getTitle());
//        map.put("content", board.getContent());
        SqlParameterSource params = new BeanPropertySqlParameterSource(board);
        return jdbc.update(sql, params);
    }

    public Board getBoard(Long id){
        String sql = "select id, name, title, content, regdate, read_count     " +
                "from board where id = :id";
        try{
            RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);
            Map<String, ?> params = Collections.singletonMap("id", id);
            return jdbc.queryForObject(sql, params, rowMapper);
            //sql은 쿼리문 , param은 바인딩을 위함, roMapper는 조회한 DB를 DTO로 변환하기 위함
        }catch(Exception ex){
            return null;
        }
    }

    public List<Board> getBoards(int start, int limit) {
        String sql = "select id, name, title, content, regdate, read_count     " +
                "from board ORDER BY id DESC limit :start , :limit";

        try {
            RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);
            Map<String, Integer> params = new HashMap<>();
            params.put("start", start);
            params.put("limit", limit);
            return jdbc.query(sql, params, rowMapper);

        } catch (Exception e) {
            return null;
        }
    }
}
