public class ViewTransizionePNp
{
    private TransizionePNp t;

    public ViewTransizionePNp(TransizionePNp t)
    {
        this.t = t;
    }

    public String toString()
    {
        return "ID: " + this.t.getID() + " - Priorita': " +this.t.getPriorita();
    }
}
