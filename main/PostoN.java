public class PostoN extends Posto
{
    public PostoN(int ID)
    {
        super(ID);
    }

    public boolean equals(Posto p)
    {
        return p.getID() == this.getID();
    }
}
