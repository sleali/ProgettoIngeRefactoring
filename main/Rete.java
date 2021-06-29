import java.util.ArrayList;

public class Rete
{
    private ArrayList<Elemento> elementi;
    public Rete()
    {
        elementi = new ArrayList<>();
    }

    public boolean add(Elemento el)
    {
        if(!alreadyExist(el))
        {
            elementi.add(el);
            return true;
        }
        else
            return false;
    }

    public void remove(int index)
    {
        elementi.remove(index);
    }

    public Elemento getElement(int index)
    {
        return this.elementi.get(index);
    }

    public int size()
    {
        return this.elementi.size();
    }

    public boolean alreadyExist(Elemento el)
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
                        r.remove(k);
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
}
