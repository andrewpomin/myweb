package myprojects.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {
    @GetMapping("/choose")
    public ModelAndView index(){
        return new ModelAndView("/choose");
    }

    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("/home");
    }

    @GetMapping("/gallery")
    public ModelAndView gallery(){
        return new ModelAndView("/gallery");
    }

    @GetMapping("/games")
    public ModelAndView games(){
        return new ModelAndView("/games");
    }

    @GetMapping("/login")
    public ModelAndView openLogin(){
        return new ModelAndView("/login");
    }

    @GetMapping("/movies")
    public ModelAndView movies(){
        return new ModelAndView("/movies");
    }

    @GetMapping("/music")
    public ModelAndView music(){
        return new ModelAndView("/music");
    }

    @GetMapping("/signup")
    public ModelAndView signup(){
        return new ModelAndView("/signup");
    }

    @GetMapping("/tvseries")
    public ModelAndView tvseries(){
        return new ModelAndView("/tvseries");
    }
}
