import java.util.*;

public class SimulaPN implements SimulaRete
{
    private Rete rete;

    public Rete getRete(){
        return this.rete;
    }

    public SimulaPN(Rete r)
    {
        this.rete = r;
    }

    public ArrayList<TransizioneN> transizioniAbilitate()
    {
        ArrayList<TransizioneN> transizioniAbil = new ArrayList<>();
        TransizioneN tN, tNAux;
        ElementoPN elPN;
        PostoPN pPNAux;
        int marcatura, peso;
        for(int i = 0; i < this.rete.transizioniSize(); i++) {
            tN = (TransizioneN) this.rete.getTransizione(i);
            boolean abil = true;
            for (int k = 0; k < this.rete.size(); k++) {
                elPN = (ElementoPN) this.rete.getElement(k);
                pPNAux = (PostoPN) elPN.getPosto();
                tNAux = (TransizioneN) elPN.getTransazione();
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

    public int scattaTransizione(TransizioneN trans)
    {
        int marcaturaNew;
        ElementoPN elPN;
        PostoPN pPN;
        ArrayList<PostoPN> scatto1 = getScatto1(predecessori(trans), successori(trans));
        ArrayList<PostoPN> scatto2 = getScatto2(predecessori(trans), successori(trans));
        ArrayList<PostoPN> scatto3 = getScatto3(predecessori(trans), successori(trans));


        for(PostoPN posto : scatto1)
        {
            marcaturaNew = posto.getMarcatura() - getPeso(posto, trans);

            for(int i = 0; i < this.rete.size(); i++)
            {
                elPN = (ElementoPN) this.rete.getElement(i);
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
                elPN = (ElementoPN) this.rete.getElement(i);
                pPN = (PostoPN) elPN.getPosto();
                if(pPN.getID() == posto.getID())
                    pPN.setMarcatura(marcaturaNew);
            }
        }

        for(PostoPN posto : scatto3) {
            marcaturaNew = posto.getMarcatura() - getPeso(posto, trans) + getPeso(trans, posto);

            for(int i = 0; i < this.rete.size(); i++)
            {
                elPN = (ElementoPN) this.rete.getElement(i);
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
    public ArrayList<PostoPN> predecessori(TransizioneN trans)
    {
        ArrayList<PostoPN> pred = new ArrayList<>();
        ElementoPN elPN;
        TransizioneN tN;
        PostoPN pPN;
        for(int i = 0; i < this.rete.size(); i++)
        {
            elPN = (ElementoPN) this.rete.getElement(i);
            tN = (TransizioneN) elPN.getTransazione();
            if(tN.getID() == trans.getID() && elPN.getVerso())
            {
                pPN = (PostoPN) elPN.getPosto();
                pred.add(pPN);
            }
        }
        return pred;
    }

    // Metodo per avere i successori della transizione trans
    public ArrayList<PostoPN> successori(TransizioneN trans)
    {
        ArrayList<PostoPN> succ = new ArrayList<>();
        ElementoPN elPN;
        TransizioneN tN;
        PostoPN pPN;
        for(int i = 0; i < this.rete.size(); i++)
        {
            elPN = (ElementoPN) this.rete.getElement(i);
            tN = (TransizioneN) elPN.getTransazione();
            if(tN.getID() == trans.getID() && !elPN.getVerso())
            {
                pPN = (PostoPN) elPN.getPosto();
                succ.add(pPN);
            }
        }
        return succ;
    }

    public int getPeso(TransizioneN trans, PostoPN posto)
    {
        ElementoPN elPN;
        PostoPN pPN;
        TransizioneN tN;
        for(int i = 0; i < this.rete.size(); i++)
        {
            elPN = (ElementoPN) this.rete.getElement(i);
            pPN = (PostoPN) elPN.getPosto();
            tN = (TransizioneN) elPN.getTransazione();
            if(pPN.getID() == posto.getID() && tN.getID() == trans.getID() && !elPN.getVerso())
                return elPN.getPeso();
        }
        return 0;
    }

    public int getPeso(PostoPN posto, TransizioneN trans)
    {
        ElementoPN elPN;
        PostoPN pPN;
        TransizioneN tN;
        for(int i = 0; i < this.rete.size(); i++)
        {
            elPN = (ElementoPN) this.rete.getElement(i);
            pPN = (PostoPN) elPN.getPosto();
            tN = (TransizioneN) elPN.getTransazione();
            if(pPN.getID() == posto.getID() && tN.getID() == trans.getID() && elPN.getVerso())
                return elPN.getPeso();
        }
        return 0;
    }
}
