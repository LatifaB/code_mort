import spoon.Launcher;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;
import spoon.reflect.factory.Factory;
import spoon.reflect.visitor.filter.TypeFilter;

import java.util.ArrayList;

public class Analyse  {
    private static ArrayList<CtMethod<?>> listMethods = new ArrayList<CtMethod<?>>();
    private static ArrayList<CtMethod<?>> listMethodsToKeep = new ArrayList<CtMethod<?>>();
    private static ArrayList<CtMethod<?>> mainMethods = new ArrayList<CtMethod<?>>();
    private static ArrayList<CtMethod<?>> listDeadMethod = new ArrayList<CtMethod<?>>();

    public static void main(String[] args) {

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
        /*for(CtMethod<?> m : listMethods) {
            System.out.println(m.getParent().getShortRepresentation() + " " + m.getShortRepresentation());
        }*/

        // recuperation des methodes main du projet a analyser.
        for (CtMethod<?> m : factory.Method().getMainMethods()) {
            mainMethods.add(m);
            listMethodsToKeep.add(m);
        }


        // pour chacune des methodes main
        for (CtMethod<?> mainMethod : mainMethods) {
            flowOfInvocation(mainMethod);
        }

        listDeadMethod = new ArrayList<CtMethod<?>>(listMethods);
        listDeadMethod.removeAll(listMethodsToKeep);
        /*System.out.println("All methods in the project : " + listMethods.size());
        System.out.println("Dead methods : " + listDeadMethod.size());
        System.out.println("List of dead methods : ");
        for(CtMethod<?> m : listMethods) {
            System.out.println(m.getParent().getShortRepresentation() + " " + m.getShortRepresentation());
        }
        System.out.println("\nList of keep methods : ");
        for(CtMethod<?> m : listMethodsToKeep) {
            System.out.println(m.getParent().getShortRepresentation() + " " + m.getShortRepresentation());
        }
*/
    }

    private static void flowOfInvocation(CtMethod<?> method){

        /* CtConstructeurCall */

        //on recupere toute les invocations dans le corp de la methode
        for (CtInvocation<?> i : (ArrayList<CtInvocation<?>>) method.getBody().getElements(new TypeFilter(CtInvocation.class))) {

            //pour chaque invocation on recupere le nom de la methode pour retrouve sa ctmethode dans la liste des methodes
            String rep = pickMethodNameAndClassFromAnCtInvocation(i);
            for (CtMethod<?> m : listMethods) {
                if (rep.equals(m.getSimpleName()) && ifNotAlreadyVerified(rep)) {
                    System.out.println(rep + " " + m.getSimpleName());
                    // on enregistre le pasage dans la methode dans une liste de methode visite
                    listMethodsToKeep.add(m);
                    flowOfInvocation(m);

                }
            }
        }
    }

    private static boolean ifNotAlreadyVerified(String method){
        for (CtMethod<?> m : listMethodsToKeep){
            if (method.equals(m.getSimpleName())) {
                return false;
            }
        }
        return true;
    }

    private static String pickMethodNameAndClassFromAnCtInvocation(CtElement invocation){
        String representation = invocation.getShortRepresentation();
        representation = representation.split("#")[1];
        representation = representation.split("\\(")[0];
        return representation;
    }
}
