package MainProgram.DBConnector.Service;

import MainProgram.DBConnector.Bean.Video;
import MainProgram.DBConnector.DAO.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VideoService {

    @Autowired
    private VideoMapper videoMapper;

    public int create_video(Video video){

        videoMapper.create_video(video);
        return 1;
    }

    public List<Video> getByMap_video (Map<String,Object> map){
        return videoMapper.getByMap_video(map);
    }

    public Video getByName_video(String Name){
        return videoMapper.getByName_video(Name);
    }
    public int update_video(Video video){
        return videoMapper.update_video(video);
    }

}
