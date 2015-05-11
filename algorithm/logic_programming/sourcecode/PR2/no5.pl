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





