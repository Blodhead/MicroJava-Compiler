 

Elektrotehnički fakultet u Beogradu Katedra za računarsku tehniku i informatiku

Predmet:	Programski prevodioci 1 Nastavnik:	dr Dragan Bojić, redovni profesor Asistenti:	mast. inž. Maja Vukasović,
mast. inž. Mihajlo Ogrizović
Student:	Ćirković Miloš
Školska:	2022/2023.
Datum:	8.12.2022.








Projekat
– Kompajler za Mikrojavu –






 

 
1.	Uvod
 

Cilj projektnog zadatka je realizacija kompajlera za programski jezik Mikrojavu. Kompajler omogućava prevodjenje sintaksno i semantički ispravnih Mikrojava programa u Mikrojava bajtkod koji se izvršava na virtuelnoj mašini za Mikrojavu. Sintaksno i semantički ispravni Mikrojava programi su definisani specifikacijom [MJ].
Programski prevodilac za Mikrojavu ima četiri osnovne funkcionalnosti: leksičku analizu, sintaksnu analizu, semantičku analizu i generisanje koda.
Leksički analizator treba da prepoznaje jezičke lekseme i vrati skup tokena izdvojenih iz izvornog koda, koji se dalje razmatraju u okviru sintaksne analize. Ukoliko se tokom leksičke analize detektuje leksička greška, potrebno je ispisati odgovarajuću poruku na izlaz.
Sintaksni analizator ima zadatak da utvrdi da li izdvojeni tokeni iz izvornog koda programa mogu formiraju gramatički ispravne sentence. Tokom parsiranja Mikrojava programa potrebno je na odgovarajući način omogućiti i praćenje samog procesa parsiranja na način koji će biti u nastavku dokumenta detaljno opisan. Nakon parsiranja sintaksno ispravnih Mikrojava programa potrebno je obavestiti korisnika o uspešnosti parsiranja. Ukoliko izvorni kod ima sintaksne greške, potrebno je izdati adekvatno objašnjenje o detektovanoj sintaksnoj grešci, izvršiti oporavak i nastaviti parsiranje.
Semantički analizator se formira na osnovu apstraktnog sintaksnog stabla koje je nastalo kao rezultat sintaksne analize. Semantička analiza se sprovodi implementacijom metoda za posećivanje čvorova apstraktnog sintaksnog stabla. Stablo je formirano na osnovu gramatike implementirane u prethodnoj fazi. Ukoliko izvorni kod ima semantičke greške, potrebno je prikazati adekvatnu poruku o detektovanoj semantičkoj grešci.
Generator koda prevodi sintaksno i semantički ispravne programe u izvršni oblik za odabrano izvršno okruženje Mikrojava VM. Generisanje koda se implementira na sličan način kao i semantička analiza, implementacijom metoda koje posećuju čvorove.
 

 
2.	Specifikacija zahteva
 
I	Leksička analiza 
U nastavku teksta su navedeni i opisani projektni zahtevi za implementaciju leksičkog analizatora.

	Potrebno je realizovati leksički analizator (skener) izvornih programa napisanih na jeziku Mikrojava.
	Leksički analizator se implementira pisanjem .flex specifikacije, čiji format je detljano opisan u prezentacijama primera domaćih zadataka sa sajta predmeta.
	Specifikacija leksičkog analizatora mora da se smesti u fajl [PT]/src/spec/mjlexer.flex.
	Specifikacija .flex se transformiše u implementaciju leksera na programskom jeziku Java korišćenjem alata JFlex sa sajta predmeta.
	Generisana klasa leksičkog analizatora mora da pripada paketu rs.ac.bg.etf.pp1 u okviru direktorijuma [PT]/src.
	Interfejs leksičkog analizatora prema sintaksnom analizatoru mora biti standardni CUP interfejs. Za više informacija, pogledati primer mini domaćeg u vežbama na sajtu predmeta.
	Skener prihvata fajl za izvornim kodom na jeziku Mikrojava i deli ga na tokene.
	Token se vraća eksplicitnim pozivom leksičkog analizatora (operacija next_token()). Potrebno je detektovati i obraditi sledeće leksičke strukture:
–	identifikatore,
–	konstante,
–	ključne reči,
–	operatore,
–	komentare.
	Leksičke strukture implementirati prema specifikaciji jezika [MJ§A.2p3].
	Leksički analizator treba da preskače komentare i "beline" u tekstu programa.
	Pod "belinama" se smatraju: tabulatori (\t), prelazak u novi red (\r \n), razmak (' '), backspace (\b), prelazak na novu stranu (\f, form feed).
	U slučaju leksičke greške, ispisuje se greška i nastavlja se obrada teksta programa.
	Poruka o grešci treba da sadrži sledeće informacije:
