function Profile(hash) {
    this.hash = hash;
    this.addEventHandlers();
}

Profile.prototype.addEventHandlers = function () {
    var _self = this;
    $("#btn-add-game").on("click", function () {
        _self.addGame();
    });

    $(document).on("click", ".game", function (e) {
        console.log("asdasd");
        window.location.href = "/" + _self.hash + "/game/" + $(e.currentTarget).data("id");
    });
};

Profile.prototype.addGame = function () {
    var venue = $("#select-venue").val();
    var lane = $("#input-lane").val();
    $.post("/" + this.hash + "/addGame", {venue: venue, lane: lane}).success(function (data) {
        $("#games .body").prepend(data);
    });
};