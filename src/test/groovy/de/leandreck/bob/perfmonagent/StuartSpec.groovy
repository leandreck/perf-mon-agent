package de.leandreck.bob.perfmonagent

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

import java.lang.instrument.Instrumentation

/**
 * @author Mathias Kowalzik (leandreck.org) 2017.
 */
@Subject(Stuart)
class StuartSpec extends Specification {

    @Unroll
    def "if premain is called with args '#args' and instrumentation '#instrumentation'"() {
        given: "a Stuart"

        when: "premain is called"
        Stuart.premain(args, instrumentation)

        then: "there was no error and no method was called on instrumentation"
        0 * _._ //shortcut for 0 calls of any method call on any mock object

        where: "possible values are"
        args     | instrumentation
        null     | null
        ""       | null
        "fooBar" | null
        "bogus"  | Mock(Instrumentation)
    }
}