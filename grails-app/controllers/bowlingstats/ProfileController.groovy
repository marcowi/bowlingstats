package bowlingstats

class ProfileController {

    ProfileService profileService
    GameService gameService

    def index() {
        Profile profile = Profile.findByEditHash(params.hash)
        List<Game> gameList = Game.findAllByProfile(profile, [sort: "dateCreated", order: "desc"])
        List<Venue> venueList = Venue.list()
        render view: "/profile/index", model: [profile: profile, gameList: gameList, venueList: venueList]
    }

    def addGame() {
        Profile profile = Profile.findByEditHash(params.hash)
        Venue venue = Venue.get(params.getInt("venue"))
        int lane = params.getInt("lane")
        int gameNumber = profileService.getNewGameNumber(profile)
        Game game = gameService.add(profile, venue, lane, gameNumber)
        render template: "/profile/game", model: [game: game]
    }

}
