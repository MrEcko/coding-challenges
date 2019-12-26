package world.coding.challenges.codility;

/**
 * A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
 *
 * Array A contains only 0s and/or 1s:
 *
 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
 *
 * For example, consider array A such that:
 *
 *   A[0] = 0
 *   A[1] = 1
 *   A[2] = 0
 *   A[3] = 1
 *   A[4] = 1
 * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
 *
 * The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
 *
 * For example, given:
 *
 *   A[0] = 0
 *   A[1] = 1
 *   A[2] = 0
 *   A[3] = 1
 *   A[4] = 1
 * the function should return 5, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 */
public class PassingCars {

    public int solution(int[] A) {
        int output = 0;

        //suffix sum
        int[] carsGoWest = new int[A.length + 1];
        for (int i = A.length - 1; i >= 0; i--) {
            if (carGoesWest(A[i])) { //here's another car
                carsGoWest[i] = carsGoWest[i + 1] + 1;
            } else { // number stays the same
                carsGoWest[i] = carsGoWest[i + 1];
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (carGoesEast(A[i])) {
                output += carsGoWest[i];
            }
        }

        if (Math.abs(output) > 1000000000) {
            output = -1;
        }
        return output;
    }


    public int solution2(int[] A) {
        int output = 0;

        //prefix sum
        int[] carsGoEast = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            if (carGoesEast(A[i])) { //here's another car
                carsGoEast[i+1] = carsGoEast[i] + 1;
            } else { // number stays the same
                carsGoEast[i+1] = carsGoEast[i];
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (carGoesWest(A[i])) {
                output += carsGoEast[i+1];
            }
        }

        if (Math.abs(output) > 1000000000) {
            output = -1;
        }
        return output;
    }

    boolean carGoesWest(int carDirection) {
        return carDirection == 1;
    }

    boolean carGoesEast(int carDirection) {
        return carDirection == 0;
    }
}
