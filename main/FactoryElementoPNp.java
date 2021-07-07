public class FactoryElementoPNp
{
    private Rete rete;
    public FactoryElementoPNp(Rete r)
    {
        this.rete = r;
    }

    public ElementoPNp createElemento(int postoIndex, int transizioneIndex, boolean verso, int peso)
    {
        PostoPN p = (PostoPN) this.rete.getPosto(postoIndex);
        TransizionePNp t = (TransizionePNp) this.rete.getTransizione(transizioneIndex);
        ElementoPNp el = new ElementoPNp(p, t, verso, peso);
        return el;
    }
}
