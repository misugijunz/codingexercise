%occured(accident).
insecure(publictransport).
inadequate(publictransport).
mostpreferredtransportation(privatecar):- insecure(publictransport),inadequate(publictransport).
toomany(privatecar):-mostpreferredtransportation(privatecar).
jammed(traffic):- occured(accident).
jammed(traffic):-toomany(privatecar).