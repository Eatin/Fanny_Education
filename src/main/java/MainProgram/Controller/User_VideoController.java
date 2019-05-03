package MainProgram.Controller;

import MainProgram.DBConnector.Bean.Apper;
import MainProgram.DBConnector.Bean.User_Video;
import MainProgram.DBConnector.Bean.Video;
import MainProgram.DBConnector.Service.ApperService;
import MainProgram.DBConnector.Service.VideoService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static java.lang.Math.sqrt;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
public class User_VideoController {
    @Autowired
    ApperService apperService;

    @Autowired
    VideoService videoService;


    @RequestMapping("/video/result")
    public User_Video[] count(Apper apper, List<Video> ls) {

        User_Video[] UV = new User_Video[100];
        User_Video temp = new User_Video();
        int length;
        int i = 0;
        double result = 0.0;
        for (Video vv : ls
                ) {

            result = vv.getWeight() - sqrt((vv.getSport() - apper.getSport()) * (vv.getSport() - apper.getSport())
                    + (vv.getEntertain() - apper.getEntertain()) * (vv.getEntertain() - apper.getEntertain())
                    + (vv.getEvent() - apper.getEvent()) * (vv.getEvent() - apper.getEvent()));
            UV[i] = new User_Video();
            UV[i].setDistance(result);
            UV[i].setVideo(vv.getName());
//            System.out.println(UV[i].toString());
            i++;
        }

        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i - j - 1; k++) {
                if (UV[k].getDistance() < UV[k + 1].getDistance()) {
                    temp = UV[k];
                    UV[k] = UV[k + 1];
                    UV[k + 1] = temp;
                }
            }
        }

        return UV;
    }

    public User_Video[] Json_arr(String jsont) {

        User_Video[] arr = new User_Video[100];
        JSONArray json = JSONArray.parseArray(jsont);
        Video video = new Video();
        if (json.size() > 0) {
            for (int i = 0; i < json.size(); i++) {
                arr[i] = new User_Video();
                JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                arr[i].setDistance(Double.valueOf(String.valueOf(job.get("distance").toString())));
                arr[i].setVideo((String) job.get("video"));
            }
        }
        return arr;
    }

    @RequestMapping(value = "/GetNext", method = POST)
    public ModelAndView getNext(HttpServletRequest request) {
        ModelAndView mv=new ModelAndView();
        User_Video[] arr = new User_Video[100];
        String jsont = request.getParameter("jsont");
        String Tel = request.getParameter("Tel");
        int index = Integer.parseInt(request.getParameter("index"));
        JSONArray json = JSONArray.parseArray(jsont);
        arr = Json_arr(jsont);

        mv.setViewName("/Player/UserMain");
        mv.addObject("jsont", jsont);
        mv.addObject("Tel", Tel);
        mv.addObject("Arr", arr);
        if (json.size() - 1 == index) {
            mv.addObject("index", 0);
        } else {
            mv.addObject("index", index + 1);
        }
        return mv;
    }

    @RequestMapping(value = "/GetLast", method = POST)
    public ModelAndView getLast(HttpServletRequest request) {
        ModelAndView mv=new ModelAndView();
        User_Video[] arr = new User_Video[100];
        String jsont = request.getParameter("jsont");
        String Tel = request.getParameter("Tel");
        int index = Integer.parseInt(request.getParameter("index"));
        arr = Json_arr(jsont);
        JSONArray json = JSONArray.parseArray(jsont);
        mv.setViewName("/Player/UserMain");
        mv.addObject("jsont", jsont);
        mv.addObject("Tel", Tel);
        mv.addObject("Arr", arr);

        if (index == 0) {
            mv.addObject("index", index);
        } else {
            mv.addObject("index", index - 1);
        }
        return mv;
    }


