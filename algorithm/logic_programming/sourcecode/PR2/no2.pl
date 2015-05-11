% prolog solution for number 2
% Name: Oscar Kurniawan Manule
% NPM: 0706272080


delduplelems([X],[X]). %base case kalau kedua argumen list memiliki elemen yang sama

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% bilangan Z adalah head dari list pada argumen kedua delduplelems
% yang sama dengan bilangan X yang pertama kali ditemukan dalam
% list argumen pertama, lalu dengan term delete (built-in) hapus
% sisa elemen dari list pada argumen pertama yang mengandung X
% dan hasilnya adalah L1 dan kemudian secara rekursif diujikan kembali
% dengan argumen L1 dan T2 dimana T2 adalah subset yang didapat dengan
% mengambil elemen pertama dari set yang diujikan yaitu Z
%
delduplelems([X,Y|T1],[Z|T2]) :- Z is X, delete([Y|T1],X,L1), delduplelems(L1,T2).

