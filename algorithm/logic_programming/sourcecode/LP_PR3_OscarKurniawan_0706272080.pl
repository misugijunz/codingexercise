/********************************
* PR 3 Prolog                   *
* Nama: Oscar Kurniawan Manule  *
* NPM : 0706272080              *
*********************************/

% no 1

/*List Concatenation Definition*/
conc([], L, L).

conc([X|L1], L2, [X|L3]) :- conc(L1, L2, L3).

expand(Term, Argument, NewTerm) :- Term =.. [HXF1|LX1], conc(LX1,[Argument], LC), NewTerm =.. [HXF1|LC].

% no 2
list_kosong([]).

instantiated(Term) :- term_variables(Term, L), list_kosong(L).


% no 3

atomlist(Term, AtomList) :- Term =.. [_|TL], searchatom(TL, AtomList).

searchatom([], []).

searchatom([H|T], AtomList) :- compound(H), !, atomlist(H, AL2), searchatom(T, AL3), append(AL2, AL3, AtomList).
searchatom([H|T], [H|TAL]) :- atom(H), searchatom(T, TAL).
searchatom([H|T], AtomList) :- not(atom(H)), searchatom(T, AtomList).

numberlist(Term, NumberList) :- Term =.. [_|TL], searchnumber(TL, NumberList).

searchnumber([], []).

searchnumber([H|T], NumberList) :- compound(H), !, numberlist(H, NL2), searchnumber(T, NL3), append(NL2, NL3, NumberList).
searchnumber([H|T], [H|NAL]) :- number(H), searchnumber(T, NAL).
searchnumber([H|T], NumberList) :- not(number(H)), searchnumber(T, NumberList).

structlist(Term, [Term|StructList]) :- Term =.. [_|TL], searchstruct(TL, StructList).

searchstruct([], []).

searchstruct([H|T], [H|TSL]) :- compound(H), !, structlist(H,[H|TSL]), searchstruct(T,TSL).
searchstruct([H|T], StructList) :- not(compound(H)), searchstruct(T, StructList).


breakupterm(Term, VarList, AtomList, NumberList, StructList) :- term_variables(Term, VarList), atomlist(Term,AtomList), numberlist(Term,NumberList), structlist(Term,StructList).

% no 4

/*count elem list tail recursively*/
addelemlist([], R, R).
addelemlist([H|T],Count, R) :- NCount is Count + H, addelemlist(T, NCount, R).

kalielemlist([], R, R).
kalielemlist([H|T],Count, R) :- NCount is Count * H, kalielemlist(T, NCount, R).

minuselemlist([], R, R).
minuselemlist([H|T],Count, R) :- NCount is Count - H, minuselemlist(T, NCount, R).

fold1(List, plus, R) :- addelemlist(List, 0, R).

fold1(List, kali, R) :- kalielemlist(List, 1, R).

fold1([Head|Tail], minus, R) :- minuselemlist(Tail, Head, R).

% no 5 a DFS

/*graph representation*/
e(u,v).
e(u,x).
e(v,w).
e(v,y).
e(w,y).
e(w,z).
e(y,x).
e(y,z).
e(z,z).

dfs(X,L) :- dfs3([X],[],L).

dfs3([],X,X).

dfs3([CH|CT],Visited,L) :- member(CH,Visited), dfs3(CT,Visited,L),!.
dfs3([CH|CT],Visited,L) :- findall(Y,e(CH,Y),LF), conc(Visited,[CH],NewVisited),
	conc(LF,CT,NewLF), dfs3(NewLF,NewVisited,L).

% no 5 b BFS

bfs(X,L) :- bfs3([X],[],L).

bfs3([], X, X).

bfs3([CH|CT],Visited,L) :- member(CH,Visited), bfs3(CT,Visited,L),!.
bfs3([CH|CT],Visited,L) :- findall(Y,e(CH,Y),LF),  conc(Visited,[CH],NewVisited), 
	conc(CT,LF,NewLF), bfs3(NewLF,NewVisited,L).

/*the differences between term DFS and term BFS are on the third goal of the second clause (
conc(CT,LF,NewLF) <-- this is for bfs and when we exchange order of the argument becoming conc(CT,LF, NewLF) the behaviour is like stack
))*/
