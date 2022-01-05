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
    },

    startGame: function () {
        this.setUnitImage();
        this.resetScoreText();

        $.ajax({
            type: 'POST',
            url: '/api/start',

        }).done(function() {
            isGameProgress = true

        }).fail(function (err) { alert(JSON.stringify(err))});
    },


    setUnitImage: function () {
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
    },

    resetScoreText: function () {
        $("#text-blackScore").text('0')
        $("#text-whiteScore").text('0')
    },

    onCellClick: function (position) {
        if (clickedCellPosition === 0) {
            if ($('#cell'+position).css('backgroundImage') === 'none') {
                return;
            }

            this.highlightCell(position);

            return;
        }

        this.restoreCell(position);

        if (clickedCellPosition !== position) {
            const movement = {
                source: clickedCellPosition,
                destination: position
            }

            $.ajax({
                type: 'GET',
                url: '/api/movable',
                dataType: 'json',
                data: JSON.stringify(movement)

            }).done(function (data) {
                if (data === false) {
                    return;
                }

               this.moveUnit(movement);

            }).fail(function (err) {
                alert(JSON.stringify(err))
            });
        }
    },

    moveUnit : function (movement) {
        $.ajax({
            type: 'POST',
            url: '/api/move',
            dataType: 'json',
            data: JSON.stringify(movement)

        }).done(function () {
            this.moveUnitImage(movement);

            this.getBlackScore();

            this.getWhiteScore();

            this.checkGameStatus();

        }).fail(function (err) {
            alert(JSON.stringify(err))
        });
    },

    moveUnitImage : function (movement) {
        const sourceID = "#cell" + movement.source;
        const destinationId = "#cell" + movement.destination;
        $(destinationId).css('backgroundImage', $(sourceID).css('backgroundImage'));
    },

    highlightCell : function (position) {
        const CellId = "#cell" + position;

        clickedCellPosition = position;
        clickedCellColor = $(CellId).css('backgroundColor')

        $(CellId).css('backgroundColor', "#FFB300");
    },

    restoreCell: function () {
        const clickedCellId = "#cell" + clickedCellPosition;

        $(clickedCellId).css('backgroundColor', clickedCellColor);
        clickedCellPosition = 0;
    },

    getBlackScore: function () {
        $.ajax({
            type: 'GET',
            url: '/api/score/black',

        }).done(function (data) {
            $('#text-blackScore').text(data)

        }).fail(function (err) {
            alert(JSON.stringify(err))
        });
    },

    getWhiteScore: function () {
        $.ajax({
            type: 'GET',
            url: '/api/score/white',

        }).done(function (data) {
            $('#text-whiteScore').text(data)

        }).fail(function (err) {
            alert(JSON.stringify(err))
        });
    },

    checkGameStatus : function () {
        $.ajax({
            type: 'GET',
            url: '/api/status',

        }).done(function (data) {
            if (data === "ONGOING") {
                return;
            }

            isGameProgress = false;
            this.alertWinner(data)

        }).fail(function (err) {
            alert(JSON.stringify(err))
        });
    },

    alertWinner : function (winner) {
        if (winner === "BLACKWIN") {
            alert("흑 승리");
            return;
        }

        alert("백 승리");
    }
}

main.init();