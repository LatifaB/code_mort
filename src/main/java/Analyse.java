import spoon.Launcher;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;
import spoon.reflect.factory.Factory;
import spoon.reflect.visitor.filter.TypeFilter;

import java.util.ArrayList;

public class Analyse  {

    public static void main(String[] args) {
        ArrayList<CtMethod<?>> listMethods = new ArrayList<CtMethod<?>>();
        CtMethod<?> mainMethod = null;

        Launcher spoon = new Launcher();
        spoon.addInputResource("src/main/resources/");
        spoon.run();
        Factory factory = spoon.getFactory();

        for (CtType<?> s : factory.Class().getAll()) {
            for (CtMethod<?> m : s.getMethods()) {
                listMethods.add(m);
                System.out.println("class: " + s.getQualifiedName() + " method: " + m.getSignature());
            }
        }

        for (CtMethod<?> m : factory.Method().getMainMethods()) {
            mainMethod = m;
            System.out.println("method: " + m.getSignature());
        }

        for (Object m : mainMethod.getBody().getElements(new TypeFilter(CtInvocation.class))){
            System.out.println("invocation : " + m.toString());
        }

    }
}
