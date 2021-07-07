import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonManagerPNp extends PersistentManager
{
    //applicazione del metodo template: in questa classe vi è la definizione delle primitive

    @Override
    protected Gson createGson()
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ElementoPNp.class, new ElementoPNpCreator());
        gsonBuilder.registerTypeAdapter(Posto.class, new PostoPNCreator());
        gsonBuilder.registerTypeAdapter(Transizione.class, new TransizionePNpCreator());
        Gson gson = gsonBuilder.create();
        return gson;
    }

    @Override
    protected Elemento getElementFromJson(String s, Gson gson) {
        return gson.fromJson(s, ElementoPNp.class);
    }
}
