package world.coding.challenges.leetcode.medium;

import spock.lang.Shared;
import spock.lang.Specification;

class AccountsMergeTest extends Specification {
    @Shared
    private static AccountsMerge solution = new AccountsMerge()

    def "AccountsMerge"() {
        expect:
        solution.accountsMerge(input) == expectedOut

        where:
        input                                                                                                                                                                     || expectedOut
        [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]] || [["John", "johnnybravo@mail.com"], ["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'], ["Mary", "mary@mail.com"]]


    }
}

