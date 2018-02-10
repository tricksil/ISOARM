package com.spring.aula.trick.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getTexto(){
        return "Olá pessoal!";
    }

    @RequestMapping(value = "/{nome}", method = RequestMethod.GET)
    public String getTexto(@PathVariable String nome){
        return "Olá pessoal, sou o " + nome;
    }

}
