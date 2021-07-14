import java.util.ArrayList;

public class Main_simula_PNp {
    public static void simula(ControllerRepositoryPNp repo)
    {
        if(repo.sizeFileNames() == 0)
            System.out.println("Prima di simulare una rete PNp e' necessario averne inserita almeno una\n");
        else {
            System.out.println(repo.toStringFileNames());
            int retePNp = (InputDati.leggiIntero("Selezionare la rete PNp che si vuole simulare: ", 1, repo.sizeFileNames()) -1);
            SimulaPNp sim = new SimulaPNp(repo.getRete(retePNp));
            simulation(sim);
        }
    }

    private static void simulation(SimulaPNp sim)
    {
        int prosegui=1;
        ArrayList<TransizionePNp> abil;
        ViewRetePNp view = new ViewRetePNp(sim.getRete());

        do {
            abil = sim.transizioniAbilitatePriority();
            switch(abil.size()) {
                case 0:
                    System.out.println("DEADLOCK\n");
                    break;
                case 1:
                    System.out.println("E' scattata la transizione con ID " + sim.scattaTransizione(abil.get(0)));
                    System.out.println(view.toStringPosti());
                    break;
                default:
                    System.out.println("E' scattata la transizione con ID " + sim.scattaTransizione(scegliTransizione(abil)));
                    System.out.println(view.toStringPosti());
                    break;
            }
            if(abil.size() > 0)
                prosegui = InputDati.leggiIntero("Vuoi proseguire con la simulazione?\n\b1) SI\n\n0) NO\n", 0, 1);
        }while(prosegui==1 && abil.size()!=0);
    }

    private static TransizionePNp scegliTransizione(ArrayList<TransizionePNp> list){
        System.out.println("Scegli una transizione tra quelle proposte qui sotto:\n\n");
        for(int i=0 ; i<list.size() ; i++) {
            ViewTransizionePNp view = new ViewTransizionePNp(list.get(i));
            System.out.println((i+1)+") "+view.toString());
        }
        System.out.println("\n\n");
        return list.get((InputDati.leggiIntero("Inserisci il numero della transizione che vuoi far scattare (1, "+list.size()+")", 1, list.size()))-1);
    }
}
