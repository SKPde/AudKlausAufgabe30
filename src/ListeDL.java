
public class ListeDL {

	static class ElementDL {	// innere Klasse für die Elemente
		private Object inhalt;	// Inhalt des Listenelementes
		private ElementDL nach, vorg;	// Verweis auf den Nachfolger und Vorgänger
		
		public ElementDL(Object o) {
			inhalt = o;
		}
	}
	
	private ElementDL kopf;
	private ElementDL ende;
	
	public void endElementNachVorne() { // End-Element zu Kopf-Element machen
		
		ende.vorg.nach = kopf;
		kopf.vorg = ende.vorg;
		ende.nach = kopf.nach;
		kopf.nach = null;
		ende.vorg = null;
		ElementDL temp = kopf;
		kopf = ende;
		ende = temp;
		
		
	}
	
	public void einfugen(Object o) {
		if(kopf == null) {
			kopf = new ElementDL(o);
			ende = kopf;
		} else {
			ElementDL temp = new ElementDL(o);
			ende.nach = temp;
			temp.vorg = ende;
			ende = temp;
		}
	}
	
	public void ausgeben() {
		ElementDL temp = kopf;
		System.out.println("");
		while(temp != null) {
			System.out.println(temp.inhalt.toString());
			temp = temp.nach;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListeDL liste = new ListeDL();
		
		liste.einfugen("Techniksupport");
		liste.einfugen("kuebel_skp");
		liste.einfugen("blaue_minze");
		liste.einfugen("bluegraphics960");
		liste.einfugen("rebecca_graph");
		liste.einfugen("manug010798");
		
		liste.ausgeben();
		
		liste.endElementNachVorne();
		
		liste.ausgeben();
		
		liste.endElementNachVorne();
		
		liste.ausgeben();
		
		
	}

}
