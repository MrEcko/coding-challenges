package world.coding.challenges.leetcode.challenge30days


import spock.lang.Specification
import spock.lang.Unroll

class MinStackTest extends Specification {

    @Unroll
    def "MinStack"() {
        given:
        MinStack solution = new MinStack()

        expect:
        for (int i = 0; i<ops.size(); i++){
            switch (ops[i]) {
                case "push":
                    solution.push(vals[i][0] as int);
                    break;
                case "pop":
                    solution.pop();
                    break;
                case "getMin":
                    assert solution.getMin() == output[i]
                    break;
                case "top":
                    assert solution.top() == output[i]
                    break;
            }
        }


        where:
        ops | vals ||output
        ["MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"] | [[],[-2],[0],[-3],[],[],[],[]] || [null,null,null,null,-3,null,0,-2]
        ["MinStack", "push", "push", "push", "top", "pop", "getMin", "pop", "getMin", "pop", "push", "top", "getMin", "push", "top", "getMin", "pop", "getMin"] | [[], [2147483646], [2147483646], [2147483647], [], [], [], [], [], [], [2147483647], [], [], [-2147483648], [], [], [], []] || [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
    }
}

