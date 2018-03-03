package bowlingstats

class Frame {

    Integer num
    static hasMany = [shots: Shot]
    static belongsTo = [game: Game]

    static constraints = {
    }
}
