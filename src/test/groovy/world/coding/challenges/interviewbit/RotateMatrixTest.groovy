package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class RotateMatrixTest extends Specification {
    @Shared
    private static RotateMatrix rotateMatrix = new RotateMatrix()

    def "RotateMatrix"() {
        given:
        ArrayList<ArrayList<Integer>> input = [[1, 2], [3, 4]]
        when:
        rotateMatrix.rotate(input as ArrayList<ArrayList<Integer>>)

        then:
        input == [[3, 1], [4, 2]] as ArrayList<ArrayList<Integer>>

    }
}

