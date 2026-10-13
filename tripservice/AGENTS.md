# Trip Service

Die Regeln der Wurzel gelten (`../AGENTS.md`). Hier nur, was diese Kata besonders macht.

## Struktur
- `src/main/java/de/sharpsharp/tripservice/trip/TripService.java`: der Legacy-Code, `getTripsByUser(User)`, so wie in der Kata.
- `src/test/java/de/sharpsharp/tripservice/trip/TripServiceTest.java`: ein Canary-Test, der nur zeigt, dass die Tests laufen. Die Imports für JUnit 4, Hamcrest und Mockito stehen schon da.
- `TripServiceKata.pdf`: die Aufgabe (Sandro Mancuso).

## Die Regel der Kata
- Produktivcode wird nur geändert, wenn er unter Test ist.
- Ausnahme: automatische Refactorings (Extract Method, Rename, Introduce Parameter), die nötig sind, um einen Test schreiben zu können. Sonst nichts.
- Erst unter Test bringen, dann umbauen. Nie beides in einem Schritt.

## Der Weg
- `/coach`: der Clean-Code-Coach führt Schritt für Schritt, mit den Techniken aus dem Skill legacy-seams.
- Ziel: `TripService` vollständig unter Test bringen, dann hin zu Clean Code refactoren und so umbauen, dass die Tests keinen Spy brauchen, sondern mit Mocks auskommen.
