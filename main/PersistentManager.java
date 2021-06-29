import com.google.gson.Gson;
import java.io.*;

public abstract class PersistentManager
{
    private String directory;

    public PersistentManager(String directory)
    {
        checkDirectory();
        this.directory = directory;
    }
    public final boolean save(Rete r, String fileName)
    {
        boolean save = false;
        if (r.size() > 0) {
            try {
                File f = new File(directory + fileName + ".json");
                for(int i = 1; f.exists() && !f.isDirectory(); i++)
                {
                    f = new File(fileName + "(" + i + ")" + ".json");
                }
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
                Gson gson = new Gson();
                String jsonString;
                for(int i = 0; i < r.size(); i++)
                {
                    Elemento el = r.getElement(i);
                    jsonString = gson.toJson(el);
                    pw.println(jsonString);
                }
                pw.close();
                save = true;
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }
        return save;
    }

    //applicazione del pattern template
    public final Rete load(String fileName)
    {
        String s;
        Elemento e;
        Rete r = getRete(); //primitiva pattern template
        Gson gson = createGson();
        File f = new File(fileName);
        BufferedReader source;
        try {
            source = new BufferedReader(new FileReader(f));
            do {
                s = source.readLine();
                if (!(s == null)) {
                    e = getElementFromJson(s, gson); //primitiva pattern template
                    r.add(e);
                }
            } while (!(s == null));
            source.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return r;
    }

    private void checkDirectory() {
        File directory = new File("./salvataggi");
        File directoryN = new File("./salvataggi/retiN");
        File directoryPN = new File("./salvataggi/retiPN");
        File directoryPNP = new File("./salvataggi/retiPNP");

        if (!directory.isDirectory()) {
            directory.mkdir();
            if (!directoryN.isDirectory()) {
                directoryN.mkdir();
            }
            if (!directoryPN.isDirectory()) {
                directoryPN.mkdir();
            }
            if (!directoryPNP.isDirectory()) {
                directoryPNP.mkdir();
            }
        }
    }

    protected abstract Gson createGson();
    protected abstract Rete getRete();
    protected abstract Elemento getElementFromJson(String s, Gson gson);
}
