package com.aornelas.burger_app.interfaces;

import com.aornelas.burger_app.domain.Burger;

import java.util.List;

public interface IBurgerDao {
    List<Burger> findAll();

    void insertBurger(Burger burger);

    void updateBurger(Burger burger);

    void deleteBurger(Long id);

}
