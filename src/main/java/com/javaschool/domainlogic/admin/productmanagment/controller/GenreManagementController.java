package com.javaschool.domainlogic.admin.productmanagment.controller;

import com.javaschool.domainlogic.admin.productmanagment.dto.GenreDto;
import com.javaschool.domainlogic.admin.productmanagment.service.api.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/genre")
public class GenreManagementController {

    @Autowired
    private GenreService genreService;

    @ModelAttribute("genres")
    private List<GenreDto> genreDtoList() {
        return genreService.getGenreDtoListOrderById();
    }

    @GetMapping
    public String showGenrePage() {
        return "/admin/genre-list";
    }

    @ResponseBody
    @PostMapping(value = "/edit", consumes = "application/json", produces = "application/json")
    public GenreDto editGenre(@RequestBody GenreDto genreDto) {
        return genreService.saveOrUpdate(genreDto);
    }

    @ResponseBody
    @PostMapping(value = "/delete/{id}")
    public void deleteGenre(@PathVariable("id") Integer id) {
        genreService.deleteById(id);
    }


}
