A0B36PR2
========
Dokumentace semestrální práce PR2

Apolikace slouží k tvorbě, správe a exportu otázek pro systém LMS Moodle. 
Podporuje tyto typy úloh:
Multichoice
Essay
Cloze
True-False question

A tyto operace s nimi:
Přidání úlohy
Editace úlohy
Uložení a načtení listu úloh ze souboru
Import úloh typu multichouce ze souboru csv
Export úloh do xml importovatelného systémem LMS Moodle


Struktura programu.
Program se skládá ze tří částí-jádra, otázek a gui

Otázky
Třída Ot.java je abstraktní třídou ze které jsou odděděny všechny třáidy otázek, každá otázka osahuje název, zadání, odpověď a je v ní překryta metoda toString která převede otazku do xml.

Jádro
Statická třída procesor v sobě vytváří list astraktních otázek který osahuje jednotlivé otázky, implementuje načtení, uložení a export do xml(jedná se vlastně o toString do souboru)

Gui
celé gui se odehrává v jednom okně které obsahuje list otázek, tlačítka pro vytvoření jednotlivých otázek, uložení a reset, horní lištu s uložením a exporty a JPanel obsahující editaci zvoleného typu otázky
Každá otázka má svoji třídu dědící ze společné třídy editace. Jedná se o frame který osahuje grafickou reprezentaci třídy otázky, metodu uložení a resetu.

