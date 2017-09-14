package com.wm.config;

import com.wm.service.VectorReader;
import org.springframework.beans.factory.FactoryBean;

/**
 * TODO: comment here
 */
public class ModelTemplateFactoryBean implements FactoryBean<VectorReader>{

	private ModelTemplateProperty modelTemplateProperty;

	public ModelTemplateFactoryBean(ModelTemplateProperty modelTemplateProperty) {
		this.modelTemplateProperty = modelTemplateProperty;
	}

	@Override
	public VectorReader getObject() throws Exception {
		if(modelTemplateProperty.getMode().contains("rocks")){
			return VectorReaderFactory.getRocksDBVectorReader(modelTemplateProperty);
		}
		return null;
	}


	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}


}
