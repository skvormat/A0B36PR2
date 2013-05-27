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
Třída Ot.java je abstraktní třídou ze které jsou odděděny všechny třáidy otázek, každá otázka v sobě implementuje 
