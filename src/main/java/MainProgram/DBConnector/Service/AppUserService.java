package MainProgram.DBConnector.Service;

import MainProgram.DBConnector.Bean.AppUser;
import MainProgram.DBConnector.DAO.AppUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    private AppUserMapper appUserMapper;

    public int create_appuser(AppUser appUser){
        appUserMapper.create_appuser(appUser);
        return 1;
    }



//    public List<Apper> getByMap_apper (Map<String,Object> map){
//        return apperMapper.getByMap_apper(map);
//    }




}
