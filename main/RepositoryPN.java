import java.util.*;
import java.io.*;

public class RepositoryPN implements NetRepository
{
    private static final String DIRECTORY = "./salvataggi/retiPN/";

    private ArrayList<Rete> retiPN;
    private PersistentManager persistentManager;
    private RepositoryN retiN;

    public RepositoryPN()
    {
        retiPN = new ArrayList<Rete>();
        persistentManager = new JsonManagerPN();
        this.checkDirectory();
    }

    @Override
    public boolean add(Rete r)
    {
        if(!checkDuplicate(r))
        {
            retiPN.add(r);
            return true;
        }
        else
            return false;
    }

    @Override
    public Rete getRete(int index)
    {
        return this.retiPN.get(index);
    }

    @Override
    public boolean save(int index, String filename)
    {
        boolean saved = false;
        Rete r = this.getRete(index);
        saved = this.persistentManager.save(r, DIRECTORY + filename);
        return saved;
    }

    @Override
    public boolean load(String fileName)
    {
        boolean loaded = false;
        Rete r = this.persistentManager.load(DIRECTORY + fileName);
        if(r != null)
        {
            loaded = this.retiPN.add(r);
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

    private void checkDirectory() {
        File directory = new File("./salvataggi");
        File directoryPN = new File(DIRECTORY);

        if (!directory.isDirectory()) {
            directory.mkdir();
            if (!directoryPN.isDirectory()) {
                directoryPN.mkdir();
            }
        }
    }

    @Override
    public int size()
    {
        return this.retiPN.size();
    }
}
