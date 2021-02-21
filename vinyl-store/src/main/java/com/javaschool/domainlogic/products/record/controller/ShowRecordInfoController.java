package com.javaschool.domainlogic.products.record.controller;

import com.javaschool.domainlogic.products.record.exception.GetRecordFailed;
import com.javaschool.domainlogic.products.record.exception.RecordNotFound;
import com.javaschool.domainlogic.products.record.service.api.ShowRecordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/record")
public class ShowRecordInfoController {

    @Autowired
    private ShowRecordInfoService showRecordInfoService;

    @GetMapping("/{id}")
    public String showRecordInfo(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.put("record", showRecordInfoService.getRecordById(id));
        return "product/record";
    }

    @ExceptionHandler(RecordNotFound.class)
    public String handleRecordNotFound() {
        return "exception/404";
    }

    @ExceptionHandler(GetRecordFailed.class)
    public String handleGetRecordFailed() {
        return "exception/error";
    }

}
