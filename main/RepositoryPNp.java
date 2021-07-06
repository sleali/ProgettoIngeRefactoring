public class RepositoryPNp implements NetRepository{
    @Override
    public boolean add(Rete r) {
        return false;
    }

    @Override
    public Rete getRete(int index) {
        return null;
    }

    @Override
    public boolean save(int index, String fileName) {
        return false;
    }

    @Override
    public boolean load(String fileName) {
        return false;
    }

    @Override
    public boolean checkDuplicate(Rete retePar) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
