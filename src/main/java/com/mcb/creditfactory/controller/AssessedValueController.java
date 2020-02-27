package com.mcb.creditfactory.controller;


import com.mcb.creditfactory.dto.AssessedValue;
import com.mcb.creditfactory.service.AssessedValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssessedValueController {

        @Autowired
        private AssessedValueService service;

        @PostMapping("/assessed/save")
        public HttpEntity<Long> save(@RequestBody AssessedValue object) {
        Long id = service.saveAssessedValue(object);
                return id != null ? ResponseEntity.ok(id) : ResponseEntity.badRequest().build();
}
}