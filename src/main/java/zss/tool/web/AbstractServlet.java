package zss.tool.web;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zss.tool.Version;

@Version("2013-11-18")
public abstract class AbstractServlet implements Servlet
{
    private ServletConfig servletConfig;

    @Override
    public void destroy()
    {
        servletConfig = null;
    }

    @Override
    public ServletConfig getServletConfig()
    {
        return servletConfig;
    }

    @Override
    public String getServletInfo()
    {
        return servletConfig.getServletName();
    }

    @Override
    public void init(final ServletConfig servletConfig) throws ServletException
    {
        this.servletConfig = servletConfig;
    }

    protected abstract void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException;

    @Override
    public void service(final ServletRequest request, final ServletResponse response) throws ServletException, IOException
    {
        service((HttpServletRequest) request, (HttpServletResponse) response);
    }
}
