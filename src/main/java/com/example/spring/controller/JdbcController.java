package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jdbc")

public class JdbcController {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @RequestMapping("/execute")
    public String execute() {
        String sql = "SELECT count(*) FROM employees WHERE id = :firstID OR id = :secondID;";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("firstID", 1).addValue("secondID", 3);
        Integer result = template.queryForObject(sql, param, Integer.class);
        System.out.println("result = " + result);
        return "finished";
    }

}
