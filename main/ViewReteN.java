public class ViewReteN extends ViewRete
{
    public ViewReteN(Rete rete)
    {
        super(rete);
    }

    public String toStringPosto(int index)
    {
        PostoN p = (PostoN) this.rete.getPosto(index);
        ViewPostoN viewP = new ViewPostoN(p);
        return viewP.toString();
    }

    public String toStringTransizione(int index)
    {
        TransizioneN t = (TransizioneN) this.rete.getTransizione(index);
        ViewTransizioneN viewT = new ViewTransizioneN(t);
        return viewT.toString();
    }

    public String toStringElemento(int index)
    {
        ElementoN el = (ElementoN) this.rete.getElement(index);
        ViewElementoN viewEl = new ViewElementoN(el);
        return viewEl.toString();
    }

    public String toString()
    {
        String toString = "";
        int n = this.rete.size();
        for(int i = 0; i < n; i++)
        {
            toString += this.toStringElemento(i) + "\n\n";
        }
        return toString;
    }
}
