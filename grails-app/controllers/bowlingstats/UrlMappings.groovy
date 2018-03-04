package bowlingstats

class UrlMappings {

    static mappings = {

        "/"(controller: "main", action: "index")
        "500"(view:'/error')
        "404"(view:'/notFound')

        "/$hash"(controller: "profile", action: "index")
        "/$hash/addGame"(controller: "profile", action: "addGame", method: "POST")
        "/$hash/game/$game"(controller: "game", action: "show")

    }
}
