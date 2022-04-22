package com.aornelas.burger_app.repositories;

import com.aornelas.burger_app.domain.Burger;
import com.aornelas.burger_app.interfaces.IBurgerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.aornelas.burger_app.utils.BurgerRowMapper;

import java.util.List;

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

    }

    @Override
    public void updateBurger(Burger burger) {

    }

    @Override
    public void deleteBurger(Burger burger) {

    }
}
