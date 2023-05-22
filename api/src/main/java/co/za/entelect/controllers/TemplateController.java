package co.za.entelect.controllers;

import co.za.entelect.services.TemplateService;
import com.microsoft.graph.models.extensions.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/whatsapp")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemplateController {

    private final TemplateService templateService;

    @Autowired
    public TemplateController(TemplateService templateService){
        this.templateService = templateService;
    }

    @GetMapping
    public ResponseEntity<String> test(){
        return new ResponseEntity<>(templateService.test(), HttpStatus.OK);
    }

    @PostMapping
    public String token(@RequestHeader("AccessToken") String token){
        User me = templateService.tet(token);
        System.out.println(me.displayName);
        return me.displayName;
    }

}
