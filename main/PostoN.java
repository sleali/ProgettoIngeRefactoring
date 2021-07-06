public class PostoN extends Posto
{
    public PostoN(int ID)
    {
        super(ID);
    }

    public PostoPN convertToPostoPN(int marcatura)
    {
        PostoPN pPN = new PostoPN(this.getID(), marcatura);
        return pPN;
    }
}
