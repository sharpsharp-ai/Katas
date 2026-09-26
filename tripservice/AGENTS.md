# Trip Service

Die Regeln der Wurzel gelten (`../AGENTS.md`). Hier nur, was diese Kata besonders macht.

## Struktur
- `src/main/java/de/sharpsharp/tripservice/trip/TripService.java`: der Legacy-Code, `getTripsByUser(User)`. Eine Naht ist schon da: `getLoggedUser()`, im Test per Spy übersteuert.
- `trip/TripDAO.java`: statische `findTripsByUser`, wirft im Test. `user/UserSession.java`: Singleton, `getLoggedUser()` wirft im Test.
- `user/User.java`: Freunde und Reisen. `trip/Trip.java`: leer. `exception/`: `UserNotLoggedInException`, `CollaboratorCallException`.
- `TripService_Original.java`: die Ausgangsfassung ohne Naht, zum Vergleich. Bleibt unverändert.
- `src/test/java/de/sharpsharp/tripservice/trip/TripServiceTest.java`: ein Test als Einstieg. JUnit 4, Hamcrest, Mockito.
- `TripServiceKata.pdf`: die Aufgabe (Sandro Mancuso).

## Die Regel der Kata
- Produktivcode wird nur geändert, wenn er unter Test ist.
- Ausnahme: automatische Refactorings (Extract Method, Rename, Introduce Parameter), die nötig sind, um einen Test schreiben zu können. Sonst nichts.
- Erst unter Test bringen, dann umbauen. Nie beides in einem Schritt.

## Der Weg
- `/coach`: der Clean-Code-Reviewer und Coach führt Schritt für Schritt, mit den Techniken aus dem Skill legacy-seams.
- Mockito-Mocks erst, wenn eine Abhängigkeit hereinreichbar ist; vorher Nähte: Spy, Subclass-and-Override.
