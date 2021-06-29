public interface Rete
{
    public boolean add(Elemento el);
    public void remove(int index);
    public Elemento getElement(int index);
    public int size();
    public boolean alreadyExist(Elemento el);
    public boolean equals(Rete r);
}
