package MainProgram.Controller;

import MainProgram.DBConnector.Bean.Apper;
import MainProgram.DBConnector.Bean.User_Video;
import MainProgram.DBConnector.Bean.Video;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static java.lang.Math.sqrt;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
public class User_VideoController {


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


    @RequestMapping(value = "/GetArray", method = POST)
    public String getNext(HttpServletRequest request, Model model) {
        User_Video[] arr = new User_Video[100];
        String jsont = request.getParameter("jsont");
        String Tel = request.getParameter("Tel");
        int index = Integer.parseInt(request.getParameter("index"));


        JSONArray json = JSONArray.parseArray(jsont);
        Video video = new Video();
        if (json.size() > 0) {
            for (int i = 0; i < json.size(); i++) {
                arr[i] = new User_Video();
                JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                System.out.println(job.get("distance").toString());;  // 得到 每个对象中的属性值
                arr[i].setDistance(Double.valueOf(String.valueOf(job.get("distance").toString())));
                arr[i].setVideo((String) job.get("video"));
                System.out.println(arr[i].toString());  // 得到 每个对象中的属性值
            }
        }

        model.addAttribute("jsont", jsont);
        model.addAttribute("Tel", Tel);
        model.addAttribute("Arr", arr);
        model.addAttribute("index", index + 1);

        return "/Player/UserMain";
    }
}
