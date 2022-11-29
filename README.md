# Software_Engineering_G12
Dette prosjektet er kodet med kode språket Java med miljøet Gradle og det er lagt til GitHub Actions som blir brukt til å utføre testene.
Prosjektet er utviklet i VS Code med JDK versjon 17, men kan fint åpnes av andre editorer som støtter kode språket java. 

Etter å ha lastet ned ZIP filen så må den pakkes ut i filutforskeren og kan åpnes i foretrukket editor.
Når programmet er åpnet så vil editoren bruke litt tid på å gå igjennom koden og laste inn Gradle. Når Gradle er lastet og editoren har gått igjennom koden så er det
mulig å åpne programmet Main.java. og kjøre koden. Main.java ligger under mappen src – main – java – org – example. 

Når programmet kjører så vil du bli møtt av ett innloggings panel som lar deg velge mellom å logge inn som Administrator, Bruker, Utleier eller Registering av ny bruker.
JSON filene inneholder ikke bruker, bil eller utleier, så det vil være anbefalt å lage en bruker og legge til en bil før du begynner å teste alle funksjonene. 

Når en bruker leier ut en bil så bli bilen lagret i car.json og når den blir leid ut til en bruker så fjernes den fra car.json og blir lagt til i store.json.
