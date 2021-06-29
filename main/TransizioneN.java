public class TransizioneN extends Transizione
{
    public TransizioneN(int ID)
    {
        super(ID);
    }

    public boolean equals(Transizione t)
    {
        return t.getID() == this.getID();
    }
}