//    @RequestMapping(value = "/GetNext", method = GET)
//    public String getNextGet(HttpServletRequest request, Model model) {
//        User_Video[] arr = new User_Video[100];
//        String jsont = request.getParameter("jsont");
//        String Tel = request.getParameter("Tel");
//        int index = Integer.parseInt(request.getParameter("index"));
//        JSONArray json = JSONArray.parseArray(jsont);
//        arr = Json_arr(jsont);
//
//        model.addAttribute("jsont", jsont);
//        model.addAttribute("Tel", Tel);
//        model.addAttribute("Arr", arr);
//        if (json.size() - 1 == index) {
//            model.addAttribute("index", 0);
//        } else {
//            model.addAttribute("index", index + 1);
//        }
//        return "redirect:/Player/UserMain";
//    }

    @ResponseBody
    @RequestMapping(value = "/SetUnlike", method = POST)
    public String unLike(HttpServletRequest request) {
        Apper apper = apperService.getByTel_apper(request.getParameter("Tel"));
        Video video = videoService.getByName_video(request.getParameter("videoN"));
        setLocatUnLike(apper,video);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/Setlike", method = POST)
    public String Like(HttpServletRequest request) {
        Apper apper = apperService.getByTel_apper(request.getParameter("Tel"));
        Video video = videoService.getByName_video(request.getParameter("videoN"));
        setLocatLike(apper,video);
        return "success";
    }

    public void setLocatLike(Apper apper, Video video) {
        double temp;
        temp = Math.abs((apper.getEvent() - video.getEvent()) / 100);
        System.out.println(temp);
        if (apper.getEvent() > video.getEvent()) {
            apper.setEvent(apper.getEvent() - 3 * temp);
            video.setEvent(video.getEvent() + 3 * temp);
        } else {
            apper.setEvent(apper.getEvent() + 3 * temp);
            video.setEvent(video.getEvent() - 3 * temp);
        }
        temp = Math.abs((apper.getEntertain() - video.getEntertain()) / 100);
        if (apper.getEntertain() > video.getEntertain()) {
            apper.setEntertain(apper.getEntertain() - 3 * temp);
            video.setEntertain(video.getEntertain() + 3 * temp);
        } else {
            apper.setEntertain(apper.getEntertain() + 3 * temp);
            video.setEntertain(video.getEntertain() - 3 * temp);
        }

        temp = Math.abs((apper.getSport() - video.getSport()) / 100);
        if (apper.getSport() > video.getSport()) {
            apper.setSport(apper.getSport() - 3 * temp);
            video.setSport(video.getSport() + 3 * temp);
        } else {
            apper.setSport(apper.getSport() + 3 * temp);
            video.setSport(video.getSport() - 3 * temp);
        }
        video.setWeight(video.getWeight()+1);
        apperService.update_apper(apper);
        videoService.update_video(video);
    }

    public void setLocatUnLike(Apper apper, Video video) {

        System.out.println(apper.toString());
        System.out.println(video.toString());
        if (apper.getEvent() > video.getEvent()) {
            apper.setEvent(apper.getEvent() * 1.03);
            video.setEvent(video.getEvent() * 0.97);
        } else {
            apper.setEvent(apper.getEvent() * 0.97);
            video.setEvent(video.getEvent() * 1.03);
        }

        if (apper.getEntertain() > video.getEntertain()) {
            apper.setEntertain(apper.getEntertain() * 1.03);
            video.setEntertain(video.getEntertain() * 0.97);
        } else {
            apper.setEntertain(apper.getEntertain() * 0.97);
            video.setEntertain(video.getEntertain() * 1.03);
        }

        if (apper.getSport() > video.getSport()) {
            apper.setSport(apper.getSport() * 1.03);
            video.setSport(video.getSport() * 0.97);
        } else {
            apper.setSport(apper.getSport() * 0.97);
            video.setSport(video.getSport() * 1.03);
        }
        video.setWeight(video.getWeight() - 1);
        apperService.update_apper(apper);
        videoService.update_video(video);

    }
}
