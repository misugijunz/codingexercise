convert(E,[E|_],[D|_],D).
convert(E,[_|T1],[_|T2],D) :- convert(E,T1,T2,D).

converts([],_,_,[]).
converts([H|T],X,Y,[P|Q]) :-
    convert(H,X,Y,P),
    converts(T,X,Y,Q).
% prolog solution for number 3
% Name: Oscar Kurniawan Manule
% NPM: 0706272080
% Collaboration with Fabian

delonelem(_, [], []).
deloneelem(X,[X|T1],T1).
deloneelem(X,[H|T1],[H|T2]) :- deloneelem(X,T1,T2),!.

delduplelems([X],[X]).
delduplelems([X,Y|T1],[Z|T2]) :- Z is X, delete([Y|T1],X,L1), delduplelems(L1,T2).

gendigits([],DL,UL,UD,DL,UL,UD,[]).
gendigits([LH|LT],DL,UL,UD,NDL,NUL,NUD,[A|D]) :-
    not(member(LH,UL)),
    member(A,DL), 
    deloneelem(A,DL,DL1),
    gendigits(LT,DL1,[LH|UL],[A|UD],NDL,NUL,NUD,D).
gendigits([LH|LT],DL,UL,UD,NDL,NUL,NUD,[A|D]) :-
    member(LH,UL),
    convert(LH,UL,UD,A),
    gendigits(LT,DL,UL,UD,NDL,NUL,NUD,D).

cryptadd(S1,S2,R,D1,D2,DR) :-
    append(S1,S2,X1), append(X1,R,LX),
    deldupelems(LX,L),
    gendigits(L,[0,1,2,3,4,5,6,7,8,9],[],[],_,_,_,D),
    converts(S1,L,D,D1),
    converts(S2,L,D,D2),
    converts(R,L,D,DR),
    sum(D1,D2,DR).

numberize(L,N) :- reverse(L,RL), number(RL,N).
number([],0).
number([H|T],X) :- number(T,A), Y is A * 10, X is H + Y.

sum(X,Y,Z) :- numberize(X,A), numberize(Y,B), numberize(Z,C),
    C is A + B.
