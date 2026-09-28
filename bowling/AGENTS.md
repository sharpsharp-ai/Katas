# Bowling Game

Die Regeln der Wurzel gelten (`../AGENTS.md`). Hier nur, was diese Kata besonders macht.

## Struktur
- `src/main/java/de/sharpsharp/bowling/`: leer bis auf `package-info.java`. Hier entsteht `Game` mit `roll(int pins)` und `score()`.
- `src/test/java/de/sharpsharp/bowling/`: leer. Die Testklasse heißt `GameTest`.
- `BowlingKata.md`: Regeln, Spielbogen, Aufgabe und die drei vorgeschlagenen Testfälle (Robert C. Martin). `BowlingGame.pdf`: die Original-Folien.

## Der Weg
- TDD in kleinen Schritten: `/implementiere` mit einem Testfall, aus dem Dokument oder selbst gewählt.
