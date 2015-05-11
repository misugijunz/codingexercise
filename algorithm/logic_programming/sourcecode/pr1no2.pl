s(nil).
%s(s(A)):- s(A).
%more(X,Y):- s(s(X)),s(s(Y)).
s(s(s(A))):- s(A).
divisible_by_4(X):- X;s(s(s(X))).