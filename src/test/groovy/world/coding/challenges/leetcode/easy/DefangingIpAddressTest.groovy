package world.coding.challenges.leetcode.easy;

import spock.lang.Shared;
import spock.lang.Specification;

class DefangingIpAddressTest extends Specification {
    @Shared
    private static DefangingIpAddress DefangingIpAddress = new DefangingIpAddress()

    def "DefangingIpAddress"() {
        expect:
        DefangingIpAddress.defangIPaddr(input) == expectedOut

        where:
        input     || expectedOut
        "1.1.1.1" || "1[.]1[.]1[.]1"
    }
}

