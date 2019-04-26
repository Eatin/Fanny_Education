package MainProgram.DBConnector.DAO;

import MainProgram.DBConnector.Bean.User;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
@MapperScan
public interface UserMapper {
    List<User> getByMap(Map<String, Object> map);

    User getById(Integer id);

    Integer create(User user);

    int update(User user);

    int delete(Integer id);

}
