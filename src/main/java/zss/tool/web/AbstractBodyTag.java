package zss.tool.web;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;
import zss.tool.Version;

@Version("2013-02-06")
public abstract class AbstractBodyTag implements BodyTag
{
    protected Tag parent;
    protected PageContext pageContext;
    protected BodyContent bodyContent;

    public final BodyContent getBodyContent()
    {
        return bodyContent;
    }

    @Override
    public final void setBodyContent(final BodyContent content)
    {
        bodyContent = content;
    }

    public final PageContext getPageContext()
    {
        return pageContext;
    }

    @Override
    public final void setPageContext(final PageContext pageContext)
    {
        this.pageContext = pageContext;
    }

    @Override
    public final Tag getParent()
    {
        return parent;
    }

    @Override
    public final void setParent(final Tag parent)
    {
        this.parent = parent;
    }

    @Override
    public void release()
    {
        parent = null;
        pageContext = null;
        bodyContent = null;
    }
}
