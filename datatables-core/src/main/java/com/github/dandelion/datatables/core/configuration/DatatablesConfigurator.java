/*
 * [The "BSD licence"]
 * Copyright (c) 2012 Dandelion
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 3. Neither the name of Dandelion nor the names of its contributors 
 * may be used to endorse or promote products derived from this software 
 * without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.github.dandelion.datatables.core.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dandelion.datatables.core.constants.SystemConstants;
import com.github.dandelion.datatables.core.exception.BadConfigurationException;
import com.github.dandelion.datatables.core.util.ClassUtils;
import com.github.dandelion.datatables.core.util.StringUtils;

/**
 * <p>
 * Configurator used to set the {@link ConfigurationLoader} that will be used to
 * load specific configuration.
 * 
 * @author Thibault Duchateau
 * @since 0.9.0
 */
public class DatatablesConfigurator {

	// Logger
	private static Logger logger = LoggerFactory.getLogger(DatatablesConfigurator.class);
		
	private AbstractConfigurationLoader configurationLoader;
	
	public DatatablesConfigurator(){
		
		logger.debug("Getting the ConfigurationLoader...");
		
		this.configurationLoader = new ConfigurationPropertiesLoader();

		if(StringUtils.isNotBlank(System.getProperty(SystemConstants.DANDELION_DT_CONF_CLASS))){
			Class<?> clazz;
			try {
				clazz = ClassUtils.getClass(System.getProperty(SystemConstants.DANDELION_DT_CONF_CLASS));
				this.configurationLoader = (AbstractConfigurationLoader) ClassUtils.getNewInstance(clazz);
			} catch (BadConfigurationException e) {
				logger.warn("The custom configurator {} has not been found in the classpath. Using default one");
			}
		}
		
		logger.debug("DatatablesConfigurator is being initialized using the {}", this.configurationLoader.getClass()
				.getSimpleName());
	}

	public AbstractConfigurationLoader getConfLoader(){
		return this.configurationLoader;
	}

	public void setConfLoader(AbstractConfigurationLoader confLoader){
		this.configurationLoader = confLoader;
	}
}