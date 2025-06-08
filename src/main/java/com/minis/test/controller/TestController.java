package com.minis.test.controller;

import com.minis.batis.SqlSession;
import com.minis.batis.SqlSessionFactory;
import com.minis.beans.factory.annotation.Autowired;
import com.minis.jdbc.core.JdbcTemplate;
import com.minis.test.AServiceImpl;
import com.minis.web.RequestMapping;
import com.minis.web.ResponseBody;
import com.minis.web.servlet.view.ModelAndView;
import com.test.aop.service.IAction;
import com.test.mvc.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yjc
 */
public class TestController {


    @Autowired
    private AServiceImpl aservice;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    @Autowired
    private IAction action;

    @Autowired
    private IAction action2;


    @Autowired
    private JdbcTemplate jdbcTemplate;

    //curl http://localhost:8000/test?name=xxx&gender=xxx
    @RequestMapping("/test")
    @ResponseBody
    public User doTest(User user) {
        System.out.println(user.getName() + " " + user.getGender());
        aservice.sayHello();
        return user;
    }


    @RequestMapping("/test_jsp1")
    public ModelAndView doTest5(User user) {
        ModelAndView mav = new ModelAndView("test", "msg", user.getName());
        return mav;
    }

    @RequestMapping("/test_jsp2")
    public String doTest6(User user) {
        return "error";
    }


    @RequestMapping("/test_jdbc1")
    @ResponseBody
    public List<com.test.jdbc.entity.User> doTest7() {
        //因为没有实现对于List的json解析,这里只能返回一个List引用
        String sql = "select * from user";
        return (List<com.test.jdbc.entity.User>) jdbcTemplate.query(stmt -> {
            ResultSet resultSet = stmt.executeQuery(sql);
            List<com.test.jdbc.entity.User> ret = new ArrayList<>();
            while (resultSet.next()) {
                com.test.jdbc.entity.User user = new com.test.jdbc.entity.User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setBirthday(resultSet.getDate("birthday"));
                ret.add(user);
            }
            return ret;
        });
    }

    @RequestMapping("/test_jdbc2")
    @ResponseBody
    public com.test.jdbc.entity.User doTest8() {
        String sql = "select * from user where id = ?";
        Integer id = Integer.valueOf(1);
        return (com.test.jdbc.entity.User) jdbcTemplate.query(sql, new Object[] {id}, stmt -> {
            ResultSet rs = stmt.executeQuery();
            com.test.jdbc.entity.User user = new com.test.jdbc.entity.User();
            if (rs.next()) {
                user.setId(id);
                user.setName(rs.getString("name"));
                user.setBirthday(rs.getDate("birthday"));
            }
            return user;
        });
    }

    @RequestMapping("/test_jdbc3")
    @ResponseBody
    public List<com.test.jdbc.entity.User> doTest9() {
        String sql = "select * from user where id >= ?";
        Integer id = Integer.valueOf(1);
        List<com.test.jdbc.entity.User> res = jdbcTemplate.query(sql, new Object[]{id}, ((rs, rowNum) -> {
            com.test.jdbc.entity.User user = new com.test.jdbc.entity.User();
            user.setId(id);
            user.setName(rs.getString("name"));
            user.setBirthday(rs.getDate("birthday"));
            return user;
        }));
        System.out.println(res);
        return res;
    }

    @RequestMapping("/test_jdbc4")
    @ResponseBody
    public com.test.jdbc.entity.User doTest10() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String sqlId = "com.test.jdbc.entity.User.getUserInfo";
        return (com.test.jdbc.entity.User) sqlSession.selectOne(sqlId, new Object[]{Integer.valueOf(1)}, pst -> {
            ResultSet resultSet = pst.executeQuery();
            com.test.jdbc.entity.User user = new com.test.jdbc.entity.User();
            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setBirthday(resultSet.getDate("birthday"));
            }
            return user;
        });
    }

    @RequestMapping("/test_aop1")
    public void doTest11(HttpServletResponse response) throws IOException {
        response.getWriter().write(action.doAction());
    }

    @RequestMapping("/test_aop2")
    public void doTest12(HttpServletResponse response) throws IOException {

        //You can achieve before, after, and custom by adjusting the class of MethodInterceptor bean

        response.getWriter().write(action.doAction());
    }

    @RequestMapping("/test_aop3")
    public void doTest13(HttpServletResponse response) throws IOException {
        response.getWriter().write(action.doAction() + " " + action.doAction2());
    }


    @RequestMapping("/test_aop4")
    public void doTest14(HttpServletResponse response) throws IOException {
        response.getWriter().write(action.doAction() + action2.doAction());
    }

}
