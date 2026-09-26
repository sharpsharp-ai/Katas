# Game of Life

Die Regeln der Wurzel gelten (`../AGENTS.md`). Hier nur, was diese Kata besonders macht.

## Struktur
- `src/main/java/de/sharpsharp/gameoflife/`: leer bis auf `package-info.java`. Hier entsteht das Raster mit seiner nächsten Generation.
- `src/test/java/de/sharpsharp/gameoflife/`: leer. Testklassen heißen nach dem Gegenstand (`GridTest`, `CellTest`).
- `GameOfLifeKata.md`: die vier Regeln und das Beispiel für Ein- und Ausgabe (Emmanuel Gaillot, XP2005).

## Der Weg
- Erst die Regeln je Zelle (Nachbarn zählen, leben oder sterben), dann das Raster, zuletzt das Textformat. `/spec` macht aus den vier Regeln EARS-Regeln, `/akzeptanztest` Szenarien, `/implementiere` den Code.
- Das Raster ist endlich: außerhalb der Ränder gibt es keine Nachbarn.
