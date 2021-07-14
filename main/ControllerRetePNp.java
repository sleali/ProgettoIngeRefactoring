import java.util.HashMap;

public class ControllerRetePNp
{
    private Rete retePN, retePNp;
    private ViewRetePNp viewRPNp;
    private HashMap<Integer, Integer> prioritaHash;

    public ControllerRetePNp(Rete retePN)
    {
        this.retePN = retePN;
    }

    public String toString()
    {
        return this.viewRPNp.toString();
    }

    private void convertToTransizioniPNp(int priorita[])
    {
        prioritaHash = new HashMap<>();
        int n = this.retePN.transizioniSize();
        int ID;
        for(int i = 0; i < n; i++)
        {
            ID = retePN.getTransizione(i).getID();
            prioritaHash.put(ID, priorita[i]);
        }
    }

    private int[] getPriorita(int prioritaInput[])
    {
        convertToTransizioniPNp(prioritaInput);
        int[] priorita = new int[this.sizeElementi()];
        ElementoPN el;
        TransizioneN t;
        for(int i = 0; i < this.sizeElementi(); i++)
        {
            el = (ElementoPN) retePN.getElement(i);
            t = (TransizioneN) el.getTransazione();
            priorita[i] = prioritaHash.get(t.getID());
        }
        return priorita;
    }

    public Rete getRete()
    {
        return this.retePNp;
    }

    public int sizeTransizioni()
    {
        return this.retePN.transizioniSize();
    }

    public int sizeElementi()
    {
        return this.retePN.size();
    }

    public int size()
    {
        return this.retePNp.size();
    }

    public String toStringTransizione(int index)
    {
        TransizioneN t = (TransizioneN) this.retePN.getTransizione(index);
        ViewTransizioneN tView = new ViewTransizioneN(t);
        return tView.toString();
    }
    public String toStringElemento(int index)
    {
        ElementoPN el = (ElementoPN) this.retePN.getElement(index);
        ViewElementoPN elView = new ViewElementoPN(el);
        return elView.toString();
    }

    public void convertToPNp(int priorita[])
    {
        this.retePNp = this.retePN.convertToRetePNp(getPriorita(priorita));
        this.viewRPNp = new ViewRetePNp(retePNp);
    }
}
