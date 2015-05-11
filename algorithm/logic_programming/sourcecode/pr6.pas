Program Romawi;

Uses WinCrt;


Const

	Des : array [1..13] of integer =

			(1000,900,500,400,100,90,50,40,10,9,5,4,1);

	Rom : array [1..13] of String =

		(‘M’,'CM’,'D’,'CD’,'C’,'XC’,'L’,'XL’,'X’,'IX’,'V’,'IV’,'I’);


Var

	Bil,i,Bil1 : Integer;

	Roma : String;


Begin

	writeln ('**************************************************');


	writeln (' PROGRAM KONVERSI BILANGAN DESIMAL KE ROMAWI ');

	writeln ('**************************************************'); 

	Write('Masukkan bilangan yang akan dikonversi [1..4999] : ');

	Readln(Bil);

	Bil1 := Bil;

	if (Bil > 0) and (Bil <= 4999) then

		Begin

			For i:=1 to 13 do

				Begin

					while (Bil >= Des[i]) do

						Begin

							Bil := Bil – Des[i];

							Roma := Roma + Rom[i]

						End;
d
				End;

		Write('Angka ',Bil1,' –> Romawinya ',Roma)

		end;

	else

		Writeln('Tidak Diketahui Simbol Romawinya…..');

End.