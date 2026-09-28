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
- Phase 1, unter Test bringen: der kürzeste Weg (nicht angemeldet, Exception) ist schon da, `userMayNotBeNull` spied die Naht `getLoggedUser()`. Dann: keine Freunde, leere Liste. Dann: Freund, Reisen aus einer Naht für `TripDAO` (Extract and Override). Erst weiter, wenn `../scripts/unabgedeckt.sh TripService` keine Zeile mehr nennt.
- Phase 2, umbauen, jeder Schritt unter grünen Tests: Guard Clause für „nicht angemeldet"; Freundschaftsfrage nach `User.isFriendsWith(User)` mit eigenem Test; `TripDAO` als Instanz mit Konstruktor-Injektion, Mockito-Mock statt Naht; angemeldeten Benutzer hereinreichen statt aus dem Singleton holen; Nähte entfernen.
- Mockito-Mocks erst, wenn eine Abhängigkeit hereinreichbar ist; vorher Nähte: Spy, Subclass-and-Override.
