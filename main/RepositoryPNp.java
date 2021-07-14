import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class RepositoryPNp extends NetRepository
{
    private static final String DIRECTORY = "./salvataggi/retiPNP/";

    private ArrayList<Rete> retiPNp;
    private PersistentManager persistentManager;

    public RepositoryPNp()
    {
        retiPNp = new ArrayList<Rete>();
        persistentManager = new JsonManagerPNp();
        fileNames = new ArrayList<>();
        this.checkDirectory();
        this.loadAllDirectory();
    }

    @Override
    public boolean add(Rete r)
    {
        if(!checkDuplicate(r))
        {
            retiPNp.add(r);
            return true;
        }
        else
            return false;
    }

    @Override
    public Rete getRete(int index) {
        return this.retiPNp.get(index);
    }

    @Override
    public String save(int index, String fileName)
    {
        String saved;
        Rete r = this.getRete(index);
        saved = this.persistentManager.save(r, DIRECTORY + fileName);
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
            loaded = this.retiPNp.add(r);
        }
        return loaded;
    }

    @Override
    public boolean importRete(String pathName)
    {
        boolean correct = false;
        RepositoryPN repoPN = new RepositoryPN();
        Rete rPNp = this.persistentManager.load(pathName);
        Rete rPN = rPNp.convertToPNFromPNp();
        if(rPNp != null && repoPN.checkDuplicate(rPN))
        {
            correct = this.retiPNp.add(rPNp);
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

    @Override
    public int size()
    {
        return this.retiPNp.size();
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
