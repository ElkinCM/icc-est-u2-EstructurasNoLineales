package Materia.controllers;

import Materia.models.Node;

public class ArbolBinario {
    private Node root;
    
    public ArbolBinario() {
        this.root = null;
    }
    
    public void insert(int value) {
        root = insertRec(root, value);
    }
    
    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            return new Node(value);
        }
        if (value < padre.getValue()) {
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    private void imprimir(Node node) {
        if (node != null){
            System.out.print(node.getValue() + ", ");
            imprimir(node.getLeft());
            imprimir(node.getRight());
        }
    }

    public void imprimirArbol() {
        imprimir(root);
    }

    public boolean buscar(int value) {
        return buscarRec(root, value);
    }

    private boolean buscarRec(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.getValue()) {
            return true;
        }
        if (value < node.getValue()) {
            return buscarRec(node.getLeft(), value);
        } else {
            return buscarRec(node.getRight(), value);
        }
    }

    public int getHeight() {
        return getHeightRec(root);
    }

    private int getHeightRec(Node node) {
        if (node == null) {
            return 0;
        }
        int leftheight = getHeightRec(node.getLeft());
        int rightheight = getHeightRec(node.getRight());
        return Math.max(leftheight, rightheight) + 1;
    }

    public int calcularpeso() {
        return calcularpesoRec(root);
    }

    private int calcularpesoRec(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + calcularpesoRec(node.getLeft()) + calcularpesoRec(node.getRight());
    }

    public void imprimirInOrderSimple() {
        imprimirInOrderSimpleRec(root);
        System.out.println();
    }

    private void imprimirInOrderSimpleRec(Node node) {
        if (node == null) {
            return;
        }
        imprimirInOrderSimpleRec(node.getLeft());
        System.out.print(node.getValue() + ", ");
        imprimirInOrderSimpleRec(node.getRight());
    }

    public void imprimirInOrder() {
        imprimirInOrderRec(root);
        System.out.println();
    }

    private void imprimirInOrderRec(Node node) {
        if (node == null) {
            return;
        }
        imprimirInOrderRec(node.getLeft());
        int profundidad = alturaDeNodo(node.getValue());
        System.out.print(node.getValue() + "[ h = " + profundidad + " ], ");
        imprimirInOrderRec(node.getRight());
    }

    public void factorDeEquilibrio() {
        factorDeEquilibrioRec(root);
    }

    private void factorDeEquilibrioRec(Node node) {
        if (node == null) {
            return;
        }
        factorDeEquilibrioRec(node.getLeft());
        int alturaIzquierda = getHeightRec(node.getLeft());
        int alturaDerecha = getHeightRec(node.getRight());
        int factor = alturaIzquierda - alturaDerecha;
        System.out.print("Nodo: " + node.getValue() + " | Factor: " + factor + ", ");
        factorDeEquilibrioRec(node.getRight());
    }

    public int alturaDeNodo(int value) {
        return alturaDeNodoRec(root, value, 0);
    }

    private int alturaDeNodoRec(Node node, int value, int altura) {
        if (node == null) {
            return -1;
        }
        if (node.getValue() == value) {
            return altura;
        }
        if (value < node.getValue()) {
            return alturaDeNodoRec(node.getLeft(), value, altura + 1);
        } else {
            return alturaDeNodoRec(node.getRight(), value, altura + 1);
        }
    }

    public boolean ArbolEquilibrado() {
        return esEquilibrado(root);
    }

    private boolean esEquilibrado(Node node) {
        if (node == null) {
            return true;
        }
        int alturaIzquierda = getHeightRec(node.getLeft());
        int alturaDerecha = getHeightRec(node.getRight());
        if (Math.abs(alturaIzquierda - alturaDerecha) > 1) {
            return false;
        }
        return esEquilibrado(node.getLeft()) && esEquilibrado(node.getRight());
    }

    public void imprimirNodosDesequilibrados() {
        imprimirNodosDesequilibradosRec(root);
    }

    private void imprimirNodosDesequilibradosRec(Node node) {
        if (node == null) return;

        int alturaIzquierda = getHeightRec(node.getLeft());
        int alturaDerecha = getHeightRec(node.getRight());
        int factor = alturaIzquierda - alturaDerecha;

        if (factor < -1 || factor > 1) {
            System.out.println("Nodo desequilibrado: " + node.getValue() + " | Factor: " + factor);
        }

        imprimirNodosDesequilibradosRec(node.getLeft());
        imprimirNodosDesequilibradosRec(node.getRight());
    }
}
