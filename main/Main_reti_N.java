public class Main_reti_N
{
    public static void reti_N(ControllerRepositoryN repo)
    {
        int scelta = 0;
        do
        {
            System.out.println("Menu principale reti N [utente: configuratore]\n1) Inserimento nuova rete \n2) Visualizzazione reti \n3) Importa rete \n\n0) Esci");
            scelta = InputDati.leggiIntero("Selezionare una delle voci del menu:", 0, 3);
            switch (scelta)
            {
                case 1:
                    inserimento_reti_N(repo);
                    break;
                case 2:
                    visualizza_reti_N(repo);
                    break;
                case 3:
                    importa_rete_N(repo);
                    break;
                default:
                    System.out.println("Ritorno al menu di scelta utente...");
                    break;
            }
        }
        while (scelta != 0);
    }

    public static void inserimento_reti_N(ControllerRepositoryN repo)
    {
        int scelta = 0;
        int IDp, IDt, verso;
        ControllerReteN controllerN = new ControllerReteN();
        do
        {
            System.out.println("Menu principale inserimento reti N [utente: configuratore]\n1) Aggiungi posto \n2) Aggiungi transizione \n3) Crea elemento" +
                    "\n4) Visualizza rete attuale \n5) Concludi inserimento \n\n0) Esci");
            scelta = InputDati.leggiIntero("Selezionare una delle voci del menu:", 0, 5);
            switch (scelta)
            {
                case 1:
                    IDp = InputDati.leggiIntero("Inserire l'ID del posto: ");
                    if(controllerN.addPosto(IDp))
                        System.out.println("Posto aggiunto con successo");
                    else
                        System.out.println("Il posto inserito è gia' esistente");
                    break;
                case 2:
                    IDt = InputDati.leggiIntero("Inserire l'ID della transizione: ");
                    if(controllerN.addTransizione(IDt))
                        System.out.println("Transizione aggiunta con successo");
                    else
                        System.out.println("La transizione inserita è gia' esistente");
                    break;
                case 3:
                    if(controllerN.sizePosti() == 0)
                        System.out.println("Non e' ancora stato inserito alcun posto, impossibile procedere\n");
                    else
                    {
                        if(controllerN.sizeTransizioni() == 0)
                            System.out.println("Non e' ancora stata inserita alcuna transizione, impossibile procedere\n");
                        else
                        {
                            System.out.println("Elenco dei posti attualmente inseriti:");
                            System.out.println(controllerN.toStringPosti());
                            int sceltaPosto = (InputDati.leggiIntero("Selezionare quale posto aggiungere all'elemento: ") - 1);
                            System.out.println("Elenco delle transizioni attualmente inserite:");
                            System.out.println(controllerN.toStringTransizioni());
                            int sceltaTransizione = (InputDati.leggiIntero("Selezionare quale transizione aggiungere all'elemento: ") - 1);
                            if(sceltaDoppia("Selezionare il verso dell'elemento (0/1):\n"
                                    + "0) Dal posto alla transizione\n"
                                    + "1) Dalla transizione al posto\n", '0', '1').equals('0'))
                                verso = 0;
                            else
                                verso = 1;
                            if(controllerN.addElemento(sceltaPosto, sceltaTransizione, verso))
                                System.out.println("Elemento aggiunta con successo");
                            else
                                System.out.println("L'elemento inserito è gia' esistente");
                        }
                    }
                    break;
                case 4:
                    if(controllerN.size() == 0)
                        System.out.println("La rete attuale e' ancora vuota");
                    else
                        System.out.println(controllerN.toString());
                    break;
                case 5:
                    if(controllerN.size() == 0)
                        System.out.println("La rete attuale e' ancora vuota");
                    else
                    {
                        String fileName = InputDati.leggiStringa("Inserire il nome del file con cui si desidera salvare la rete: ");
                        if(repo.salvaRete(controllerN.getRete(), fileName))
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

    public static void visualizza_reti_N(ControllerRepositoryN repo)
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

    public static void importa_rete_N(ControllerRepositoryN repo)
    {
        String pathName = InputDati.leggiStringa("Inserire il path name del file contenente la rete da importare: ");
        String fileName = InputDati.leggiStringa("Inserire il nome con cui si dovra' salvare la rete da importare: ");
        if(repo.importaRete(pathName, fileName))
            System.out.println("Rete importata con successo!");
        else
            System.out.println("Si e' verificato un errore nell'importazione della rete");
    }

    private static Character sceltaDoppia(String messaggio, char scelta1, char scelta2)
    {
        Character input;
        do
        {
            input = InputDati.leggiChar(messaggio);
            input = Character.toLowerCase(input);
            if(!input.equals(scelta1) && !input.equals(scelta2))
                System.out.println("Errore, scegliere tra le opzioni " + scelta1 + "/" + scelta2);
        }
        while(!input.equals(scelta1) && !input.equals(scelta2));
        return input;
    }
}
