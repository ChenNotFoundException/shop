package com.shop.action.order;

import com.shop.action.BaseAction;
import com.shop.model.order.Orderitem;
import com.shop.model.product.Productinfo;

import java.util.Iterator;
import java.util.Set;

/**
 * @author chenchen
 * @date 2018/10/25 17:09
 * @Content:
 */
public class CartAction extends BaseAction {
    private static final long serialVersionUID = 1L;

    // 查看购物车
    public String list() throws Exception {
        return LIST;//返回购物车页面
    }
    // 清空购物车
    public String clear() throws Exception {
        session.remove("cart");
        return LIST;
    }

    // 商品id
    private Integer productId;
    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    //添加商品
    @Override
    public String add() throws Exception {
        if (productId != null && productId > 0) {
            Set <Orderitem> cart = getCart();
            boolean same = false;
            for (Orderitem item :
                    cart) {
                if (item.getProductId() == productId) {
                    item.setAmount(item.getAmount()+1);
                    same = true;
                }

            }
            if (!same) {
                Orderitem item = new Orderitem();
                Productinfo pro = productDao.load(productId);
                item.setProductId(pro.getId());
                item.setProductName(pro.getName());
                item.setProductPrice(pro.getSellprice());
                item.setProductMarketprice(pro.getMarketprice());
                cart.add(item);
            }
            session.put("cart", cart);
        }
        return LIST;
    }

    //删除商品
    public String delete() throws Exception {
        Set<Orderitem> cart = getCart();
        Iterator <Orderitem> it = cart.iterator();
        while (it.hasNext()) {
            Orderitem item = it.next();
            if (item.getProductId() == productId) {
                it.remove();
            }
        }
        session.put("cart", cart);
        return LIST;
    }

}
