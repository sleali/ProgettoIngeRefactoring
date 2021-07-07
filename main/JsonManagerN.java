import com.google.gson.*;

public class JsonManagerN extends PersistentManager
{
    //applicazione del metodo template: in questa classe vi è la definizione delle primitive
    @Override
    public Gson createGson()
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ElementoN.class, new ElementoNCreator());
        gsonBuilder.registerTypeAdapter(Posto.class, new PostoNCreator());
        gsonBuilder.registerTypeAdapter(Transizione.class, new TransizioneNCreator());
        Gson gson = gsonBuilder.create();
        return gson;
    }

    @Override
    protected Elemento getElementFromJson(String s, Gson gson)
    {
        return gson.fromJson(s, ElementoN.class);
    }
}
