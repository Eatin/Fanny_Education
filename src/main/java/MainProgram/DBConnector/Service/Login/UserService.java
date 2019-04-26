package MainProgram.DBConnector.Service.Login;


import MainProgram.DBConnector.Bean.User;
import MainProgram.DBConnector.DAO.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getByMap(Map<String,Object> map){
        return userMapper.getByMap(map);
    }

    public User getById(Integer id){
        return userMapper.getById(id);
    }

    public User create(User user){
        userMapper.create(user);
        return user;
    }

    public User update(User user){
        userMapper.update(user);
        return user;
    }

    public int delete(Integer id){
        return userMapper.delete(id);
    }


}
