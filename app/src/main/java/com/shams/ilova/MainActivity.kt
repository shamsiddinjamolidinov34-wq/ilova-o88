<!DOCTYPE html>
<html lang="uz">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Oddiy Domino O'yini</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #1e272e;
            color: #fff;
            text-align: center;
            margin: 0;
            padding: 20px;
        }
        h1 {
            color: #f5cd79;
        }
        #status {
            font-size: 18px;
            margin-bottom: 20px;
            color: #ff7675;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background: #2f3640;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.5);
        }
        #board {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            align-items: center;
            gap: 10px;
            min-height: 120px;
            background: #353b48;
            padding: 15px;
            border-radius: 8px;
            margin-bottom: 20px;
            border: 2px dashed #718093;
        }
        .hand {
            display: flex;
            justify-content: center;
            gap: 12px;
            flex-wrap: wrap;
        }
        .tile {
            background: #f5f6fa;
            color: #2f3640;
            border: 2px solid #2f3640;
            border-radius: 6px;
            width: 50px;
            height: 90px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: space-around;
            font-weight: bold;
            font-size: 20px;
            cursor: pointer;
            transition: transform 0.2s, background 0.2s;
            box-shadow: 0 2px 5px rgba(0,0,0,0.3);
        }
        .tile:hover {
            transform: translateY(-5px);
            background: #dcdde1;
        }
        .divider {
            width: 100%;
            height: 2px;
            background: #2f3640;
        }
        .section-title {
            margin: 15px 0 10px 0;
            font-size: 18px;
            color: #74b9ff;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>🎲 Domino O'yini</h1>
        <div id="status">O'yin boshlandi! Maydonga mos toshni tashlang.</div>

        <div class="section-title">Stol (O'yin maydoni):</div>
        <div id="board"></div>

        <div class="section-title">Sizning toshlaringiz:</div>
        <div id="player-hand" class="hand"></div>
    </div>

    <script>
        const boardElement = document.getElementById('board');
        const handElement = document.getElementById('player-hand');
        const statusElement = document.getElementById('status');

        // Boshlang'ich toshlar
        let playerHand = [[1, 3], [2, 5], [4, 4], [0, 6], [3, 5]];
        let boardTiles = [[3, 3]]; // Stol ustidagi boshlang'ich tosh

        function renderGame() {
            // Stolni yangilash
            boardElement.innerHTML = '';
            boardTiles.forEach(tile => {
                const tileDiv = document.createElement('div');
                tileDiv.className = 'tile';
                tileDiv.innerHTML = <span>${tile[0]}</span><div class="divider"></div><span>${tile[1]}</span>;
                boardElement.appendChild(tileDiv);
            });

            // O'yinchi qo'lidagi toshlarni yangilash
            handElement.innerHTML = '';
            playerHand.forEach((tile, index) => {
                const tileDiv = document.createElement('div');
                tileDiv.className = 'tile';
                tileDiv.innerHTML = <span>${tile[0]}</span><div class="divider"></div><span>${tile[1]}</span>;
                tileDiv.onclick = () => playTile(index);
                handElement.appendChild(tileDiv);
            });
        }
