package cn.pinghu.springboot_web_jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登入控制器
 *
 * @author shenkai
 * @date 2019/1/15
 */
@Controller
public class loginController {

//    @Autowired
//    private UserService userService;

    @RequestMapping("/login")
    public String login(String username, String password) {
        if (username == null || password == null) {
            return "error";
        }
        return "";
    }
}
