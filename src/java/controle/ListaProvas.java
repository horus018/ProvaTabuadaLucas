package controle;

import dados.Prova;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

@ManagedBean
@Named(value = "ListaProvas")
@ApplicationScoped
public class ListaProvas {
    
    public static ArrayList<Prova> listaProvas = new ArrayList<>();

    public ArrayList<Prova> getListaProvas() {
        return listaProvas;
    }

    public static String contemProvaComMatricula(int matricula) {
        for (Prova prova : listaProvas) {
            if (prova.getNumeroMatricula() == matricula) {
                return prova.getDataProva();
            }
        }
        return null;
    }

    static void add(Prova atual) {
        listaProvas.add(atual);
    }
    
    public ArrayList<Prova> getListaProvasOrdenadaPorNota() {
        ArrayList<Prova> listaOrdenada = new ArrayList<>(listaProvas);
        Collections.sort(listaOrdenada, new Comparator<Prova>() {
            @Override
            public int compare(Prova prova1, Prova prova2) {
                return Double.compare(prova2.getNota(), prova1.getNota());
            }
        });
        return listaOrdenada;
    }

}
