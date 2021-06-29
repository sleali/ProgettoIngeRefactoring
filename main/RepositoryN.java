import java.util.*;
import java.io.*;

public class RepositoryN implements NetRepository
{
    private static final String DIRECTORY = "./salvataggi/retiN/";

    private ArrayList<Rete> retiN;
    private PersistentManager persistentManager;

    public RepositoryN()
    {
        retiN = new ArrayList<Rete>();
        persistentManager = new JsonManagerN();
    }

    @Override
    public boolean add(Rete r)
    {
        if(!checkDuplicate(r))
        {
            retiN.add(r);
            return true;
        }
        else
            return false;
    }

    @Override
    public void remove(int index)
    {
        this.retiN.remove(index);
    }

    @Override
    public Rete getRete(int index) {
        return this.retiN.get(index);
    }

    @Override
    public boolean save(int index, String filename)
    {
        boolean saved = false;
        Rete r = this.getRete(index);
        saved = this.persistentManager.save(r, filename);
        return saved;
    }

    @Override
    public boolean load(String fileName)
    {
        boolean loaded = false;
        Rete r = this.persistentManager.load(fileName);
        if(r != null)
        {
            loaded = this.retiN.add(r);
        }
        return loaded;
    }

    @Override
    public boolean checkDuplicate(Rete retePar)
    {
        boolean find = false;
        File dir = new File(DIRECTORY);
        String names[] = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                boolean value;
                // return files only that begins with test
                if(name.startsWith(".")){
                    value=false;
                }
                else{
                    value=true;
                }
                return value;
            }
        });
        for (int i = 0; i < names.length && !find; i++)
        {
            Rete reteEsistente = persistentManager.load(DIRECTORY + names[i]);
            if (retePar.equals(reteEsistente))
                find = true;
        }
        return find;
    }

    @Override
    public int size()
    {
        return this.retiN.size();
    }
}
