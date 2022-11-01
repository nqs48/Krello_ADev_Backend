package org.sofka.mykrello.controller;

import org.sofka.mykrello.model.service.LogService;
import org.sofka.mykrello.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "*")
@RestController
public class LogController {

    @Autowired
    LogService logService;

    @Autowired
    private MyResponseUtility response;


    @GetMapping(path = "/api/v1/logs/{id}")
    public ResponseEntity<MyResponseUtility> putTask(@PathVariable(value = "id") Integer idTask) {
        response.data = logService.findByIdTask(idTask);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
