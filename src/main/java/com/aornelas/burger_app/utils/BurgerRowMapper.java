package com.aornelas.burger_app.utils;

import com.aornelas.burger_app.domain.Burger;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BurgerRowMapper implements RowMapper<Burger> {
    @Override
    public Burger mapRow(ResultSet rs, int rowCount) throws SQLException {
        Burger burger = new Burger();
        burger.setId(rs.getLong("id"));
        burger.setName(rs.getString("name"));
        burger.setPrice(rs.getDouble("price"));
        burger.setDescription(rs.getString("description"));
        return burger;
    }
}
