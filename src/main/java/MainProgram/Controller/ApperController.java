package MainProgram.Controller;

import MainProgram.DBConnector.Bean.Apper;
import MainProgram.DBConnector.DAO.ApperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ApperController {
    @Autowired
    ApperMapper apperMapper;

    @RequestMapping("/apper/all")
    public String getalluser(Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Apper> ls = apperMapper.getByMap_apper(map);
        model.addAttribute("ls", ls);
        System.out.println(ls.toString());
        return "/Table/userall";
    }

}
