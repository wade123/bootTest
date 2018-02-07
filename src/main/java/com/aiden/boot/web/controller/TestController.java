package com.aiden.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Tim_Yu
 * @version $Id: TestController.java, v0.1 2018/1/9 10:26 Tim_Yu
 */
@Controller
@RequestMapping("test")
public class TestController {

    @GetMapping(value = "/{name}/{sex}")
    public String test(Model model, @PathVariable(value = "name", required = false) String name, @PathVariable(value = "sex", required = false) String sex) {
        model.addAttribute("name", name);
        model.addAttribute("sex", sex);
        return "/work";
    }

    @GetMapping
    public String test2(Model model, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "sex", required = false) String sex) {
        model.addAttribute("name", name);
        model.addAttribute("sex", sex);
        return "/work";
    }

}
