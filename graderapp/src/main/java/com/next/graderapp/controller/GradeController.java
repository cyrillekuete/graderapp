package com.next.graderapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.next.graderapp.Constants;
import com.next.graderapp.Grade;
import com.next.graderapp.repository.GradeRepository;
import com.next.graderapp.service.GradeService;

import jakarta.validation.Valid;

@Controller
public class GradeController {

    @Autowired
    GradeService gradeService;

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {

        model.addAttribute("grade", gradeService.getGradeById(id));

        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors())
            return "form";
        gradeService.submitGrade(grade);

        return "redirect:/grades";

    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", gradeService.getGrades());
        return "grades";
    }

}
