package bowlingstats

class BootStrap {

    def init = { servletContext ->

        if (Venue.count() == 0) {

            Venue bowlero = new Venue(name: "Bowlero").save()
            Venue usBowl = new Venue(name: "US-Bowl").save()

            Profile profile1 = new Profile(editHash: "asd", viewHash: "dsa").save()

        }


    }
    def destroy = {
    }
}
