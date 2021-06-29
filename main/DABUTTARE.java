import java.io.File;

public class DABUTTARE
{
    public static void main(String[] args)
    {
        NetRepository retiN = new RepositoryN();

        PostoN p1 = new PostoN(1);
        TransizioneN t1 = new TransizioneN(1);
        ElementoN e1 = new ElementoN(p1, t1, true);

        PostoN p2 = new PostoN(2);
        TransizioneN t2 = new TransizioneN(2);
        ElementoN e2 = new ElementoN(p2, t2, true);

        PostoN p3 = new PostoN(3);
        TransizioneN t3 = new TransizioneN(2);
        ElementoN e3 = new ElementoN(p3, t3, false);

        ReteN r = new ReteN();
        r.add(e1);
        r.add(e2);
        r.add(e3);

        retiN.add(r);
        System.out.println(retiN.size());
        boolean b = retiN.save(0, "prova1");
        System.out.println(b);

    }
}
