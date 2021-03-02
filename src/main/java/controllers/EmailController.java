package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/check")
public class EmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    Pattern pattern;
    Matcher matcher;


    @PostMapping("/validate")
    public ModelAndView validateEmail(@RequestParam String email) {
        ModelAndView modelAndView = new ModelAndView("checkValidateEmail");
        boolean isValidate = this.validate(email);
        if (isValidate==true){
            modelAndView.addObject("message","validate");
            return modelAndView;
        }
        modelAndView.addObject("message","In Validate!");
        return modelAndView;
    }

    private boolean validate(String regex) {
    pattern = Pattern.compile(EMAIL_REGEX);
    matcher = pattern.matcher(regex);
    return matcher.matches();
    }
}
