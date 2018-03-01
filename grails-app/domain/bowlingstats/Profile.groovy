package bowlingstats

class Profile {

    String editHash
    String viewHash

    static hasMany = [games: Game]

    static constraints = {
    }
}
