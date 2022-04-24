package com.aornelas.burger_app.repositories;

import com.aornelas.burger_app.domain.Burger;
import com.aornelas.burger_app.interfaces.IBurgerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.aornelas.burger_app.utils.BurgerRowMapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcBurgerRepositoryDaoImpl implements IBurgerDao {
    private NamedParameterJdbcTemplate template;

    @Autowired
    public JdbcBurgerRepositoryDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Burger> findAll() {
        return template.query("SELECT * FROM burger;", new BurgerRowMapper());
    }

    @Override
    public void insertBurger(Burger burger) {
        final String sql = "INSERT INTO burger(name, price, description) VALUES (:name, :price, :description)";
        Map<String, Object> burgerMapRow = new HashMap<String, Object>();
        burgerMapRow.put("name", burger.getName());
        burgerMapRow.put("price", burger.getPrice());
        burgerMapRow.put("description", burger.getDescription());
        template.execute(sql, burgerMapRow, (PreparedStatementCallback) ps -> ps.executeUpdate());
    }

    @Override
    public void updateBurger(Burger burger) {

    }

    @Override
    public void deleteBurger(Long id) {
        final String sql = "DELETE FROM burger WHERE id=:id";
        Map<String, Long> paramMap = new HashMap<>();
        paramMap.put("id", id);
        template.execute(sql, paramMap, (PreparedStatementCallback<Object>) ps -> ps.executeUpdate());
    }
}
