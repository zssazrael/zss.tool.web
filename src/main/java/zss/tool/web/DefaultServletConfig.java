package zss.tool.web;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import zss.tool.Version;

@Version("2013-11-18")
public class DefaultServletConfig implements ServletConfig
{
    private final Map<String, String> parameters = new LinkedHashMap<>();

    private String servletName;
    private ServletContext servletContext;

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

    public void setServletName(final String servletName)
    {
        this.servletName = servletName;
    }

    @Override
    public String getServletName()
    {
        return servletName;
    }
}
