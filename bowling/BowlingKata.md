# Bowling Game Kata

Nach Robert C. Martin, „The Bowling Game Kata". Die Original-Folien liegen daneben: `BowlingGame.pdf`.

## Die Regeln

Ein Spiel besteht aus 10 Frames. In jedem Frame hat der Spieler zwei Würfe, um 10 Pins umzuwerfen. Die Punkte eines
Frames sind die Zahl der umgeworfenen Pins plus Bonus für Strikes und Spares.

Ein Spare ist, wenn der Spieler alle 10 Pins mit zwei Würfen umwirft. Der Bonus für diesen Frame ist die Zahl der Pins,
die der nächste Wurf umwirft. In Frame 3 des Spielbogens unten sind das 10 (alle Pins) plus 5 als Bonus (die Pins des
nächsten Wurfs).

Ein Strike ist, wenn der Spieler alle 10 Pins mit dem ersten Wurf umwirft. Der Bonus für diesen Frame ist die Summe der
nächsten zwei Würfe.

Im zehnten Frame darf ein Spieler, der einen Spare oder Strike wirft, die Zusatzwürfe machen, um den Frame
abzuschließen. Mehr als drei Würfe gibt es im zehnten Frame aber nicht.

## Der Spielbogen

| Frame | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
|---|---|---|---|---|---|---|---|---|---|---|
| Würfe | 1 4 | 4 5 | 6 / | 5 / | X | 0 1 | 7 / | 6 / | X | 2 / 6 |
| Punkte | 5 | 14 | 29 | 49 | 60 | 61 | 77 | 97 | 117 | 133 |

X ist ein Strike, / ein Spare, - ein Fehlwurf (kein Pin). Die Punkte sind aufsummiert; 133 ist das Ergebnis des Spiels.

## Die Aufgabe

Schreibe eine Klasse `Game` mit zwei Methoden:

- `roll(pins : int)` wird bei jedem Wurf gerufen. Das Argument ist die Zahl der umgeworfenen Pins.
- `score() : int` wird erst ganz am Ende des Spiels gerufen. Es liefert die Gesamtpunktzahl des Spiels.

## Vorgeschlagene Testfälle

| Würfe | Was das ist | Punkte |
|---|---|---|
| X X X X X X X X X X X X | 12 Würfe: 12 Strikes | 10 Frames × 30 Punkte = 300 |
| 9- 9- 9- 9- 9- 9- 9- 9- 9- 9- | 20 Würfe: 10 Paare aus 9 und Fehlwurf | 10 Frames × 9 Punkte = 90 |
| 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5 | 21 Würfe: 10 Paare aus 5 und Spare, am Ende noch eine 5 | 10 Frames × 15 Punkte = 150 |
