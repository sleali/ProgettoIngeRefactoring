import java.util.ArrayList;

public class DABUTTARE
{
    public static void main(String[] args)
    {
        /*NetRepository retiPN = new RepositoryPN();
        Rete r = new Rete();
        FactoryElementoPN factory = new FactoryElementoPN(r);


        PostoPN p1 = new PostoPN(1, 3);
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

        ElementoPN e4 = factory.createElemento(2, 1, false, 1);
        r.addElemento(e4);

        System.out.println(r.addElemento(e3));

        retiPN.add(r);
        System.out.println(retiPN.size());
        boolean b = retiPN.save(0, "provaSimula");
        System.out.println(b);
        */

        NetRepository retiPNp = new RepositoryPNp();
        boolean b = retiPNp.importRete("/Users/mirkoglisenti/Desktop/ProgettoInge/ProgettoIngeRefactoring/salvataggi/retiPNP/prova1.json");
        System.out.println("IMPORT: "+b);
        System.out.println("SIZE: " + retiPNp.size());
        Rete rete = retiPNp.getRete(0);
        SimulaPNP simula = new SimulaPNP(rete);
        ArrayList<TransizionePNp> abil;
        int i = 1;
        do{
            abil = simula.transizioniAbilitatePriority();
            System.out.println("CICLO "+i);
            System.out.println("ABILITATE: "+abil.size());
            switch (abil.size()) {
                case 0:
                    System.out.println("DEADLOCK");
                    break;
                case 1:
                    simula.scattaTransizione(abil.get(0));
                    statoRete(simula.getRete());
                    break;
                default:
                    simula.scattaTransizione(scegliTransizione(abil));
                    statoRete(simula.getRete());
                    break;
            }
            i++;
        }while(abil.size() != 0);
    }

    public static TransizionePNp scegliTransizione(ArrayList<TransizionePNp> abil){
        for(TransizionePNp t : abil){
            System.out.println(t.getID());
        }
        return abil.get(0);
    }

    public static void statoRete(Rete r)
    {
        int n = r.postiSize();
        PostoPN pn;
        for(int i = 0; i < n; i++)
        {
            pn = (PostoPN) r.getPosto(i);
            System.out.println("ID Posto: "+pn.getID()+"\nMarcatura Posto: "+pn.getMarcatura()+"\n\n");
        }
    }
}
