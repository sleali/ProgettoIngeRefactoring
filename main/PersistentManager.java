import com.google.gson.Gson;
import java.io.*;

public abstract class PersistentManager
{
    public final boolean save(Rete r, String fileName)
    {
        boolean save = false;
        if (r.size() > 0) {
            try {
                File f = new File(fileName + ".json");
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
        Rete r = new Rete();
        Gson gson = createGson();
        File f = new File(fileName);
        BufferedReader source;
        try {
            source = new BufferedReader(new FileReader(f));
            do {
                s = source.readLine();
                if (!(s == null)) {
                    e = getElementFromJson(s, gson); //primitiva pattern template
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

    protected abstract Gson createGson();
    protected abstract Elemento getElementFromJson(String s, Gson gson);
}
