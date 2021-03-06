package com.javaschool.domainlogic.admin.productmanagement.controller;

import com.javaschool.domainlogic.admin.productmanagement.dto.AddRecordDto;
import com.javaschool.domainlogic.admin.productmanagement.dto.GenreDto;
import com.javaschool.domainlogic.admin.productmanagement.dto.MusicianDto;
import com.javaschool.domainlogic.admin.productmanagement.service.api.AddRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/add/record")
public class AddRecordController {

    private final AddRecordService addRecordService;

    @ModelAttribute("genres")
    public List<GenreDto> genreDtoList() {
        return addRecordService.getGenres();
    }

    @ModelAttribute("allMusicians")
    public List<MusicianDto> musicianDtoList() {
        return addRecordService.getMusicians();
    }

    @GetMapping
    public String showAddRecordPage(ModelMap modelMap) {
        AddRecordDto record = new AddRecordDto();
        modelMap.addAttribute("record", record);

        return "admin/add-record";
    }

    @PostMapping("/save")
    public String addRecord(@Valid @ModelAttribute("record") AddRecordDto recordDto,
                            BindingResult result, RedirectAttributes ra) {

        if (result.hasErrors()) {
            return "admin/add-record";
        }

        addRecordService.saveRecord(recordDto);
        ra.addFlashAttribute("success", "Success!");

        return "redirect:/admin/add/record";
    }

}
