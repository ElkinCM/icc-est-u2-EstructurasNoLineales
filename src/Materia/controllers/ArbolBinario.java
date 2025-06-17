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
            //me voy a la izquierda
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            //me voy a la derecha
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


}
