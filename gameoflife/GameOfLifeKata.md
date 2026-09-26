# Game of Life Kata

Vorgestellt als Prepared Kata auf der XP2005 von Emmanuel Gaillot. Schwierigkeit: mittel. Verwandte Katas: Minesweeper,
Reversi.

## Die Aufgabe

Berechne die nächste Generation von Conways Game of Life aus einer beliebigen Ausgangsstellung. Hintergrund:
https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life

Ausgangspunkt ist ein zweidimensionales Raster aus Zellen, jede Zelle ist lebendig oder tot. In dieser Fassung ist das
Raster endlich, außerhalb der Ränder gibt es kein Leben. Für die nächste Generation gelten diese Regeln:

1. Jede lebende Zelle mit weniger als zwei lebenden Nachbarn stirbt, wie durch Unterbevölkerung.
2. Jede lebende Zelle mit mehr als drei lebenden Nachbarn stirbt, wie durch Überbevölkerung.
3. Jede lebende Zelle mit zwei oder drei lebenden Nachbarn lebt in der nächsten Generation weiter.
4. Jede tote Zelle mit genau drei lebenden Nachbarn wird zu einer lebenden Zelle.

Schreibe ein Programm, das ein beliebiges Raster aus Zellen annimmt und ein Raster derselben Form mit der nächsten
Generation ausgibt.

## Hinweise

Die Ausgangsstellung könnte eine Textdatei sein, die so aussieht:

```
Generation 1:
4 8
........
....*...
...**...
........
```

Und die Ausgabe könnte so aussehen:

```
Generation 2:
4 8
........
...**...
...**...
........
```
