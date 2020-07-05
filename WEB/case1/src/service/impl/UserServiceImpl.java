package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void delUser(String id) {
        dao.delUser(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public User findById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void delUsers(String[] ids) {
        if (ids != null && ids.length > 0) {
            for (String id : ids) {
                dao.delUser(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows,
                                         Map<String ,String[]> map) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currentPage <= 0) {
            currentPage = 1;
        }

        //创建空的PageBean对象
        PageBean<User> pageBean = new PageBean<>();
        //设置参数

        pageBean.setRows(rows);

        //调用dao查询总记录数
        int totalCount = dao.findTotalCount(map);
        pageBean.setTotalCount(totalCount);
        //调用dao查询list集合
        //计算开始记录索引
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start,rows,map);
        pageBean.setList(list);

        //计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : totalCount/rows + 1;
        pageBean.setTotalPage(totalPage);

        if (currentPage >= totalPage) {
            currentPage = totalPage;
        }
        pageBean.setCurrentPage(currentPage);

        return pageBean;
    }
}
