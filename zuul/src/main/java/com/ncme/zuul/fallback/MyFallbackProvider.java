/**
 * MyFallbackProvider.java
 * com.ncme.zuul.fallback
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年12月14日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.zuul.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.exception.HystrixTimeoutException;

/**
 * ClassName:MyFallbackProvider
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年12月14日	上午10:43:15
 *
 * @see 	 
 *  
 */
@Component
public class MyFallbackProvider implements FallbackProvider {
	/**
	 * (non-Javadoc)
	 * @see org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider#getRoute()
	 */
	@Override
	public String getRoute() {
		
		// TODO Auto-generated method stub
		return "*";
		
	}

	/**
	 * (non-Javadoc)
	 * @see org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider#fallbackResponse()
	 */
	@Override
	public ClientHttpResponse fallbackResponse() {
		
		 return response(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	/**
	 * (non-Javadoc)
	 * @see org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider#fallbackResponse(java.lang.Throwable)
	 */
	@Override
	public ClientHttpResponse fallbackResponse(Throwable cause) {
		
        if (cause instanceof HystrixTimeoutException) {
            return response(HttpStatus.GATEWAY_TIMEOUT);
        } else {
            return fallbackResponse();
        }
		
	}
	
	
	
	 private ClientHttpResponse response(final HttpStatus status) {
	        return new ClientHttpResponse() {
	            @Override
	            public HttpStatus getStatusCode() throws IOException {
	                return status;
	            }

	            @Override
	            public int getRawStatusCode() throws IOException {
	                return status.value();
	            }

	            @Override
	            public String getStatusText() throws IOException {
	                return status.getReasonPhrase();
	            }

	            @Override
	            public void close() {
	            }

	            @Override
	            public InputStream getBody() throws IOException {
	                return new ByteArrayInputStream("Gateway timeout!".getBytes());
	            }

	            @Override
	            public HttpHeaders getHeaders() {
	                HttpHeaders headers = new HttpHeaders();
	                headers.setContentType(MediaType.APPLICATION_JSON);
	                return headers;
	            }
	        };
	    }


}
