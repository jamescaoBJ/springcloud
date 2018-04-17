/**
 * ValidatorConfig.java
 * com.ncme.springboot.configuration.validator
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月20日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.configuration.validator;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

/**
 * ClassName:ValidatorConfig
 * Function: TODO ADD validator config
 * Reason:	 TODO ADD validity of check parameters
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月20日	上午10:40:27
 *
 * @see 	 
 *  
 */
@Configuration
public class ValidatorConfig {
	
	    @Bean
	    public Validator validator(){
	        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
	                .configure()
	                .addProperty( "hibernate.validator.fail_fast", "true" )
	                .buildValidatorFactory();
	        Validator validator = validatorFactory.getValidator();

	        return validator;
	    }
	    
	    @Bean
	    public Converter<String, Date> addNewConvert() {
	        return new Converter<String, Date>() {
	            @Override
	            public Date convert(String source) {
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                 Date date = null;
	            try {
	                date = sdf.parse((String) source);
	                } catch (Exception e) {
	                e.printStackTrace();
	                }
	             return date;
	            }
	        };
	    }

}
