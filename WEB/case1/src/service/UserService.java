package service;

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    User login(User user);

    /**
     * 保存User
     * @param user
     */
    void addUser(User user);

    /**
     * 根据id删除user
     * @param id
     */
    void delUser(String id);

    /**
     * 修改User
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id查询user
     * @param id
     * @return
     */
    User findById(String id);

    /**
     * 删除选中
     * @param ids
     */
    void delUsers(String[] ids);

    /**
     * 分页查询
     * @param currentPage
     * @param rows
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String ,String[]> map);
}
