public abstract class Posto
{
    private int ID;
    public Posto(int ID)
    {
        this.ID = ID;
    }
    public int getID()
    {
        return this.ID;
    }
    public void setID(int ID)
    {
        this.ID = ID;
    }
    public abstract boolean equals(Posto p);
}
