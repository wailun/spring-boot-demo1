package com.wm.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.bind.PropertiesConfigurationFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.validation.BindException;

/**
 * TODO: comment here
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({ ModelTemplateProperties.class })
public class ModelTemplateAutoConfiguration implements ImportBeanDefinitionRegistrar, EnvironmentAware {
	public static final String PREFIX_MODEL_TEMPLATE = "model_template_";

	private ModelTemplateProperties modelTemplateProperties;

	private ConfigurableEnvironment environment;

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = (ConfigurableEnvironment) environment;
	}

	public ModelTemplateAutoConfiguration() {
	}

	@Override
	public void registerBeanDefinitions(AnnotationMetadata annotationMetadata,
			BeanDefinitionRegistry beanDefinitionRegistry) {
		this.modelTemplateProperties = resolveSettings();
		registerModelTemplates(beanDefinitionRegistry);
	}

	private void registerModelTemplates(BeanDefinitionRegistry beanDefinitionRegistry) {

		log.info("use modelTemplateProperties are: {}", modelTemplateProperties);
		if (modelTemplateProperties != null && CollectionUtils.isNotEmpty(modelTemplateProperties.getProperties())) {
			for (ModelTemplateProperty modelTemplateProperty : modelTemplateProperties.getProperties()) {
				String templateBeanName = registerModelTemplate(modelTemplateProperty, beanDefinitionRegistry);
				log.info("Register templateBeanName: {}", templateBeanName);
			}
		}

	}

	private String registerModelTemplate(ModelTemplateProperty modelTemplateProperty, BeanDefinitionRegistry beanDefinitionRegistry) {
		String beanName = PREFIX_MODEL_TEMPLATE + modelTemplateProperty.getBizType() + "_" + modelTemplateProperty.getMode();
		BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(ModelTemplateFactoryBean.class);
		definitionBuilder.addConstructorArgValue(modelTemplateProperty);
		beanDefinitionRegistry.registerBeanDefinition(beanName, definitionBuilder.getBeanDefinition());
		return beanName;
	}

	private ModelTemplateProperties resolveSettings() {
		ModelTemplateProperties settings = new ModelTemplateProperties();
		PropertiesConfigurationFactory<Object> factory = new PropertiesConfigurationFactory<Object>(settings);
		factory.setTargetName("cube");
		factory.setPropertySources(environment.getPropertySources());
		factory.setConversionService(environment.getConversionService());
		try {
			factory.bindPropertiesToTarget();
		} catch (BindException ex) {
			throw new FatalBeanException("Could not bind DataSourceSettings properties", ex);
		}
		return settings;
	}
}
