package com.drools.DroolsSample.controller;

import com.drools.DroolsSample.model.User;
import com.drools.DroolsSample.service.DroolsAppService;
import org.apache.poi.ss.formula.functions.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bankservice")
public class DroolsAppController {
    @Autowired
    private DroolsAppService bankService;

    @PostMapping("/getrate")
    public ResponseEntity<Rate> getRate(@RequestBody User request){
        Rate rate = bankService.getRate(request);
        return new ResponseEntity<>(rate, HttpStatus.OK);
    }
}
