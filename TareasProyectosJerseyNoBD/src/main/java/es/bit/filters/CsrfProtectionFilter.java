package es.bit.filters;


import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Priority;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

@Priority(Priorities.AUTHENTICATION) // should be one of the first post-matching filters to get executed
//@WebFilter(filterName = "CsrfProtectionFilter", urlPatterns = { "/rest/*" })
public class CsrfProtectionFilter implements Filter {

    /**
     * Name of the header this filter will attach to the request.
     */
    public static final String HEADER_NAME = "X-Requested-By";

    private static final Set<String> METHODS_TO_IGNORE;
    static {
        HashSet<String> mti = new HashSet<>();
        mti.add("GET");
        mti.add("OPTIONS");
        mti.add("HEAD");
        METHODS_TO_IGNORE = Collections.unmodifiableSet(mti);
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CSRF!....:"+((HttpServletRequest)request).getHeader(HEADER_NAME));
        if (
        		!METHODS_TO_IGNORE.contains(((HttpServletRequest)request).getMethod()) && 
        		((HttpServletRequest)request).getHeader(HEADER_NAME)==null 
        	) {
            throw new BadRequestException();
        }else {
        	chain.doFilter(request, response);
        }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
