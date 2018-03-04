package bowlingstats

class Game {

    Integer num
    Venue venue
    Integer lane
    Date dateCreated
    Date lastUpdated

    static hasMany = [frames: Frame]
    static belongsTo = [profile: Profile]

    static constraints = {

    }
}
