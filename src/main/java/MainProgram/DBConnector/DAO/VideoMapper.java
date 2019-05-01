package MainProgram.DBConnector.DAO;


import MainProgram.DBConnector.Bean.Video;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
@MapperScan
public interface VideoMapper {

    List<Video> getByMap_video(Map<String, Object> map);

    Video getById_video(Integer id);

    Integer create_video(Video video);

    int update_video(Video video);

    int delete_video(Integer id);

}
