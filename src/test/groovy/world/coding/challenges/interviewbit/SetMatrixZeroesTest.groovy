package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class SetMatrixZeroesTest extends Specification {
    @Shared
    private static SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes()

    def "SetMatrixZeroes"() {

        given:
        ArrayList<ArrayList<Integer>> input = [[0, 1, 1, 1], [1, 1, 1, 1], [0, 1, 1, 1], [1, 1, 1, 0]]
        ArrayList<ArrayList<Integer>> expectedOutput = [[0, 0, 0, 0], [0, 1, 1, 0], [0, 0, 0, 0], [0, 0, 0, 0]]

        when:
        setMatrixZeroes.setZeroes(input)

        then:
        input == expectedOutput
    }
}

