package MainProgram.DBConnector.DAO;


import MainProgram.DBConnector.Bean.Video;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
@MapperScan
@Component
public interface UVMapper {

    List<Video> getByMap_video(Map<String, Object> map);

}
