package MainProgram.DBConnector.DAO;

import MainProgram.DBConnector.Bean.Apper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
@Mapper
@MapperScan
public interface ApperMapper {
    List<Apper> getByMap_apper(Map<String, Object> map);

    Apper getById_apper(Integer id);

    Integer create_apper(Apper Apper);

    int update_apper(Apper Apper);

    int delete_apper(Integer id);

}
