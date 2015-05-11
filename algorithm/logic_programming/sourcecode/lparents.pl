male([ali,carl,ed,frank,hugo,kurt,rene,tico,vico]).
female([berta,dora,gina,ina,jane,laura,mia,olga,vera,susan,uta]).
father(ali,[gina,hugo]).
father(carl,[ina,jane]).
father(ed,[kurt]).
father(frank,[mia,olga]).
father(hugo,[vera,rene,vico]).
father(kurt,[tina,uta]).
mother(berta,[gina,hugo]).
mother(dora,[ina,jane]).
mother(gina,[mia,olga]).
mother(ina,[vera,rene,vico]).
mother(jane,[susan]).
mother(laura,[tino,uta]).

/*
* define lparents(PL,CL)
*       PL: a list of parents([Father,Mother])
*       CL: list of childrens
*/

lparents([X,Y],List) :- father(X,List),mother(Y,List).

ismale(X) :- male(Y), member(X,Y).
parents([X,Y],Z) :- lparents([X,Y],List), member(Z,List).

lbrother(B,C) :- ismale(B), parents(L,B), parents(L,C), B \= C.

lgrandpa(G,C) :- father(G,List),father(X,List2),member(X,List),member(C,List2).
lgrandpa(G,C) :- father(G,List),mother(X,List2),member(X,List),member(C,List2).
