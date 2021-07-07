public class TransizionePNp extends Transizione
{
    private int priorita;
    public TransizionePNp(int ID, int priorita)
    {
        super(ID);
        this.priorita = priorita;
    }

    public int getPriorita()
    {
        return this.priorita;
    }

    public void setPriorita(int priorita)
    {
        this.priorita = priorita;
    }

    public TransizioneN convertToTransizioneN()
    {
        return new TransizioneN(this.getID());
    }
}
