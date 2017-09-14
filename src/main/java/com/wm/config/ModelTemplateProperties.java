package com.wm.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "cube.models")
public class ModelTemplateProperties {

	private List<ModelTemplateProperty> properties;

}