import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JsonPN
{
    private BufferedReader source;
    public String writeElemento(ElementoPN el)
    {
        PostoPN p = (PostoPN) el.getPosto();
        TransizioneN t = (TransizioneN) el.getTransazione();

        int peso = el.getPeso();
        String verso = Boolean.toString(el.getVerso());

        String posto = writePosto(p);
        String transizione = writeTransizione(t);

        return  "{\"peso\":" + peso + ",\"verso\":" + verso + "," + posto +"," + transizione +'}';
    }

    private String writePosto(PostoPN p)
    {
        int idPosto = p.getID();
        int marcatura = p.getMarcatura();
        return "\"p\":{\"marcatura\":" + marcatura + ",\"ID\":" + idPosto + "}";
    }

    private String writeTransizione(TransizioneN t)
    {
        int idTransizione = t.getID();
        return "\"t\":{\"ID\":" + idTransizione + "}";
    }

    public ElementoPN readElemento(String rigaLetta)
    {
        ArrayList<String> tokens = new ArrayList<>();
        ElementoPN el;
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
        el = readElementoPN(tokens.get(0), readPosto(tokens.get(1)), readTransizione(tokens.get(3)));
        return el;
    }

    private ElementoPN readElementoPN(String el, PostoPN p, TransizioneN t)
    {
        StringTokenizer st1 = new StringTokenizer(el, ":");
        StringTokenizer st2, st3;
        st1.nextToken();
        st2 = new StringTokenizer(st1.nextToken(), ",");
        int peso = Integer.parseInt(st2.nextToken());
        st3 = new StringTokenizer(st1.nextToken(), ",");
        boolean verso = Boolean.parseBoolean(st3.nextToken());
        return new ElementoPN(p, t, verso, peso);
    }

    private PostoPN readPosto(String p)
    {
        StringTokenizer st1 = new StringTokenizer(p, ":");
        StringTokenizer st2;
        st1.nextToken();
        st2 = new StringTokenizer(st1.nextToken(), ",");
        int marcatura = Integer.parseInt(st2.nextToken());
        int ID = Integer.parseInt(st1.nextToken());
        return new PostoPN(ID, marcatura);
    }

    private TransizioneN readTransizione(String t)
    {
        StringTokenizer st = new StringTokenizer(t, ":");
        st.nextToken();
        int ID = Integer.parseInt(st.nextToken());
        return new TransizioneN(ID);
    }
}
