public class ViewRetePNp extends ViewRete
{
    public ViewRetePNp(Rete rete)
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
        TransizionePNp t = (TransizionePNp) this.rete.getTransizione(index);
        ViewTransizionePNp viewT = new ViewTransizionePNp(t);
        return viewT.toString();
    }

    @Override
    public String toStringElemento(int index)
    {
        ElementoPNp el = (ElementoPNp) this.rete.getElement(index);
        ViewElementoPNp viewEl = new ViewElementoPNp(el);
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
