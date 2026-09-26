---
description: Spec schreiben, EARS-Regeln nach specs/<nr>-<name>/spec.md, aus einer Story oder aus dem Anforderungsdokument der Kata
agent: spec-und-akzeptanztestschreiber
---
Schreibe die Spec für: $ARGUMENTS (eine Story-Nummer aus `specs/stories.md`, oder die Story selbst als Text. Leer heißt: das Anforderungsdokument der Kata, die `*Kata.md` im Ordner, ein Abschnitt je Spec, beginnend mit dem ersten, der noch keine hat).

Skill ears-regeln, hier eingefügt:
@../.opencode/skills/ears-regeln/SKILL.md

Die Stories, falls es die Datei gibt:
!`cat specs/stories.md 2>/dev/null`

Das Anforderungsdokument der Kata:
!`cat *Kata.md 2>/dev/null | head -150`

Glossar, falls vorhanden:
!`cat specs/glossar.md 2>/dev/null`

Vorhandene Specs:
!`ls specs 2>/dev/null`

Vorgehen:
1. Finde die Story: die Überschrift mit der Nummer in `specs/stories.md`, sonst der Text aus dem Auftrag, sonst der Abschnitt des Dokuments. Nur diese eine.
2. Lege die Datei `specs/<nr>-<kurzname>/spec.md` an; ohne Nummer die nächste freie. Kurzname: klein, ohne Umlaute, Wörter mit Bindestrich. Gibt es die Datei schon, überarbeite sie.
3. Inhalt, höchstens eine halbe Seite, genau diese drei Abschnitte:
   `## Story`: wörtlich von der Karte oder aus dem Dokument.
   `## Regeln`: eine EARS-Regel je Akzeptanzkriterium, nach dem Skill: allgemein, mit der Schwelle, ohne Beispielwerte. Der Gegenstand heißt so, wie das Dokument ihn nennt (das Spiel, der Rechner, das Raster), nicht „der Automat“.
   `## Offene Fragen`: Fragen an den Kunden, oder „keine“.
4. Ändere nichts außerhalb von `specs/`.
5. Antworte mit dem Pfad der Datei und den Regeln.
