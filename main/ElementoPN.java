public class ElementoPN extends Elemento
{
    private int peso;
    public ElementoPN(PostoPN p, TransizioneN t, boolean verso, int peso)
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

    public ElementoPNp convertToElementoPNp(int priorita)
    {
        PostoPN pPN = (PostoPN) this.getPosto();
        TransizioneN tN = (TransizioneN) this.getTransazione();
        TransizionePNp tPNp = tN.convertToPNp(priorita);
        ElementoPNp elPNp = new ElementoPNp(pPN, tPNp, this.getVerso(), peso);
        return elPNp;
    }

    public ElementoN convertToElementoN()
    {
        PostoPN pPN = (PostoPN) this.getPosto();
        PostoN pN = pPN.convertToPostoN();
        TransizioneN tN = (TransizioneN) this.getTransazione();
        ElementoN elN = new ElementoN(pN, tN, this.getVerso());
        return elN;
    }
}
