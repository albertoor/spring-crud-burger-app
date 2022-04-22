package com.aornelas.burger_app.controllers;

import com.aornelas.burger_app.domain.Burger;
import com.aornelas.burger_app.repositories.JdbcBurgerRepositoryDaoImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
public class BurgerController {

    private JdbcBurgerRepositoryDaoImpl burgerRepo;

    @Autowired
    public BurgerController(JdbcBurgerRepositoryDaoImpl burgerRepo) {
        this.burgerRepo = burgerRepo;
    }

    @GetMapping
    public String getBurgers(Model model) {
        model.addAttribute("burgers", burgerRepo.findAll());
        return "index";
    }

}
