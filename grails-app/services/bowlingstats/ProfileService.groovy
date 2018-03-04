package bowlingstats

import grails.gorm.transactions.Transactional

@Transactional
class ProfileService {

    def getNewGameNumber(Profile profile) {
        List<Game> games = Game.findAllByProfile(profile)
        if (games.size() > 0) {
            return games.num.max() + 1
        } else {
            return 1
        }
    }
}
