public class PostoPN extends Posto
{
    private int marcatura;
    public PostoPN(int ID, int marcatura)
    {
        super(ID);
        this.marcatura = (marcatura>=0) ? marcatura : 0;
    }

    public PostoPN(int ID) {
        super(ID);
        this.marcatura=0;
    }

    public void setMarcatura(int marcatura) {
        this.marcatura=marcatura;
    }

    public int getMarcatura() {
        return marcatura;
    }

    public PostoN convertToPostoN()
    {
        return new PostoN(this.getID());
    }

}
