/**
* Implementazione di un server web utilizzando la comunicazione tramite socket.
* Lettura dati multi riga provenienti dal cliente
*
* dalla cartella rete/..
* rete javac/TcpServer.java; rete java.TcpServer
*/
 rete pacchetto ;

importa  java . io .*;
importa  java . netto . ServerSocket ;
importa  java . netto . Presa ;

 classe  pubblica TcpServer {
	public  static  void  main ( String [] args ) lancia  Exception {
		
		final  int  SERVER_PORT = 8765 ;
		String  clientMsg = "" ;
		
		prova {			 
			// Creazione del socket sul server e ascolto sulla porta
			ServerSocket  serverSocket = new  ServerSocket ( SERVER_PORT );
			Sistema . fuori . println ( "Server: in ascolto sulla porta " + SERVER_PORT );

			booleano  endConn = falso ;
			while (! endConn ) {
				// Attesa della connessione con il client
				Sistema . fuori . println ( "Attesa ricezione dati dal client ....................... \n" );
				Socket  clientSocket = serverSocket . accettare ();
				
				// Crea un flusso di output per scrivere i dati e un flusso di input per leggere i dati dal socket
				DataOutputStream  outStream = nuovo  DataOutputStream ( clientSocket . getOutputStream ());	
				BufferedReader  inStream = nuovo  BufferedReader ( nuovo  InputStreamReader ( clientSocket . getInputStream ()));
	
				// ------------------------------------------------ ---------
				//Lettura dati dal client un diritto alla volta   
				while (( clientMsg = inStream . readLine ()). length () != 0 ) {
					Sistema . fuori . println ( clientMsg );	
				}  
				// Elaborare qui i dati ricevuti dal client
				// ------------------------------------------------ ---------

				//Invio dei dati su stream di rete al client
				clientMsg = "HTTP/1.1 200 OK\r\n" ;
				//clientMsg += "Connessione: chiudi\r\n";
				//clientMsg += "Tipo di contenuto: testo/semplice\r\n";
				clientMsg += "\r\n" ;
				clientMsg += "Saluti dal web server Java di davide gioele colpo" ;
				outstream . scrivere ( clientMsg . getBytes ());
				outstream . filo ();

				Sistema . fuori . println ( "\n.......................Fine ricezione dati\n" );
				// Chiudi le risorse
				clientSocket . chiudere ();
				inStream . chiudere ();
				outstream . chiudere ();
			}

			// Chiudi le risorse
			serverSocket . chiudere ();

		} catch ( Eccezione  e ) {
			Sistema . fuori . println ( e );
		}
	}
}
