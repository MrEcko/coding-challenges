package world.coding.challenges.codility;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 */
public class FrogJmp {

    /**
     * Assumption: X <= Y
     *
     * @param X start position
     * @param Y end position (min)
     * @param D step
     * @return  minimal number of jumps from position X to a position equal to or greater than Y.
     */
    public int solution(int X, int Y, int D){
        int output = 0;
        if ( X<=Y && D > 0){
            int minJumps = (Y-X) / D;
            if (minJumps * D < (Y-X)){
                minJumps++;
            }
            output = minJumps;
        }
        return output;
    }
}
