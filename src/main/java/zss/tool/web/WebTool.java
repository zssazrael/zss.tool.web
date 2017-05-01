package zss.tool.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zss.tool.LoggedException;
import zss.tool.ReflectTool;
import zss.tool.StringObjectMap;
import zss.tool.Version;

@Version("2017.05.01")
public final class WebTool {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebTool.class);

    private static final int DEFAULT_HTTP_PORT = 80;
    private static final int DEFAULT_HTTPS_PORT = 443;

    private WebTool() {
    }

    public static String getRequestURI(final HttpServletRequest request) {
        return request.getRequestURI().substring(request.getContextPath().length());
    }

    public static String getRequestURL(final HttpServletRequest request) {
        StringBuffer buffer = request.getRequestURL();
        String query = request.getQueryString();
        if (StringUtils.isNotEmpty(query)) {
            buffer.append('?');
            buffer.append(query);
        }
        return buffer.toString();
    }

    public static String getContextURL(final HttpServletRequest request, final String path) {
        StringBuilder builder = new StringBuilder();
        String scheme = request.getScheme();
        builder.append(scheme);
        builder.append("://");
        builder.append(request.getServerName());
        int port = request.getServerPort();
        if (("http".equals(scheme) && (port != DEFAULT_HTTP_PORT)) || ("https".equals(scheme) && (port != DEFAULT_HTTPS_PORT))) {
            builder.append(":");
            builder.append(Integer.toString(port, 10));
        }
        builder.append(request.getContextPath());
        builder.append(path);
        return builder.toString();
    }

    public static String getContextURL(final HttpServletRequest request) {
        return getContextURL(request, "/");
    }

    public static <T> T getAttribute(final ServletRequest request, final String name, final Class<T> type) {
        return ReflectTool.cast(request.getAttribute(name), type);
    }

    public static <T> T getAttribute(final HttpSession session, final String name, final Class<T> type) {
        return ReflectTool.cast(session.getAttribute(name), type);
    }

    public static void forward(final ServletRequest request, final ServletResponse response, final String path) {
        try {
            request.getRequestDispatcher(path).forward(request, response);
        } catch (ServletException e) {
            LOGGER.error(e.getMessage(), e);
            throw new LoggedException();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new LoggedException();
        }
    }

    public static Cookie getCookie(final HttpServletRequest request, final String name) {
        if ((request == null) || (name == null)) {
            return null;
        }
        return getCookie(request.getCookies(), name);
    }

    public static Cookie getCookie(final Cookie[] cookies, final String name) {
        if ((cookies == null) || (name == null)) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

    public static StringObjectMap getModelMap(final HttpServletRequest request) {
        Object object = request.getAttribute("model");
        if (!(object instanceof StringObjectMap)) {
            object = new StringObjectMap();
            request.setAttribute("model", object);
        }
        return (StringObjectMap) object;
    }
}
