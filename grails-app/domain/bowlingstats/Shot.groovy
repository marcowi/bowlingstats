package bowlingstats

class Shot {

    Integer num
    Integer points
    PinPattern pinPattern
    Boolean foul

    static belongsTo = [frame: Frame]

    static constraints = {
        foul nullable: true
        pinPattern nullable: true
    }

    static mapping = {
        sort "num"
        points defaultValue: 0
    }
}
