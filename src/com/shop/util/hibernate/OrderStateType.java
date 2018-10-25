package com.shop.util.hibernate;

import com.lyq.model.OrderState;
/**
 * ����״̬Hibernateӳ������
 * @author Li Yongqiang
 */
public class OrderStateType extends EnumType<OrderState> {
	public OrderStateType() {
		super(OrderState.class);
	}
}
