<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>BowlingStats</title>
    <asset:stylesheet src="game.css"/>
</head>
<body>
<content tag="nav">

</content>

<div id="content" role="main">
    <div class="row table-points">
    <g:each in="${1..10}" var="framenum">
        <g:if test="${framenum < 10}">
            <div class="col-sm-1 frame-regular">
                <div class="row frame">
                    <div class="col-sm-6 shot">
                        1
                    </div>
                    <div class="col-sm-6 shot">
                        2
                    </div>
                </div>
                <div class="row result">
                    <div class="col-sm-12">
                        3
                    </div>
                </div>
            </div>
        </g:if>
        <g:else>
            <div class="col-sm-2 frame-final">
                <div class="row frame">
                    <div class="col-sm-4 shot">
                        1
                    </div>
                    <div class="col-sm-4 shot">
                        2
                    </div>
                    <div class="col-sm-4 shot">
                        3
                    </div>
                </div>
                <div class="row result">
                    <div class="col-sm-12">
                        6
                    </div>
                </div>
            </div>
        </g:else>
    </g:each>
        <div class="col-sm-1">

        </div>
    </div>
    <div class="points">
        <div class="input-points">
            <g:render template="points"/>
        </div>
        <div class="input-points">
            <g:render template="points"/>
        </div>
    </div>
</div>

<asset:javascript src="game.js"/>

<content tag="extrajs">
    <script type="application/javascript">
        $(function () {
            new Game("${profile.editHash}", "${game.num}");
        });
    </script>
</content>
</body>
</html>
