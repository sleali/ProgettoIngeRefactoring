import java.util.ArrayList;

public abstract class NetRepository
{
    protected ArrayList<String> fileNames;

    public abstract boolean add(Rete r);
    public abstract Rete getRete(int index);
    public abstract String save(int index, String fileName);
    public abstract boolean load(int index);
    public abstract boolean checkDuplicate(Rete retePar);
    public abstract boolean importRete(String pathName);
    public abstract int size();



    public int fileNamesSize()
    {
        return this.fileNames.size();
    }

    public String getFileName(int index)
    {
        return this.fileNames.get(index);
    }
}
