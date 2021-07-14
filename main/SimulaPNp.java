import java.util.*;

public class SimulaPNp implements SimulaRete
{
    private Rete rete;

    public Rete getRete(){
        return this.rete;
    }

    public SimulaPNp(Rete r)
    {
        this.rete = r;
    }

    public ArrayList<TransizionePNp> transizioniAbilitate()
    {
        ArrayList<TransizionePNp> transizioniAbil = new ArrayList<>();
        TransizionePNp tN, tNAux;
        ElementoPNp elPN;
        PostoPN pPNAux;
        int marcatura, peso;
        for(int i = 0; i < this.rete.transizioniSize(); i++) {
            tN = (TransizionePNp) this.rete.getTransizione(i);
            boolean abil = true;
            for (int k = 0; k < this.rete.size(); k++) {
                elPN = (ElementoPNp) this.rete.getElement(k);
                pPNAux = (PostoPN) elPN.getPosto();
                tNAux = (TransizionePNp) elPN.getTransazione();
                if (elPN.getVerso() && tN.getID() == tNAux.getID()) {
                    marcatura = pPNAux.getMarcatura();
                    peso = elPN.getPeso();
                    if (marcatura - peso < 0)
                        abil = false;
                }
            }
            if (abil)
                transizioniAbil.add(tN);
        }
        return transizioniAbil;
    }
    
    public ArrayList<TransizionePNp> transizioniAbilitatePriority()
    {
        ArrayList<TransizionePNp> transizioniAbil = new ArrayList<>();
        int max = 0;
        for(TransizionePNp trans : transizioniAbilitate()) {
            max = Math.max(trans.getPriorita(), max);
        }

        for(TransizionePNp trans : transizioniAbilitate()) {
            if(trans.getPriorita() == max)
                transizioniAbil.add(trans);
        }
        return transizioniAbil;
    }

    public int scattaTransizione(TransizionePNp trans)
    {
        int marcaturaNew;
        ElementoPNp elPN;
        PostoPN pPN;
        ArrayList<PostoPN> scatto1 = getScatto1(predecessori(trans), successori(trans));
        ArrayList<PostoPN> scatto2 = getScatto2(predecessori(trans), successori(trans));
        ArrayList<PostoPN> scatto3 = getScatto3(predecessori(trans), successori(trans));


        for(PostoPN posto : scatto1)
        {
            marcaturaNew = posto.getMarcatura() - getPeso(posto, trans);

            for(int i = 0; i < this.rete.size(); i++)
            {
                elPN = (ElementoPNp) this.rete.getElement(i);
                pPN = (PostoPN) elPN.getPosto();
                if(pPN.getID() == posto.getID())
                    pPN.setMarcatura(marcaturaNew);
            }
        }

        for(PostoPN posto : scatto2)
        {
            marcaturaNew = posto.getMarcatura() + getPeso(trans, posto);

            for(int i = 0; i < this.rete.size(); i++)
            {
                elPN = (ElementoPNp) this.rete.getElement(i);
                pPN = (PostoPN) elPN.getPosto();
                if(pPN.getID() == posto.getID())
                    pPN.setMarcatura(marcaturaNew);
            }
        }

        for(PostoPN posto : scatto3) {
            marcaturaNew = posto.getMarcatura() - getPeso(posto, trans) + getPeso(trans, posto);

            for(int i = 0; i < this.rete.size(); i++)
            {
                elPN = (ElementoPNp) this.rete.getElement(i);
                pPN = (PostoPN) elPN.getPosto();
                if(pPN.getID() == posto.getID())
                    pPN.setMarcatura(marcaturaNew);
            }
        }

        return trans.getID();
    }

    // Metodo per ritornare solo i posti che fanno parte dei predecessori e non dei successori
    public ArrayList<PostoPN> getScatto1(ArrayList<PostoPN> prec, ArrayList<PostoPN> succ)
    {
        ArrayList<PostoPN> scatto = prec;
        for(PostoPN pre : scatto) {
            for(PostoPN suc : succ) {
                if(pre.equals(suc))
                    scatto.remove(suc);
            }
        }
        return scatto;
    }

    // Metodo per ritornare solo i posti che fanno parte dei successori e non dei predecessori
    public ArrayList<PostoPN> getScatto2(ArrayList<PostoPN> prec, ArrayList<PostoPN> succ){
        ArrayList<PostoPN> scatto = succ;
        for(PostoPN suc : scatto) {
            for(PostoPN pre : prec) {
                if(suc.equals(pre))
                    scatto.remove(pre);
            }
        }
        return scatto;
    }

    // Metodo per ritornare solo i posti che fanno parte sia dei predecessori che dei successori
    public ArrayList<PostoPN> getScatto3(ArrayList<PostoPN> prec, ArrayList<PostoPN> succ){
        ArrayList<PostoPN> scatto = new ArrayList<>();
        for(PostoPN suc : succ) {
            for(PostoPN pre : prec) {
                if(suc.equals(pre))
                    scatto.add(pre);
            }
        }
        return scatto;
    }

    // Metodo per avere i predecessori della transizione trans
    public ArrayList<PostoPN> predecessori(TransizionePNp trans)
    {
        ArrayList<PostoPN> pred = new ArrayList<>();
        ElementoPNp elPN;
        TransizionePNp tN;
        PostoPN pPN;
        for(int i = 0; i < this.rete.size(); i++)
        {
            elPN = (ElementoPNp) this.rete.getElement(i);
            tN = (TransizionePNp) elPN.getTransazione();
            if(tN.getID() == trans.getID() && elPN.getVerso())
            {
                pPN = (PostoPN) elPN.getPosto();
                pred.add(pPN);
            }
        }
        return pred;
    }

    // Metodo per avere i successori della transizione trans
    public ArrayList<PostoPN> successori(TransizionePNp trans)
    {
        ArrayList<PostoPN> succ = new ArrayList<>();
        ElementoPNp elPN;
        TransizionePNp tN;
        PostoPN pPN;
        for(int i = 0; i < this.rete.size(); i++)
        {
            elPN = (ElementoPNp) this.rete.getElement(i);
            tN = (TransizionePNp) elPN.getTransazione();
            if(tN.getID() == trans.getID() && !elPN.getVerso())
            {
                pPN = (PostoPN) elPN.getPosto();
                succ.add(pPN);
            }
        }
        return succ;
    }

    public int getPeso(TransizionePNp trans, PostoPN posto)
    {
        ElementoPNp elPN;
        PostoPN pPN;
        TransizionePNp tN;
        for(int i = 0; i < this.rete.size(); i++)
        {
            elPN = (ElementoPNp) this.rete.getElement(i);
            pPN = (PostoPN) elPN.getPosto();
            tN = (TransizionePNp) elPN.getTransazione();
            if(pPN.getID() == posto.getID() && tN.getID() == trans.getID() && !elPN.getVerso())
                return elPN.getPeso();
        }
        return 0;
    }

    public int getPeso(PostoPN posto, TransizionePNp trans)
    {
        ElementoPNp elPN;
        PostoPN pPN;
        TransizionePNp tN;
        for(int i = 0; i < this.rete.size(); i++)
        {
            elPN = (ElementoPNp) this.rete.getElement(i);
            pPN = (PostoPN) elPN.getPosto();
            tN = (TransizionePNp) elPN.getTransazione();
            if(pPN.getID() == posto.getID() && tN.getID() == trans.getID() && elPN.getVerso())
                return elPN.getPeso();
        }
        return 0;
    }
}
