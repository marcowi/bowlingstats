package bowlingstats

class Frame {

    static hasMany = [shots: Shot]
    static belongsTo = [game: Game]

    static constraints = {
    }
}
