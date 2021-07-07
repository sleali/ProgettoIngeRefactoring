public class DABUTTARE
{

    public static void main(String[] args)
    {
        /*NetRepository retiN = new RepositoryN();
        PersistentManager m = new JsonManagerN();
        Rete r = m.load("/Users/davide/Desktop/prova1.json");
        retiN.add(r);
        System.out.println(retiN.size());
        boolean b = retiN.save(0, "prova1");
        System.out.println(b);

        /*------------------------------------------------------
        * test rete N*/

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

        /*------------------------------------------------------/

        /*------------------------------------------------------
        * test rete PN*/

        /*NetRepository retiPN = new RepositoryPN();
        Rete r = new Rete();
        FactoryElementoPN factory = new FactoryElementoPN(r);


        PostoPN p1 = new PostoPN(1, 1);
        r.addPosto(p1); //fatto da configuratore (controller)

        TransizioneN t1 = new TransizioneN(1);
        r.addTransizione(t1);

        ElementoPN e1 = factory.createElemento(0, 0, true, 1);
        r.addElemento(e1);


        PostoPN p2 = new PostoPN(2, 2);
        r.addPosto(p2); //fatto da configuratore (controller)

        TransizioneN t2 = new TransizioneN(2);
        r.addTransizione(t2);

        ElementoPN e2 = factory.createElemento(1, 1, true, 2);
        r.addElemento(e2);


        PostoPN p3 = new PostoPN(3, 3);
        r.addPosto(p3); //fatto da configuratore (controller)

        ElementoPN e3 = factory.createElemento(2, 1, false, 3);
        r.addElemento(e3);

        System.out.println(r.addElemento(e3));

        retiPN.add(r);
        System.out.println(retiPN.size());
        boolean b = retiPN.save(0, "prova1");
        System.out.println(b);*/

        /*---------------------------------------------------------*/

        /*---------------------------------------------------------
        * test import rete PN*/

        NetRepository retiPN = new RepositoryPN();
        boolean b = retiPN.importRete("/Users/davide/Desktop/prova1.json");
        System.out.println(b);
        System.out.println(retiPN.size());
        boolean b1 = retiPN.save(0, "prova1");
        System.out.println(b1);
    }
}
