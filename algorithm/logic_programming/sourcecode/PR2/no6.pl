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
