% prolog solution for number 1
% Name: Oscar Kurniawan Manule
% NPM: 0706272080


% rules

scalar([A],[B],S) :- S is A*B. % base case
/*if one of vectors has the bigger dimension
scalar([_|_],[],S) :- S is 0.
scalar([],[_|_],S) :- S is 0.*/


scalar([A|Tail1],[B|Tail2],S) :- scalar(Tail1,Tail2,X),Y is A*B, S is Y+X. %X will be instantiated after several recursive calls and the value is returned.

% prolog solution for number 2
% Name: Oscar Kurniawan Manule
% NPM: 0706272080


delduplelems([X],[X]). %base case kalau kedua argumen list memiliki elemen yang sama



delduplelems([X,Y|T1],[Z|T2]) :- Z is X, delete([Y|T1],X,L1), delduplelems(L1,T2).

% prolog solution for number 3
% Name: Oscar Kurniawan Manule
% NPM: 0706272080
% % Collaboration with Denvil


delonelem(_, [], []).
deloneelem(X,[X|T1],T1).
deloneelem(X,[H|T1],[H|T2]) :- deloneelem(X,T1,T2),!.


% prolog solution for number 4
% Name: Oscar Kurniawan Manule
% NPM: 0706272080

convert(A,[A|_],[B|_],B).

convert(A,[_|T1],[_|T2],B) :- convert(A,T1,T2,B).

% prolog solution for number 5
% Name: Oscar Kurniawan Manule
% NPM: 0706272080

% no cut version

split([],[] ,[]).

split([X|Tail], P, [X|N]):- X < 0, split(Tail, P, N).
split([X|Tail], [X|P], N):- X >= 0, split(Tail, P, N).

% with cut version
/*
split([],[] ,[]) :- !

split([X|Tail], P, [X|N]):- X < 0, split(Tail, P, N).
split([X|Tail], [X|P], N):- X >= 0, split(Tail, P, N).
*/


% prolog solution for number 6
% Name: Oscar Kurniawan Manule
% NPM: 0706272080


roman(0,' ') :- !.

roman(N,R) :-
	numeral(N,[1000,900,500,400,100, 90, 50, 40, 10, 9, 5, 4, 1],
		['M','CM','D','CD','C','XC','L','XL','X','IX','V','IV','I'], R).

numeral(0, _, _, ' ').

numeral(N,[N1|NTail],[S1|STail],R) :- N1 =< N, N2 is N - N1,  numeral(N2,[N1|NTail],[S1|STail],R1), atom_concat(S1,R1,R), !.
numeral(N,[N1|NTail],[_|RTail],R) :- N1 > N, numeral(N, NTail, RTail, R).

% prolog solution for number 3
% Name: Oscar Kurniawan Manule
% NPM: 0706272080
% Collaboration with Fabian

converts([],_,_,[]).
converts([H|T],X,Y,[P|Q]) :-
    convert(H,X,Y,P),
    converts(T,X,Y,Q).

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







