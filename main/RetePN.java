import java.util.ArrayList;

public class RetePN implements Rete
{
    private ArrayList<Elemento> elementi;

    public RetePN()
    {
        elementi = new ArrayList<>();
    }

    @Override
    public boolean add(Elemento el) {
        return false;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public Elemento getElement(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean alreadyExist(Elemento el) {
        return false;
    }

    @Override
    public boolean equals(Rete r) {
        return false;
    }
}
