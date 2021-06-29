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
}
