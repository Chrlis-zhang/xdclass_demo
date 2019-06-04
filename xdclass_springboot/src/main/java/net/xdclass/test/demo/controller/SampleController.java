package net.xdclass.test.demo.controller;

import net.xdclass.test.demo.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SampleController {


    @RequestMapping("/")
    @ResponseBody
    String hellO(){
        return "hello";
    }

    @RequestMapping("/test")
    public Map<String, String> testMap(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "xdclass");
        return map;
    }

    @GetMapping("/testjson")
    public Object testjson(){
        return new User(11,"aaaa","1111", new Date());
    }

    @RequestMapping("/test/home")
    public String home(){
        return "home";
    }
}
