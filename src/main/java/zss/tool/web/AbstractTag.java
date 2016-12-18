package zss.tool.web;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import zss.tool.Version;

@Version("2013-02-04")
public abstract class AbstractTag implements Tag
{
    protected Tag parent;
    protected PageContext pageContext;

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
    }
}
