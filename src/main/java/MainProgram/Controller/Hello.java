package MainProgram.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {
    @RequestMapping("/upload")
    public String say(){
        return "upload";
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}

