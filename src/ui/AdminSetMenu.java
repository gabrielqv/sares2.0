package com.kagada.sares.ui;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

class Node {
    public Node right;
    public Node left;
    String data;
    long quantity;

    public Node(String newString, int quantity) {
        data = newString;
        this.quantity = quantity;
        left = null; right = null;
    }
}
class myThree{
    private Node root;
    public int count;
    int height,cacheHeight = 0;

    public myThree(){
        count = 0;
        root = null;

    }
    public void insertPublic(String newString,int quantity){
        root = insert( newString, root,  quantity);
        cacheHeight = 0;
        count ++;

    }
    public void insertPublic(String newString,int quantity,String debug){
        long start = System.nanoTime();
        root = insert( newString, root,  quantity);
        cacheHeight = 0;
        long end = System.nanoTime() - start;
        Notification.show(String.valueOf(end/1000) + " Miliseconds");
        count ++;

    }
    private Node insert(String newString, Node p, int quantity) {
        cacheHeight++;
        if(p == null) {
            p = new Node(newString,quantity);
            if(cacheHeight>height) height = cacheHeight;
        } else if(newString.compareTo(p.data)>0) {
            p.left = insert(newString,p.left,quantity );
        } else if(newString.compareTo(p.data)<0) {
            p.right=insert(newString,p.right,quantity );
        } else
        System.out.println("Item in tree and not inserted.");
        return p;
    }
    public void traverseBST() {
        Notification.show("THREE");
        if (root != null) traverse(root);
        else Notification.show("EMPTY");
    }
    public void traverseBST(String debugging) {
        Notification.show("THREE of size " + count + " was traversed in ");
        long start = System.nanoTime();

        if (root != null) traverseTester(root);
        else Notification.show("EMPTY");
        long end = System.nanoTime() - start;

        Notification.show(String.valueOf(end/1000) + " Miliseconds");
    }
    private void traverse(Node ptr) {
        if(ptr.left != null)
        traverse(ptr.left);
        Notification.show(" " + ptr.data);
        if(ptr.right != null)
        traverse(ptr.right);
    }
    private void traverseTester(Node ptr) {
        if(ptr.left != null)
        traverseTester(ptr.left);
        if(ptr.right != null)
        traverseTester(ptr.right);
    }





}
@Route("AdminSet")
public class AdminSetMenu extends VerticalLayout {

    public AdminSetMenu() {

        HorizontalLayout prin = new HorizontalLayout();
        TextField plato = new TextField("Plato");
        NumberField cantidad = new NumberField("Cantidad");
        Button addPrin = new Button("Añadir");
//        addPrin.addClickListener(click ->
//                Storage.principales.put(plato.getValue(), cantidad.getValue().intValue())
//        );
        addPrin.addClickListener(click ->
               add( new Span(plato.getValue()))
        );
//        addPrin.addClickShortcut(Key.ENTER);
        add(new HorizontalLayout(plato,cantidad),addPrin);

//        HorizontalLayout prin = new HorizontalLayout();
        TextField plato2 = new TextField("Acompañamiento");
        NumberField cantidad2 = new NumberField("Cantidad");
        Button addPrin2 = new Button("Añadir");
//        addPrin2.addClickListener(click ->
//        );
//        addPrin2.addClickShortcut(Key.ENTER);
        Button guardar = new Button("Guardar");
        guardar.addClickListener(click ->
                guardar.getUI().ifPresent(ui ->
                        ui.navigate("Admin"))
        );


        add(new HorizontalLayout(plato2,cantidad2),new HorizontalLayout(addPrin2,guardar));
//        prin.add( plato, cantidad, addPrin);


    myThree testThree = new myThree();

        Random r = new Random();
        int bound = 10_000_000;
        bound = 10;
        long n = r.nextInt(bound);
Notification.show("quantity of data is "+ String.valueOf(n));
        for(int i = 0; i<n; i++){

    testThree.insertPublic(String.valueOf(r.nextInt()),10);;
    }

    testThree.insertPublic(String.valueOf(r.nextInt()),10,"debugging = True");
    }
}
