package MainProgram.Controller;


import MainProgram.DBConnector.Bean.Video;
import MainProgram.DBConnector.DAO.VideoMapper;
import MainProgram.DBConnector.Service.VideoService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
public class VideoController {
    @Autowired
    VideoMapper videoMapper;

    public static ArrayList<String> NewFile = new ArrayList<>();

    @RequestMapping(value = "/Getdata",method = GET)
    @ResponseBody
   public ArrayList<String> setNewFile(){
        System.out.println(NewFile);
        return NewFile;
    }

    @RequestMapping("/upload")
    public String say() {
        return "upload";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/vmsg")
    public String vmsg(Model model) {

        return "/SBADMIN/filetable";
    }

    @RequestMapping(value = "/vmsg2",method = GET)
    public String vmsg2(Model model) {

        model.addAttribute("filename",NewFile);
        return "/SBADMIN/filetab";
    }

    @RequestMapping("/GetJson")
    @ResponseBody
    public  String getJson(String videos) {
        VideoService videoService = new VideoService();

        JSONArray json = JSONArray.parseArray(videos);
        Video video = new Video();
        if (json.size() > 0) {
            for (int i = 0; i < json.size(); i++) {
                JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                video.setName((String) job.get("Name"));  // 得到 每个对象中的属性值
                video.setSport(Integer.parseInt((String) job.get("Sport")));
                video.setID(Integer.parseInt((String) job.get("ID")));  // 得到 每个对象中的属性值
                video.setSport(Integer.parseInt((String) job.get("Sport")));  // 得到 每个对象中的属性值
                video.setEntertain(Integer.parseInt((String) job.get("Entertain")));  // 得到 每个对象中的属性值
                video.setEvent(Integer.parseInt((String) job.get("Event")));  // 得到 每个对象中的属性值
                video.setWeight(Integer.parseInt((String) job.get("Weight")));  // 得到 每个对象中的属性值
                videoMapper.create_video(video);
            }

        }
        return "0";

    }

//    @ResponseBody
    @RequestMapping("/video/getallvideo")
    public String getAllVideo(Model model){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Video> ls =  videoMapper.getByMap_video(map);
        model.addAttribute("ls",ls);
        return "/SBADMIN/fileall";
    }
}

