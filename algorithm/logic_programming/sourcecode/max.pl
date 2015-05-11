max([X],X).
max([X,Y|List],Z) :- X =< Y, max(Y|List,Z).
max([X,Y|List],Z) :- X > Y, max(X|List,Z).
