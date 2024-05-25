package Daily_code_buffer.Spring_BootLearning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

//    @Value("${welcome.message}")
//    private String welcomemesage;

    @GetMapping("/")
    public String helloworld(){
        return "Take Care";
    }
}

