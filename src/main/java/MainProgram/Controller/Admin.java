package MainProgram.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Admin {
    @RequestMapping("/admin")
    public String admin(){
        return "/SBADMIN/index";
    }
}
