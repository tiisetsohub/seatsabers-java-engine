package co.za.entelect.controllers;

import co.za.entelect.services.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/template")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemplateController {

    private final TemplateService _templateService;

    @Autowired
    public TemplateController(TemplateService templateService){
        this._templateService = templateService;
    }

    @GetMapping
    public ResponseEntity<String> test(){
        return new ResponseEntity<>(_templateService.test(), HttpStatus.OK);
    }

    @PostMapping
    public String token(@RequestBody String token){
        System.out.println(token);
        return "YESSS - TOKEN : " + token;
    }

}
