package MainProgram.Controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.Map;

@Controller
public class Upload {
    @ResponseBody
    @RequestMapping(value = "/ajax/upload", method = RequestMethod.POST)
    public String addfile(HttpServletRequest request, HttpServletRequest response, HttpSession session,Model model) {

//        List<String> file_name = new ArrayList<String>() ;
        String filePath = "D:\\FileAll";
        File path = new File(filePath); //判断文件路径下的文件夹是否存在，不存在则创建
        File savedFile = new File(filePath);


        if (!path.exists()) {
            path.mkdirs();
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map fileMap = multipartRequest.getMultiFileMap();
        List<MultipartFile> fileList = (List) fileMap.get("files[]");

        for (MultipartFile file : fileList) {

            savedFile = new File(filePath,file.getOriginalFilename());
            VideoController.NewFile.add(file.getOriginalFilename());

            try{
                FileUtils.copyInputStreamToFile(file.getInputStream(),savedFile);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }

        MultipartFile File = multipartRequest.getFile("files[]");

        return "";
    }


}
