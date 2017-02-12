import spoon.Launcher;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;
import spoon.reflect.factory.Factory;
import spoon.reflect.visitor.filter.TypeFilter;

import java.util.ArrayList;

public class Analyse  {

    public static void main(String[] args) {
        ArrayList<CtMethod<?>> listMethods = new ArrayList<CtMethod<?>>();
        ArrayList<CtMethod<?>> listMethodsToKeep = new ArrayList<CtMethod<?>>();
        ArrayList<CtMethod<?>> mainMethods = new ArrayList<CtMethod<?>>();

        Launcher spoon = new Launcher();
        spoon.addInputResource("src/main/resources/");
        spoon.run();
        Factory factory = spoon.getFactory();

        // recuperation de la liste complete des methodes du projet a analyser.
        for (CtType<?> s : factory.Class().getAll()) {
            for (CtMethod<?> m : s.getMethods()) {
                listMethods.add(m);
            }
        }

        // recuperation des methodes main du projet a analyser.
        for (CtMethod<?> m : factory.Method().getMainMethods()) {
            mainMethods.add(m);
        }

        // pour chacune des methodes main
        for (CtMethod<?> mainMethod : mainMethods) {
            //on recupere toute les invocations dans le corp de la methode
            for (CtInvocation<?> i : (ArrayList<CtInvocation<?>>) mainMethod.getBody().getElements(new TypeFilter(CtInvocation.class))) {
                //P
                //for (CtInvocation<?> l : (ArrayList<CtInvocation<?>>) i.getElements(new TypeFilter(CtInvocation.class))) {
                    String rep = pickMethodNameFromAnCtInvocation(i);

                    for (CtMethod<?> m : listMethods) {
                        if (rep.equals(m.getSimpleName())) {
                            System.out.println("get a match");
                            listMethodsToKeep.add(m);
                            System.out.println(m.getBody().getElements(new TypeFilter(CtInvocation.class)));
                        }
                    }
                //}
            }

        }

    }

    private static String pickMethodNameFromAnCtInvocation(CtInvocation<?> invocation){
        String rep = invocation.getShortRepresentation();
        rep = rep.split("#")[1];
        rep = rep.split("\\(")[0];
        System.out.println(rep);
        return rep;
    }
}
