package zss.tool.web;

import javax.servlet.ServletRequest;

import org.apache.commons.text.StringEscapeUtils;

import zss.tool.Version;

@Version("2018.09.21")
public class JSPTool {
    public static String escapeJavaScript(final ServletRequest request, final String name) {
        final Object value = request.getAttribute(name);
        if (value instanceof String) {
            return StringEscapeUtils.escapeEcmaScript((String) value);
        }
        return "";
    }

    public static String escapeHTML(final ServletRequest request, final String name) {
        final Object value = request.getAttribute(name);
        if (value instanceof String) {
            return StringEscapeUtils.escapeHtml4((String) value);
        }
        return "";
    }

    private JSPTool() {
    }
}
