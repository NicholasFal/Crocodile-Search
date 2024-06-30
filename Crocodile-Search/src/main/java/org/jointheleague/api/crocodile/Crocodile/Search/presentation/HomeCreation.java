package org.jointheleague.api.crocodile.Crocodile.Search.presentation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
@CrossOrigin(origins = "http://localhost:3000",methods = RequestMethod.GET)
@Controller
@ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
public class HomeCreation {
    @GetMapping("/")
    public String home(){
        return "redirect:swagger-ui.html";
    }
}
