package com.virtual.third.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtual.third.model.Element;
import com.virtual.third.repository.ElementRepository;
import com.virtual.third.requests.ElementRequest;

@RestController
public class ElementController {
    @Autowired
    private ElementRepository repository;

    @PostMapping("/addelement")
    public String addElement(@RequestBody ElementRequest request) {
        Element element = Element.builder().name(request.getName()).build();
        repository.save(element);
        return "New element has been added.";
    }

    @GetMapping("/viewelements")
    public List<Element> viewElements() {
        return repository.findAll();
    }

}
