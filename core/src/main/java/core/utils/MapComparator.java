package core.src.main.java.core.utils;

import core.src.main.java.core.structure.Dimensional;

import java.util.Comparator;
import java.util.Map;

public class MapComparator implements Comparator<Map<Dimensional,Integer>> {
    @Override
    public int compare(Map<Dimensional, Integer> o1, Map<Dimensional, Integer> o2) {
        for(Map.Entry<Dimensional,Integer> entry:o1.entrySet()){
            Dimensional dimensional=entry.getKey();
            int var1=o1.get(dimensional);
            int var2=o2.get(dimensional);
            if(var1<=var2){
                return -1;
            }
        }
        return 1;
    }
}