–	niz znakova koji nije prepoznat,
–	broj linije teksta programa u kojoj se desila greška, i
–	kolonu (poziciju prvog znaka) u kojoj je detektovana greška.
	Obavezno je korišćenje jdk 1.8 kao što je opisano u primerima na vežbama.

II	Sintaksna analiza (maks. 7 poena)

Opšti tehnički zahtevi 

	Gramatika jezika Mikrojava mora biti napisana u skladu sa specifikacijom jezika definisanom u [MJ].
	Za implementaciju parsera mora se koristiti generator sintaksnih analizatora AST-CUP (u nastavku teksta: AST-CUP generator). AST-CUP generator je lokalno razvijeno proširenje alata CUP za rad sa sintaksnim stablima.
	Mora se koristiti instalacija alata isključivo sa sajta predmeta (biblioteka cup_v10k.jar).
 
	Gramatička specifikacija parsera mora biti napisana u CUP fajlu, u formatu koji AST-CUP generator prepoznaje (u nastavku teksta: AST-CUP specifikacija).
	AST-CUP specifikacija mora da se smestu u fajl [PT]/src/spec/mjparser.cup.
	Sintaksni analizator mora biti integrisan sa CUP kompatibilnim leksičkim analizatorom za jezik Mikrojava.
	U slučaju uspešnog parsiranja ulaznog fajla parser na kraju rada na standardnom izlazu prikazuje apstraktno sintaksno stablo pozivom funkcije toString() nad korenom stabla (videti primer mini domaćeg).
	Parser treba da omogući oporavak od sintaksnih grešaka za zadate jezičke elemente.
	U slučaju nailaska na sintaksnu grešku parser:
–	ispisuje poruku greške u log fajl,
–	vrši oporavak od greške i
–	nastavlja sa parsiranjem ostatka fajla.
	Opis sintaksne greške TREBA da sadrži:
–	broj linije ulaznog programa u kojoj je greška detektovana (videti realizaciju u primeru mini domaćeg sa sajta predmeta),
–	nedvosmislen opis greške.
Implementacija parsera

	Nije dozvoljeno koristiti opciju precedence u .cup fajlu za definisanje prioriteta operatora. Izuzetak je korišćenje direktive precedence left ELSE; koja se može koristiti da se razreši konflikt između smena za if iskaz (statement) sa else delom i if iskaz bez else dela.
	Neterminali u AST-CUP specifikaciji moraju biti imenovani na način kako je to propisano zadatom specifikacijom [MJ] uz eventualno dodavanje sopstvenih neterminale, ukoliko se za tim ukaže potreba.
	Svakoj produkciji mora se zadati jedinstveni naziv na osnovu kojeg AST-CUP generator generiše Java klasu koja reprezentuje deo podstabla koji odgovara toj produkciji.
	Na osnovu AST-CUP specifikacije AST-CUP generator proizvodi standardnu CUP specifikaciju i geneiše klase elemenata sintaksnog stabla.
	Dobijena CUP specifikacija mora biti smeštena u fajl [PT]/src/spec/mjparser_astbuild.cup. Generisane klase apstr. sint. stabla moraju biti smeštene u paket rs.ac.bg.etf.pp1.ast u okviru direktorijuma [PT]/src.
	Uz izuzetak prijave sintaksnih grešaka, nije dozvoljeno ubacivati nikakve druge akcije u AST- CUP specifikaciju parsera {: :}.
Dozvoljeno je dodavati uslužne metode ili polja u code {: :} sekciju AST-CUP specifikacije parsera isključivo za prijavljivanje i/ili oporavak od sinktasnih grešaka.
	Napisati klasu rs.ac.bg.etf.pp1.Compiler na programskom jeziku Java sa funkcijom glavnog programa main koja pokreće parsiranje Mikrojava programa. U slučaju uspešnog parsiranja, ispisuje strukturu sintaksnog stabla kako je opisano u zahtevima.
	Putanja do ulaznog fajla sa Mikrojava izvornim kodom prosleđuje se glavnom programu klase Compiler kao prvi argument komandne linije.
Oporavak od grešaka (maks. 3 poena)
	U AST-CUP specifikaciju gramatike TREBA dodati smene i akcije za oporavak od grešaka. Implementirati oporavak od grešaka za sledeće jezičke elemente:
	NIVO A (1 poen):
–	definicija globalne promenljive – ignorisati karaktere do prvog znaka ";" ili sledećeg ","
–	konstrukcija iskaza dodele – ignorisati karaktere do ";"
	NIVO B (2 poena, uključujući i A):
–	deklaracija formalnog parametra funkcije – ignorisati znakove do znaka "," ili ")"
–	logički izraz unutar if konstrukcije - ignorisati karaktere do prvog znaka ")"
	NIVO C (3 poena, uključujući i sve za B):
 
