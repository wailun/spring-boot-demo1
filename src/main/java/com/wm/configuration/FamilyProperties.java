package com.wm.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by wm on 2017/8/19.
 */
@Data

@ConfigurationProperties(prefix = "family")
public class FamilyProperties {
    private String familyName;
}
