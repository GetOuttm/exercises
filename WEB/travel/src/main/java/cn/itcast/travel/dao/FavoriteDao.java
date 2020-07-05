package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

public interface FavoriteDao {
    /**
     * 根据用户id和旅游线路id查询是否被收藏
     * @param rid
     * @param uid
     * @return
     */
    Favorite findByRidAndUid(int rid, int uid);

    /**
     * 查询收藏次数
     * @param rid
     * @return
     */
    int findCountByRid(int rid);

    /**
     *添加收藏
     * @param rid
     * @param uid
     */
    void add(String rid, int uid);
}
