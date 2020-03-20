package com.company.Viva1;

import com.sun.javafx.image.IntPixelGetter;
import com.sun.media.jfxmediaimpl.HostUtils;

import java.util.ArrayList;
import java.util.Collections;

public class Viva1 {

    Integer[] a = {1, 2, 3, 4, 5 ,6};
    Integer[] b = {1, 2, 5, 9, 13};
    Integer[] c = {1, 2, 5, 9, 13, 14};
    Integer[] d = {1, 2, 5, 9, 13};
    Integer[] e = {1, 2, 3};

    public Viva1() {

        //Q1
        Set<Integer> A = new Set<Integer>(a);
        Set<Integer> B = new Set<Integer>(b);
        Set<Integer> C = new Set<Integer>(c);
        Set<Integer> D = new Set<Integer>(d);
        Set<Integer> E = new Set<Integer>(e);

//        System.out.println(A.toString());
//        System.out.println(B.toString());
//        System.out.println(C.toString());
//        System.out.println(D.toString());
//
//        Set<Integer> AunionB = A.union(B);
//        System.out.println(AunionB.toString());
//
//        Set<Integer> AintersectB = A.intersection(B);
//        System.out.println(AintersectB.toString());
//
//        Set<Integer> AcomplementB = A.complement(B);
//        System.out.println(AcomplementB.toString());
//
//        System.out.println(B.isSet(C));
//        System.out.println(B.isSet(D));


        //Q2
        Set<Set<Integer>> powerSet = C.PowerSet();
        System.out.println();
        System.out.println("Set C: " + C.toString());
        System.out.println("P(S) of Set C: " + powerSet.toString());

        //Q3
//        int count = 0;
//
//        Integer[] w = new Integer[500];
//        for (int i = 1; i < 500; i++) {
//            if (i % 2 == 0) {
//                w[count] = i;
//                count++;
//            }
//        }
//        Set<Integer> W = new Set<>(w);
//        System.out.println(W.toString());
//
//        Integer[] x = new Integer[500];
//        int a;
//        for (int i = 1; i < 500; i++) {
//            a = 2;
//            while (i % a != 0) a++;
//            if (i == a) {
//                x[count] = i;
//                count++;
//            }
//        }
//        Set<Integer> X = new Set<>(x);
//        System.out.println(X.toString());
//
//        Integer[] y = new Integer[500];
//        count = 0;
//        for (int i = 1; i < 500; i++) {
//            if ((int)Math.sqrt(i) == (double)Math.sqrt(i)) {
//                y[count] = i;
//                count++;
//            }
//        }
//        Set<Integer> Y = new Set<>(y);
//        System.out.println(Y.toString());
//
//        Integer[] z = new Integer[500];
//        count = 0;
//        for (int i = 1; i < 500; i++) {
//            if (i % 7 == 0) {
//                z[count] = i;
//                count++;
//            }
//        }
//        Set<Integer> Z = new Set<>(z);
//        System.out.println(Z.toString());
//
//        Set[] sets = {W, X ,Y ,Z};
//        //TotalElements(sets);
//        System.out.println(
//                A.cardinality() + B.cardinality() + C.cardinality() + D.cardinality() - A.intersection(B).cardinality() -
//                        B.intersection(C).cardinality() - C.intersection(D).cardinality() - A.intersection(D).cardinality() +
//                        A.intersection(B).intersection(C).cardinality() + B.intersection(C).intersection(D).cardinality() +
//                        A.intersection(B).intersection(D).cardinality() - A.intersection(B).intersection(C).intersection(D).cardinality()
//        );
    }
//
//    private void TotalElements(Set[] sets) {
//        for (int i = 0; i < sets.length; i++) {
//
//        }
//    }


}
