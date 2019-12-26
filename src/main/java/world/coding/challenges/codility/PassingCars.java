package world.coding.challenges.codility;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
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
