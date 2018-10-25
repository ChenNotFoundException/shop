package com.shop.dao.product;

import com.shop.dao.DaoSupport;
import com.shop.model.PageModel;
import com.shop.model.product.Productinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenchen
 * @date 2018/10/25 15:31
 * @Content:
 */
public class ProductDaoImpl extends DaoSupport<Productinfo> implements ProductDao {
    /**
     * 查询推荐商品的前10件，按上架时间降序排序
     */
    @Override
    public List<Productinfo> findCommend() {
        String where = "where commend = ?";
        Object[] parames = {true};
        Map <String, String> orderby = new HashMap <String, String>();
        orderby.put("createTime", "desc");
        PageModel <Productinfo> pageModel = find(where, parames, orderby, 1, 20);
        return pageModel.getList();
    }

    /**
     * 查询排名前10商品
     * @return
     */
    @Override
    public List <Productinfo> findClickcount() {
        Map <String, String> orderby = new HashMap <String, String>();
        orderby.put("clickcount", "desc");
        PageModel <Productinfo> pageModel = find(1, 10, orderby);
        return pageModel.getList();
    }


    @Override
    public List <Productinfo> findSellCount() {
        Map<String, String> orderby = new HashMap<String, String>();
        orderby.put("sellCount", "desc");
        PageModel<Productinfo> pageModel = find(1, 10, orderby);
        return pageModel.getList();
    }
}
