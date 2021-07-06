public class FactoryElementoN
{
    private Rete rete;
    public FactoryElementoN(Rete r)
    {
        this.rete = r;
    }

    public ElementoN createElemento(int postoIndex, int transizioneIndex, boolean verso)
    {
        PostoN p = (PostoN) this.rete.getPosto(postoIndex);
        TransizioneN t = (TransizioneN) this.rete.getTransizione(transizioneIndex);
        ElementoN el = new ElementoN(p, t, verso);
        return el;
    }
}
