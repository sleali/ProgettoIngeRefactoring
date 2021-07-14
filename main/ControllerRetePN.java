import java.util.HashMap;

public class ControllerRetePN
{
    private Rete retePN, reteN;
    private ViewRetePN viewRPN;
    private HashMap<Integer, Integer> marcatureHash;

    public ControllerRetePN(Rete reteN)
    {
        this.reteN = reteN;
    }

    public String toString()
    {
        return this.viewRPN.toString();
    }

    private void convertToPostiPN(int marcature[])
    {
        marcatureHash = new HashMap<>();
        int n = this.reteN.postiSize();
        int ID;
        for(int i = 0; i < n; i++)
        {
            ID = reteN.getPosto(i).getID();
            marcatureHash.put(ID, marcature[i]);
        }
    }

    private int[] getMarcature(int marcatureInput[])
    {
        convertToPostiPN(marcatureInput);
        int[] marcature = new int[this.sizeElementi()];
        ElementoN el;
        PostoN p;
        for(int i = 0; i < this.sizeElementi(); i++)
        {
            el = (ElementoN) reteN.getElement(i);
            p = (PostoN) el.getPosto();
            marcature[i] = marcatureHash.get(p.getID());
        }
        return marcature;
    }

    public Rete getRete()
    {
        return this.retePN;
    }

    public int sizePosti()
    {
        return this.reteN.postiSize();
    }

    public int sizeElementi()
    {
        return this.reteN.size();
    }

    public int size()
    {
        return this.retePN.size();
    }

    public String toStringPosto(int index)
    {
        PostoN p = (PostoN) this.reteN.getPosto(index);
        ViewPostoN pView = new ViewPostoN(p);
        return pView.toString();
    }
     public String toStringElemento(int index)
     {
         ElementoN el = (ElementoN) this.reteN.getElement(index);
         ViewElementoN elView = new ViewElementoN(el);
         return elView.toString();
     }

     public void convertToPN(int marcature[], int pesi[])
     {
         this.retePN = this.reteN.convertToretePN(getMarcature(marcature), pesi);
         this.viewRPN = new ViewRetePN(retePN);
     }
}
