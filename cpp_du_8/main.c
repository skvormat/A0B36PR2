/* 
 * File:   main.c
 * Author: Mates
 *
 * Created on 5. květen 2013, 20:57
 */

#include <stdio.h>
#include <stdlib.h>

void bubble_sort(int *x, int size, int(*compar)(int*, int*))
{
  int i, j, temp;
 
  for (i = (size - 1); i > 0; i--)
  {
    for (j = 1; j <= i; j++)
    {
      //if (*(x+j-1) > *(x+j))
        if (compar((x+j-1), (x+j)) > 0)
      {
        temp = *(x+j-1);
        *(x+j-1) = *(x+j);
        *(x+j) = temp;
      }
    }
  }
}

int compar_vzestup(int *a, int *b) 
{ 
   if (*a<*b) return -1;
    if (*a>*b) return 1;
    else return 0;
}

int compar_sestup(int *a, int *b) 
{ 
   if (*a<*b) return 1;
    if (*a>*b) return -1;
    else return 0;
}

int compar_lichsud(int *a, int *b) 
{
    //Napřed všechna sudá čísla vzestupně a za nimi všechna lichá sestupně
    if (*a % 2) {
        if (*b % 2)
 {
            if (*a<*b) return 1;
            if (*a>*b) return -1;
            else return 0;
        }
        else
            return 1;
    }

    else {
        if (*b % 2)
            return -1;
        else {
            if (*a<*b) return -1;
            if (*a>*b) return 1;
            else return 0;
        }
    }


}

void vypis_pole(int *x, int size)
{printf("\n\nVypis pole\n");
    int v;

    for (v = 0; v < size; v++) {
        printf("%d, ", *(x+v));
    } }


/*
 * 
 */
int main(int argc, char** argv) {
/*    Napište program, který ze souboru z minulé úlohy načte pole čísel a dle pokynu 
uživatele ho seřadí:
 Vzestupně
 Sestupně
 Napřed všechna sudá čísla vzestupně a za nimi všechna lichá sestupně
Algoritmus řazení (např. bubble sort) realizujte pomocí funkce, kterou nazvete 
sort(…). Tato funkce bude mít jako parametry pole, velikost pole a pointer na 
komparační funkci. Komparační funkce bude sloužit k porovnání dvou prvků. 
Vrátí 1, jsou-li ve správném pořadí, nebo 0, jestliže je třeba je prohodit. Každý 
způsob řazení bude mít svou vlastní komparační funkci.
*/
    

    int *x, pocet = 10;
    x = (int *) malloc(pocet * sizeof (int));

    FILE *fr;

    fr = fopen("cisla.txt", "r");

    int i = 0;
    while (fscanf(fr, "%d", (x + i)) != EOF) {

        i++;
        if (i + 2 == pocet) {
            int *p_pom1, *p_pom2, *p_nove;
            p_nove = (int *) malloc((pocet + 10) * sizeof (int));
            p_pom1 = x;
            p_pom2 = p_nove;
            while (p_pom1 < x + pocet) {
                *p_pom2++ = *p_pom1++;
            }
            pocet += 10;
            free((void *) x);
            x = p_nove;
        }
    }

    vypis_pole(x, i);

    bubble_sort(x, i, compar_vzestup);
    vypis_pole(x, i);

    bubble_sort(x, i, compar_sestup);
    vypis_pole(x, i);

    bubble_sort(x, i, compar_lichsud);
    vypis_pole(x, i);

    return (EXIT_SUCCESS);
}

