public class ControllerRepositoryPNp
{
    private RepositoryPNp repo;
    private ViewRepository viewR;

    public ControllerRepositoryPNp()
    {
        repo = new RepositoryPNp();
    }

    public boolean addRete(Rete r)
    {
        return this.repo.add(r);
    }

    public boolean salvaRete(Rete r, String fileName)
    {
        boolean bool = false;
        if(this.addRete(r))
        {
            int n = repo.size();
            if(repo.save(n - 1, fileName) != null)
                bool = true;
        }
        return bool;
    }

    public boolean importaRete(String pathName, String fileName)
    {
        boolean bool = this.repo.importRete(pathName);
        if(bool)
            this.repo.save(repo.size() - 1, fileName);
        return bool;
    }

    public int size()
    {
        return this.repo.size();
    }

    public String toString()
    {
        int n = repo.size();
        int k;
        String toString = null;
        ViewRetePNp viewR;
        for (int i = 0; i < n; i++)
        {
            viewR = new ViewRetePNp(repo.getRete(i));
            k = i + 1;
            toString += k + ") " + viewR.toString() + "\n\n";
        }
        return toString;
    }

    public String toStringFileNames()
    {
        viewR = new ViewRepository(this.repo);
        return viewR.toStringFileNames();
    }

    public int sizeFileNames()
    {
        return this.repo.fileNamesSize();
    }

    public String visualizzaRete(int index)
    {
        Rete r = repo.getRete(index);
        ViewRetePNp view = new ViewRetePNp(r);
        return view.toString();
    }

    public Rete getRete(int index)
    {
        return this.repo.getRete(index);
    }
}
