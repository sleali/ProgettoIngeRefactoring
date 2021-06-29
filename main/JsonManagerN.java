import com.google.gson.*;

public class JsonManagerN extends PersistentManager
{
    //applicazione del metodo template: in questa classe vi è la definizione delle primitive
    @Override
    public Gson createGson()
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ElementoN.class, new ElementoNCreator());
        gsonBuilder.registerTypeAdapter(Posto.class, new PostoCreator());
        gsonBuilder.registerTypeAdapter(Transizione.class, new TransizioneCreator());
        Gson gson = gsonBuilder.create();
        return gson;
    }

    @Override
    protected Rete getRete()
    {
        return new Rete();
    }

    @Override
    protected Elemento getElementFromJson(String s, Gson gson)
    {
        return gson.fromJson(s, ElementoN.class);
    }
}
