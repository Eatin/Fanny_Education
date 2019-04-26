package MainProgram.Controller;

import MainProgram.DBConnector.Bean.User;
import MainProgram.DBConnector.DAO.UserMapper;
import MainProgram.DBConnector.Service.Login.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginPage {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/loginPage", method = {RequestMethod.POST, RequestMethod.GET})
    public String LoginPage(User user) {


//        user.toString();
        Logger log = Logger.getLogger(LoginPage.class);
        SqlSession sqlSession = null;
        SqlSessionFactory sessionFactory;

        try {
//            sqlSession = SqlSessionFactoryUtils.openSqlSession();
//            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(userMapper.getById(1));

        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

        return "upload";
    }
}
