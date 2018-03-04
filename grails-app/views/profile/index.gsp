<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>BowlingStats</title>
    <asset:stylesheet src="profile.css"/>
</head>
<body>
<content tag="nav">

</content>

<div id="content" role="main">
    <div id="form-game-add">
        <div class="row head">
            <div class="col-sm-6 venue">Venue</div>
            <div class="col-sm-6 lane">Lane</div>
        </div>
        <div class="row body">
            <div class="col-sm-6 venue">
                <g:select name="venue" id="select-venue" from="${venueList}" optionKey="id"></g:select>
            </div>
            <div class="col-sm-6 lane">
                <input name="lane" id="input-lane" type="number" value="1"/>
                <button id="btn-add-game">Go</button>
            </div>
        </div>
    </div>
    <div id="games">
        <div class="head">
            <div class="row">
                <div class="col-sm-2">Start</div>
                <div class="col-sm-8">Venue</div>
                <div class="col-sm-2">Lane</div>
            </div>
        </div>
        <div class="body">
        <g:each in="${gameList}" var="game">
            <g:render template="game" model="[game: game]"/>
        </g:each>
        </div>
    </div>
</div>

<asset:javascript src="profile.js"/>

<content tag="extrajs">
    <script type="application/javascript">
        $(function () {
            new Profile("${profile.editHash}");
        });
    </script>
</content>
</body>
</html>
