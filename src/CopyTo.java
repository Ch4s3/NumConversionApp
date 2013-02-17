import java.awt.datatransfer.*;
import java.awt.Toolkit;

public class CopyTo {
	public static void Copy(){
		String num1 = Gui.numToConvert.getText();
		String base = (String) Gui.startBase.getSelectedItem();
		String num2 = Gui.resField.getText();
    	String base_res = (String) Gui.endBase.getSelectedItem();
    	
    	toClip(ConCat(num1, base, num2, base_res));
	}
	
	
	private static String ConCat(String n1, String b, String n2, String b2){
		
		String string_for_clipboard = (n1 + " base " + b + " = " + n2 + " base " + b2 );
		
		return string_for_clipboard;
	}
	
	private static void toClip (String toCopy){
		StringSelection stringSelection = new StringSelection (toCopy);
		Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
		clpbrd.setContents (stringSelection, null);
	}

}
