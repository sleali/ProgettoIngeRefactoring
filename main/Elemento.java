public abstract class Elemento
{
    protected Posto p;
    protected Transizione t;
    private boolean verso;

    public final static boolean DA_POSTO_A_TRANSAZIONE = true;
    public final static boolean DA_TRANSAZIONE_A_POSTO = false;

    public Elemento(Posto p, Transizione t, boolean verso)
    {
        this.p = p;
        this.t = t;
        if(verso)
            this.verso = DA_POSTO_A_TRANSAZIONE;
        else
            this.verso = DA_TRANSAZIONE_A_POSTO;
    }

    public boolean getVerso()
    {
        return this.verso;
    }
    public void setVerso(boolean verso)
    {
        this.verso = verso;
    }
    /*public int getIdPosto()
    {
        return this.p.getId();
    }
    public int getIdTransizione()
    {
        return this.t.geId();
    }*/
    public Posto getPosto()
    {
        return this.p;
    }
    public Transizione getTransazione()
    {
        return this.t;
    }
    public boolean equals(Elemento el)
    {
        if(this.verso == el.getVerso() && this.p.equals(el.getPosto()) && this.t.equals(el.getTransazione()))
            return true;
        else
            return false;
    }
}
