% prolog solution for number 4
% Name: Oscar Kurniawan Manule
% NPM: 0706272080

convert(A,[A|_],[B|_],B).

convert(A,[_|T1],[_|T2],B) :- convert(A,T1,T2,B).

