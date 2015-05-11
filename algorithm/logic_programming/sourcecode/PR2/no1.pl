% prolog solution for number 1
% Name: Oscar Kurniawan Manule
% NPM: 0706272080


% rules

scalar([A],[B],S) :- S is A*B. % base case
/*if one of vectors has the bigger dimension
scalar([_|_],[],S) :- S is 0.
scalar([],[_|_],S) :- S is 0.*/


scalar([A|Tail1],[B|Tail2],S) :- scalar(Tail1,Tail2,X),Y is A*B, S is Y+X. %X will be instantiated after several recursive calls and the value is returned.




