package com.shop.util.hibernate;

import com.lyq.model.PaymentWay;
/**
 * ֧����ʽHibernateӳ������
 * @author Li Yongqiang
 */
public class PaymentWayType extends EnumType<PaymentWay> {
	public PaymentWayType() {
		super(PaymentWay.class);
	}
}
