
import Materia.controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        ArbolBinario ab = new ArbolBinario();

        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);

        System.out.println("nombre: Elkin Chamba");
        System.out.println();

        System.out.println("Peso del arbol:" + ab.calcularpeso());
        System.out.println("Altura del arbol:" + ab.getHeight());
        System.out.println();
        System.out.println("Arbol en InOrder:");
        ab.imprimirInOrderSimple();
        System.out.println();
        System.out.println("Arbol en InOrder con alturas:");
        ab.imprimirInOrder();
        System.out.println();
        System.out.println("Arbol en InOrder con Factor de Equilibrio:");
        ab.factorDeEquilibrio();
        System.out.println();
        System.out.println();
        System.out.println("Arbol esta equilibrado: " + ab.ArbolEquilibrado());
        ab.insert(15);
        System.out.println("Agregamos el valor = 15");
        System.out.println();
        System.out.println("Arbol InOrder con Factor de Equilibrio despues de agregar el 15:");
        ab.factorDeEquilibrio();
        System.out.println();
        System.out.println("\nNodos desequilibrados:");
        ab.imprimirNodosDesequilibrados();

    }
}
