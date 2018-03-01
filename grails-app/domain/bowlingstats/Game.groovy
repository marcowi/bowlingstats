package bowlingstats

class Game {

    Integer lane
    Venue venue

    Frame frame1
    Frame frame2
    Frame frame3
    Frame frame4
    Frame frame5
    Frame frame6
    Frame frame7
    Frame frame8
    Frame frame9
    Frame frame10

    Date createdAt
    Date lastUpdated

    static belongsTo = [profile: Profile]

    static constraints = {
        frame1 nullable: true
        frame2 nullable: true
        frame3 nullable: true
        frame4 nullable: true
        frame5 nullable: true
        frame6 nullable: true
        frame7 nullable: true
        frame8 nullable: true
        frame9 nullable: true
        frame10 nullable: true
    }
}
