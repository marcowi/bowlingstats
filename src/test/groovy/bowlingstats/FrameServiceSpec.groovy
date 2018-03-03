package bowlingstats

import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class FrameServiceSpec extends Specification implements ServiceUnitTest<FrameService>, DomainUnitTest<Frame> {

    def setup() {
    }

    def cleanup() {
    }

    void "is regular frame (1-9) strike"() {

        given: "first shot clearance"
        Frame frame = new Frame(num: 1)
        frame.addToShots(new Shot(num: 1, points: 10))

        expect:"strike"
        service.isStrike(frame.shots.first())

    }

    void "is first strike in final frame"() {

        given: "first shot clearance"
        Frame frame = new Frame(num: 10)
        frame.addToShots(new Shot(num: 1, points: 10))

        expect:"strike"
        service.isStrike(frame.shots.first())

    }

    void "is second strike in final frame"() {

        given: "second, first shot clearance"
        Frame frame = new Frame(num: 10)
        frame.addToShots(new Shot(num: 1, points: 10))
        frame.addToShots(new Shot(num: 2, points: 10))

        expect:"strike"
        service.isStrike(frame.shots[1])

    }

    void "is third strike in final frame"() {

        given: "third, first shot clearance"
        Frame frame = new Frame(num: 10)
        frame.addToShots(new Shot(num: 1, points: 10))
        frame.addToShots(new Shot(num: 2, points: 10))
        frame.addToShots(new Shot(num: 3, points: 10))

        expect:"strike"
        service.isStrike(frame.shots[2])

    }

    void "is only third-throw-strike in final frame"() {

        given: "strike at third attempt"
        Frame frame = new Frame(num: 10)
        frame.addToShots(new Shot(num: 1, points: 5))
        frame.addToShots(new Shot(num: 2, points: 5))
        frame.addToShots(new Shot(num: 3, points: 10))

        expect:"strike at third"
        !service.isStrike(frame.shots[0])
        !service.isStrike(frame.shots[1])
        service.isStrike(frame.shots[2])

    }

    void "is regular (1-9) frame spare"() {

        given:
        Frame frame = new Frame(num: 1)
        frame.addToShots(new Shot(num: 1, points: 5))
        frame.addToShots(new Shot(num: 2, points: 5))

        expect:"spare"
        service.isSpare(frame.shots[1])

    }

    void "is second-throw-spare in final frame"() {

        given:
        Frame frame = new Frame(num: 10)
        frame.addToShots(new Shot(num: 1, points: 5))
        frame.addToShots(new Shot(num: 2, points: 5))
        frame.addToShots(new Shot(num: 3, points: 10))

        expect:"spare at second"
        !service.isSpare(frame.shots[0])
        service.isSpare(frame.shots[1])
        !service.isSpare(frame.shots[2])

    }

    void "is third-throw-spare in final frame"() {

        given:
        Frame frame = new Frame(num: 10)
        frame.addToShots(new Shot(num: 1, points: 10))
        frame.addToShots(new Shot(num: 2, points: 5))
        frame.addToShots(new Shot(num: 3, points: 5))

        expect:"spare at third"
        !service.isSpare(frame.shots[0])
        !service.isSpare(frame.shots[1])
        service.isSpare(frame.shots[2])

    }

    void "is closed regular frame (1-9) by strike"() {

        given:
        Frame frame = new Frame(num: 1)
        frame.addToShots(new Shot(num: 1, points: 10))

        expect:
        service.isClosed(frame)

    }

    void "is closed regular frame (1-9) by spare"() {

        given:
        Frame frame = new Frame(num: 1)
        frame.addToShots(new Shot(num: 1, points: 5))
        frame.addToShots(new Shot(num: 2, points: 5))

        expect:
        service.isClosed(frame)

    }

    void "is closed regular frame (1-9) by shot count"() {

        given:
        Frame frame = new Frame(num: 1)
        frame.addToShots(new Shot(num: 1, points: 5))
        frame.addToShots(new Shot(num: 2, points: 4))

        expect:
        service.isClosed(frame)

    }

    void "is not closed regular frame (1-9) by shot count"() {

        given: "second try left"
        Frame frame = new Frame(num: 1)
        frame.addToShots(new Shot(num: 1, points: 5))

        expect:
        !service.isClosed(frame)

    }

    void "is closed final frame by shot count"() {

        given:
        Frame frame = new Frame(num: 10)
        frame.addToShots(new Shot(num: 1, points: 5))
        frame.addToShots(new Shot(num: 2, points: 5))
        frame.addToShots(new Shot(num: 3, points: 4))

        expect:
        service.isClosed(frame)

    }

    void "is closed final frame by spare, strike"() {

        given:
        Frame frame = new Frame(num: 10)
        frame.addToShots(new Shot(num: 1, points: 5))
        frame.addToShots(new Shot(num: 2, points: 5))
        frame.addToShots(new Shot(num: 3, points: 10))

        expect:
        service.isClosed(frame)

    }

    void "is closed final frame by strike, spare"() {

        given:
        Frame frame = new Frame(num: 10)
        frame.addToShots(new Shot(num: 1, points: 10))
        frame.addToShots(new Shot(num: 2, points: 5))
        frame.addToShots(new Shot(num: 3, points: 5))

        expect:
        service.isClosed(frame)

    }

    void "is closed final frame by strike, hit, miss"() {

        given:
        Frame frame = new Frame(num: 10)
        frame.addToShots(new Shot(num: 1, points: 10))
        frame.addToShots(new Shot(num: 2, points: 5))
        frame.addToShots(new Shot(num: 3, points: 0))

        expect:
        service.isClosed(frame)

    }

    void "is not closed final frame by strike, hit"() {

        given:
        Frame frame = new Frame(num: 10)
        frame.addToShots(new Shot(num: 1, points: 10))
        frame.addToShots(new Shot(num: 2, points: 5))

        expect:
        !service.isClosed(frame)

    }


}
