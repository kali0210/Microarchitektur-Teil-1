## Mikroarchitektur-Teil-1
### BLUEJ-BUCH KLASSENENTWURF Kapitel 8
Entwurf nach Zuständigkeiten <br>
Kohäsion, Kopplung, Refactoring

#### Kopplung:
Beschreibt den Grad der Abhängigkeiten zwischen Klassen. Grad gibt an wie eng die Klassen verknüpft sind.
Deswegen wollen wir jede Klasse unabhängig ist für eine lose Kopplung.

#### Kohäsion:
Beschreibt wie gut eine Programmiereinheit eine logische Aufgabe abbildet.
Hoher Kohäsion: ist jede Methode, eine Klasse oder ein Modul verantwortlich für genau eine Aufgabe.
Guter Klassenentwurf weist einen hohen Grad an Kohäsion.

#### Code-Duplizierung:
ist ein Indiz für einen schlechten Entwurf, sollte vermieden werden.

#### Kapselung:
Saubere Kapselung reduziert die Kopplung und führt zu besseren Entwürfen.


##### Übung 8.1 Projekt: "Zuul-schlecht" <br>

Was tut diese Anwendung? <br>
"World of Zuul" ist ein sehr einfaches, textbasiertes Abenteuerspiel.
Der Benutzer kann durch einige Landschaften laufen. <br>

Welche Befehle akzeptiert das Spiel? <br>
Hilfe, quit, gehe "irgendwohin"<br>

Was bewirken die einzelnen Befehle? <br>
help: Liefert Informationen über die verfügbaren Befehle <br>
quit: Beendet das Spiel <br>
Gehe "irgendwohin": Geht durch die Tür in die angegebene Richtung. Die Richtungen können eine der folgenden sein: Norden, Osten, Süden und Westen.<br>

Wie viele Räume gibt es in der virtuellen Umgebung? <br>
Es gibt 5 Räume<br>

##### Übung 8.5: eigene Methode rauminfoAusgeben:
![img_4.png](img_4.png)

##### Übung 8.6: Änderungen an Klasse Raum:
![img_1.png](img_1.png)

##### Übung 8.7: Neue Methode definieren:
![img_2.png](img_2.png)  ![img_3.png](img_3.png) <br>

#### Übung 8.8: beschriebene Änderungen implementieren:
![img_5.png](img_5.png) ![img_11.png](img_11.png)      <br>

#### Übung 8.9: Methode keySet. Was tut Sie?: <br>
Gibt eine Set-Ansicht der Map-Schlüssel zurück. Änderungen in Map oder Set beeinflussen einander.
Während einer Iteration sind Änderungen riskant.
Entfernen ist erlaubt, Hinzufügen nicht.

#### Übung 8.10: Methode "gisAusgaengealsString": <br>
Zunächst wird eine Zeichenkette namens returnString mit dem Initialtext "Exits: ". Wir werden dann die Exits zu diesem String hinzufügen und ihn schließlich zurückgeben.
Die Namen der verfügbaren Ausgänge werden hinzugefügt, indem wir die Menge der Schlüssel aus der HashMap der Ausgänge abrufen.
Wir iterieren dann durch die Menge der Schlüssel und fügen in jeder Iteration den Schlüssel des Ausgangs zu returnString hinzu

#### Übung 8.11: Änderungen implementieren: <br>
![img_7.png](img_7.png) ![img_8.png](img_8.png) <br>

#### Übung 8.11: Änderungen implementieren: <br>

### Änderungen lokal halten:
Eines der Hauptziele eines guten Klassenentwurfs lautet: Änderungen lokal halten
eine Änderung an einer Klasse sollte möglichst geringen Einfluss auf andere Klassen haben.

#### Übung 8.15:Einen weiteren Befehl hinzufügen <br>
![img_9.png](img_9.png) ![img_10.png](img_10.png)

#### Übung 8.16: <br>
