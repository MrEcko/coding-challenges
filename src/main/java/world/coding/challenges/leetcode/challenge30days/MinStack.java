package world.coding.challenges.leetcode.challenge30days;

import java.util.NoSuchElementException;

public class MinStack {

    public MinStack() {}

    public StackElement top;

    public void push(int x) {
        if(top == null){
            top = new StackElement(x, x);
        }else{
            StackElement newTop = new StackElement(x, Math.min(x,top.min));
            newTop.below = top;
            top = newTop;
        }
    }

    public void pop() {
        if(top != null){
            StackElement newTop = top.below;
            top.below = null;
            top = newTop;
        }
    }

    public int top() {
        if (top == null) throw new NoSuchElementException("Can't get top on an empty MinStack");
        return top.value;
    }

    public int getMin() {
        if (top == null) throw new NoSuchElementException("Can't get min on an empty MinStack");
        return top.min;
    }

    private final static class StackElement {
        public int value;
        public int min;
        public StackElement below;

        public StackElement(int value, int min){
            this.value = value;
            this.min = min;
        }
    }
}
