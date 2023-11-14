## Entwurfsmuster 1
### Beschreibung
Entwurfsmuster sind wie Kochrezepte für Programmierer. Sie bieten bewährte Lösungen für häufige
Probleme und helfen dabei, den Code klar, wiederverwendbar und leicht zu verstehen zu machen.

### Wofür?
Wiederholte Probleme: <br>
Verschiedene Typen für verschiedene Probleme:<br>
Gemeinsame Sprache:<br>
Bewährte Lösungen:<br>

## Entwurfsmuster 2

### Chain of Responsibility:
Mehrere Objekte werden miteinander verkettet,
um gemeinsam eine Anfrage bearbeiten zu können.
Diese Anfrage wird an der Kette entlang geleitet, bis eines der Objekte die Anfrage beantworten kann.

### Template Method:
Das Template Method-Muster verwendet eine abstrakte Klasse, 
um Methoden zu definieren, wobei Unterklassen dies implementieren. 
Hook-Operationen erlauben zusätzliche Anpassungen, ohne die Grundstruktur zu ändern. <br>

### Decorator:
Mit dem Decorator-Muster können zur Laufzeit dynamisch zusätzliche Funktionen zu 
Objekten hinzugefügt werden, ohne die Klassen zu ändern.

### Builder:
Das Builder-Muster hilft dabei, komplexe Objekte Stück für Stück aufzubauen. 
Stellen Sie sich vor, es ist wie der Bau eines Hauses. Anstatt das ganze Haus auf einmal zu bauen, 
arbeiten Sie Schritt für Schritt: zuerst das Fundament, dann die Wände, das Dach, usw.

### Adapter:
Das Adapter-Muster in der Programmierung funktioniert wie ein Steckdosenadapter: 
Es ermöglicht es zwei Klassen mit unterschiedlichen Schnittstellen, miteinander zu kommunizieren, 
indem es die Schnittstelle der einen Klasse in eine Form umwandelt, die von der anderen Klasse verstanden wird.

### Observer:
Dieses Muster wird verwendet, um ein Abhängigkeitsverhältnis zwischen Objekten zu erstellen, 
sodass, wenn ein Objekt seinen Zustand ändert, alle seine abhängigen benachrichtigt und automatisch aktualisiert werden.


## Designprinzipien

### DRY - Don't Repeat Yourself
Das DRY-Prinzip betont die Wichtigkeit, Wiederholungen im Code zu vermeiden. 
Der Grundgedanke ist, dass jede Information oder Funktionalität in einem System nur einmal vorhanden sein sollte.

### YAGNI - You Aren't Gonna Need It
Hier sollte man Funktionen implementieren , die aktuell benötigt werden, 
um unnötige Komplexität und schwer wartbaren Code zu vermeiden.

### KISS - Keep It Simple, Stupid
Den einfachsten und klarsten Lösungen suchen. Komplizierte Ansätze 
sollten vermieden werden, um den Code verständlich, wartbar und effizient zu gestalten.