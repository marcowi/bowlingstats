package bowlingstats

import grails.gorm.transactions.Transactional

@Transactional
class GameService {

    def add(Profile profile, Venue venue, int lane, int gameNumber) {
        Game game = new Game(profile: profile, venue: venue, lane: lane, num: gameNumber).save(failOnError:true)
        return game
    }

}
