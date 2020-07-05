package cn.itcast.travel.service;

public interface FavoriteService {

    /**
     * 根据用户id和旅游线路id查询是否被收藏
     * @param rid
     * @param uid
     * @return
     */
    boolean isFavorite(String rid,int uid);

    /**
     *添加收藏
     * @param rid
     * @param uid
     */
    void addFavorite(String rid, int uid);
}
