package zss.tool.web;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;

import zss.tool.Version;

@Version("2013-11-15")
public class DefaultFilterConfig implements FilterConfig
{
    private final Map<String, String> parameters = new LinkedHashMap<>();

    private String filterName;
    private ServletContext servletContext;

    public void setFilterName(final String filterName)
    {
        this.filterName = filterName;
    }

    @Override
    public String getFilterName()
    {
        return filterName;
    }

    public void setInitParameter(final String name, final String value)
    {
        if (value == null)
        {
            parameters.remove(name);
        }
        else
        {
            parameters.put(name, value);
        }
    }

    @Override
    public String getInitParameter(final String name)
    {
        return parameters.get(name);
    }

    @Override
    public Enumeration<String> getInitParameterNames()
    {
        return Collections.enumeration(parameters.keySet());
    }

    public void setServletContext(final ServletContext servletContext)
    {
        this.servletContext = servletContext;
    }

    @Override
    public ServletContext getServletContext()
    {
        return servletContext;
    }
}
