package dao;

import domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的DAO
 */
public interface UserDao {


    public List<User> findAll();

    public User findUserByUsernameAndPassword(String username,String password);

    public void add(User user);

    void delUser(int id);

    void updateUser(User user);

    User findById(int id);

    int findTotalCount(Map<String ,String[]> map);

    List<User> findByPage(int start, int rows, Map<String ,String[]> map);
}
