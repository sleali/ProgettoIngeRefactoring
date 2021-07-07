import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class RepositoryPNp implements NetRepository
{
    private static final String DIRECTORY = "./salvataggi/retiPNP/";

    private ArrayList<Rete> retiPNp;
    private PersistentManager persistentManager;

    public RepositoryPNp()
    {
        retiPNp = new ArrayList<Rete>();
        persistentManager = new JsonManagerPNp();
        this.checkDirectory();
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
    public boolean save(int index, String fileName)
    {
        boolean saved = false;
        Rete r = this.getRete(index);
        saved = this.persistentManager.save(r, DIRECTORY + fileName);
        return saved;
    }

    @Override
    public boolean load(String fileName)
    {
        boolean loaded = false;
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
}
