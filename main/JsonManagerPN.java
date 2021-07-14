import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class JsonManagerPN extends PersistentManager
{
    //applicazione del metodo template: in questa classe vi è la definizione delle primitive

    private JsonPN j;

    public JsonManagerPN()
    {
        j = new JsonPN();
    }

    @Override
    public String save(Rete r, String fileName)
    {
        String fileNameSaved = null;
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
                    ElementoPN el = (ElementoPN) r.getElement(i);
                    jsonString = j.writeElemento(el);
                    pw.println(jsonString);
                }
                pw.close();
                fileNameSaved = f.getName();
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }
        return fileNameSaved;
    }

    @Override
    protected Elemento getElementFromJson(String s)
    {
        return j.readElemento(s);
    }
}
