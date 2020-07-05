package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean register(User user) {
        //根据用户名查询用户对象
        User u = userDao.findByUsername(user.getUsername());
        if (u != null) {
            //用户名存在
            return false;
        }
        //保存用户信息
        //设置激活码
        user.setCode(UuidUtil.getUuid());
        //设置激活码状态
        user.setStatus("N");
        userDao.save(user);

        //激活邮件发送.邮件正文
        String content = "点击激活<a href='http://localhost/travel/user/active?code="+user.getCode()+"'>黑马旅游网</a>";
        MailUtils.sendMail(user.getEmail(),content,"激活邮件");
        return true;
    }

    @Override
    public boolean active(String code) {
        //获取激活码查询用户对象
        User user = userDao.findByCode(code);
        if (user != null) {
            //修改激活码状态
            userDao.updateStatus(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User login(User user) {
        User u = userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return u;
    }
}
