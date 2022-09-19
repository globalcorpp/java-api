package ir.rnd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    //-------------------Home Page--------------------------------------------------------
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "Home Page // Check REST API Manual <br>" + "for example <br>" + " <b><br>http://YOURIP:PORT/SERVICENAME/METHOD/{item}";
    }
}