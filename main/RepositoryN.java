import java.util.*;
import java.io.*;

public class RepositoryN extends NetRepository
{
    private static final String DIRECTORY = "./salvataggi/retiN/";

    private ArrayList<Rete> retiN;
    private PersistentManager persistentManager;

    public RepositoryN()
    {
        retiN = new ArrayList<Rete>();
        persistentManager = new JsonManagerN();
        fileNames = new ArrayList<>();
        this.checkDirectory();
        this.loadAllDirectory();
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
    public Rete getRete(int index) {
        return this.retiN.get(index);
    }

    @Override
    public String save(int index, String filename)
    {
        String saved;
        Rete r = this.getRete(index);
        saved = this.persistentManager.save(r, DIRECTORY + filename);
        if(saved != null)
            this.fileNames.add(saved);
        return saved;
    }

    @Override
    public boolean load(int index)
    {
        boolean loaded = false;
        String fileName = this.fileNames.get(index);
        Rete r = this.persistentManager.load(DIRECTORY + fileName);
        if(r != null)
        {
            loaded = this.retiN.add(r);
        }
        return loaded;
    }

    public boolean importRete(String pathName)
    {
        boolean correct = false;
        Rete rN = this.persistentManager.load(pathName);
        if(rN != null)
        {
            correct = this.retiN.add(rN);
        }
        return correct;
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

    private void checkDirectory()
    {
        File directory = new File("./salvataggi");
        File directoryPN = new File(DIRECTORY);

        if (!directory.isDirectory())
            directory.mkdir();
        if (!directoryPN.isDirectory())
            directoryPN.mkdir();
    }

    @Override
    public int size()
    {
        return this.retiN.size();
    }

    private void loadFileNames()
    {
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
        for (int i = 0; i < names.length; i++)
        {
            this.fileNames.add(names[i]);
        }
    }

    private void loadAllDirectory()
    {
        loadFileNames();
        for(int i = 0; i < fileNamesSize(); i++)
        {
            this.load(i);
        }
    }
}
