public class ControllerReteN
{
    private Rete rete;
    private ViewReteN viewR;

    public ControllerReteN()
    {
        this.rete = new Rete();
        this.viewR = new ViewReteN(rete);
    }

    public boolean addPosto(int ID)
    {
        PostoN p = new PostoN(ID);
        return this.rete.addPosto(p);
    }

    public boolean addTransizione(int ID)
    {
        TransizioneN t = new TransizioneN(ID);
        return this.rete.addTransizione(t);
    }

    public boolean addElemento(int indexPosto, int indexTransizione, int verso)
    {
        boolean versoBool = verso == 0;
        PostoN p = (PostoN) this.rete.getPosto(indexPosto);
        TransizioneN t = (TransizioneN) this.rete.getTransizione(indexTransizione);
        ElementoN el = new ElementoN(p, t, versoBool);
        return this.rete.addElemento(el);
    }

    public String toString()
    {
        return this.viewR.toString();
    }

    public String toStringPosti()
    {
        return this.viewR.toStringPosti();
    }

    public String toStringTransizioni()
    {
        return this.viewR.toStringTransizioni();
    }

    public Rete getRete()
    {
        return this.rete;
    }

    public int sizePosti()
    {
        return this.rete.postiSize();
    }

    public int sizeTransizioni()
    {
        return this.rete.transizioniSize();
    }

    public int size()
    {
        return this.rete.size();
    }
}
