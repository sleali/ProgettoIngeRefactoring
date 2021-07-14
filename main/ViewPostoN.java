public class ViewPostoN
{
    private PostoN p;

    public ViewPostoN(PostoN p)
    {
        this.p = p;
    }

    public String toString()
    {
        return "ID: " + this.p.getID();
    }
}
