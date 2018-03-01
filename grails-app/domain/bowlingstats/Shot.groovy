package bowlingstats

class Shot {

    Integer num
    Integer points
    Boolean binary
    Boolean foul
    Boolean split
    Boolean miss

    static belongsTo = [frame: Frame]

    static constraints = {
        foul nullable: true
        split nullable: true
        miss nullable: true
        binary nullable: true
    }

    static mapping = {
        points defaultValue: 0
        binary defaultValue: false
    }
}
