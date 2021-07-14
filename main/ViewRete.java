public abstract class ViewRete
{
    protected Rete rete;

    public ViewRete(Rete rete)
    {
        this.rete = rete;
    }

    public abstract String toStringPosto(int index);
    public abstract String toStringTransizione(int index);
    public abstract String toStringElemento(int index);
    public abstract String toString();

    public final String toStringPosti()
    {
        String toString = "";
        int n = this.rete.postiSize();
        int k;
        for(int i = 0; i < n; i++)
        {
            k = i + 1;
            toString += k + ") " + this.toStringPosto(i) + "\n";
        }
        return toString;
    }

    public final String toStringTransizioni()
    {
        String toString = "";
        int n = this.rete.transizioniSize();
        int k;
        for(int i = 0; i < n; i++)
        {
            k = i + 1;
            toString += k + ") " + this.toStringTransizione(i) + "\n";
        }
        return toString;
    }
}
