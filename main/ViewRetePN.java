public class ViewRetePN extends ViewRete
{
    public ViewRetePN(Rete rete)
    {
        super(rete);
    }

    @Override
    public String toStringPosto(int index)
    {
        PostoPN p = (PostoPN) this.rete.getPosto(index);
        ViewPostoPN viewP = new ViewPostoPN(p);
        return viewP.toString();
    }

    @Override
    public String toStringTransizione(int index)
    {
        TransizioneN t = (TransizioneN) this.rete.getTransizione(index);
        ViewTransizioneN viewT = new ViewTransizioneN(t);
        return viewT.toString();
    }

    @Override
    public String toStringElemento(int index)
    {
        ElementoPN el = (ElementoPN) this.rete.getElement(index);
        ViewElementoPN viewEl = new ViewElementoPN(el);
        return viewEl.toString();
    }

    @Override
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
