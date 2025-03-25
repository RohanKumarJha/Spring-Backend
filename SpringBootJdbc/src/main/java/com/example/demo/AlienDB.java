package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AlienDB {
	
	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void saveToDb(Alien alien) {
		String sql = "insert into alien(id,name,tech) values(?,?,?)";
		template.update(sql,alien.getId(),alien.getName(),alien.getTech());
	}
	
	public List<Alien> getAll() {
		String sql = "select * from alien";
		RowMapper<Alien> rm = (rs,rowTable) -> {
			Alien alien = new Alien();
			alien.setId(rs.getInt(1));
			alien.setName(rs.getString(2));
			alien.setTech(rs.getString(3));
			return alien;
		};
		
		List<Alien> aliens = template.query(sql,rm);
		return aliens;
	}
}
