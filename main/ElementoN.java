public class ElementoN extends Elemento
{
    public ElementoN(PostoN p, TransizioneN t, boolean verso)
    {
        super(p, t, verso);
    }

    public ElementoPN convertToElementoPN(int marcatura, int peso)
    {
        PostoN pN = (PostoN) this.getPosto();
        PostoPN pPN = pN.convertToPostoPN(marcatura);
        TransizioneN tN = (TransizioneN) this.getTransazione();
        ElementoPN elPN = new ElementoPN(pPN, tN, this.getVerso(), peso);
        return elPN;
    }
}
