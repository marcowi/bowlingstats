package bowlingstats

import grails.gorm.transactions.Transactional

@Transactional
class FrameService {

    def addShot(Frame frame, int points, PinPattern pinPattern, boolean split, boolean foul) {
        Shot shot = new Shot()
        shot.points = points
        shot.pinPattern = pinPattern
        shot.split = split
        shot.foul = foul

        frame.addToShots(shot)
        frame.save()
    }

    def isStrike(Shot shot) {

        if (isStrikeAtFirst(shot)) {
            return true
        }

        if (isFinalFrame(shot.frame)) {
            if (isStrikeAtSecond(shot)) {
                return true
            } else {
                return isStrikeAtThird(shot)
            }
        }

    }

    private static def isStrikeAtFirst(Shot shot) {
        return isShot1(shot) && isCleared(shot)
    }

    private def isStrikeAtSecond(Shot shot) {
        return isShot2(shot) && isCleared(shot) && isStrike(getPreviousShot(shot))
    }

    private def isStrikeAtThird(Shot shot) {
        return isShot3(shot) && isCleared(shot) && (isStrike(getPreviousShot(shot)) || isSpare(getPreviousShot(shot)))
    }

    def isSpare(Shot shot) {
        if (isShot2(shot) && !isStrike(getPreviousShot(shot))) {
            return shot.points + getPreviousShot(shot).points == 10
        }

        if (isFinalFrame(shot.frame)) {
             if (isShot3(shot) && !isStrike(getPreviousShot(shot)) && !isSpare(getPreviousShot(shot))) {
                return shot.points + getPreviousShot(shot).points == 10
            } else {
                return false
            }
        }
    }

    def isFinalFrame(Frame frame) {
        return frame.num == 10
    }

    def isClosed(Frame frame) {
        if (isFinalFrame(frame)) {
            return frame.shots.size() == 3 || (frame.shots.size() == 2 && !isStrike(frame.shots[0]) && !isSpare(frame.shots[1]) && !isStrike(frame.shots[1]))
        } else {
            return frame.shots.size() == 2 || isStrike(frame.shots[0])
        }
    }

    private static def getPreviousShot(Shot shot) {
        if (shot.num > 1) {
            return shot.frame.shots[shot.num - 2]
        } else {
            return shot //TODO: This is not as good as it could be!
        }
    }

    private static def isShot1(Shot shot) {
        return shot.num == 1
    }

    private static def isShot2(Shot shot) {
        return shot.num == 2
    }

    private static def isShot3(Shot shot) {
        return shot.num == 3
    }

    private static def isCleared(Shot shot) {
        return shot.points == 10
    }
}
