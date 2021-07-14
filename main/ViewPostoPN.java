public class ViewPostoPN
{
    private PostoPN p;

    public ViewPostoPN(PostoPN p)
    {
        this.p = p;
    }

    public String toString()
    {
        return "ID: " + this.p.getID() + " - Marcatura: " + this.p.getMarcatura();
    }
}
