import com.google.gson.Gson;

public class JsonManagerPN extends PersistentManager
{
    public JsonManagerPN(String directory) {
        super(directory);
    }

    @Override
    protected Gson createGson() {
        return null;
    }

    //applicazione del metodo template: in questa classe vi è la definizione delle primitive
    @Override
    protected Rete getRete() {
        return null;
    }

    @Override
    protected Elemento getElementFromJson(String s, Gson gson) {
        return null;
    }
}
