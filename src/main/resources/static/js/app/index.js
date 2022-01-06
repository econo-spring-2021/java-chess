let isGameProgress = false;
let clickedCellPosition = 0;
let clickedCellColor = "";

var main = {
    init: function () {
        $('#btn-start').on('click', function () {
            _this.startGame();
        })

        var _this = this;
        for (let i = 1; i <= 64; i++) {
            let cellId = "#cell" + i;
            $(cellId).on('click', function () {
                _this.onCellClick(i);
            })
        }

        _this.loadGameData();
    },

    startGame: function () {
        $.ajax({
            type: 'POST',
            url: '/api/game/start',

        }).done(function () {
            isGameProgress = true;
            setUnitImage();
            resetScoreText();

        }).fail(function (err) {
            alert(JSON.stringify(err))
        });
    },

    onCellClick: function (position) {
        if (isGameProgress === false) {
            return;
        }

        if (clickedCellPosition === 0) {
            if ($('#cell' + position).css('backgroundImage') === 'none') {
                return;
            }

            this.highlightCell(position);
            return;
        }

        if (clickedCellPosition !== position) {
            const movement = {
                source: clickedCellPosition,
                destination: position
            }

            console.log(movement);

            this.restoreHighlightCell();

            $.ajax({
                type: 'GET',
                url: '/api/unit/movable?source=' + movement.source + "&destination=" + movement.destination,

            }).done(function (data) {
                if (data === false) {
                    return;
                }

                moveUnit(movement);

            }).fail(function (err) {
                alert(JSON.stringify(err))
            });
        }
    },

    highlightCell: function (position) {
        const CellId = "#cell" + position;

        clickedCellPosition = position;
        clickedCellColor = $(CellId).css('backgroundColor')

        $(CellId).css('backgroundColor', "#FFB300");
    },

    restoreHighlightCell: function () {
        $("#cell" + clickedCellPosition).css('backgroundColor', clickedCellColor);
        clickedCellPosition = 0;
    },

    loadGameData: function () {
        $.ajax({
            type: 'GET',
            url: '/api/game/state',

        }).done(function (data) {
            if (data === "ONGOING") {
                syncGameData();
            }
        }).fail(function (err) {
            alert(JSON.stringify(err))
        });
    }
}

function setUnitImage() {
    for (let i = 1; i <= 64; i++) {
        let cellId = "#cell" + i;
        $(cellId).css('backgroundImage', '');
    }

    $('#cell1').css('backgroundImage', "url('/image/br.png')");
    $('#cell2').css('backgroundImage', "url('/image/bn.png')");
    $('#cell3').css('backgroundImage', "url('/image/bb.png')");
    $('#cell4').css('backgroundImage', "url('/image/bq.png')");
    $('#cell5').css('backgroundImage', "url('/image/bk.png')");
    $('#cell6').css('backgroundImage', "url('/image/bb.png')");
    $('#cell7').css('backgroundImage', "url('/image/bn.png')");
    $('#cell8').css('backgroundImage', "url('/image/br.png')");

    $('#cell9').css('backgroundImage', "url('/image/bp.png')");
    $('#cell10').css('backgroundImage', "url('/image/bp.png')");
    $('#cell11').css('backgroundImage', "url('/image/bp.png')");
    $('#cell12').css('backgroundImage', "url('/image/bp.png')");
    $('#cell13').css('backgroundImage', "url('/image/bp.png')");
    $('#cell14').css('backgroundImage', "url('/image/bp.png')");
    $('#cell15').css('backgroundImage', "url('/image/bp.png')");
    $('#cell16').css('backgroundImage', "url('/image/bp.png')");

    $('#cell57').css('backgroundImage', "url('/image/wr.png')");
    $('#cell58').css('backgroundImage', "url('/image/wn.png')");
    $('#cell59').css('backgroundImage', "url('/image/wb.png')");
    $('#cell60').css('backgroundImage', "url('/image/wq.png')");
    $('#cell61').css('backgroundImage', "url('/image/wk.png')");
    $('#cell62').css('backgroundImage', "url('/image/wb.png')");
    $('#cell63').css('backgroundImage', "url('/image/wn.png')");
    $('#cell64').css('backgroundImage', "url('/image/wr.png')");

    $('#cell49').css('backgroundImage', "url('/image/wp.png')");
    $('#cell50').css('backgroundImage', "url('/image/wp.png')");
    $('#cell51').css('backgroundImage', "url('/image/wp.png')");
    $('#cell52').css('backgroundImage', "url('/image/wp.png')");
    $('#cell53').css('backgroundImage', "url('/image/wp.png')");
    $('#cell54').css('backgroundImage', "url('/image/wp.png')");
    $('#cell55').css('backgroundImage', "url('/image/wp.png')");
    $('#cell56').css('backgroundImage', "url('/image/wp.png')");
}

function resetScoreText() {
    $("#text-blackScore").text('0')
    $("#text-whiteScore").text('0')
}

function moveUnit(movement) {
    $.ajax({
        type: 'POST',
        url: '/api/unit/move?source=' + movement.source + "&destination=" + movement.destination,

    }).done(function () {
        moveUnitImage(movement);

        getBlackScore();

        getWhiteScore();

        checkGameStatus();

    }).fail(function (err) {
        alert(JSON.stringify(err))
    });
}

function moveUnitImage(movement) {
    const sourceID = "#cell" + movement.source;
    const destinationId = "#cell" + movement.destination;
    $(destinationId).css('backgroundImage', $(sourceID).css('backgroundImage'));
    $(sourceID).css('backgroundImage', '');
}

function getBlackScore() {
    $.ajax({
        type: 'GET',
        url: '/api/game/score/black',

    }).done(function (data) {
        $('#text-blackScore').text(data)

    }).fail(function (err) {
        alert(JSON.stringify(err))
    });
}

function getWhiteScore() {
    $.ajax({
        type: 'GET',
        url: '/api/game/score/white',

    }).done(function (data) {
        $('#text-whiteScore').text(data)

    }).fail(function (err) {
        alert(JSON.stringify(err))
    });
}

function checkGameStatus() {
    $.ajax({
        type: 'GET',
        url: '/api/game/state',

    }).done(function (data) {
        if (data === "ONGOING" || data === "IDLE") {
            return;
        }

        isGameProgress = false;
        alertWinner(data)

    }).fail(function (err) {
        alert(JSON.stringify(err))
    });
}

function alertWinner(winner) {
    if (winner === "BLACKWIN") {
        alert("흑 승리");
        return;
    }

    alert("백 승리");
}

function syncGameData() {
    $.ajax({
        type: 'GET',
        url: '/api/game/data',

    }).done(function (data) {
        for (let i = 0; i < 64; i++) {
            syncUnit(i + 1, data[i]);
        }

    }).fail(function (err) {
        alert(JSON.stringify(err))
    });
}

function syncUnit(position, delimiter) {
    let unitFileName = "";
    let unitCode = delimiter.charCodeAt(0);
    if (unitCode >= 97) {
        unitFileName += "w";
    } else {
        unitFileName += "b";
        unitCode += 32;
    }

    unitFileName += String.fromCharCode(unitCode);

    $('#cell' + position).css('backgroundImage', "url('/image/" + unitFileName + ".png')");
}

main.init();