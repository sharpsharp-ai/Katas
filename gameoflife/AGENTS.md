# Game of Life

Die Regeln der Wurzel gelten (`../AGENTS.md`). Hier nur, was diese Kata besonders macht.

## Struktur
- `src/main/java/de/sharpsharp/gameoflife/`: leer bis auf `package-info.java`. Hier entsteht das Raster mit seiner nächsten Generation.
- `src/test/java/de/sharpsharp/gameoflife/`: leer. Testklassen heißen nach dem Gegenstand (`GridTest`, `CellTest`).
- `GameOfLifeKata.md`: die vier Regeln und das Beispiel für Ein- und Ausgabe (Emmanuel Gaillot, XP2005).

## Der Weg
- `/spec` macht aus den Regeln des Dokuments EARS-Regeln, `/akzeptanztest` Szenarien, `/implementiere` den Code. Ein Schritt nach dem anderen.
