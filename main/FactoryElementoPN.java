public class FactoryElementoPN
{
    private Rete rete;
    public FactoryElementoPN(Rete r)
    {
        this.rete = r;
    }

    public ElementoPN createElemento(int postoIndex, int transizioneIndex, boolean verso, int peso)
    {
        PostoPN p = (PostoPN) this.rete.getPosto(postoIndex);
        TransizioneN t = (TransizioneN) this.rete.getTransizione(transizioneIndex);
        ElementoPN el = new ElementoPN(p, t, verso, peso);
        return el;
    }
}
