package com.xxxJppp.cloud.auth.component;

import com.xxxJppp.cloud.auth.config.BaseResourceServerConfigurerAdapter;
import com.xxxJppp.cloud.common.constant.SecurityConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author
 */
@Slf4j
@Order(1000)
public class BaseSecurityBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	/**
	 * 根据注解值动态注入资源服务器的相关属性
	 *
	 * @param metadata 注解信息
	 * @param registry 注册器
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
		if (registry.isBeanNameInUse(SecurityConstant.RESOURCE_SERVER_CONFIGURER)) {
			log.warn("本地存在资源服务器配置，覆盖默认配置:" + SecurityConstant.RESOURCE_SERVER_CONFIGURER);
			return;
		}

		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(BaseResourceServerConfigurerAdapter.class);
		registry.registerBeanDefinition(SecurityConstant.RESOURCE_SERVER_CONFIGURER, beanDefinition);

	}
}
