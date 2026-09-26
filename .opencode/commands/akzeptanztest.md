---
description: Szenarien für eine Spec schreiben, Gherkin auf Deutsch, Schritte gegen den Kern, Runner anlegen, wenn er fehlt
agent: spec-und-akzeptanztestschreiber
---
Schreibe die Szenarien für: $ARGUMENTS (eine Spec-Nummer aus `specs/`, oder eine Regel als Text).

Skill akzeptanztest-regeln, hier eingefügt:
@../.opencode/skills/akzeptanztest-regeln/SKILL.md

Alle Specs; nimm die aus dem Auftrag:
!`for f in specs/*/spec.md; do [ -f "$f" ] && { echo "=== $f"; cat "$f"; }; done`

Glossar mit den vorhandenen Schritten, falls vorhanden:
!`cat specs/glossar.md 2>/dev/null`

Vorhandene Feature-Dateien, Schritte und Runner:
!`find src/test \( -name '*.feature' -o -name '*Steps.java' -o -name 'RunCucumberTest.java' \) | sort`

Der Kern, so wie er heute ist, nur Signaturen:
!`grep -rnE '^\s*public' src/main/java --include='*.java'`

Vorgehen:
1. Jede Regel der Spec bekommt mindestens ein Szenario: Normalfall, Grenzwert, Fehlerfall, wo es sie gibt. Zahlen kommen aus der Spec oder von der Karte; steht eine nirgends, schreib die Frage in die Antwort, nimm nicht 0. WHILE wird Angenommen, WHEN wird Wenn, SHALL wird Dann. IF wird ein eigenes Fehlerfall-Szenario. Eine Regel ohne WHEN bekommt ein Szenario ohne Wenn.
2. Datei `src/test/resources/features/<kurzname>.feature`, erste Zeile `# language: de`. Gibt es die Datei, ergänze fehlende Szenarien; vorhandene bleiben, auch ihr Titel. Hebt die neue Spec eine alte Regel auf, ändere oder lösche das alte Szenario und schreib das in die Antwort.
3. Schritte: erst vorhandene wiederverwenden. Fehlt ein Wort, schreib den Schritt in `src/test/java/<Package>/<Gegenstand>Steps.java`. Fehlt dafür eine Methode am Kern, benutze sie so, wie sie heißen soll; der TDD-Implementierer baut sie. Zeit und Zufall kommen von außen in den Konstruktor, nie über einen Setter. Angenommen-Schritte stellen den Zustand her und prüfen nichts. Wenn-Schritte rufen genau eine Methode. Dann-Schritte prüfen genau eine Sache mit `assertThat`.
4. Fehlt der Runner, leg `src/test/java/<Package>/RunCucumberTest.java` an: `@RunWith(Cucumber.class)` und `@CucumberOptions(features = "src/test/resources/features", glue = "<Package>", plugin = "pretty")` über einer leeren Klasse. Cucumber ist in der `pom.xml` schon da.
5. `mvn -q test -Dtest=RunCucumberTest`. Neue Szenarien dürfen rot sein oder nicht kompilieren; alte Szenarien bleiben grün. Kein Produktivcode wird angefasst.
6. Antworte mit: Datei, Liste der Szenarien, und je Regel des Skills „ja“ oder „nein“ mit einem Wort Begründung.
