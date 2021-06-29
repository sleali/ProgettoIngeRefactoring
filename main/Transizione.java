public abstract class Transizione
{
    private int ID;
    public Transizione(int ID)
    {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean equals(Transizione t)
    {
        return t.getID() == this.getID();
    }
}
