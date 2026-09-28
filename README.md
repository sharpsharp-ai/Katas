# Katas

Sechs Katas für Clean Code, TDD und Legacy-Code, alle mit derselben Werkzeugkiste (Java 17, Maven, JUnit 4, Hamcrest,
Mockito, ApprovalTests, Cucumber, JaCoCo) und denselben opencode-Rollen. Jede Kata ist ein Ordner mit eigener `pom.xml`
und eigener AGENTS.md. Fertig ist eine Änderung, wenn `mvn -q verify` ohne Ausgabe und mit Exit-Code 0 endet.

| Kata | Worum es geht | Startstand |
|---|---|---|
| `gildedrose/` | Legacy-Code unter Test bringen, dann umbauen, dann „Conjured" einbauen (Terry Hughes, Emily Bache) | der Code der Kata, ein Test |
| `tripservice/` | fest verdrahtete Abhängigkeiten: Nähte, dann Mocks (Sandro Mancuso) | der Code mit einer Naht, ein Spy-Test |
| `stringcalculator/` | TDD von der ersten Zeile an (Roy Osherove) | leer, ein Testname |
| `trainreservation/` | Mockist TDD mit zwei Diensten als Ports (Emily Bache) | Werte, Ports, ein mockist-Test |
| `bowling/` | TDD Schritt für Schritt, Testfälle aus dem Dokument (Robert C. Martin) | leer |
| `gameoflife/` | TDD mit Regeln und Raster (Emmanuel Gaillot) | leer |

## Loslegen

Voraussetzung: JDK 17 oder neuer und Maven (IntelliJ bringt Maven mit).

```bash
git clone https://github.com/sharpsharp-ai/Katas.git
cd Katas/bowling                   # oder eine andere Kata
mvn -q verify                      # keine Ausgabe heißt grün; schreibt den Abdeckungsbericht
../scripts/unabgedeckt.sh          # welche Zeilen und Verzweigungen die Tests nicht erreichen
```

IntelliJ: File → New → Project from Version Control, die URL einfügen. IntelliJ erkennt die `pom.xml` der Wurzel und
lädt alle sechs Katas als Module. `mvn -q verify` in der Wurzel baut alle.

## Mit opencode arbeiten

opencode im Kata-Ordner starten, nicht in der Wurzel: `cd gildedrose`, dann `opencode --agent refactorer`. Rollen,
Skills und Commands liegen einmal in `.opencode/` der Wurzel und gelten in jedem Kata-Ordner; die AGENTS.md der Wurzel
und die der Kata werden beide gelesen. In IntelliJ (ACP) den Session-Modus mit dem Rollennamen wählen.

Fünf Rollen, jede eine Markdown-Datei unter `.opencode/agents/`:

| Rolle | Tut | Darf ändern |
|---|---|---|
| `spec-und-akzeptanztestschreiber` | aus Stories Specs (EARS), aus Specs Szenarien; Approval-, Characterization- und Spec-Tests als Sicherheitsnetz für Legacy-Code | `specs/`, `src/test/` |
| `tdd-implementierer` | macht ein Szenario oder einen roten Test grün: Unit-Test, Code, Aufräumen | `src/main/`, Unit-Tests |
| `clean-code-reviewer-und-coach` | Befunde mit Datei:Zeile und Refactoring, der Clean-Code-Report, Coaching Schritt für Schritt | nur nach OK |
| `refactorer` | Umbau in kleinen Schritten, ein Refactoring je Commit, rot heißt zurück | `src/main/` über `schritt.sh` |
| `superMario` | kann alles und darf alles | alles außer `opencode.json` und den Dateien der anderen Rollen |

### Dazulernen

Jede Rolle darf ihre eigene Definition ändern, und nur die: am Ende ihrer Datei steht ein Abschnitt „Gelernt", in den
sie schreibt, was sie beim nächsten Mal wissen will, eine Zeile je Erkenntnis, mit Datum. So lernen die Rollen über
Sessions hinweg. Fremde Definitionen und `opencode.json` sind für alle gesperrt, auch für SuperMario.

```text
/spec 3                                      Spec für Story 3 (oder einen Abschnitt der *Kata.md) als EARS-Regeln
/akzeptanztest 3                             Szenarien in Gherkin für Spec 3, Schritte, Runner
/implementiere Ein Spare zählt den nächsten Wurf dazu   genau das grün machen, Test zuerst
/approval-test GildedRose#updateQuality      Golden Master: Raster aus den Literalen der Methode, genehmigt als Datei
/characterization-test GildedRose#updateQuality   je Verzweigung ein Test, Grenzwerte als Paar
/generate-tests-from-spec                    Tests aus der *Kata.md, der Code bleibt zu
/refactor-in-small-steps GildedRose#updateQuality   Umbau unter Test, ein Refactoring je Commit
/review                                      Befunde zu den Änderungen seit dem letzten Commit
/clean-code-report                           Punkte, Rang, Endgegner; Bericht in target/
/coach                                       Legacy-Code Schritt für Schritt unter Test bringen und umbauen, nach OK
```

| Datei | Wirkung |
|---|---|
| `AGENTS.md` | Befehle, Rollen, Regeln für alle Katas; je Kata eine zweite mit der Struktur |
| `opencode.json` | Rechte und die Bash-Whitelist |
| `.opencode/agents/*.md` | die fünf Rollen: Rechte im Kopf, Prompt im Rumpf, „Gelernt" am Ende |
| `.opencode/commands/*.md` | die Commands; lesbares Markdown, das ist der Prompt |
| `.opencode/skills/*/SKILL.md` | elf Skills: Regeln und Muster, ohne Bezug auf eine Kata |
| `scripts/` | `unabgedeckt.sh`, `approve.sh`, `schritt.sh`, `regeln.sh`; aus dem Kata-Ordner als `../scripts/…` |
| `.github/workflows/ci.yml` | baut alle Katas bei jedem Push |

## Clean-Code-Report

Ein Blick auf den Code, ohne Gnade und ohne Gate: 30 Code Smells aus sechs Familien, Punkte, Rang, Radar und
Monster-Galerie; das Regelwerk mit jeder Schwelle und jedem Refactoring steht im Bericht.

```bash
cd gildedrose
java ../.opencode/skills/clean-code-report/CleanCodeReport.java   # schreibt target/clean-code-report.html
```
