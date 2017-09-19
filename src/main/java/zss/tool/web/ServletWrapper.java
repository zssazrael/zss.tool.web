package zss.tool.web;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import zss.tool.Version;

@Version("2017.09.18")
public class ServletWrapper implements Servlet {
    private ServletConfig servletConfig;
    private Servlet servlet;

    @Override
    public void destroy() {
        if (servlet != null) {
            servlet.destroy();
        }
    }

    public void setServlet(Servlet servlet) throws ServletException {
        if (this.servlet != null) {
            this.servlet.destroy();
        }
        this.servlet = servlet;
        if (servlet != null) {
            servlet.init(servletConfig);
        }
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
        this.servletConfig = servletConfig;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        if (servlet != null) {
            servlet.service(request, response);
        }
    }
}
