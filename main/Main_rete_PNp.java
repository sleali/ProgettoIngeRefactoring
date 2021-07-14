public class Main_rete_PNp
{
    public static void reti_PNp(ControllerRepositoryPN repoPN, ControllerRepositoryPNp repoPNp)
    {
        int scelta = 0;
        do
        {
            System.out.println("Menu principale reti PNp [utente: configuratore]\n1) Inserimento nuova rete \n2) Visualizzazione reti \n3) Importa rete \n\n0) Esci");
            scelta = InputDati.leggiIntero("Selezionare una delle voci del menu:", 0, 3);
            switch (scelta)
            {
                case 1:
                    inserimento_reti_PNp(repoPN, repoPNp);
                    break;
                case 2:
                    visualizza_reti_PNp(repoPNp);
                    break;
                case 3:
                    importa_rete_PNp(repoPNp);
                    break;
                default:
                    System.out.println("Ritorno al menu di scelta utente...");
                    break;
            }
        }
        while (scelta != 0);
    }

    public static void inserimento_reti_PNp(ControllerRepositoryPN repoPN, ControllerRepositoryPNp repoPNp)
    {
        int scelta = 0;
        boolean obbligo = true;
        ControllerRetePNp controllerPNp = null;
        do
        {
            System.out.println("Menu principale inserimento reti PNp [utente: configuratore]\n1) Creazione rete PNp \n2) Visualizza rete attuale \n3) Concludi inserimento \n\n0) Esci");
            scelta = InputDati.leggiIntero("Selezionare una delle voci del menu:", 0, 3);
            switch (scelta)
            {
                case 1:
                    int n = repoPN.sizeFileNames();
                    if(n == 0)
                        System.out.println("Prima di inserire una rete PNp e' necessario aver inserito almeno una rete PN\n");
                    else {
                        System.out.println(repoPN.toStringFileNames());
                        int retePN = (InputDati.leggiIntero("Selezionare la rete PN che si vuole usare come base della rete PNp: ", 1, n) - 1);
                        controllerPNp = new ControllerRetePNp(repoPN.getRete(retePN));
                        int priorita[] = new int[controllerPNp.sizeTransizioni()];
                        System.out.println("Inserimento delle priorita' delle transizioni: \n");
                        for (int i = 0; i < controllerPNp.sizeTransizioni(); i++) {
                            System.out.println("Transizione attuale:");
                            System.out.println(controllerPNp.toStringTransizione(i));
                            priorita[i] = InputDati.leggiIntero("Inserire la priorita della transizione sopra - stampata: ", 1, Integer.MAX_VALUE);
                        }
                        controllerPNp.convertToPNp(priorita);
                        obbligo = false;
                    }
                    break;
                case 2:
                    if(obbligo == true)
                        System.out.println("E' prima necessario selezionare la voce 1");
                    else
                        System.out.println(controllerPNp.toString());
                    break;
                case 3:
                    if(obbligo == true)
                        System.out.println("E' prima necessario selezionare la voce 1");
                    else
                    {
                        String fileName = InputDati.leggiStringa("Inserire il nome del file con cui si desidera salvare la rete: ");
                        if(repoPNp.salvaRete(controllerPNp.getRete(), fileName))
                        {
                            System.out.println("Rete salvata con successo!");
                        }
                        else
                            System.out.println("Errore, la rete attuale e' gia' esistente");
                    }
                    break;
                default:
                    System.out.println("\n");
                    break;
            }
        }
        while (scelta != 0);
    }

    public static void visualizza_reti_PNp(ControllerRepositoryPNp repo)
    {
        int n = repo.sizeFileNames();
        if(n == 0)
            System.out.println("Non sono presenti reti da visualizzare\n");
        else
        {
            System.out.println(repo.toStringFileNames());
            int scelta = (InputDati.leggiIntero("Selezionare il nome della rete che si desidera visualizzare", 1, n) - 1);
            System.out.println(repo.visualizzaRete(scelta));
        }
    }

    public static void importa_rete_PNp(ControllerRepositoryPNp repo)
    {
        String pathName = InputDati.leggiStringa("Inserire il path name del file contenente la rete da importare: ");
        String fileName = InputDati.leggiStringa("Inserire il nome con cui si dovra' salvare la rete da importare: ");
        if(repo.importaRete(pathName, fileName))
            System.out.println("Rete importata con successo!");
        else
            System.out.println("Si e' verificato un errore nell'importazione della rete");
    }
}
