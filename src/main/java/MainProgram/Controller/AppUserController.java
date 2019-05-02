package MainProgram.Controller;


import MainProgram.DBConnector.Bean.AppUser;
import MainProgram.DBConnector.Bean.Apper;
import MainProgram.DBConnector.Bean.User_Video;
import MainProgram.DBConnector.Bean.Video;
import MainProgram.DBConnector.DAO.AppUserMapper;
import MainProgram.DBConnector.DAO.ApperMapper;
import MainProgram.DBConnector.DAO.UVMapper;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class AppUserController {
    @Autowired
    AppUserMapper appUserMapper;

    @Autowired
    ApperMapper apperMapper;

    @Autowired
    UVMapper uvMapper;

    @ResponseBody
    @RequestMapping(value = "/addUser", method = POST)
    public String User_rg(AppUser appUser) {
        int result = appUserMapper.create_appuser(appUser);
        return "Result" + result;
    }


    @RequestMapping(value = "/User/login", method = POST)
    public String User_lg(AppUser appUser, Model model) {
        AppUser appUser1 = new AppUser();
        Apper apper = new Apper();
        String jsont = "[";
        appUser1 = appUserMapper.getByPsd_appuser(appUser);
        apper = apperMapper.getByTel_apper(appUser1.getTel());
        Map<String, Object> map = new HashMap<String, Object>();
        List<Video> ls = uvMapper.getByMap_video(map);
        User_VideoController user_videoController = new User_VideoController();
        User_Video[] arr = user_videoController.count(apper, ls);
        int i = 0;


        while (arr[i] != null) {
            System.out.println(JSON.toJSONString(arr[i]));
            if (i > 0) {
                jsont = jsont + ",";
            }
            jsont = jsont + JSON.toJSONString(arr[i]);

            i++;
        }
        jsont = jsont + "]";
        model.addAttribute("jsont", jsont);
        model.addAttribute("Tel", apper.getTel());
        model.addAttribute("Arr", arr);
        model.addAttribute("index", 0);
        System.out.println(model.toString());
        return "/Player/UserMain";
    }

    @RequestMapping("/user/register")
    public String User_rgPage() {
        return "/Apper/register";
    }

    @RequestMapping("/user/login")
    public String User_lgPage() {
        return "/Apper/login";
    }

}
