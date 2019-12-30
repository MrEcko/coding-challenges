package world.coding.challenges.codility;

import java.util.*;

public class Fish {
    private static final int UP = 0;
    private static final int DOWN = 1;

    public int solution(int[] A, int[] B) {
        int n = A.length;
        Stack<Fishie> survivors = new Stack<>();
        for (int pos=0; pos<n; pos++){
            Fishie currentFish = new Fishie(A[pos],B[pos]);
            if (survivors.isEmpty()){
                survivors.push(currentFish);
            } else {
                Fishie previousFish = survivors.peek();
                if (currentFish.met(previousFish)) {
                    boolean isCurrentFishAlive = true;
                    while (!survivors.isEmpty() && survivors.peek().getDirection() != currentFish.getDirection()) {
                        if (survivors.peek().getSize() < currentFish.getSize()) {
                            survivors.pop();
                        } else {
                            isCurrentFishAlive = false;
                            break;
                        }
                    }
                    if (isCurrentFishAlive) {
                        survivors.push(currentFish);
                    }
                } else {
                    survivors.push(currentFish);
                }
            }
        }
        return survivors.size();
    }

    class Fishie{
        private final int direction;
        private final int size;

        public Fishie(int size, int direction){
            this.size = size;
            this.direction = direction;
        }
        public int getSize(){
            return this.size;
        }
        public int getDirection(){
            return this.direction;
        }

        public boolean met(Fishie fish){
            return this.direction == UP && fish.getDirection() == DOWN;
        }

        public String toString(){
            return (direction == UP ? "<":"") +"-"+size +"-" + (direction == DOWN ? ">":"");
        }
    }
}
