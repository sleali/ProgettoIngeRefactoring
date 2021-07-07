import java.util.ArrayList;

public class Rete
{
    private ArrayList<Elemento> elementi;
    private ArrayList<Posto> posti;
    private ArrayList<Transizione> transazioni;
    public Rete()
    {

        posti = new ArrayList<>();
        transazioni = new ArrayList<>();
        elementi = new ArrayList<>();
    }
    
    public boolean addPosto(Posto p)
    {
        if(!alreadyExistsPosto(p))
        {
            posti.add(p);
            return true;
        }
        else
            return false;
    }

    public boolean addTransizione(Transizione t)
    {
        if(!alreadyExistsTransizione(t))
        {
            transazioni.add(t);
            return true;
        }
        else
            return false;
    }

    public boolean addElemento(Elemento el)
    {
        if(!alreadyExistsElemento(el))
        {
            elementi.add(el);
            return true;
        }
        else
            return false;
    }

    public void removePosto(int index)
    {
        if(index >= 0 && index < this.posti.size())
            this.posti.remove(index);
    }

    public void removeTransizione(int index)
    {
        if(index >= 0 && index < this.transazioni.size())
            this.transazioni.remove(index);
    }

    public void removeElemento(int index)
    {
        if(index >= 0 && index < this.elementi.size())
            elementi.remove(index);
    }

    public Elemento getElement(int index)
    {
        return this.elementi.get(index);
    }

    public Posto getPosto(int index)
    {
        return this.posti.get(index);
    }

    public Transizione getTransizione(int index)
    {
        return this.transazioni.get(index);
    }

    public int size()
    {
        return this.elementi.size();
    }

    public boolean alreadyExistsPosto(Posto p)
    {
        boolean exist = false;
        for (Posto posto : posti) {
            if (posto.equals(p))
                exist = true;
        }
        return exist;
    }

    public boolean alreadyExistsTransizione(Transizione t)
    {
        boolean exist = false;
        for (Transizione transizione : transazioni) {
            if (transizione.equals(t))
                exist = true;
        }
        return exist;
    }

    public boolean alreadyExistsElemento(Elemento el)
    {
        boolean exist = false;
        for (Elemento elemento : elementi) {
            if (elemento.equals(el))
                exist = true;
        }
        return exist;
    }

    public boolean equals(Rete r)
    {
        boolean find = false;
        if(this.size() != r.size())
            return false;
        else
        {
            for(int i = 0; i < this.size(); i++)
            {
                for(int k = 0; k < r.size() && !find; k++)
                {
                    if(this.getElement(i).equals(r.getElement(k)))
                    {
                        r.removeElemento(k);
                        find = true;
                    }
                }
                if(!find)
                    return false;
                find = false;
            }
            if(r.size() == 0)
                return true;
            else
                return false;
        }
    }

    public Rete convertToretePN(int marcature[], int pesi[])
    {
        Rete rPN = new Rete();
        ElementoN elN;
        ElementoPN elPN;
        for(int i = 0; i < this.size(); i++)
        {
            elN = (ElementoN) this.getElement(i);
            elPN = elN.convertToElementoPN(marcature[i], pesi[i]);
            rPN.addElemento(elPN);
        }
        return rPN;
    }

    public Rete convertToRetePNp(int priorita[])
    {
        Rete rPNp = new Rete();
        ElementoPN elPN;
        ElementoPNp elPNp;
        for(int i = 0; i < this.size(); i++)
        {
            elPN = (ElementoPN) this.getElement(i);
            elPNp = elPN.convertToElementoPNp(priorita[i]);
            rPNp.addElemento(elPN);
        }
        return rPNp;
    }

    public Rete convertToRetePNp(int marcature[], int pesi[], int priorita[])
    {
        Rete rPN = this.convertToretePN(marcature, pesi);
        Rete rPNp = rPN.convertToRetePNp(priorita);
        return rPNp;
    }

    public Rete convertToNFromPN()
    {
        Rete rN = new Rete();
        ElementoPN elPN;
        ElementoN elN;
        for(int i = 0; i < this.size(); i++)
        {
            elPN = (ElementoPN) this.getElement(i);
            elN = elPN.convertToElementoN();
            rN.addElemento(elN);
        }
        return rN;
    }

    public Rete convertToPNFromPNp()
    {
        Rete rPN = new Rete();
        ElementoPNp elPNp;
        ElementoPN elPN;
        for(int i = 0; i < this.size(); i++)
        {
            elPNp = (ElementoPNp) this.getElement(i);
            elPN = elPNp.convertToElementoPN();
            rPN.addElemento(elPN);
        }
        return rPN;
    }
}
