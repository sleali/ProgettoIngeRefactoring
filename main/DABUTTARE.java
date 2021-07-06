public class DABUTTARE
{

    public static void main(String[] args)
    {
        NetRepository retiN = new RepositoryN();
        PersistentManager m = new JsonManagerN();
        Rete r = m.load("/Users/davide/Desktop/prova1.json");
        retiN.add(r);
        System.out.println(retiN.size());
        boolean b = retiN.save(0, "prova1");
        System.out.println(b);

        /*Rete r = new Rete();
        FactoryElementoN factory = new FactoryElementoN(r);


        PostoN p1 = new PostoN(1);
        r.addPosto(p1); //fatto da configuratore (controller)

        TransizioneN t1 = new TransizioneN(1);
        r.addTransizione(t1);

        ElementoN e1 = factory.createElemento(0, 0, true);
        r.addElemento(e1);


        PostoN p2 = new PostoN(2);
        r.addPosto(p2); //fatto da configuratore (controller)

        TransizioneN t2 = new TransizioneN(2);
        r.addTransizione(t2);

        ElementoN e2 = factory.createElemento(1, 1, true);
        r.addElemento(e2);


        PostoN p3 = new PostoN(3);
        r.addPosto(p3); //fatto da configuratore (controller)

        ElementoN e3 = factory.createElemento(2, 1, false);
        r.addElemento(e3);

        System.out.println(r.addElemento(e3));

        retiN.add(r);
        System.out.println(retiN.size());
        boolean b = retiN.save(0, "prova1");
        System.out.println(b);*/

    }
}
