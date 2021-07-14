public class Main_rete_PN
{
    public static void reti_PN(ControllerRepositoryN repoN, ControllerRepositoryPN repoPN)
    {
        int scelta = 0;
        do
        {
            System.out.println("Menu principale reti PN [utente: configuratore]\n1) Inserimento nuova rete \n2) Visualizzazione reti \n3) Importa rete \n\n0) Esci");
            scelta = InputDati.leggiIntero("Selezionare una delle voci del menu:", 0, 3);
            switch (scelta)
            {
                case 1:
                    inserimento_reti_PN(repoN, repoPN);
                    break;
                case 2:
                    visualizza_reti_PN(repoPN);
                    break;
                case 3:
                    importa_rete_PN(repoPN);
                    break;
                default:
                    System.out.println("Ritorno al menu di scelta utente...");
                    break;
            }
        }
        while (scelta != 0);
    }

    public static void inserimento_reti_PN(ControllerRepositoryN repoN, ControllerRepositoryPN repoPN)
    {
        int scelta = 0;
        boolean obbligo = true;
        ControllerRetePN controllerPN = null;
        do
        {
            System.out.println("Menu principale inserimento reti PN [utente: configuratore]\n1) Creazione rete PN \n2) Visualizza rete attuale \n3) Concludi inserimento \n\n0) Esci");
            scelta = InputDati.leggiIntero("Selezionare una delle voci del menu:", 0, 3);
            switch (scelta)
            {
                case 1:
                    int n = repoN.sizeFileNames();
                    if(n == 0)
                        System.out.println("Prima di inserire una rete PN e' necessario aver inserito almeno una rete N\n");
                    else {
                        System.out.println(repoN.toStringFileNames());
                        int reteN = (InputDati.leggiIntero("Selezionare la rete N che si vuole usare come base della rete PN: ", 1, n) - 1);
                        controllerPN = new ControllerRetePN(repoN.getRete(reteN));
                        int marcature[] = new int[controllerPN.sizePosti()];
                        int pesi[] = new int[controllerPN.sizeElementi()];
                        System.out.println("Inserimento delle marcature dei posti: \n");
                        for (int i = 0; i < controllerPN.sizePosti(); i++) {
                            System.out.println("Posto attuale:");
                            System.out.println(controllerPN.toStringPosto(i));
                            marcature[i] = InputDati.leggiIntero("Inserire la marcatura del posto sopra - stampato: ", 0, Integer.MAX_VALUE);
                        }
                        System.out.println("Inserimento dei pesi degli elementi: \n");
                        for (int i = 0; i < controllerPN.sizeElementi(); i++) {
                            System.out.println("Elemento attuale:");
                            System.out.println(controllerPN.toStringElemento(i));
                            pesi[i] = InputDati.leggiIntero("Inserire il peso dell'elemento sopra - stampato: ", 1, Integer.MAX_VALUE);
                        }
                        controllerPN.convertToPN(marcature, pesi);
                        obbligo = false;
                    }
                    break;
                case 2:
                    if(obbligo == true)
                        System.out.println("E' prima necessario selezionare la voce 1");
                    else
                        System.out.println(controllerPN.toString());
                    break;
                case 3:
                    if(obbligo == true)
                        System.out.println("E' prima necessario selezionare la voce 1");
                    else
                    {
                        String fileName = InputDati.leggiStringa("Inserire il nome del file con cui si desidera salvare la rete: ");
                        if(repoPN.salvaRete(controllerPN.getRete(), fileName))
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

    public static void visualizza_reti_PN(ControllerRepositoryPN repo)
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

    public static void importa_rete_PN(ControllerRepositoryPN repo)
    {
        String pathName = InputDati.leggiStringa("Inserire il path name del file contenente la rete da importare: ");
        String fileName = InputDati.leggiStringa("Inserire il nome con cui si dovra' salvare la rete da importare: ");
        if(repo.importaRete(pathName, fileName))
            System.out.println("Rete importata con successo!");
        else
            System.out.println("Si e' verificato un errore nell'importazione della rete");
    }
}
