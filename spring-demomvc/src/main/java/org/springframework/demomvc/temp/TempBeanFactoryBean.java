package org.springframework.demomvc.temp;

import org.springframework.beans.factory.FactoryBean;

public class TempBeanFactoryBean implements FactoryBean<TempBean> {


	@Override
	public TempBean getObject() throws Exception {
		return new TempBean();
	}

	@Override
	public Class<?> getObjectType() {
		return TempBean.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
