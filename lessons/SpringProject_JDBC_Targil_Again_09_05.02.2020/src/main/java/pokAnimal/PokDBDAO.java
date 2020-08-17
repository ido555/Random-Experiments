package pokAnimal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class PokDBDAO implements RowMapper<Pok> {
	@Autowired // gotta call template the same name as @Bean
	private JdbcTemplate getJdbcTemplate;

	public void addPok(Pok pok) {
		getJdbcTemplate.update("INSERT INTO pokanimal.pok(name, type, health_points, defense) values(?,?,?,?)",
				pok.getName(), String.valueOf(pok.getType()), pok.getHealthPoints(), pok.getDefense());
		// update - change the db = update, insert, delete
	}

	public void deletePok(int id) {
		getJdbcTemplate.update("DELETE FROM pokanimal.pok WHERE pok_id=?", id);
	}

	public List<Pok> getAllPoks() {
		// this = PokDBDAO finds mapRow by itself ?
		return getJdbcTemplate.query("SELECT * FROM pokanimal.pok", this);
	}

	public Pok getOnePok(int id) {
		return getJdbcTemplate.queryForObject("SELECT * FROM pokanimal.pok WHERE id =" + id, this);
	}

	public Pok mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Pok(rs.getInt(1), rs.getInt(4), rs.getInt(5), rs.getString(2), PokType.valueOf(rs.getString(3)));
	}
}
