package zss.tool.web;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import zss.tool.Version;

@Version("2018.06.24")
public class ServletWrapper implements Servlet {
    private ServletConfig servletConfig;
    private Servlet servlet;
    private boolean init = false;

    @Override
    public void destroy() {
        if (servlet != null) {
            servlet.destroy();
        }
    }

    public void setServlet(Servlet servlet) throws ServletException {
        if (servlet == null) {
            return;
        }
        if (this.servlet != null) {
            return;
        }
        this.servlet = servlet;
        if (servletConfig == null) {
            return;
        }
        if (init) {
            return;
        }
        init = true;
        servlet.init(servletConfig);
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public String getServletInfo() {
        if (servlet == null) {
            return null;
        }
        return servlet.getServletInfo();
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        if (servletConfig == null) {
            return;
        }
        if (this.servletConfig != null) {
            return;
        }
        this.servletConfig = servletConfig;
        if (servlet == null) {
            return;
        }
        if (init) {
            return;
        }
        init = true;
        servlet.init(servletConfig);
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        if (servlet != null) {
            servlet.service(request, response);
        }
    }
}
