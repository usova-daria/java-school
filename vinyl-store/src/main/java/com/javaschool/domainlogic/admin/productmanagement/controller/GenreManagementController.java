package com.javaschool.domainlogic.admin.productmanagement.controller;

import com.javaschool.domainlogic.admin.productmanagement.dto.GenreDto;
import com.javaschool.domainlogic.admin.productmanagement.service.api.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/genre")
public class GenreManagementController {

    private final GenreService genreService;

    @GetMapping
    public String showGenrePage(ModelMap modelMap) {
        modelMap.put("genres", genreService.getGenreDtoList());
        return "/admin/genre-list";
    }

    @ResponseBody
    @PostMapping(value = "/edit", consumes = "application/json")
    public ResponseEntity<GenreDto> editGenre(@RequestBody @Valid GenreDto genreDto,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(genreDto);
        }

        return genreService.saveOrUpdate(genreDto);
    }

    @ResponseBody
    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable("id") Integer id) {
        return genreService.deleteById(id);
    }

}
