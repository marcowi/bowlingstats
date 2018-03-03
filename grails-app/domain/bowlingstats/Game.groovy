package bowlingstats

class Game {

    Venue venue
    Integer lane
    Date createdAt
    Date lastUpdated

    static hasMany = [frames: Frame]
    static belongsTo = [profile: Profile]

    static constraints = {

    }
}
