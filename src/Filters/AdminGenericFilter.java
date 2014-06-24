package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/AdminGenericFilter")
public class AdminGenericFilter implements Filter {
	private FilterConfig filterconfg = null;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterconfg = fConfig;
	}
	
   public FilterConfig getFilterconfg() {
		return filterconfg;
	}

	public void setFilterconfg(FilterConfig filterconfg) {
		this.filterconfg = filterconfg;
	}

	public void destroy() {
		this.filterconfg = null;
	}

	

	

}
