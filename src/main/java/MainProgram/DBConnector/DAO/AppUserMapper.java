package MainProgram.DBConnector.DAO;

import MainProgram.DBConnector.Bean.AppUser;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
@Mapper
@MapperScan
public interface AppUserMapper {
    List<AppUser> getByMap_appuser(Map<String, Object> map);

    AppUser getById_appuser(Integer id);

    AppUser getByPsd_appuser(AppUser appUser);

    Integer create_appuser(AppUser appUser);

    int update_appuser(AppUser appUser);

    int delete_appuser(Integer id);



}
