package MainProgram.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Table {
    @RequestMapping("/table")
    public String table(){
        return "/SBADMIN/tables";
    }
}
