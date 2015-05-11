% prolog solution for number 3
% Name: Oscar Kurniawan Manule
% NPM: 0706272080
% % Collaboration with Denvil


delonelem(_, [], []).
deloneelem(X,[X|T1],T1).
deloneelem(X,[H|T1],[H|T2]) :- deloneelem(X,T1,T2),!.




