/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.leeds.ccg.andyt.projects.moses.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author geoagdt
 */
public class Moses_Collections {
    
        public static HashSet getRandomIndexes_HashSet(Vector v,
            int n, Random r) {
        HashSet toSwap = new HashSet();
        int aIndex;
        int count = 0;
        if (n > v.size() / 2) {
            for (aIndex = 0; aIndex < v.size(); aIndex++) {
                toSwap.add(aIndex);
                count++;
            }
            while (count != n) {
                do {
                    aIndex = r.nextInt(v.size());
                } while (!toSwap.remove(aIndex));
                count--;
            }
        } else {
            while (count < n) {
                do {
                    aIndex = r.nextInt(v.size());
                } while (!toSwap.add(aIndex));
                count++;
            }
        }
        return toSwap;
    }
}
