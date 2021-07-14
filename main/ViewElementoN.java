public class ViewElementoN
{
    private ElementoN el;
    private PostoN p;
    private TransizioneN t;

    public ViewElementoN(ElementoN el)
    {
        this.el = el;
        this.p = (PostoN) el.getPosto();
        this.t = (TransizioneN) el.getTransazione();
    }

    public String toString()
    {
        ViewPostoN viewP = new ViewPostoN(p);
        ViewTransizioneN viewT = new ViewTransizioneN(t);
        return "Posto: " + viewP.toString() + "\nTransizione: " + viewT.toString() + "\nVerso: " + this.el.getVerso();
    }
}
