public interface NetRepository
{
    public boolean add(Rete r);
    public Rete getRete(int index);
    public boolean save(int index, String fileName);
    public boolean load(String fileName);
    public boolean checkDuplicate(Rete retePar);
    public boolean importRete(String pathName);
    public int size();
}
