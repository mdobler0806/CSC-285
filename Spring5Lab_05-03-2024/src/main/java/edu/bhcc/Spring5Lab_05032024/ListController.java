package edu.bhcc.Spring5Lab_05032024;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/****************************
 *  @Author : Matthew Dobler"
 *  @Date    : 5/3/24"
 *  @File   : ListController"
 *  @Class   : CSC-"
 *****************************/

@Controller
public class ListController {

    @GetMapping("/user")
    public String user(@RequestParam(name = "name", required=false,
            defaultValue = "World") String name, (@RequestParam(String lastName, String emailAddress, Model model) {
        model.addAttribute("firstName",firstName);
        model.addAttribute("name", name);
        return "user";
    }

}