–	deklaracija polja unutrašnje klase – ignorisati karaktere do prvog ";" ili "{"
–	deklaracija proširenja natklase – ignorisati znakove do prvog znaka "{".
Testiranje rada implementiranog parsera:
	Napisati reprezentativni skup testova sintaksno ispravnih i neispravnih programa i testirati oporavak od grešaka.

III	Semantička analiza
Format poruke
	Poruka o detektovanom simbolu MORA da sadrži sledeće podatke (videti Prilog 2):
–	linija izvornog koda u kojoj je pronađen simbol,
–	naziv pronađenog simbola,
–	ispis objektnog čvora iz tabele simbola koji odgovara pronađenom simbolu.
Provera kontekstnih uslova (Bodovanje: Nivo A - 2, NivoB - 4, NivoC - 6)
	U klasi SemanticAnalyzer implementirati proveru svih kontekstnih uslova navedenih u specifikaciji [MJ§A.4p5], a predviđenih za odabrani nivo težine.
Testiranja rada implementiranog semantičkog analizatora:
	Napisati ulazne fajlove na programskom jeziku Mikrojava koji sadrže sve sintaksno i semantički ispravne MJ programe uz pokrivanje svih smena iz gramatike.
	Napisati ulazne fajlove na programskom jeziku Mikrojava koji sadrže sve kombinacije semantičkih grešaka.

IV	Generisanje koda
Generisanje koda podrazumeva transformaciju sintaksno i semantički ispravnog sintaksnog stabla u bajtkod za izvršno okruženje za MJ virtuelnu mašinu (MJVM).

Opšti zahtevi
	Generisanje koda vrši se obilaskom apstraktnog sintaksnog stabla koje je nastalo kao rezultat sintaksne analize i zadovoljilo uslove semantičke provere.
	Potrebno je implementirati klasu rs.ac.bg.etf.pp1.CodeGenerator, koja proširuje automatski generisanu klasu rs.ac.bg.etf.pp1.ast.VisitorAdapter, i u njoj redefinisati medote za obilazak elemenata sintaksnog stabla koji su relevanti za generisanje koda.
	Nije dozvoljeno implementirati generisanje koda u akcijama {: :} AST-CUP specifikacije parsera, niti klasi parsera dodavati metode niti polja koja obavljaju ili posredno ili neposredno utiču na generisanje koda.
	Generator koda mora da generiše ispravan bajtkod za MJVM.
	Za implementaciju generatora koda moraju se koristiti alati Code, disasm i Run. dostupni i biblioteci mj-runtime.jar: 
	Generisanje koda se pokreće u glavnom programu klase Compiler po završetku semantičke analize i ispisa sadržaja tabele simbola. Implementira se prosleđivanjem objekta klase CodeGenerator korenu sintaksnog stabla.
	Izlaz generatora koda mora da bude izvršivi .obj fajl za MJVM.
	Putanja do izlaznog .obj fajla prosleđuje se glavnom programu klase Compiler kao drugi argument komandne linije.
 
V	Podela funkcionalnosti po nivoima


DesignatorStatement := Designator "=" Expr.
DesignatorStatement := "[" [Designator] {"," [Designator]}"]" "=" Designator.
DesignatorStatement := Designator "++". DesignatorStatement := Designator "--". Statement := DesignatorStatement ";".
Statement := "read" "(" Designator ")" ";".
Statement := "print" "(" Expr [“,” numConst] ")" ";". Expr := ["‐"] Term {Addop Term}.
Term := Factor {Mulop Factor}.
Factor := numConst | charConst | "(" Expr ")" | boolConst | "new" Type "[" Expr "]"| Designator. Designator := ident [ "[" Expr "]" ].
Addop := "+" | "‐" .
Mulop := "*" | "/" | "%".

	Od nizova, treba podržati samo nizove ugrađenih tipova podataka. Program mora da sadrži funkciju main, globalne/lokalne promenljive (proste ili nizovne), globalne konstante. Ne treba obrađivati unutrašnje klase.



VI	Primer programa:
program Program
class A{int x[],y[];} const int pi = 3, e = 2; int a, b;
class B extends A { int i;
{
int getValue(int a) int b; bool c;{ return this.i + this.x[0] + a; } void m()int a;{x.foreach(a => print(a););}
}
}
class C extends B{A theA;int a;}
{
void main() A a; C c; int i; int x[]; char ch; { a = new A;
a.x = new int[5]; a.y = new int[5]; c = new C;
c.theA = a; c.x = new int[5]; x = new int[3];
read(c.i); i = 0;
while(i<5){
read(c.x[i]); read(c.theA.x[i]); i++;
}
[a,,b] = c.x; print(c.getValue(c.theA.x[0])); c.m();
}
