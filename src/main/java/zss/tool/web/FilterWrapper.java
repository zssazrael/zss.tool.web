package zss.tool.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import zss.tool.Version;

@Version("2017.09.19")
public class FilterWrapper implements Filter {
    private FilterConfig filterConfig;
    private Filter filter;

    public Filter getFilter() {
        return filter;
    }

    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    public void setFilter(Filter filter) throws ServletException {
        if (this.filter != null) {
            this.filter.destroy();
        }
        this.filter = filter;
        if (filter != null) {
            filter.init(filterConfig);
        }
    }

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (filter == null) {
            chain.doFilter(request, response);
        } else {
            filter.doFilter(request, response, chain);
        }
    }

    @Override
    public void destroy() {
        if (filter != null) {
            filter.destroy();
        }
    }
}
