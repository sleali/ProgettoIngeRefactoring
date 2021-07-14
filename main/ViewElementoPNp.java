public class ViewElementoPNp
{
    private ElementoPNp el;
    private PostoPN p;
    private TransizionePNp t;

    public ViewElementoPNp(ElementoPNp el)
    {
        this.el = el;
        this.p = (PostoPN) el.getPosto();
        this.t = (TransizionePNp) el.getTransazione();
    }

    public String toString()
    {
        ViewPostoPN viewP = new ViewPostoPN(p);
        ViewTransizionePNp viewT = new ViewTransizionePNp(t);
        return "Posto: " + viewP.toString() + "\nTransizione: " + viewT.toString() + "\nVerso: " + this.el.getVerso() + "\nPeso: " + this.el.getPeso();
    }
}
