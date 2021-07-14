public class ViewElementoPN
{
    private ElementoPN el;
    private PostoPN p;
    private TransizioneN t;

    public ViewElementoPN(ElementoPN el)
    {
        this.el = el;
        this.p = (PostoPN) el.getPosto();
        this.t = (TransizioneN) el.getTransazione();
    }

    public String toString()
    {
        ViewPostoPN viewP = new ViewPostoPN(p);
        ViewTransizioneN viewT = new ViewTransizioneN(t);
        return "Posto: " + viewP.toString() + "\nTransizione: " + viewT.toString() + "\nVerso: " + this.el.getVerso() + "\nPeso: " + this.el.getPeso();
    }
}
