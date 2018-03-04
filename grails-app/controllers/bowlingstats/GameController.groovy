package bowlingstats

class GameController {

    def show() {
        Profile profile = Profile.findByEditHash(params.hash)
        Game game = Game.findByProfileAndNum(profile, params.getInt("game"))
        render view: "/game/show", model: [profile: profile, game: game]
    }
}
