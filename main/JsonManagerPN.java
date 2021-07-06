import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonManagerPN extends PersistentManager
{
    //applicazione del metodo template: in questa classe vi è la definizione delle primitive
    @Override
    public Gson createGson()
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ElementoPN.class, new ElementoPNCreator());
        gsonBuilder.registerTypeAdapter(Posto.class, new PostoCreator());
        gsonBuilder.registerTypeAdapter(Transizione.class, new TransizioneCreator());
        Gson gson = gsonBuilder.create();
        return gson;
    }

    @Override
    protected Elemento getElementFromJson(String s, Gson gson)
    {
        return gson.fromJson(s, ElementoPN.class);
    }
}
