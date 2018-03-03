package bowlingstats

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PinPatternSpec extends Specification implements DomainUnitTest<PinPattern> {

    def setup() {
    }

    def cleanup() {
    }

    void "test default value"() {
        given:
        def pinPattern = new PinPattern().save()

        expect:"default pin true"
        pinPattern.pin1
        pinPattern.pin2
        pinPattern.pin3
        pinPattern.pin4
        pinPattern.pin5
        pinPattern.pin6
        pinPattern.pin7
        pinPattern.pin8
        pinPattern.pin9
        pinPattern.pin10
    }
}
