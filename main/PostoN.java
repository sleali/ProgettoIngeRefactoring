public class PostoN extends Posto
{
    public PostoN(int ID)
    {
        super(ID);
    }

    @Override
    public boolean equals(Posto p)
    {
        return p.getID() == this.getID();
    }
}
