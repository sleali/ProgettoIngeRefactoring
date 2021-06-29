import java.util.ArrayList;

public class ReteN implements Rete
{
    private ArrayList<Elemento> elementi;
    public ReteN()
    {
        elementi = new ArrayList<>();
    }

    @Override
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

    @Override
    public void remove(int index)
    {
        elementi.remove(index);
    }

    @Override
    public Elemento getElement(int index)
    {
        return this.elementi.get(index);
    }

    @Override
    public int size()
    {
        return this.elementi.size();
    }

    @Override
    public boolean alreadyExist(Elemento el)
    {
        boolean exist = false;
        for (Elemento elemento : elementi) {
            if (elemento.equals(el))
                exist = true;
        }
        return exist;
    }

    @Override
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
