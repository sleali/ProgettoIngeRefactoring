public class ViewRepository
{
    private NetRepository repo;

    public ViewRepository(NetRepository repo)
    {
        this.repo = repo;
    }

    public String toStringFileNames()
    {
        int n = repo.fileNamesSize();
        int k;
        String toString = "";
        for (int i = 0; i < n; i++)
        {
            k = i + 1;
            toString += k + " ) " + repo.getFileName(i);
        }
        return toString;
    }
}
