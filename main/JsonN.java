import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JsonN
{
    private BufferedReader source;
    public String writeElemento(ElementoN el)
    {
        PostoN p = (PostoN) el.getPosto();
        TransizioneN t = (TransizioneN) el.getTransazione();

        String verso = Boolean.toString(el.getVerso());

        String posto = writePosto(p);
        String transizione = writeTransizione(t);

        return  "{\"verso\":" + verso + "," + posto +"," + transizione +'}';
    }

    private String writePosto(PostoN p)
    {
        int idPosto = p.getID();
        return "\"p\":{\"ID\":" + idPosto + "}";
    }

    private String writeTransizione(TransizioneN t)
    {
        int idTransizione = t.getID();
        return "\"t\":{\"ID\":" + idTransizione + "}";
    }

    public ElementoN readElemento(String rigaLetta)
    {
        ArrayList<String> tokens = new ArrayList<>();
        ElementoN el;
        StringTokenizer st1, st2 = null;
        st1 = new StringTokenizer(rigaLetta, "{");
        for (int i = 0;st1.hasMoreTokens(); i++)
        {
            st2 = new StringTokenizer(st1.nextToken(), "}");
            while(st2.hasMoreTokens())
            {
                tokens.add(st2.nextToken());
            }
        }
        el = readElementoN(tokens.get(0), readPosto(tokens.get(1)), readTransizione(tokens.get(3)));
        return el;
    }

    private ElementoN readElementoN(String el, PostoN p, TransizioneN t)
    {
        StringTokenizer st1 = new StringTokenizer(el, ":");
        StringTokenizer st2, st3;
        st1.nextToken();
        st2 = new StringTokenizer(st1.nextToken(), ",");
        boolean verso = Boolean.parseBoolean(st2.nextToken());
        return new ElementoN(p, t, verso);
    }

    private PostoN readPosto(String p)
    {
        StringTokenizer st1 = new StringTokenizer(p, ":");
        st1.nextToken();
        int ID = Integer.parseInt(st1.nextToken());
        return new PostoN(ID);
    }

    private TransizioneN readTransizione(String t)
    {
        StringTokenizer st = new StringTokenizer(t, ":");
        st.nextToken();
        int ID = Integer.parseInt(st.nextToken());
        return new TransizioneN(ID);
    }
}
