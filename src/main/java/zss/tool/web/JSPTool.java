package zss.tool.web;

import javax.servlet.ServletRequest;

import org.apache.commons.lang.StringEscapeUtils;

import zss.tool.Version;

@Version("2016-09-19")
public class JSPTool
{
    public static String escapeJavaScript(final ServletRequest request, final String name)
    {
        final Object value = request.getAttribute(name);
        if (value instanceof String)
        {
            return StringEscapeUtils.escapeJavaScript((String) value);
        }
        return "";
    }

    public static String escapeHTML(final ServletRequest request, final String name)
    {
        final Object value = request.getAttribute(name);
        if (value instanceof String)
        {
            return StringEscapeUtils.escapeHtml((String) value);
        }
        return "";
    }
}
