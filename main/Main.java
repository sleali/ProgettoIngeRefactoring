public class Main
{
    public static void main(String[] args)
    {
        int scelta = 0;
        do
        {
            System.out.println("Menu principale\n1) Configuratore \n2) Fruitore \n\n0) Esci");
            scelta = InputDati.leggiIntero("Selezionare una delle voci del menu:", 0, 2);
            switch (scelta)
            {
                case 1:
                    System.out.println("\n");
                    configuratore();
                    break;
                case 2:
                    System.out.println("\n");
                    fruitore();
                    break;
                default:
                    System.out.println("\n");
                    System.out.println("Uscita in corso...");
                    break;
            }
        }
        while (scelta != 0);
    }

    public static void configuratore()
    {
        int scelta = 0;
        ControllerRepositoryN repoN = new ControllerRepositoryN();
        ControllerRepositoryPN repoPN = new ControllerRepositoryPN();
        ControllerRepositoryPNp repoPNp = new ControllerRepositoryPNp();
        do
        {
            System.out.println("Menu principale [utente: configuratore]\n1) Gestione reti N \n2) Gestione reti PN \n3) Gestione reti PNP\n\n0) Esci");
            scelta = InputDati.leggiIntero("Selezionare una delle voci del menu:", 0, 3);
            switch (scelta)
            {
                case 1:
                    System.out.println("\n");
                    Main_reti_N.reti_N(repoN);
                    break;
                case 2:
                    Main_rete_PN.reti_PN(repoN, repoPN);
                    break;
                case 3:
                    Main_rete_PNp.reti_PNp(repoPN, repoPNp);
                    break;
                default:
                    System.out.println("Uscita in corso...");
                    break;
            }
        }
        while (scelta != 0);
    }

    public static void fruitore()
    {
        int scelta = 0;
        ControllerRepositoryPN repoPN = new ControllerRepositoryPN();
        ControllerRepositoryPNp repoPNp = new ControllerRepositoryPNp();
        do
        {
            System.out.println("Menu principale [utente: fruitore]\n1) Simula reti PN \n2) Simula reti PNp \n\n0) Esci");
            scelta = InputDati.leggiIntero("Selezionare una delle voci del menu:", 0, 2);
            switch (scelta)
            {
                case 1:
                    System.out.println("\n");
                    Main_simula_PN.simula(repoPN);
                    break;
                case 2:
                    Main_simula_PNp.simula(repoPNp);
                    break;
                default:
                    System.out.println("Uscita in corso...");
                    break;
            }
        }
        while (scelta != 0);
    }
}
