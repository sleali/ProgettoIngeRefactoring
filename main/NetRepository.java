public interface NetRepository
{
    public boolean add(Rete r);
    public void remove(int index);
    public Rete getRete(int index);
    public boolean save(int index, String fileName);
    public boolean load(String fileName);
    public boolean checkDuplicate(Rete retePar);
    public int size();
}
