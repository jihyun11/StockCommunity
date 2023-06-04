package com.jihyun.stockcommunity.controller;

import com.jihyun.stockcommunity.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    private final SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/sample")
    public String sample(Model model) {
        int message = sampleService.selectSample();
        model.addAttribute("message", message);
        return "sample";
    }



    @GetMapping("pokemonpick")
    public String pokemonpick() {
        return "pokemonpick";
    }

//    @PostMapping("/pokemon")
//    public String pick(Pokemon pokemon) {
//        Pokemon pk = new Pokemon();
//        pk.setPokemon(PokemonFrom.getPokemon());
//        System.out.println(PokemonFrom.getPokemon());
//
//        return "redirect:/pokemon";
//    }


}