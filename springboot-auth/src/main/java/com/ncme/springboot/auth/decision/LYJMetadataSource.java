package com.ncme.springboot.auth.decision;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
@Service
public class LYJMetadataSource implements FilterInvocationSecurityMetadataSource{

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();
        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
        ConfigAttribute configAttribute = new LYJConfigAttribute(request);
        allAttributes.add(configAttribute);
        return allAttributes;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
