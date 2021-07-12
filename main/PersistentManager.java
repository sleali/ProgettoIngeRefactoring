import java.io.*;

public abstract class PersistentManager
{
    //applicazione del pattern template
    public final Rete load(String fileName)
    {
        String s;
        Elemento e;
        Rete r = new Rete();
        File f = new File(fileName);
        BufferedReader source;
        try {
            source = new BufferedReader(new FileReader(f));
            do {
                s = source.readLine();
                if (!(s == null)) {
                    e = getElementFromJson(s); //primitiva pattern template
                    r.addElemento(e);
                    r.addPosto(e.getPosto());
                    r.addTransizione(e.getTransazione());
                }
            } while (!(s == null));
            source.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return r;
    }
    protected abstract Elemento getElementFromJson(String s);
    public abstract boolean save(Rete r, String fileName);
}
