package com.virtual.third.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;

import java.nio.file.Path;

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

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile() throws IOException {
        // Путь к файлу внутри контейнера
        Path filePath = Paths.get("/app/MIREA_Gerb_Colour.png");

        try {
            // Создание ресурса из файла
            Resource resource = new UrlResource(filePath.toUri());

            // Проверка, существует ли файл
            if (resource.exists()) {
                return ResponseEntity.ok()
                        .header("Content-Disposition", "attachment; filename=\"MIREA_Gerb_Colour.png\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("File not found.", e);
        }
    }

}
