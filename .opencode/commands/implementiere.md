---
description: Ein Szenario oder einen roten Test grün machen, Test zuerst, kleine Schritte
agent: tdd-implementierer
---
Mache genau das grün: "$ARGUMENTS" (ein Szenario, ein Testname oder eine Regel). Nichts anderes.

Skill tdd-zyklus, hier eingefügt:
@../.opencode/skills/tdd-zyklus/SKILL.md

Skill clean-code-check, hier eingefügt:
@../.opencode/skills/clean-code-check/SKILL.md

Die Szenarien, falls es welche gibt:
!`for f in src/test/resources/features/*.feature; do [ -f "$f" ] && { echo "=== $f"; cat "$f"; }; done`

Was an Szenarien und Specs geändert ist (gelöschte oder geänderte Szenarien heißen: die alte Regel gilt nicht mehr, ihre Unit-Tests sind veraltet):
!`git status --short -- src/test/resources/features specs 2>/dev/null`

Die Schritte, falls es welche gibt:
!`for f in $(find src/test -name '*Steps.java'); do echo "=== $f"; cat "$f"; done`

Der Produktivcode:
!`find src/main -name '*.java' | sort`

Stand von `mvn -q verify` jetzt (keine Zeilen heißt grün):
!`mvn -q verify 2>&1 | tail -30`

Vorgehen:
1. Ist das Ziel schon grün: sag das und hör auf.
2. Kompiliert der Code nicht: ein Test oder ein Schritt verlangt eine Methode oder ein Interface, das fehlt. Bau genau das, so klein wie möglich.
3. Schreib einen Unit-Test in der Testklasse des Gegenstands (`src/test/java/<Package>/<Gegenstand>Test.java`) für die kleinste Regel, die das Ziel braucht. Lass ihn laufen: rot.
4. Schreib den Code, so wenig wie möglich. Lass den Test laufen: grün.
5. Wiederhole 3 und 4, bis das Ziel grün ist.
6. Räum auf nach dem Clean-Code-Check. Dann `mvn -q verify`. Nicht grün: zurück zu 3.
7. Feature-Dateien, Schritte, Specs und `pom.xml` bleiben unverändert.
8. Antworte in drei Zeilen: geänderte Dateien, letzte Zeilen von `mvn -q verify`, offen.
