public class TransizioneN extends Transizione
{
    public TransizioneN(int ID)
    {
        super(ID);
    }

    public TransizionePNp convertToPNp(int priorita)
    {
        TransizionePNp tPNp = new TransizionePNp(this.getID(), priorita);
        return tPNp;
    }
}
