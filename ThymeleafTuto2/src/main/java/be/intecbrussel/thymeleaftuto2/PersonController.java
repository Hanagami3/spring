package be.intecbrussel.thymeleaftuto2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
public class PersonController {

    @GetMapping
    public String getPeople(Model model){
        model.addAttribute("something", "this is coming from the controller");
        model.addAttribute("people", Arrays.asList(
                new Person("Marie", 20),
                new Person("Deepika", 35),
                new Person("Abdul", 25)
        ));
        return "people";
    }
}
