import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class JsonManagerPNp extends PersistentManager
{
    //applicazione del metodo template: in questa classe vi è la definizione delle primitive

    private JsonPNp j;

    public JsonManagerPNp()
    {
        j = new JsonPNp();
    }

    @Override
    public boolean save(Rete r, String fileName)
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
                String jsonString;
                for(int i = 0; i < r.size(); i++)
                {
                    ElementoPNp el = (ElementoPNp) r.getElement(i);
                    jsonString = j.writeElemento(el);
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

    @Override
    protected Elemento getElementFromJson(String s)
    {
        return j.readElemento(s);
    }
}
