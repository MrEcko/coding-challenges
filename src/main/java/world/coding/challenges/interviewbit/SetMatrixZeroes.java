package world.coding.challenges.interviewbit;

import java.util.*;

/**
 * https://www.interviewbit.com/problems/set-matrix-zeros/
 */
public class SetMatrixZeroes {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        Set<Integer> emptyCols = new HashSet<>();
        Set<Integer> emptyRows = new HashSet<>();
        if (a != null && a.size() > 0) {
            for (int i=0; i < a.size(); i++){
                ArrayList<Integer> row = a.get(i);
                if (row != null){
                    for (int j=0; j < row.size(); j++){
                        if (row.get(j) == 0){
                            emptyRows.add(i);
                            emptyCols.add(j);
                        }
                    }
                }
            }


            for (int i=0; i < a.size(); i++){
                if (emptyRows.contains(i)){
                    ArrayList<Integer> row = a.get(i);
                    for (int j=0; j < a.get(i).size(); j++){
                        row.set(j,0);
                    }
                } else{
                    ArrayList<Integer> row = a.get(i);
                    for (Integer colIdx : emptyCols){
                        row.set(colIdx,0);
                    }
                }

            }
        }
    }
}
