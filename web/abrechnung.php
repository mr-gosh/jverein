<? include ("frame.inc"); ?>
  <h1>Abrechung</h1>
	<p>Die Abrechnung wird mit dem untenstehenden Bildschirm initiiert. Es k�nnen</p>
	<ul>
		<li>Mitgliedsbeitr�ge je nach <a href="dokumentationbeitragsmodelle.php">Beitragsmodell</a></li>
		<li>Beitr�ge f�r im laufenden Jahr eingetretene Mitglieder</li>
		<li>Zusatzbetr�ge</li>
		<li>Kursgeb�hren</li>
	</ul>
	<p>verarbeitet werden.</p>
	<p>Sofern als Modus <b>nicht</b> 'keine Beitragsabbuchung' ausgew�hlt wurde, werden f�r alle 
		Mitglieder, die nicht ausgetreten sind oder deren Austrittsdatum nach dem Stichtag liegt, 
		die Beitr�ge gem�� eingetragener Beitragsgruppe und Zahlungsrhytmus eingezogen.</p>
	<p>F�r Mitglieder, die im Laufe des Jahres eingetreten sind, k�nnen ebenfalls die Beitr�ge 
		eingezogen werden. Dazu wird das Eingabedatum eingetragen, ab dem die Beitr�ge f�r 
		nachtr�glich eingetretene Mitglieder abgebucht werden sollen.</p>
	<p>Mit der Option Zusatzbetr�ge werden auch die zus�tzlichen Betr�ge abgebucht.</p>
	<p>F�r die Abbuchung werden die Daten werden in eine DTAUS-Datei geschrieben. Diese Datei kann entweder direkt auf 
		Diskette ausgegeben und bei der Bank eingereicht oder zum Beispiel in Hibiscus importiert 
		werden. Buchungen k�nnen als Einzel- oder Sammellastschriften direkt in Hibiscus verbucht 
		werden. Die Kontonummer in den <a href="administration_stammdaten.php">Stammdaten</a> 
		wird mit den Kontonummern in Hibiscus abgeglichen. Gibt es eine �bereinstimmende Bankverbindung, 
		wird diese verwendet. Ansonsten erscheint der Hibiscus-Konto-Auswahldialog. </p>
  <p>Kompakte Abbuchung: Alle Abbuchungen von einem Konto werden in eine Abbuchung zusammengefasst, soweit die
    Verwendungszwecke (max. 15) in einen Datensatz passen.</p>
	<p>Die Abrechnungsdaten werden in das Mitgliedskonto geschrieben, sofern der entsprechende Parameter 
	  unter Administration|Einstellungen gesetzt wurde.</p>
	<p>Optional kann die ausgegebene DTAUS-Datei in ein PDF-Dokument zum Ausdruck ausgegeben werden.</p>
    <p>Teilnehmer von Kursen k�nnen abgerechnet werden. Kursteilnehmer sind Personen, die
		nicht Mitglied des Vereins sind. Sofern Mitglieder an Kursen teilnehmen, die zus�tzlich
		abgerechnet werden, bieten sich die Zusatzabbuchungen an.</p>
    <img src='images/Abbuchung.png' class='screenshot'>
        
<? include ("footer.inc"); ?>

