package com.sacrederp


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LogInterceptor)
class LogInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test log interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"log")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
