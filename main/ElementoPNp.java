public class ElementoPNp extends Elemento
{
    private int peso;
    public ElementoPNp(PostoPN p, TransizionePNp t, boolean verso, int peso)
    {
        super(p, t, verso);
        this.peso = (peso<1) ? 1 : peso;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public ElementoPN convertToElementoPN()
    {
        PostoPN pPN = (PostoPN) this.getPosto();
        TransizionePNp tPNp = (TransizionePNp) this.getTransazione();
        TransizioneN tN = tPNp.convertToTransizioneN();
        ElementoPN elPN = new ElementoPN(pPN, tN, this.getVerso(), this.getPeso());
        return elPN;
    }
}
