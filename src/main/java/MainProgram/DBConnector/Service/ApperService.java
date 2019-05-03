package MainProgram.DBConnector.Service;

import MainProgram.DBConnector.Bean.Apper;
import MainProgram.DBConnector.DAO.ApperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ApperService {

    @Autowired
    private ApperMapper apperMapper;

    public int create_apper(Apper apper){
        apperMapper.create_apper(apper);
        return 1;
    }

    public List<Apper> getByMap_apper (Map<String,Object> map){
        return apperMapper.getByMap_apper(map);
    }

    public Apper getByTel_apper(String Tel){
        return apperMapper.getByTel_apper(Tel);
    }

    public int update_apper(Apper apper){
        return apperMapper.update_apper(apper);
    }


}
